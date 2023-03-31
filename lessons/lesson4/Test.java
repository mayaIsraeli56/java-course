public class Test {

    /**
     * @param args
     * @return
     */
    public static void main(String[] args) {

        ////////////////////BOX///////////////////////
        /* Box box1 = new Box(1, 2, 3);
        System.out.println("box1: " + box1);
        box1.setWidth(-5);
        System.out.println("box1: " + box1);
        box1.setHeight(10);
        System.out.println("box1: " + box1);

        Box b10 = new Box(5, 7, 4);
        Box b11 = b10;
        Box b12 = new Box(5, 7, 4);
        Box b13 = new Box(3, 6, 9);

        System.out.println("b10.equals(b11): " + b10.equals(b11));
        System.out.println("b10==b11: " + (b10 == b11));
        System.out.println("b10.equals(b12): " + b10.equals(b12));
        System.out.println("b10==b12: " + (b10 == b12));
        System.out.println("b10.equals(b13): " + b10.equals(b13)); */
        

        ////////////////////StaticTry///////////////////////
        System.out.println(StaticTry.max(2, 3, 1));
        System.out.println(StaticTry.max(1, 2, 3));
        System.out.println(StaticTry.max(3, 1, 2));

        StaticTry.solve(1, 11, 30);
    }   
}
