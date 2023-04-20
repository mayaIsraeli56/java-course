public class Tester {
    public static void main(String[] args) {
        Polygon p1 = new Polygon();
        //System.out.println(p1);
        p1.addVertex(0, 0);
        p1.addVertex(0, 2);
        p1.addVertex(2, 2);
        p1.addVertex(2, 0);

        //System.out.println(p1);
        //System.out.println(p1.calcPerimeter());
        System.out.println(p1.calcArea());

        Polygon p2 = new Polygon();
        p2.addVertex(0, 0);
        p2.addVertex(0, 4);
        p2.addVertex(5, 4);
        p2.addVertex(4, 0);
        System.out.println(p2.calcPerimeter());
        System.out.println(p2.calcArea());
        System.out.println(p1.isBigger(p2));
        System.out.println(p1.findVertex(new Point(2,0)));
        System.out.println(p1.getNextVertex(new Point(0,0)));

        Polygon p3 = new Polygon();
        p3.addVertex(0, 0);
        System.out.println(p3.getNextVertex(new Point(0,0)));
        System.out.println(p2.getBoundingBox());

    }

}
