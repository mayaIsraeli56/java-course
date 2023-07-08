public class Tester3 {

  public static void main(String[] args) {
    line();
    print("STARTING NEW PERSONAL TEST");
    line();

    Country france = new Country("France");
    print(
      "just created France, the number of cities is " + france.getNumOfCities()
    );

    City a1 = new City("Flotzem", 19, 5, 1921, 7, 7, 4, 4, 164, 1);
    City a2 = new City("Momoinku", 19, 5, 1521, 7, 7, 4, 4, 164, 1);
    City a3 = new City("ZMomoIsland", 19, 5, 1521, 7, 7, 4, 4, 164, 1);
    City a4 = new City("AAA", 19, 5, 1321, 7, 7, 4, 4, 164, 1);
    City a5 = new City("AAA1", 19, 5, 2121, 7, 7, 4, 4, 164, 1);
    City a6 = new City("AAA1", 19, 5, 2121, 7, 7, 4, 4, 164, 1);

    print(
      "city a1 was founded in 1521. city a2 was established in 1921. check for a2 before a1: " +
      (a2.getDateEstablished().before(a1.getDateEstablished()))
    );

    line();
    print("adding new cities" + "\n");

    print("Adding city " + "\n" + "\n" + a2.toString() + "\n");
    france.addCity("Momoinku", 19, 5, 1521, 7, 7, 4, 4, 164, 1);
    print("number of cities is " + france.getNumOfCities() + "");

    print("Adding city " + "\n" + "\n" + a2.toString() + "\n");
    france.addCity("Flotzem", 19, 5, 1921, 7, 7, 4, 4, 164, 1);
    print("number of cities is" + france.getNumOfCities() + "");

    print("Adding city " + "\n" + "\n" + a3.toString() + "\n");
    france.addCity("ZMomoIsland", 19, 5, 1521, 7, 7, 4, 4, 164, 1);
    print("number of cities is" + france.getNumOfCities() + "");

    print("Adding city " + "\n" + "\n" + a4.toString() + "\n");
    france.addCity("AAA", 19, 5, 1321, 7, 7, 4, 4, 164, 1);
    print("number of cities is" + france.getNumOfCities() + "");

    print("Adding city " + "\n" + "\n" + a5.toString() + "\n");
    france.addCity("BBB1", 19, 5, 2121, 7, 7, 4, 4, 164, 1);
    print("number of cities is" + france.getNumOfCities() + "");

    line();
    print(
      "check if equals in name works well: " +
      "\n" +
      "should be true: " +
      a5.getCityName().equals(a6.getCityName()) +
      "\n" +
      "should be false: " +
      a1.getCityName().equals(a6.getCityName())
    );
    line();

    line();
    print(
      "the cities were added in this order: Momoinku, Flotzem, ZMomoIsland, AAA, BBB1"
    );
    print(
      "there should be 5 cities. 1-\"aaa\", 2-\"Momoinku\", 3-\"ZmomoIsland\", 4-\"Flotzem\", 5-\"BBB1\" "
    );
    line();

    print("printing the country: " + "\n" + france.toString());

    france.addCity("Momoinku", 19, 5, 1521, 7, 7, 4, 4, 164, 1);
    print("number of cities is" + france.getNumOfCities() + "");
  }

    public static void print(String msg) {
      System.out.println(msg + "\n");
    }

    public static void line() {
      print("**************");
    }
  }

