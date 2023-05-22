public class Tester {
    public static void main(String[] args) {
        A b1 = new B(2,2);
        A c1 = new C (5,2);
        B b2 = new B(5,2);
        C c2 = new C(3,4);

        System.out.println(b1.foo(2));
        System.out.println(!b2.foo(5));
        System.out.println(b2.foo(2));
        System.out.println(c1.foo(3));
        System.out.println(c2.foo(3));
        System.out.println(!c2.foo(4));

        System.out.println();
        System.out.println(c1.equals(b1));
        System.out.println(c1.equals(b2));
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(b1));
        System.out.println(c2.equals(b2));

        B b3 = new B(2,10);
        System.out.println(b3.equals(b1));

        B obj = new B(2,10);
        System.out.println(b3.equals(b1));

        A a1 = new B(2,10);

        Object obj2 = new Object();
        System.out.println(b3.equals(obj2));

        System.out.println();
        System.out.println(a1.equals(b2));
        System.out.println(b3.equals(b1));
        System.out.println(c1.equals(c2));
        System.out.println(b3.equals(obj));
        System.out.println(obj.equals(a1));
    }
}
