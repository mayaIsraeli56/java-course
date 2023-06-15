/**
 * This class represents a country with a linked-list of cities.
 */
public class Country {
    CityNode _head;
    String _name;

    /**
     * Constructs a new Country object with the given name.
     *
     * @param countryName The name of the country.
     */
    Country(String countryName) {
        this._name = countryName;
        this._head = null;
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
     * @return The number of cities in the country.
     */
    public int getNumOfCities() {
        int count = 0;
        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            count++;
        }
        return count;
    }

    /**
     * Adds a city to the country.
     *
     * @param cityName          The name of the city to add.
     * @param dayEstablished    The day the city was established.
     * @param monthEstablished  The month the city was established.
     * @param yearEstablished   The year the city was established.
     * @param centerX           The x coordinate of the city center.
     * @param centerY           The y coordinate of the city center.
     * @param stationX          The x coordinate of the city's central station.
     * @param stationY          The y coordinate of the city's central station.
     * @param numOfResidents    The number of residents in the city.
     * @param noOfNeighborhoods The number of neighborhoods in the city.
     * @return True if the city was added successfully, false otherwise.
     */
    public boolean addCity(String cityName, int dayEstablished, int monthEstablished, int yearEstablished, int centerX, int centerY, int stationX, int stationY, long numOfResidents, int noOfNeighborhoods) {
        CityNode cityToAdd = new CityNode(new City(cityName, dayEstablished, monthEstablished, yearEstablished, centerX, centerY, stationX, stationY, numOfResidents, noOfNeighborhoods));
        CityNode previousNode = null;
        int comparisonResult;

        // If there are no cities in the country yet
        if (this._head == null) {
            this._head = cityToAdd;
            return true;
        }

        // If the city to add should be placed before the first city in the list
        if (this.compareCitiesByDateAndName(cityToAdd.getCity(), this._head.getCity()) > 0) {
            cityToAdd.setNext(this._head);
            this._head = cityToAdd;
            return true;
        }
        // This loop iterates over all the cities in the country and finds the correct place to insert the new city
        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            comparisonResult = this.compareCitiesByDateAndName(cityToAdd.getCity(), pointer.getCity());
            // If a city with the same name and date already exists
            if (comparisonResult == 0) return false;
            if (comparisonResult < 0) {
                // If the city to add should be placed after the current city in the list
                if (pointer.getNext() == null) {
                    // If we reached the end of the list
                    pointer.setNext(cityToAdd);
                    return true;
                }
            } else {
                // If the city to add should be placed before the current city in the list
                if (previousNode != null && this.compareCitiesByDateAndName(cityToAdd.getCity(), previousNode.getCity()) < 0) {
                    previousNode.setNext(cityToAdd);
                    cityToAdd.setNext(pointer);
                    return true;
                }
            }
            previousNode = pointer;
        }

        return false;
    }

    /**
     * Returns the total number of residents in all cities in the country.
     *
     * @return The total number of residents in all cities in the country.
     */
    public long getNumOfResidents() {
        int numOfResidents = 0;
        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            numOfResidents += pointer.getCity().getNumOfResidents();

        }
        return numOfResidents;
    }

    /**
     * Returns the longest distance between two cities in the country.
     *
     * @return The longest distance between two cities in the country.
     */
    public double longestDistance() {
        if (this._head == null || this._head.getNext() == null) {
            return 0;
        }

        //Because of the Point class the x and y values can only start at 0, so we only need to find the closest to 0,0 and farthest from 0,0
        City farthestCity = this._head.getCity();
        City closestCity = this._head.getCity();
        Point axis = new Point(0, 0);
        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            //Current city we're going over in the list
            City currentCity = pointer.getCity();
            if (closestCity.getCityCenter().distance(axis) > currentCity.getCityCenter().distance(axis)) {
                closestCity = currentCity;
            }
            if (farthestCity.getCityCenter().distance(axis) < currentCity.getCityCenter().distance(axis)) {
                farthestCity = currentCity;
            }
        }

        return farthestCity.getCityCenter().distance(closestCity.getCityCenter());
    }

    /**
     * Returns the number of cities north of a given city in the country.
     *
     * @param cityName The name of the city to compare to.
     * @return The number of cities north of cityName. Returns -1 if cityName is not found in the country.
     */
    public int numCitiesNorthOf(String cityName) {
        int citiesNorthOfCity = 0;
        CityNode resultNode = this.findCityByName(cityName);
        if (resultNode == null) return -1;
        City cityToCompareTO = resultNode.getCity();
        for (CityNode pointer = this._head; pointer.getNext() != null; pointer = pointer.getNext()) {
            if (pointer.getCity().getCityCenter().isUnder(cityToCompareTO.getCityCenter())) {
                citiesNorthOfCity++;
            }
        }
        return citiesNorthOfCity;
    }

    /**
     * Returns the southernmost city in the country.
     *
     * @return The southernmost city in the country. Returns null if there are no cities in the country.
     */
    public City southernmostCity() {
        if (this._head == null) return null;
        City southernmostCity = this._head.getCity();
        for (CityNode pointer = this._head; pointer.getNext() != null; pointer = pointer.getNext()) {
            if (pointer.getCity().getCityCenter().isUnder(southernmostCity.getCityCenter())) {
                southernmostCity = pointer.getCity();
            }
        }
        return southernmostCity;
    }

    /**
     * Unifies two cities into one by merging their data and removing one from the list.
     * Keeps only one city with a new name that is a concatenation of both original names separated by a hyphen.
     * Keeps only one central station - that which is more to left (if they have same x value then keep that which is lower).
     * Keeps only one date established - that which is earlier.
     * Keeps only one center point - that which is exactly between both original center points.
     * Keeps only one number of neighborhoods - that which is sum of both original numbers.
     * Keeps only one number of residents - that which is sum of both original numbers.
     *
     * @param cityName1 Name of first city to unify
     * @param cityName2 Name of second city to unify
     * @return City object representing unified city
     */
    public City unifyCities(String cityName1, String cityName2) {
        CityNode cityNode1 = this.findCityByName(cityName1);
        CityNode cityNode2 = this.findCityByName(cityName2);

        CityNode nodeToPreserve;
        CityNode nodeToDelete;

        //Older city is the one kept, other is removed
        if (cityNode1.getCity().getDateEstablished().before(cityNode2.getCity().getDateEstablished())) {
            nodeToPreserve = cityNode1;
            nodeToDelete = cityNode2;
        } else {
            nodeToPreserve = cityNode2;
            nodeToDelete = cityNode1;
        }

        City cityToModify = nodeToPreserve.getCity();
        City cityToDelete = nodeToDelete.getCity();

        //Modify the city according to instructions
        cityToModify.setNumOfResidents(cityToModify.getNumOfResidents() + cityToDelete.getNumOfResidents());
        cityToModify.setNumOfNeighborhoods(cityToModify.getNumOfNeighborhoods() + cityToDelete.getNumOfNeighborhoods());
        cityToModify.setCityCenter(cityToModify.getCityCenter().middle(cityToDelete.getCityCenter()));
        Point newCentralStation;
        if (cityToModify.getCentralStation().isLeft(cityToDelete.getCentralStation())) {
            newCentralStation = cityToModify.getCentralStation();
        } else {
            newCentralStation = cityToDelete.getCentralStation();
        }
        cityToModify.setCentralStation(newCentralStation);
        cityToModify.setCityName(cityToModify.getCityName() + '-' + cityToDelete.getCityName());

        nodeToPreserve.setCity(cityToModify);
        //Remove younger city
        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            if (pointer.getNext() == nodeToDelete) {
                pointer.setNext(nodeToDelete.getNext());
                break;
            }
        }

        return cityToModify;
    }

    /**
     * Calculates and returns maximum difference (in days) between establishment dates for any two cities in this Country
     *
     * @return Maximum difference (in days) between establishment dates for any two cities in this Country
     */
    public int establishMaxDiff() {
        if (_head == null) {
            return -1;
        }

        City firstCity = this._head.getCity();
        City lastCity = this._head.getCity();

        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            //Current city we're going over in the list
            City currentCity = pointer.getCity();
            if (firstCity.getDateEstablished().after(currentCity.getDateEstablished())) {
                firstCity = currentCity;
            }
            if (lastCity.getDateEstablished().before(currentCity.getDateEstablished())) {
                lastCity = currentCity;
            }
        }

        return firstCity.establishmentDateDiff(lastCity);
    }

    /**
     * Returns a string representation of this Country object
     *
     * @return String representation of this Country object
     */
    public String toString() {
        if (this._head == null) {
            return "There are no cities in this country.";
        }
        String returnString = "Cities of " + this._name + ": \n";
        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            returnString += pointer.getCity().toString() + "\n";
        }
        return returnString;
    }

    /**
     * Checks if there are any cities established before date1 or after date2
     *
     * @param date1 First date to check against
     * @param date2 Second date to check against
     * @return True if there are any cities established before date1 or after date2
     */
    public boolean wereCitiesEstablishedBeforeOrAfter(Date date1, Date date2) {
        for (CityNode pointer = this._head; pointer != null; pointer = pointer.getNext()) {
            if (!pointer.getCity().cityEstablishedBetweenDates(date1, date2)) {
                return true;
            }
        }
        return false;
    }


    private CityNode findCityByName(String cityName) {
        CityNode pointer = this._head;
        while (pointer != null && pointer.getNext() != null) {
            if (pointer.getCity().getCityName().equals(cityName)) return pointer;

            pointer = pointer.getNext();
        }

        return null;
    }

    private int compareCitiesByDateAndName(City cityToAdd, City cityToCompareTo) {
        Date cityToAddDate = cityToAdd.getDateEstablished();
        Date cityToCompareToDate = cityToCompareTo.getDateEstablished();

        if (cityToAdd.equals(cityToCompareTo)) return 0;

        if (cityToAddDate.before(cityToCompareToDate)) {
            return 1;
        } else if (cityToCompareToDate.before(cityToAddDate)) {
            return -1;
        }

        if (cityToAdd.getCityName().compareTo(cityToCompareTo.getCityName()) > 0) {
            return 1;
        }
        return -1;
    }


}
