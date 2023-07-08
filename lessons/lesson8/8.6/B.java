public class B extends A {

  private int _b;

  public B() {
    _b = 2;
  }

  public void printMe() {
    System.out.println("B " + _b +" " + super.getA());
  }
}
