public class CityNodeSolution
{
    private City _city;
    private CityNodeSolution _next;

    /**
     * CityNodeSolution (City c)
     */
    public CityNodeSolution (City c)
    {
        _city = new City(c);
        _next = null;
    }

    /**
     * CityNodeSolution (City c, CityNodeSolution n)
     */
    public CityNodeSolution (City c, CityNodeSolution n)
    {
        _city = new City(c);
        _next = n;
    }

    /**
     * CityNodeSolution (CityNodeSolution c)
     */
    public CityNodeSolution (CityNodeSolution c)
    {
        _city = new City(c._city);
        _next = c._next;
    }

    /**
     * City getCity()
     */
    public City getCity() {return new City(_city);}

    /**
     * CityNodeSolution getNext()
     */
    public CityNodeSolution getNext() {return _next;} 

    /**
     * void setCity(City c)
     */
    public void setCity(City c)
    {
        _city = new City(c);
    }

    /**
     * void setNext(CityNodeSolution next)
     */
    public void setNext(CityNodeSolution next)
    {
        _next = next;
    }
}
