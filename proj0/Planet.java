public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet P) {
        xxPos = P.xxPos;
        yyPos = P.yyPos;
        xxVel = P.xxVel;
        yyVel = P.yyVel;
        mass = P.mass;
        imgFileName = P.imgFileName;
    }

    public double calcDistance(Planet obj) {
        double distance;
        distance = Math.abs(obj.xxPos - xxPos) * Math.abs(obj.xxPos - xxPos) + Math.abs(obj.yyPos - yyPos) * Math.abs(obj.yyPos - yyPos);
        distance = Math.sqrt(distance);
        return distance;
    }

    public double calcForceExertedBy(Planet obj) {
        double force;
        final double G = 6.67e-11;
        force = G * this.mass * obj.mass / (calcDistance(obj) * calcDistance(obj));
        return force;
    }

    public double calcForceExertedByX(Planet obj) {
        double forceDx;
        forceDx = calcForceExertedBy(obj) * (obj.xxPos - xxPos) / calcDistance(obj);
        return forceDx;
    }

    public double calcForceExertedByY(Planet obj) {
        double forceDy;
        forceDy = calcForceExertedBy(obj) * (obj.yyPos - yyPos) / calcDistance(obj);
        return forceDy;
    }

    public double calcNetForceExertedByX(Planet[] obj) {
        double forceDx = 0;
        for (int i = 0; i < obj.length; i++) {
            if (!this.equals(obj[i])) {
                forceDx += calcForceExertedByX(obj[i]);
            }
        }
        return forceDx;
    }

    public double calcNetForceExertedByY(Planet[] obj) {
        double forceDy = 0;
        for (int i = 0; i < obj.length; i++) {
            if (!this.equals(obj[i])) {
                forceDy += calcForceExertedByY(obj[i]);
            }
        }
        return forceDy;
    }

    public void update(double t,double fx,double fy){
        double dt = t;
        xxVel = xxVel  + (dt * fx / mass);
        yyVel = yyVel  + (dt * fy / mass);
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}