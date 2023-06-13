public class Tester {

  // public static void main(String[] args) {
  //   City c1 = new City("A", 1, 1, 1, 6, 7, 7, 8, 600, 10);
  //   City c2 = new City("B", 2, 1, 1, 20, 40, 50, 60, 300, 50);
  //   City c3 = new City("C", 3, 1, 1, 20, 40, 50, 60, 300, 50);
  //   City c4 = new City("D", 4, 1, 1, 20, 40, 50, 60, 300, 50);

  //   CityNode n1 = new CityNode(c1);
  //   CityNode n2 = new CityNode(c2);
  //   CityNode n3 = new CityNode(c3);
  //   CityNode n4 = new CityNode(c4);

  //   Date d1 = new Date(1,1,2000);
  //   Date d2 = new Date(5,1,2000);

  //   n1.setNext(n2);
  //   n2.setNext(n3);
  //   n3.setNext(n4);

  //   Country co1 = new Country("I");
  //       System.out.println(co1.toString());

  //   System.out.println(co1.addCity("BA", 4, 1, 2000, 4, 6, 0, 10, 4, 4));
  //   System.out.println(co1.addCity("B", 2, 1, 2000, 2, 2, 3, 3, 4, 4));

  //   System.out.println(co1.addCity("B", 4, 1, 2000, 2, 2, 3, 3, 4, 4));
  //   System.out.println(co1.addCity("C", 3, 1, 2000, 2, 2, 3, 3, 4, 4));
  //   System.out.println(co1.addCity("A", 2, 1, 2000, 2, 2, 3, 3, 4, 4));
  //   System.out.println(co1.addCity("A", 2, 1, 2001, 2, 2, 3, 3, 4, 4));
  //   System.out.println("\n");

  //   // co1.print();
  //   // System.out.println("getNumOfResidents: " + co1.getNumOfResidents());
  //   // System.out.println("longestDistance: " + co1.longestDistance());
  //   // System.out.println("numCitiesNorthOf: " + co1.numCitiesNorthOf("BCA"));
  //   // System.out.println("southernmostCity: " + co1.southernmostCity().getCityName());
  //   // System.out.println("getNumOfCities: " + co1.getNumOfCities());
  //   // System.out.println("wereCitiesEstablishedBeforeOrAfter: " + co1.wereCitiesEstablishedBeforeOrAfter(d1,d2));
  //   // System.out.println("unifyCities: " + co1.unifyCities("BA", "B"));

  //   // System.out.println("////////////////////////////////////////");
  //   // System.out.println(  co1.unifyCities("C", "B"));
  //   //   System.out.println("////////////////////////////////////////");
  //   System.out.println(co1.toString());

  //   System.out.println("establishMaxDiff: " + co1.establishMaxDiff());

  // }

  // public static void main(String[] args) {
  //   System.out.println(
  //     "============ Starting students tester for MAMAN 14 ============\n"
  //   );
  //   City c1 = new City("Jerusalem", 1, 2, 3, 4, 5, 6, 7, 8, 9);
  //   CityNode cn1 = new CityNode(c1);
  //   City c2 = new City("Tel-Aviv", 11, 12, 13, 14, 15, 16, 17, 18, 19);
  //   CityNode cn2 = new CityNode(c1, cn1);
  //   CityNode cn3 = new CityNode(cn2);

  //   City c3 = cn1.getCity();
  //   CityNode cn4 = cn2.getNext();
  //   cn4.setCity(c3);
  //   cn2.setNext(cn1);

  //   Country co1 = new Country("Utopia");
  //   co1.addCity("Jerusalem", 1, 2, 3, 4, 5, 6, 7, 8, 9);
  //   co1.addCity("Tel-Aviv", 11, 12, 13, 14, 15, 16, 17, 18, 19);

  //   long i1 = co1.getNumOfResidents();
  //   double d1 = co1.longestDistance();
  //   i1 = co1.numCitiesNorthOf("Jerusalem");
  //   c1 = co1.southernmostCity();
  //   String s1 = co1.getCountryName();
  //   i1 = co1.getNumOfCities();
  //   boolean b1 = co1.wereCitiesEstablishedBeforeOrAfter(
  //     new Date(10, 10, 2010),
  //     new Date(5, 5, 2005)
  //   );
  //   c1 = co1.unifyCities("Jerusalem", "Tel-Aviv");
  //   i1 = co1.establishMaxDiff();
  //   System.out.println("Current country value :\n" + co1);
  //   System.out.println(
  //     "============ Finishing students tester for MAMAN 14 ============"
  //   );

  //   System.out.println(
  //     "The tester compiled and ran without any error.\n" +
  //     "PLEASE NOTICE : ALL THIS TESTER CHECKS is whether you\n" +
  //     "wrote all the expected constructors and methods in the\n" +
  //     "CityNode and Country classes, and that you used the correct\n" +
  //     "interface (i.e. number of parameters and types.)\n" +
  //     "THIS TESTER DOES NOT CHECK WHETHER YOUR CODE DOES THE JOB WELL.\n" +
  //     "YOU SHOULD WRITE YOUR OWN TESTER TO CHECK FOR THE CORRECTNESS OF YOUR CODE.\n" +
  //     "However if your code does not compile with this tester, your grade for\n" +
  //     "this MAMAN will be 0, without any possibility of appeal !\n"
  //   );
  // }
}
