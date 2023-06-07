public class CityNode {
    
    private City _city;
    private CityNode _next;

    public CityNode (City c) {
        _city = new City(c);
        _next = null;
    }

    public CityNode (City c, CityNode next)  {
        _city = new City(c);
        _next = next;
    }

    public CityNode (CityNode c) {
        _city = new City(c._city);
        _next = c._next;
    }

    public City getCity() {
        return new City(_city);
    }

    public CityNode getNext(){
        return _next;
    }

    public void setCity(City c) {
        _city = new City(c);
    }

    public void setNext(CityNode next) {
        _next = next;
    }
}
