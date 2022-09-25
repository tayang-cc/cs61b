public class TestPlanet {
    public static void main(String[] args) {
        Planet A = new Planet(0,0,0,0,10e8,"null");
        Planet B = new Planet(10e6,10e6,0,0,10e8,"null");
        System.out.println("Now testing:");
        System.out.println(A.calcForceExertedBy(B));
    }
}