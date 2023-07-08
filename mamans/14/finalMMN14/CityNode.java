/**
 * CityNode.java - Represents a single node with a city object.
 * Each node holds a city object and the following  node (to create a linked-list).
 * Id : 209956333
 *
 * @author Maya Israeli
 * @version 05.06.2023
 */

public class CityNode {

  // Instance variables
  private City _city;
  private CityNode _next;

  // Constructors

  /**
   * Constructs a node with a given city, next node is set to null.
   * @param c The city to initialize the node with.
   */
  public CityNode(City c) {
    _city = new City(c);
    _next = null;
  }

  /**
   * Constructs a node with a given city and sets its next node to a given one.
   * @param c The city to initialize the node with.
   * @param next The next node to point at.
   */
  public CityNode(City c, CityNode next) {
    _city = new City(c);
    _next = next;
  }

  /**
   * Copy constructor for CityNode.
   * Constructs a new CityNode with the same attributes as another CityNode.
   *
   * @param c The CityNode object from which to construct the new CityNode.
   */
  public CityNode(CityNode c) {
    this(c._city, c._next);
  }

  // methods

  /**
   * Returns a copy of the city object of the node.
   * @return  a copy of the city object of the node.
   */
  public City getCity() {
    return new City(_city);
  }

  /**
   * Returns the next node which the current node is pointing to.
   * @return The next node.
   */
  public CityNode getNext() {
    return _next;
  }

  /**
   * Receives a city and sets a copy of it to the current node.
   * @param c The city to set.
   */
  public void setCity(City c) {
    _city = new City(c);
  }

  /**
   * Receives a node to point next.
   * @param next The next node to set.
   */
  public void setNext(CityNode next) {
    _next = next;
  }
} // end of class