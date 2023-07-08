public class Dalmatian extends Dog {
     public Dalmatian() {
    super("kiki");
    System.out.println("new Dalmatian");
  }

  public void compare(Dog a) {
    System.out.println("c... d");
    compare((Ani) a);
  }

  public void compare(Ani a) {
    if (
      (a instanceof Poodle) || a instanceof Dog && ((Dog) a)._n.equals("kiki")
    ) System.out.println("poodle - positive"); else System.out.println(
      "poodle - negative"
    );
  }
}
