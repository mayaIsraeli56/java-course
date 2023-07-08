public class Tester2 {

  public static void main(String[] args) {
    Country c = new Country("country");

    System.out.println(c.addCity("a", 1, 1, 1000, 2, 2, 3, 3, 4, 5));
    System.out.println(c.addCity("bB", 2, 1, 1000, 2, 0, 3, 3, 4, 5));
    System.out.println(c.addCity("c", 2, 1, 1002, 2, 2, 4, 3, 4, 5));
    System.out.println(c.addCity("a", 2, 1, 1000, 2, 2, 3, 3, 4, 5));
    System.out.println(c.addCity("b", 2, 1, 1001, 2, 2, 3, 3, 4, 6));
    System.out.println(c.addCity("Aa", 3, 1, 1001, 2, 8, 4, 1, 4, 6));
    System.out.println(c.addCity("A", 3, 1, 1001, 0, 0, 4, 1, 9, 6));
    // System.out.println(c.addCity("B", 3, 1, 1001, -10, 2, 3, 2, 4, 5));
    // System.out.println(c.addCity("Bb", 3, 1, 1001, 0, 2, 3, 2, 4, 5));
    // System.out.println(c.addCity("Bb", 3, 1, 1001, 0, 2, 3, 2, 4, 5));
    System.out.println(c.addCity(null, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    System.out.println(
      "addCity" + c.addCity(null, -1, -1, -1, -1, -1, -1, -1, -1, -1)
    );
    System.out.println("getCountryName " + c.getCountryName());
    System.out.println("getNumOfCities " + c.getNumOfCities());
    System.out.println("getNumOfResidents " + c.getNumOfResidents());
    System.out.println("longestDistance " + c.longestDistance());
    System.out.println("numCitiesNorthOf " + c.numCitiesNorthOf("c"));
    System.out.println(" \nsouthernmostCity: \n" + c.southernmostCity());
    System.out.println("getNumOfCities " + c.getNumOfCities());
    System.out.println("establishMaxDiff " + c.establishMaxDiff());

    System.out.println("toString " + c.toString());
    System.out.println(
      "werebeforeOrAfter " +
      c.wereCitiesEstablishedBeforeOrAfter(
        new Date(2, 1, 1000),
        new Date(3, 1, 1001)
      )
    );
    System.out.println("***********************************8");
    System.out.println(c.unifyCities("c", "A"));
    System.out.println("***********************************7");

    System.out.println(c.toString());
    System.out.println("establishMaxDiff " + c.establishMaxDiff());
  }
}
