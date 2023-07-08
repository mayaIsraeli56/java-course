public class Tester {
   public static void main(String[] args) {
    B b1 = new B();
    A a1 = (A)b1;

    ((A)b1).printMe();
    (a1).printMe();
   }
}
