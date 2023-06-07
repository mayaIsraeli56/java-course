public class Country {
    CityNode _head;
    private String _name;

    public Country(String name) {
        _head = null;
        _name = name;
    }

    public boolean addCity(String cityName, int dayEstablished, int monthEstablished, int yearEstablished, int centerX,
            int centerY, int stationX, int stationY, long numOfResidents, int noOfNeighborhoods) {

        City newCity = new City(cityName, dayEstablished, monthEstablished, yearEstablished, centerX, centerY, stationX,
                stationY, numOfResidents, noOfNeighborhoods);

        if (_head == null) {
            _head = new CityNode(newCity);
        } else {
            CityNode ptr = _head;

            
        }
        // cityEstablishedBetweenDates
    }
}
