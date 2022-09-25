import java.util.Scanner;

public  class NBody {

    public static double readRadius(String fileName){
        double radius;
        In in = new In(fileName);
        in.readInt();
        radius = in.readDouble();
        return radius;
    }

   public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int num = in.readInt();
        Planet []  Planets = new Planet[num];
        for(int i=0 ;i<num;i++){
            Planets[i] = new Planet(0,0,0,0,0,"null");
        }
        in.readDouble();
        for(int i = 0; i< num ;i++){
                Planets[i].xxPos = in.readDouble();
                Planets[i].yyPos = in.readDouble();
                Planets[i].xxVel = in.readDouble();
                Planets[i].yyVel = in.readDouble();
                Planets[i].mass = in.readDouble();
                Planets[i].imgFileName = in.readString();
        }
        return Planets;
   }

    public static void main(String[] args) {
        double T, dt;
        String fileName;
        Scanner input = new Scanner (System.in);
        T = input.nextDouble();
        dt = input.nextDouble();
        fileName = input.next();
        Planet [] Planets = readPlanets(fileName);
        double radius = readRadius(fileName);
        //draw
        StdDraw.setScale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();

        double time = 0;
        for(;time < T; time += dt){
            double [] xForce = new  double[Planets.length];
            double [] yForce = new  double[Planets.length];
            for(int i=0; i< Planets.length; i++){
                xForce[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForce[i] = Planets[i].calcNetForceExertedByY(Planets);
                Planets[i].update(dt,xForce[i],yForce[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(int i=0; i< Planets.length; i++){
                Planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        //output the result
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
        input.close();
    }
}