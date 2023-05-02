/**
 * Represents a city.
 * City is represented by its name, the date of established,  center, central station, 
 * number of residents(non negative) and number of neighborhoods(positive).
 * 
 */
public class CitySolution
{
    private String _cityName;
    private DateSolution _dateEstablished;
    private PointSolution _cityCenter;
    private PointSolution _centralStation;
    private long  _numOfResidents;
    private int _numOfNeighborhoods;
    public final int MIN_RESIDENTS=0,MIN_NEIGHBORHOODS=1;
    /**
     * Constructor a city.
     * Construct a new city with name, x y coordinates of city center, x y coordinates of central station, 
     * number of residents (non negative, if negative will be set to 0), number of neighborhoods (positive, if less than 1 will be set to 1.).
     * @param cityName The city's name
     * @param dayEstablished The day the city established
     * @param monthEstablished The month the city established
     * @param yearEstablished The year the city established
     * @param centerX The x coordinate of the city's center
     * @param centerY The y coordinate of the city's center
     * @param stationX The x coordinate of the city's central station
     * @param stationY The y coordinate of the city's central station
     * @param numOfResidents number of residents
     * @param noOfNeighborhoods number of neighborhoods
     */ 
    public CitySolution(String cityName,int dayEstablished,int monthEstablished, int yearEstablished, int centerX,int centerY,int stationX,int stationY,long numOfResidents,int noOfNeighborhoods)
    {
        _cityName=cityName;
        _dateEstablished = new DateSolution(dayEstablished, monthEstablished, yearEstablished);
        _cityCenter=new PointSolution(centerX,centerY);
        _centralStation=new PointSolution(stationX,stationY);
        _numOfResidents=(numOfResidents<MIN_RESIDENTS)? MIN_RESIDENTS : numOfResidents;
        _numOfNeighborhoods=(noOfNeighborhoods<=MIN_NEIGHBORHOODS)? MIN_NEIGHBORHOODS : noOfNeighborhoods;   
    } 

    /**
     * Copy constructor for cities.
     * Construct a city with the same attributes as  another city.
     * @param other The City  object from  which to construct the new city.
     */
    public CitySolution(CitySolution other)
    {
        _cityName=other._cityName;
        _dateEstablished = new DateSolution(other._dateEstablished);
        _cityCenter=new PointSolution(other._cityCenter);
        _centralStation=new PointSolution(other._centralStation);
        _numOfResidents=other._numOfResidents;
        _numOfNeighborhoods=other._numOfNeighborhoods; 

    }

    /**
     * Returns the city's name.
     * @return The city's name
     */
    public String getCityName()
    {
        return _cityName;
    }

    /**
     * Returns a Date object that represents the city's established Date.
     * @return The city's established Date
     */
    public DateSolution getDateEstablished()
    {
        return new DateSolution(_dateEstablished);
    }

    /**
     * Returns a Point object representing the city's center.
     * @return The city's center
     */
    public PointSolution getCityCenter()
    {
        return new PointSolution(_cityCenter);
    }

    /**
     * Returns a Point object representing the  city's central station.
     * @return The city's central station
     */
    public PointSolution getCentralStation()
    {
        return new PointSolution(_centralStation);
    }

    /**
     * Returns the number of residents in this city.
     * @return The number of residents
     */
    public long getNumOfResidents()
    {
        return _numOfResidents;
    }

    /**
     * Returns the number of neighborhoods in this city.
     * @return The number of neighborhoods
     */
    public int getNumOfNeighborhoods()
    {
        return _numOfNeighborhoods;
    }

    /**
     *  Changes the city's name.
     *  @param cityName The city's new name
     */        
    public void setCityName(String cityName)
    {
        _cityName=cityName;
    }

    /**
     *  Changes the city's established date.
     *  @param dateEstablished The city's new establishedDate
     */        
    public void setDateEstablished(DateSolution dateEstablished)
    {
        _dateEstablished = new DateSolution(dateEstablished);
    }

    /**
     *  Changes the city's center location.
     * @param cityCenter The city's new central point
     */        
    public void setCityCenter(PointSolution cityCenter)
    {
        _cityCenter=new PointSolution(cityCenter);
    }

    /**
     *  Changes the city's central station location.
     *  @param centralStation The city's new central station location
     */        
    public void setCentralStation(PointSolution centralStation)
    {
        _centralStation=new PointSolution(centralStation);
    }

    /**
     *  Changes the city's number of residents.
     *  If a negative number is received, number of residents should not be changed.
     * @param numOfResidents The city's new number of residents
     */        
    public void setNumOfResidents(long numOfResidents)
    {
        if(numOfResidents>=MIN_RESIDENTS)
            _numOfResidents = numOfResidents;     
    }

    /**
     *  Changes the city's number of neighborhoods.
     *  If a non positive number is received, number of neighborhoods should not be changed.
     *  @param noOfNeighborhoods The city's new number of neighborhoods
     */        
    public void setNumOfNeighborhoods(int noOfNeighborhoods)
    {
        if(noOfNeighborhoods>=MIN_NEIGHBORHOODS)
            _numOfNeighborhoods = noOfNeighborhoods;   
    }

    /**
     * Return a string representation of this city.
     * @return String representation of this city
     */
    public String toString()
    {
        return  "City name: "+ _cityName + "\n" +
        "Date established: " + _dateEstablished + "\n" +
        "City center: " + _cityCenter + "\n" +
        "Central station: " +  _centralStation + "\n" +
        "Number of residents: " + _numOfResidents+ "\n" +
        "Number of neighborhoods: " + _numOfNeighborhoods;
    }

    /** 
     *  Check if two cities are the same (checking all six instace variables)
     *  @param other the city to compare to this city
     *  @return true if the cities are the same 
     */
    public boolean equals(CitySolution other){
        return(_cityName.equals(other._cityName) &&
            _dateEstablished.equals(other._dateEstablished) &&
            _cityCenter.equals(other._cityCenter) &&
            _centralStation.equals(other._centralStation) &&
            _numOfResidents == other._numOfResidents &&
            _numOfNeighborhoods == other._numOfNeighborhoods);
    }

    /**
     * Add or subtract residents to this city. 
     * If number of residents becomes negative, set to zero and return false, otherwise set to new number and return true.
     * @param residentsUpdate The change in the number of residents
     * @return True if new number of residents is calculated as  non negative
     */
    public boolean addResidents(long residentsUpdate)
    {
        if(_numOfResidents+residentsUpdate < MIN_RESIDENTS){        
            setNumOfResidents(MIN_RESIDENTS);
            return false;
        }
        else{
            setNumOfResidents(_numOfResidents+residentsUpdate);
            return true;
        }    
    }

    /**
     * Move the central station  location. 
     * If the new coordinates are negative they will be set to 0.
     * @param deltaX The change in the station's x location
     * @param deltaY The change in the station's y location
     */
    public void moveCentralStation(int deltaX,int deltaY)
    {
        _centralStation.move(deltaX,deltaY);
    }

    /**
     * Calculate the distance between  the city center   and the central station. 
     * @return double representing the distance between  the city center   and the central station 
     */ 
    public double distanceBetweenCenterAndStation()
    {
        return _cityCenter.distance(_centralStation);
    }   

    /**
     * Returns a new city with a new name, established date which is a day after this city and a City center location dX and dY away from this city, with 0 residents and 1 neighborhood. 
     * @param newCityName the new city's name
     * @param dX the x difference from this city's location
     * @param dY the y difference from this city's location
     * @return  a new city  
     */ 
    public CitySolution newCity( String newCityName, int dX, int dY)
    {
        DateSolution d = _dateEstablished.tomorrow();
        PointSolution center = new PointSolution(_cityCenter);
        center.move(dX, dY);
        PointSolution centralStation = new PointSolution(_centralStation);
        centralStation.move(dX,dY);
        return new CitySolution(newCityName, 
            d.getDay(), d.getMonth(), d.getYear(),
            center.getX(), center.getY(),
            centralStation.getX(), centralStation.getY(), 
            MIN_RESIDENTS, MIN_NEIGHBORHOODS);
    }

    /** 
     *  Check if the city establish date is between two given dates (including these dates).
     *  the given dates are no necessarily in order
     *  @param date1 the first given date
     *  @param date2 the second given date
     *  @return true if the city establish date is between the two given dates 
     */
    public boolean cityEstablishedBetweenDates(DateSolution date1, DateSolution date2)
    {
        if(date2.before(date1))
        {
            DateSolution tmp = new DateSolution(date1);
            date1 = date2;
            date2 = tmp;
        }
        return(_dateEstablished.equals(date1) || _dateEstablished.equals(date2) || (_dateEstablished.after(date1) && _dateEstablished.before(date2)));        
    }

    /** 
     *  This method calculates the number of days thet differ between the establishment date of this city and the city given as a parameter
     *  @param other the city given as a parameter to find the difference 
     *  @return the number of days differ between this city establishment date to the other city establishment date
     */
    public int establishmentDateDiff(CitySolution other)
    {
        return(_dateEstablished.difference(other._dateEstablished));        
    }    
}

