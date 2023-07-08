public class Poodle extends Dog {

  public Poodle() {
    super("kiki");
    System.out.println("new poodle");
  }

  public void compare(Dog a) {
    System.out.println("c... p");
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
