public class Country {

  CityNode _head;
  private String _name;

  private final int MIN_DISTANCE = 0;

  public Country(String name) {
    _head = null;
    _name = name;
  }

  public boolean addCity(
    String cityName,
    int dayEstablished,
    int monthEstablished,
    int yearEstablished,
    int centerX,
    int centerY,
    int stationX,
    int stationY,
    long numOfResidents,
    int noOfNeighborhoods
  ) {
    City newCity = new City(
      cityName,
      dayEstablished,
      monthEstablished,
      yearEstablished,
      centerX,
      centerY,
      stationX,
      stationY,
      numOfResidents,
      noOfNeighborhoods
    );

    if (isEmpty()) {
      _head = new CityNode(newCity);
      return true;
    }

    Date newCityDate = newCity.getDateEstablished();
    String newCityName = newCity.getCityName();

    CityNode ptr = _head;
    CityNode next = _head;

    while (
      next != null &&
      isAfter(
        newCityDate,
        newCityName,
        next.getCity().getDateEstablished(),
        next.getCity().getCityName()
      )
    ) {
      ptr = next;
      next = next.getNext();
    }

    if (newCity.equals(ptr.getCity())) {
      return false;
    }

    if (next == _head) { // points at the same object
      _head = new CityNode(newCity, next);
      return true;
    }

    ptr.setNext(new CityNode(newCity, next));
    return true;
  }

  public long getNumOfResidents() {
    // if (isEmpty()) {
    //   return 0;
    // }

    long count = 0;
    CityNode node = _head;

    while (node != null) {
      count += node.getCity().getNumOfResidents();
      node = node.getNext();
    }
    return count;
  }

  public double longestDistance() {
    CityNode node1 = _head;

    if (node1 == null || node1.getNext() == null) {
      return MIN_DISTANCE;
    }

    CityNode node2;
    Point cityCenter1;
    double maxDist = MIN_DISTANCE;

    while (node1.getNext() != null) {
      cityCenter1 = node1.getCity().getCityCenter();
      node2 = node1.getNext();

      while (node2 != null) {
        maxDist =
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

  public int numCitiesNorthOf(String cityName) {
    CityNode node = _head;
    Point cityCenter = null;

    while (node != null && cityCenter == null) {
      if (node.getCity().getCityName().equals(cityName)) {
        cityCenter = node.getCity().getCityCenter();
      }
      node = node.getNext();
    }

    if (cityCenter == null) {
      return -1;
    }

    node = _head;
    int count = 0;

    while (node != null) {
      if (node.getCity().getCityCenter().isAbove(cityCenter)) {
        count++;
      }
      node = node.getNext();
    }

    return count;
  }

  public City southernmostCity() {
    if (isEmpty()) {
      return null;
    }

    City southernmost = _head.getCity();
    CityNode node = _head.getNext();

    while (node != null) {
      if (
        southernmost.getCityCenter().isAbove(node.getCity().getCityCenter())
      ) {
        southernmost = node.getCity();
      }

      node = node.getNext();
    }

    return new City(southernmost);
  }

  public String getCountryName() {
    return _name;
  }

  public int getNumOfCities() {
    return getNumOfCities(_head);
  }

  private int getNumOfCities(CityNode node) {
    if (node == null) {
      return 0;
    }
    return 1 + getNumOfCities(node.getNext());
  }

  // ???????????????????????
  public boolean wereCitiesEstablishedBeforeOrAfter(Date date1, Date date2) {
    CityNode node = _head;

    if (date2.before(date1)) {
      Date tmp = date2;
      date2 = date1;
      date1 = tmp;
    }

    while (node != null) {
      if (
        node.getCity().getDateEstablished().before(date1) ||
        node.getCity().getDateEstablished().after(date2)
      ) {
        return true;
      }

      node = node.getNext();
    }
    return false;
  }

  public City unifyCities(String cityName1, String cityName2) {
    CityNode node1 = getCityNodeByName(cityName1);
    CityNode node2 = getCityNodeByName(cityName2);

    City city1 = node1.getCity();
    City city2 = node2.getCity();

    if (city2.getDateEstablished().before(city1.getDateEstablished())) {
      CityNode tmp = node2;
      node2 = node1;
      node1 = tmp;
      city1 = node1.getCity();
      city2 = node2.getCity();
    }

    //city1 is before city2 and nodes accordingly
    city1.setCityName(cityName1 + "-" + cityName2);

    city1.setCityCenter(city1.getCityCenter().middle(city2.getCityCenter()));

    // if c2 (the younger) has the same or a smaller x value 
    if (!city2.getCentralStation().isRight(city1.getCentralStation())) {
      city1.setCentralStation(new Point(city2.getCentralStation()));
    }

    city1.setNumOfResidents(
      city1.getNumOfResidents() + city2.getNumOfResidents()
    );

    city1.setNumOfNeighborhoods(
      city1.getNumOfNeighborhoods() + city2.getNumOfNeighborhoods()
    );

    remove(node2);
    node1.setCity(city1);

    return new City(city1);
  }

  public int establishMaxDiff() {
    if (isEmpty()) {
      return -1;
    }

    CityNode node = _head.getNext();

    if (node == null) {
      return 0;
    }

    while (node.getNext() != null) {
      node = node.getNext();
    }

    return _head
      .getCity()
      .getDateEstablished()
      .difference(node.getCity().getDateEstablished());
  }

  @Override
  public String toString() {
    if (isEmpty()) {
      return "There are no cities in this country.";
    }

    String str = "Cities of " + _name + ":";
    CityNode node = _head;

    while (node != null) {
      str += "\n\n" + node.getCity().toString();
      node = node.getNext();
    }

    return str;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////
  private boolean isAfter(
    Date newCityDate,
    String newCityName,
    Date nextCityDate,
    String nextCityName
  ) {
    return (
      newCityDate.after(nextCityDate) ||
      newCityDate.equals(nextCityDate) &&
      newCityName.compareTo(nextCityName) > 0
    );
  }

  private boolean isEmpty() {
    return _head == null;
  }

  private CityNode getCityNodeByName(String cityName) {
    CityNode node = _head;

    while (node != null) {
      if (node.getCity().getCityName().equals(cityName)) {
        return node;
      }
      node = node.getNext();
    }

    return null;
  }

  // private City getCityByName(String cityName) {
  //   CityNode node = _head;

  //   while (node != null) {
  //     if (node.getCity().getCityName().equals(cityName)) {
  //       return node.getCity();
  //     }
  //     node = node.getNext();
  //   }

  //   return null;
  // }

  public void remove(CityNode node) {
    if (_head != null) {
      if (_head == node) {
        _head = _head.getNext();
      } else {
        CityNode behind = _head;
        while (behind.getNext() != null) {
          if (behind.getNext() == node) {
            behind.setNext(behind.getNext().getNext());
            return;
          } else {
            behind = behind.getNext();
          }
        } // of while
      } // of else ( num is not in _head)
    } // of if ( list is not empty)
  } // of the method

  public void print() {
    if (isEmpty()) return;
    print(_head);
  }

  private void print(CityNode curr) {
    if (curr == null) return;

    System.out.print(curr.getCity().toString() + " \n \n");
    print(curr.getNext());
  }
}
