public class Tester {

  public static void main(String[] args) {
    AA a1 = new AA();
    AA a2 = new BB();
    AA a3 = new AA();
    AA a4 = new BB();
    BB b1 = new BB();
    BB b2 = new BB();
    // כאן יוכנסו השורות שבשאלות להלן
    System.out.println(a3.equals(a1));
    System.out.println(b1.equals(a1));
  }
}
