/**
 * This class represents a node in a linked list of cities.
 */
public class CityNode {
    public City _city;
    public CityNode _next;

    /**
     * Constructs a new CityNode object with the given city.
     *
     * @param c The city to store in this node.
     */
    public CityNode(City c) {
        this.setCity(new City(c));
    }

    /**
     * Constructs a new CityNode object with the given city and next node.
     *
     * @param c The city to store in this node.
     * @param n The next node in the list.
     */
    public CityNode(City c, CityNode n) {
        this.setCity(new City(c));
        this.setNext(n);
    }

    /**
     * Constructs a new CityNode object as a copy of the given node.
     *
     * @param c The node to copy.
     */
    public CityNode(CityNode c) {
        this.setCity(new City(c.getCity()));
        this.setNext(c.getNext());
    }

    /**
     * Returns a copy of the city stored in this node.
     *
     * @return A copy of the city stored in this node.
     */
    public City getCity() {
        return new City(this._city);
    }

    /**
     * Sets the city stored in this node to a copy of the given city.
     *
     * @param c The city to store in this node.
     */
    public void setCity(City c) {
        this._city = new City(c);
    }

    /**
     * Returns the next node in the list.
     *
     * @return The next node in the list.
     */
    public CityNode getNext() {
        return this._next;
    }

    /**
     * Sets the next node in the list to the given node.
     *
     * @param next The next node in the list.
     */
    public void setNext(CityNode next) {
        this._next = next;
    }
}
