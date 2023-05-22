public class Driver {

  public static void main(String[] args) {
    AA a1 = new AA();
    AA a2 = new BB();
    AA a3 = new AA();
    AA a4 = new BB();
    BB b1 = new BB();
    BB b2 = new BB();
    // כאן יוכנסו השורות שבשאלות להלן
    System.out.println(a4.equals(a2));
    System.out.println(a2.equals(b1));
  }
}
