public class City {
    private String _cityName;
    private Date _dateEstablished;
    private Point _cityCenter;
    private Point _centralStation;
    private long _numOfResidents;
    private int _numOfNeighborhoods;

    public static final int MIN_RESIDENTS = 0;
    public static final int MIN_NEIGHBORHOODS = 1;

    // Constractors
    public City(String cityName, int estDay, int estMonth, int estYear,
            int centerX, int centerY, int centralStationX, int centralStationY,
            long numOfResidents, int numOfNeighborhoods) {

        _cityName = cityName;
        _dateEstablished = new Date(estDay, estMonth, estYear);
        _cityCenter = new Point(centerX, centerY);
        _centralStation = new Point(centralStationX, centralStationY);

        _numOfResidents = Math.max(numOfResidents, MIN_RESIDENTS);
        _numOfNeighborhoods = Math.max(numOfNeighborhoods, MIN_NEIGHBORHOODS);

    }

    public City(City other) {
        _cityName = other._cityName;
        _dateEstablished = new Date(other._dateEstablished);
        _cityCenter = new Point(other._cityCenter);
        _centralStation = new Point(other._centralStation);
        _numOfResidents = other._numOfResidents;
        _numOfNeighborhoods = other._numOfNeighborhoods;
    }

    public String getCityName() {
        return _cityName;
    }

    public Date getDateEstablished() {
        return new Date(_dateEstablished);
    }

    public Point getCityCenter() {
        return new Point(_cityCenter);
    }

    public Point getCentralStation() {
        return new Point(_centralStation);
    }

    public long getNumOfResidents() {
        return _numOfResidents;
    }

    public int getNumOfNeighborhoods() {
        return _numOfNeighborhoods;
    }

    public void setCityName(String cityName) {
        _cityName = cityName;
    }

    public void setDateEstablished(Date dateEst) {
        _dateEstablished = new Date(dateEst);
    }

    public void setCityCenter(Point cityCenter) {
        _cityCenter = new Point(cityCenter);
    }

    public void setCentralStation(Point centralStation) {
        _centralStation = new Point(centralStation);
    }

    public void setNumOfResidents(long numOfResidents) {
        if (numOfResidents < MIN_RESIDENTS)
            return;
        _numOfResidents = numOfResidents;
    }

    public void setNumOfNeighborhoods(int numOfNeighborhoods) {
        if (numOfNeighborhoods < MIN_NEIGHBORHOODS)
            return;
        _numOfNeighborhoods = numOfNeighborhoods;
    }

    public String toString() {
        return "City name: " + _cityName + "\nDate established: " + _dateEstablished +
                "\nCity center: " + _cityCenter + "\nCentral station: " + _centralStation +
                "\nNumber of residents: " + _numOfResidents + "\nNumber of neighborhoods: " + _numOfNeighborhoods;
    }

    public boolean equals(City other) {
        return other._cityName.equals(_cityName) && other._dateEstablished.equals(_dateEstablished)
                && other._cityCenter.equals(_cityCenter) && other._centralStation.equals(_centralStation)
                && other._numOfResidents == _numOfResidents && other._numOfNeighborhoods == _numOfNeighborhoods;
    }

    public boolean addResidents(long residentsUpdate) { // need to compare
        _numOfResidents += residentsUpdate;
        if (_numOfResidents < 0) {
            _numOfResidents = MIN_RESIDENTS;
            return false;
        }
        return true;
    }

    public void moveCentralStation(int deltaX, int deltaY) { // check if >= or >
        _centralStation.move(deltaX, deltaY);
    }

    public double distanceBetweenCenterAndStation() {
        return _cityCenter.distance(_centralStation);
    }

    public City newCity(String newCityName, int dX, int dY) {

        Date newEst = _dateEstablished.tomorrow();
        Point newCenter = new Point(_cityCenter);
        newCenter.move(dX, dY);

        Point centralStation = new Point(_centralStation);
        centralStation.move(dX, dY);

        return new City(newCityName,
                newEst.getDay(),
                newEst.getMonth(),
                newEst.getYear(),
                newCenter.getX(),
                newCenter.getY(),
                centralStation.getX(),
                centralStation.getY(),
                MIN_RESIDENTS,
                MIN_NEIGHBORHOODS);
    }

    public boolean cityEstablishedBetweenDates(Date date1, Date date2) {
        /*
         * if (date2.before(date1)) {
         * Date temp = new Date(date1);
         * date1 = new Date(date2);
         * date2 = new Date(temp);
         * }
         * 
         * return (_dateEstablished.after(date1) || _dateEstablished.equals(date1))
         * && (_dateEstablished.before(date2) || _dateEstablished.equals(date2));
         */

        if (date1.before(date2))
            return (_dateEstablished.after(date1) || _dateEstablished.equals(date1))
                    && (_dateEstablished.before(date2) || _dateEstablished.equals(date2));
        else
            return (_dateEstablished.after(date2) || _dateEstablished.equals(date2))
                    && (_dateEstablished.before(date1) || _dateEstablished.equals(date1));

    }

    public int establishmentDateDiff(City other) {
        return _dateEstablished.difference(other.getDateEstablished());
    }

}
