/**
 * Country.java - Represents a country.
 * Country is represented by its name, and by the head of a linked-list
 * of the cities in this country.
 * Id : 209956333
 *
 * @author Maya Israeli
 * @version 05.06.2023
 */

public class Country {

  // constants declaration:
  private static final int MIN_VALUE = 0; // min value for non-negative variables
  private static final int NEGATIVE_ANS = -1; // negative answer

  // attributes declarations:
  CityNode _head;
  private String _name;

  // Constructors

  /**
   * Constructor of a Country.
   * Constructs a new country with a given name.
   * Sets the head of the city's linked list to null.
   *
   * @param countryName The name of the new country.
   */
  public Country(String countryName) {
    _head = null;
    _name = countryName;
  }

  // public mathods

  /**
   * A boolean method that adds a city to the country's linked list of cities.
   * It accepts the parameters needed to creat a city.
   * The new city will be added while keeping the list arranged by establishment date.
   * At the top of the list the oldest, at the end the youngest city.
   * If the dates are the same,
   * the city closer to the top is the one whose name appears in the dictionary
   * first.
   *
   * @param name              The city's name.
   * @param day               The day the city was established.
   * @param month             The month the city was established.
   * @param year              The year the city was established.
   * @param xCenter           The x coordinate of the city's center.
   * @param yCenter           The y coordinate of the city's center.
   * @param xStation          The x coordinate of the city's central station.
   * @param yStation          The y coordinate of the city's central station.
   * @param numOfResidents    number of residents.
   * @param noOfNeighborhoods number of neighborhoods.
   * @return true if the city was successfully added,
   *         false if the city was already on the list and was not added this
   *         time.
   */
  public boolean addCity(
    String name,
    int day,
    int month,
    int year,
    int xCenter,
    int yCenter,
    int xStation,
    int yStation,
    long numOfResidents,
    int noOfNeighborhoods
  ) {
    // A city must have a name in order to determine its place on the list
    if (name == null) {
      return false;
    }

    /* Other abnormal values will be handled in the class city 
    creates a node that hold a new city with the given attributes. */
    CityNode newCity = new CityNode(
      new City(
        name,
        day,
        month,
        year,
        xCenter,
        yCenter,
        xStation,
        yStation,
        numOfResidents,
        noOfNeighborhoods
      )
    );

    if (isEmpty()) { // this is the first city added to the country
      _head = newCity;
      return true;
    }

    Date newCityDate = newCity.getCity().getDateEstablished();
    CityNode ptr = _head;
    CityNode next = _head;

    /* iterates over the city's list, promotes ptr and next until it finds the
    correct place to insert the new city */
    while (
      !emptyNode(next) &&
      isAfterChronologicallyAndLexically(
        newCityDate,
        name,
        next.getCity().getDateEstablished(),
        next.getCity().getCityName()
      )
    ) {
      ptr = next;
      next = next.getNext();
    }

    if (newCity.getCity().equals(ptr.getCity())) { // the city is already on the list
      return false;
    }

    // connecting the new cityNode to the second part of the list
    newCity.setNext(next); // if next is null, newCity's _next is null

    if (next == _head) { // new cityNode is first on the list
      _head = newCity;
      return true;
    }

    // new cityNode is in the middle of the list
    // connecting the first part of the list to new cityNode
    ptr.setNext(newCity);
    return true;
  }

  /**
   * Returns the total number of residents of the country.
   * That is, the sum of the residents in all cities.
   *
   * @return Returns the total number of residents of the country
   */
  public long getNumOfResidents() {
    long nOfResidents = MIN_VALUE;
    CityNode node = _head;

    // iterates over the cities and sums their number of residents
    while (!emptyNode(node)) {
      nOfResidents += node.getCity().getNumOfResidents();
      node = node.getNext();
    }
    return nOfResidents;
  }

  /**
   * Returns the longest distance between two cities in the country.
   *
   * @return The longest distance between two cities in the country.
   */
  public double longestDistance() {
    CityNode node1 = _head; // points at the first node

    // The number of cities in the country is less than 2
    if (emptyNode(node1) || emptyNode(node1.getNext())) {
      return MIN_VALUE;
    }

    Point cityCenter1; // first cityCenters point
    CityNode node2; // points at the secoond node
    double maxDist = MIN_VALUE; // longest distance between two cities

    // the two loops together go over every combination of two cityCenters on the list
    while (!emptyNode(node1.getNext())) {
      cityCenter1 = node1.getCity().getCityCenter();
      node2 = node1.getNext(); // second cityCenters node

      while (!emptyNode(node2)) {
        // for each combination checks if the distance is bigger than the current max
        maxDist = // updates maxDist accordingly
          Math.max(
            cityCenter1.distance(node2.getCity().getCityCenter()),
            maxDist
          );
        node2 = node2.getNext();
      }
      node1 = node1.getNext();
    }
    return maxDist;
  }

  /**
   * The method receives the name of a city (string),
   * and returns the number of cities in the country that are north of this city.
   * If the city is not in the list it will return -1.
   *
   * @param cityName the name of the city for comparing
   * @return the number of cities in the country that are north of this city.
   */
  public int numCitiesNorthOf(String cityName) {
    // find the city node by the given name
    CityNode node = getCityNodeByName(cityName);

    if (emptyNode(node)) { // city is not on the list
      return NEGATIVE_ANS;
    }

    Point cityCenter = node.getCity().getCityCenter();
    node = _head; // same pointer is used, now for pointing at the different nodes
    int numCitiesNorthOf = MIN_VALUE; // count the wanted cities

    // goes over the list, increasing counter by 1 for each city that is north of
    while (!emptyNode(node)) {
      if (node.getCity().getCityCenter().isAbove(cityCenter)) {
        numCitiesNorthOf++;
      }
      node = node.getNext();
    }

    return numCitiesNorthOf;
  }

  /**
   * Returns the southernmost city in the country by the city centers.
   * If there aren't cities in the country returns null.
   * If there is more than one southernmost city, it return the one whose established earlier.
   *
   * @return the southernmost city in the country by the city centers.
   */
  public City southernmostCity() {
    if (isEmpty()) { // there aren't cities in the country
      return null;
    }

    City southernmost = _head.getCity(); // saves the curr southernmost city
    Point southernmostPoint = southernmost.getCityCenter(); // saves city center point of southernmost city
    CityNode node = _head.getNext(); // used to go over the list

    /* Goes over the list, comparing the city center's y coordinate using isAbove method.
    Only if the current city is southern (not equal) than southernmost it will be updated.
    If the cities have the same y coordinate southernmost will not be updated, so it saves the older one. */
    while (!emptyNode(node)) {
      if (southernmostPoint.isAbove(node.getCity().getCityCenter())) {
        southernmost = node.getCity();
        southernmostPoint = southernmost.getCityCenter();
      }

      node = node.getNext();
    }

    return southernmost; // aliasing was prevented in CityNode, this is a new object.
  }

  /**
   * Returns the name of the country.
   *
   * @return The name of the country.
   */
  public String getCountryName() {
    return _name;
  }

  /**
   * Returns the number of cities in the country.
   *
   * @return the number of cities in the country.
   */
  public int getNumOfCities() {
    return getNumOfCities(_head);
  }

  private int getNumOfCities(CityNode node) {
    // base case - node is null so there are no cities
    if (emptyNode(node)) {
      return MIN_VALUE;
    }

    // recursively call the method with the next node on the list
    return 1 + getNumOfCities(node.getNext());
  }

  /**
   * A boolean method, receives two dates.
   * Returns whether any city in the country was established just before the earliest of the dates
   * or just after the later of them.
   *
   * @param date1 The first object of type date for the purpose of the test
   * @param date2 The second object of type date for the purpose of the test
   * @return whether any city was established just before the earliest of the dates,
   *         or just after the later of them.
   */

  public boolean wereCitiesEstablishedBeforeOrAfter(Date date1, Date date2) {
    /* The list is arranged by chronological order. 
       So, the  establishment date of the first city is the earliest,
       and the establishment date of the last city is the latest.
       Therefore, it checks only if one of them meets the requirements,
       using the cityEstablishedBetweenDates method.
       This method handles dates that are not necessarily in chronological order.
       If a date is not between the given dates or equal to one,
       then it is before the earliest or just after the later.
       
       if list is empty no city meets the requirements
       else, head is not null, so last is not null (at worst they are equal) -
       methods can be used on them.*/

    return (
      !isEmpty() &&
      (
        !_head.getCity().cityEstablishedBetweenDates(date1, date2) ||
        !lastCityNode().getCity().cityEstablishedBetweenDates(date1, date2)
      )
    );
  }

  /**
   * The method receives the names of two cities and unite those cities.
   * The city object of the node holding the older city will be changed to those of the unified city.
   * The node of the younger city will be removed from the list.
   *
   * The name of the united city will be "cityName1-cityName2".
   * Its date of establishment will be the earlier of the two.
   * Its number of residents will be the sum of residents in both cities.
   * Its number of neighborhoods is the sum of the numbers of the neighborhoods in both cities.
   * Its center's location is halfway between the two city centers.
   * Its central station's location  is at the more western station Of the two,
   * If the two have the same x, the location of the younger city will be choosen.
   * It is assumed that the parameters are names of cities that exist on the list.
   *
   * @param cityName1  name of first city to unify
   * @param cityName2  ame of second city to unify
   * @return a copy of the object of the unifidied city
   */
  public City unifyCities(String cityName1, String cityName2) {
    CityNode node1 = getCityNodeByName(cityName1);
    CityNode node2 = getCityNodeByName(cityName2);

    // if node 1's city was established after node 2's city - it switches the pointers
    if (
      node1
        .getCity()
        .getDateEstablished()
        .after(node2.getCity().getDateEstablished())
    ) {
      CityNode tmp = node2;
      node2 = node1;
      node1 = tmp;
    }

    City city1 = node1.getCity(); // city1 holds a new *copy of the city in node1
    City city2 = node2.getCity(); // city2 holds a new *copy of the city in node2

    /* city1 was established before city2 and nodes accordingly.
    city1's values are going to change to those of the united city.
    so there is no need to change city1's date */

    // The name of the united city will be "cityName1-cityName2".
    city1.setCityName(cityName1 + "-" + cityName2);

    // The number of residents will be the sum of residents in both cities.
    city1.setNumOfResidents(
      city1.getNumOfResidents() + city2.getNumOfResidents()
    );

    // Its number of neighborhoods is the sum of neighborhoods in both cities.
    city1.setNumOfNeighborhoods(
      city1.getNumOfNeighborhoods() + city2.getNumOfNeighborhoods()
    );

    // The city center location is in the middle of the two city centers.
    city1.setCityCenter(city1.getCityCenter().middle(city2.getCityCenter()));

    // if city2 (the younger) has the same or a smaller x value - change to it
    if (!city2.getCentralStation().isRight(city1.getCentralStation())) {
      city1.setCentralStation(city2.getCentralStation()); // setCentralStation is preventing aliasing
    }

    // remove city two from the cities list
    removeNode(node2);

    // after changing the values in a copy of the city in node1 (city1)
    node1.setCity(city1); // setCity sets (a copy of) city1 as the city object of node1

    // no worry of aliasing, city1 is a new object created,
    // it is not the actual object in the linked list and it is not saved anywhere else
    return city1;
  }

  /**
   * Returns the maximum difference (in the days)
   * between the establishment dates of any two cities in the country.
   * If there are no cities in the country it will return -1.
   * If the country has one city, it will return 0.
   *
   * @return Returns the maximum difference (in the days)
   *         between the establishment dates of any two cities in the country
   */
  public int establishMaxDiff() {
    if (isEmpty()) { // head is null
      return NEGATIVE_ANS;
    } // head is not null

    if (emptyNode(_head.getNext())) { // only one object is on the list
      return MIN_VALUE;
    }

    /* The objects in the list are arranged according to the date of establishment,
     so the difference between the first date and the last date is the maximum.
     head and last are not null and are different. */
    return _head
      .getCity()
      .getDateEstablished()
      .difference(lastCityNode().getCity().getDateEstablished()); // difference is a method in the class Date
  }

  /**
   * Return a string representation of this country.
   * In it the name of the country is indicated and there is detail about the cities in it.
   *
   * @return String representation of this country.
   */
  public String toString() {
    //  head is null - there are no cities in the country
    if (isEmpty()) {
      return "There are no cities in this country.";
    }

    String str = "Cities of " + _name + ":";
    CityNode node = _head;

    // adds to the string the details of each city
    while (!emptyNode(node)) {
      str += "\n\n" + node.getCity(); // the method toString is automatically called
      node = node.getNext(); // move to next
    }

    return str;
  }

  // private methods

  /* A private boolean method that recives the established dates and the name of two cities.
     One is the city we want to add to the list (newCity),
     the other is a city we want to check whether newCity should be placed before or after it (nextCity),
     according to date and lexical order.
     The method returns true if the established date of the new city is the later one,
     or if the date are the same and the name of the new city is lexically after or equivalent. */

  private boolean isAfterChronologicallyAndLexically(
    Date newCityDate,
    String newCityName,
    Date nextCityDate,
    String nextCityName
  ) {
    return (
      newCityDate.after(nextCityDate) ||
      newCityDate.equals(nextCityDate) &&
      newCityName.compareTo(nextCityName) >= MIN_VALUE
    );
  }

  /* returns if there are no cities in the linked-list, linked list is empty */
  private boolean isEmpty() {
    return emptyNode(_head);
  }

  /* returns if the given node is empty */
  private boolean emptyNode(CityNode node) {
    return node == null;
  }

  /* returns a CityNode object that its name is equals to the given name */
  private CityNode getCityNodeByName(String cityName) {
    CityNode node = _head;

    // searching the name in the list
    while (!emptyNode(node)) {
      if (node.getCity().getCityName().equals(cityName)) {
        return node;
      }
      node = node.getNext();
    }

    return null;
  }

  /* removing the given node from the linked-list of cities */
  private void removeNode(CityNode node) {
    if (!isEmpty()) {
      if (_head == node) {
        _head = _head.getNext();
      } else {
        CityNode behind = _head;
        while (!emptyNode(behind.getNext())) {
          if (behind.getNext() == node) {
            behind.setNext(behind.getNext().getNext());
            return;
          }
          behind = behind.getNext();
        } // of while
      } // of else ( num is not in _head)
    } // of if ( list is not empty)
  } // of the method

  /* returns the last CityNode on the list */
  private CityNode lastCityNode() {
    if (isEmpty()) { // last city is null
      return null;
    }

    // head is not null we can use getNext method
    CityNode last = _head;

    // changes last until it is really the last node
    while (!emptyNode(last.getNext())) {
      last = last.getNext();
    }

    return last;
  }
}
