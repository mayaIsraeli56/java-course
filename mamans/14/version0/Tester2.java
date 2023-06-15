public class Tester2 {

  public static void main(String[] args) {
    Country c = new Country("country");

    System.out.println(c.addCity("a", 1, 1, 1000, 2, 2, 3, 3, 4, 5));

    System.out.println(c.addCity("b", 1, 1, 1001, 2, 2, 3, 3, 4, 5));
    System.out.println(c.addCity("c", 1, 1, 1001, 2, 2, 3, 3, 4, 5));
    System.out.println(c.addCity("c", 1, 1, 1000, 2, 2, 3, 3, 4, 5));
    System.out.println(c.addCity("a", 1, 1, 1000, 2, 2, 3, 3, 4, 5));
    System.out.println(c.addCity("b", 2, 1, 1001, 2, 2, 3, 3, 4, 6));
    System.out.println(c.addCity("b", 2, 1, 1001, 2, 2, 3, 3, 4, 6));
    System.out.println(c.addCity("b", 1, 1, 1001, 2, 2, 3, 3, 4, 5));

    System.out.println(c.toString());
    System.out.println(c.getNumOfResidents());
  }
}
