public class Tester {

  public static void main(String[] args) {
    //Q1
    //System.out.println(Q1.calc(3, 36, 4));

    //Q2
    // int[] a = {3,0,0,4,7,9,0,0,0,0,11,15,0,19,20,0,0,31,40,0};
    // int[] b = {0};
    // System.out.println(Q2.kAlmostSearch(b, 30));

    //Q4
    Q4.A y1 = new Q4.B(100);
    Q4.B y2 = new Q4.B(100);
    Q4.B y3 = new Q4.B(20);
    Q4.A z1 = new Q4.C();
    Q4.C z2 = new Q4.C();
   
    System.out.println("1: " + y1.foo(y2));
    System.out.println("1: " + y2.foo(y1));
    System.out.println();
    System.out.println("2: " + y1.foo(y3));
    System.out.println("2: " + y3.foo(y1));
    System.out.println();
    System.out.println("3: " + y1.foo(z1));
    System.out.println("3: " + y1.foo(z2));
    System.out.println();
    System.out.println("4: " + y2.foo(y3));
    System.out.println();
    System.out.println("5: " + y2.foo(z1));
    System.out.println();
    System.out.println("6: " + y2.foo(z2));
    System.out.println();
    System.out.println("7: " + y3.foo(z2));
    System.out.println();
    System.out.println("8: " + z1.foo(y1));
    System.out.println("8: " + z1.foo(y2));
    System.out.println("8: " + z1.foo(y3));
    System.out.println("8: " + z1.foo(z1));
  }
}
