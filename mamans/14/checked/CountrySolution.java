
/**
 * Write a description of class Country here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class CountrySolution {
	CityNodeSolution _head;
	private String _countryName;

	/**
	 * Country(java.lang.String countryName)
	 */
	public CountrySolution(String countryName) {
		_head = new CityNodeSolution(new City("", 0, 0, 0, 0, 0, 0, 0, 0, 0));
		_countryName = countryName;
	}

	/**
	 * boolean addCity(java.lang.String name, int day, int month, int year, int
	 * xCenter, int yCenter, int xStation, int yStation, long numOfResidents, int
	 * numOfNeighborhoods)
	 */
	public boolean addCity(String name, int day, int month, int year, int xCenter, int yCenter, int xStation,
			int yStation, long numOfResidents, int numOfNeighborhoods) {
		City city = new City(name, day, month, year, xCenter, yCenter, xStation, yStation, numOfResidents,
				numOfNeighborhoods);
		Date establishmentDate = new Date(day, month, year);
		CityNodeSolution search = _head;
		while (search.getNext() != null && search.getNext().getCity().getDateEstablished().before(establishmentDate))
			search = search.getNext();

		if (search.getNext() == null) {
			search.setNext(new CityNodeSolution(city));
			return true;
		}

		while (search.getNext() != null && establishmentDate.equals(search.getNext().getCity().getDateEstablished())) {
			if (search.getNext().getCity().getCityName().compareTo(name) >= 0)
				break;
			search = search.getNext();
		}

		if (search.getNext() != null && search.getNext().getCity().equals(city))
			return false;

		search.setNext(new CityNodeSolution(city, search.getNext()));

		return true;
	}

	/**
	 * long getNumOfResidents()
	 */
	public long getNumOfResidents() {
		int result = 0;
		CityNodeSolution search = _head.getNext();
		while (search != null) {
			result += search.getCity().getNumOfResidents();
			search = search.getNext();
		}

		return result;
	}

	/**
	 * double longestDistance()
	 */
	public double longestDistance() {
		if (_head.getNext() == null || _head.getNext().getNext() == null)
			return 0;
		double result = 0;
		CityNodeSolution search1 = _head.getNext();
		while (search1.getNext() != null) {
			CityNodeSolution search2 = search1.getNext();
			while (search2 != null) {
				double temp = search1.getCity().getCityCenter().distance(search2.getCity().getCityCenter());
				if (temp > result)
					result = temp;
				search2 = search2.getNext();
			}
			search1 = search1.getNext();
		}

		return result;
	}

	/**
	 * int numCitiesNorthOf(java.lang.String cityName)
	 */
	public int numCitiesNorthOf(String cityName) {
		CityNodeSolution search1 = _head.getNext();
		while (search1 != null) {
			if (search1.getCity().getCityName().equals(cityName))
				break;
			search1 = search1.getNext();
		}
		if (search1 == null)
			return -1;

		int result = 0;
		CityNodeSolution search2 = _head.getNext();
		while (search2 != null) {
			if (search2.getCity().getCityCenter().isAbove(search1.getCity().getCityCenter()))
				result++;
			search2 = search2.getNext();
		}

		return result;
	}

	/**
	 * java.lang.String getCountryName()
	 */
	public String getCountryName() {
		return _countryName;
	}

	/**
	 * int getNumOfCities()
	 */
	public int getNumOfCities() {
		CityNodeSolution search = _head.getNext();
		int result = 0;
		while (search != null) {
			result++;
			search = search.getNext();
		}

		return result;
	}

	/**
	 * City southernmostCity()
	 */
	public City southernmostCity() {
		if (_head.getNext() == null)
			return null;

		CityNodeSolution result = _head.getNext();
		CityNodeSolution search = _head.getNext();
		while (search != null) {
			if (search.getCity().getCityCenter().getY() < result.getCity().getCityCenter().getY()
					|| (search.getCity().getCityCenter().getY() == result.getCity().getCityCenter().getY()
							&& search.getCity().getDateEstablished().before(result.getCity().getDateEstablished())))
				result = search;
			search = search.getNext();
		}
		return new City(result.getCity());
	}

	/**
	 * boolean wereCitiesEstablishedBeforeOrAfter(Date date1, Date date2)
	 */
	public boolean wereCitiesEstablishedBeforeOrAfter(Date date1, Date date2) {
		// Make sure that date1 is before date2
		if (date1.after(date2)) {
			Date temp = date1;
			date1 = date2;
			date2 = temp;
		}
		CityNodeSolution search = _head.getNext();
		while (search != null) {
			if (search.getCity().getDateEstablished().before(date1) || search.getCity().getDateEstablished().after(date2))
				return true;
			search = search.getNext();
		}

		return false;
	}

	/**
	 * City unifyCities(java.lang.String cityName1, java.lang.String cityName2)
	 */
	public City unifyCities(String cityName1, String cityName2) {
		CityNodeSolution search1 = _head;
		while (search1.getNext() != null) {
			if (search1.getNext().getCity().getCityName().equals(cityName1))
				break;
			search1 = search1.getNext();
		}
		if (search1.getNext() == null)
			return null;

		int result = 0;
		CityNodeSolution search2 = _head;
		while (search2.getNext() != null) {
			if (search2.getNext().getCity().getCityName().equals(cityName2))
				break;
			search2 = search2.getNext();
		}
		if (search2.getNext() == null)
			return null;

		String cityName = cityName1 + "-" + cityName2;

		Date dateEstablished;
		if (search1.getNext().getCity().getDateEstablished().before(search2.getNext().getCity().getDateEstablished()))
			dateEstablished = search1.getNext().getCity().getDateEstablished();
		else
			dateEstablished = search2.getNext().getCity().getDateEstablished();

		Point cityCenter = search1.getNext().getCity().getCityCenter()
				.middle(search2.getNext().getCity().getCityCenter());

		Point centralStation;
		if (search1.getNext().getCity().getCentralStation().getX() < search2.getNext().getCity().getCentralStation()
				.getX()
				|| (search1.getNext().getCity().getCentralStation().getX() == search2.getNext().getCity()
						.getCentralStation().getX()
						&& search1.getNext().getCity().getDateEstablished()
								.after(search2.getNext().getCity().getDateEstablished())))
			centralStation = search1.getNext().getCity().getCentralStation();
		else
			centralStation = search2.getNext().getCity().getCentralStation();

		long numOfResidents = search1.getNext().getCity().getNumOfResidents()
				+ search2.getNext().getCity().getNumOfResidents();
		int numOfNeighborhoods = search1.getNext().getCity().getNumOfNeighborhoods()
				+ search2.getNext().getCity().getNumOfNeighborhoods();

		if (search1.getNext().getCity().getDateEstablished().before(search2.getNext().getCity().getDateEstablished())) {
			search1.getNext()
					.setCity(new City(cityName, dateEstablished.getDay(), dateEstablished.getMonth(),
							dateEstablished.getYear(), cityCenter.getX(), cityCenter.getY(), centralStation.getX(),
							centralStation.getY(), numOfResidents, numOfNeighborhoods));
			search2.setNext(search2.getNext().getNext());
			return search1.getNext().getCity();
		} else {
			search2.getNext()
					.setCity(new City(cityName, dateEstablished.getDay(), dateEstablished.getMonth(),
							dateEstablished.getYear(), cityCenter.getX(), cityCenter.getY(), centralStation.getX(),
							centralStation.getY(), numOfResidents, numOfNeighborhoods));
			search1.setNext(search1.getNext().getNext());
			return search2.getNext().getCity();
		}
	}

	/**
	 * int establishMaxDiff()
	 */
	public int establishMaxDiff() {
		if (_head.getNext() == null)
			return -1;
		if (_head.getNext().getNext() == null)
			return 0;

		CityNodeSolution search = _head.getNext().getNext();
		while (search.getNext() != null)
			search = search.getNext();

		return _head.getNext().getCity().getDateEstablished().difference(search.getCity().getDateEstablished());
	}

	/**
	 * java.lang.String toString()
	 */
	public String toString() {
		String result = "Cities of " + _countryName + ":\n\n";
		CityNodeSolution search = _head.getNext();
		if (search == null) {
			return "There are no cities in this country.";
		}

		while (search != null) {
			result += search.getCity() + "\n\n";
			search = search.getNext();
		}
		return result;
	}

	// ------------------- method for the tester
	public boolean equals(Country c) {
		CityNode n = c._head;
		CityNodeSolution myN = _head.getNext();// first node
// 		if (n != null && n.getCity().getCityName().equals("")) {
		if (Mmn14Tester.USE_DUMMY) {
			n = n.getNext();
		}
		while (myN != null && n != null) {
			if (!myN.getCity().equals(n.getCity())) {
				return false;
			}
			n = n.getNext();
			myN = myN.getNext();
		}
		return n == null && myN == null;
	}

}
