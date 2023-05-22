public class Driver {

  public static void main(String[] args) {
    C cd = new D();

    D dd = (D) cd;

    // כאן יוכנסו השורות שבשאלות להלן
    cd.foo(dd);
    dd.foo(dd);
  }
}
