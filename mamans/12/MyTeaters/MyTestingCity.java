

public class MyTestingCity
{
    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Start testing for your class City, good luck\n");
        System.out.println("1. Create new object by City class \n2. Testing functions get set \n3. Testing over functions\n");
        System.out.println("=====================================");
        System.out.print("1. Create a new object, c1 (cityName = \"City-17\", day = 30, month =  2, year = 1999, centerX = -7, centerY = -6, StationX = -3, StationY = -3, ");
        System.out.println(" numOfResidents = -127, numOfNeighborhoods = 0");
        System.out.println("for testing we creating a 2 new City, defaultResult = (\"City-17\", 1, 1, 2000, 0, 0, 0, 0, 0, 1) and realCity = (\"Insmut\", 20, 3, 1925, 5, 7, 3, 6, 1500, 5)");
        System.out.println("Expected Result c1 == (\"City-17\", 01/01/2000, cityCenter = (0,0), centralStation = (0, 0), numOfResidents = 0, numOfNeighborhoods = 1)");
        City c1 = new City("City-17", 30, 2, 1999, -7, -6, -3, -3, -127, 0);
        City defaultResult = new City("City-17", 1, 1, 2000, 0, 0, 0, 0, 0, 1);
        City realCity = new City("Insmut", 20, 3, 1925, 5, 7, 3, 6, 1500, 5);
        System.out.println("c1 is  equals dafaultResult ? " + c1.equals(defaultResult));
        System.out.println("\nc1 is: \n" + c1 + "\n");
        System.out.println("defaultResult is: \n" + defaultResult + "\n");
        System.out.println("=====================================");
        System.out.println("now let\'s change c1 = new City(realCity)");
        c1 = new City(realCity);
        System.out.println("c1 is  equals realCity ? " + c1.equals(realCity));
        System.out.println("\nc1 is: \n" + c1 + "\n");
        System.out.println("realCity is: \n" + realCity + "\n");
        System.out.println("now let\'s change c1 = new City(realCity)");
        System.out.println("=====================================");
        System.out.println("now let\'s change c1.setCityCenter(new Point(1,1)), c1.setDateEstablished(new Date(31, 12, 2017)), c1.setCentralStation(new Point(9, 9))");
        c1.setCityCenter(new Point(1, 1));
        c1.setDateEstablished(new Date(31, 12, 2017));
        c1.setCentralStation(new Point(9, 9));
        System.out.println("c1 is not equals realCity ? " + !c1.equals(realCity));
        System.out.println("\nc1 is: \n" + c1 + "\n");
        System.out.println("realCity is: \n" + realCity + "\n");
        System.out.println("=====================================");
        System.out.println("c1 getCityName = " + c1.getCityName());
        System.out.println("c1 getDateEstablished = " + c1.getDateEstablished());
        System.out.println("c1 getCityCenter = " + c1.getCityCenter());
        System.out.println("c1 getCentralStation = " + c1.getCentralStation());
        System.out.println("c1 getNumOfResidents = " + c1.getNumOfResidents());
        System.out.println("c1 getNumOfNeighborhoods = " + c1.getNumOfNeighborhoods());
        System.out.println("=====================================");
        System.out.println("now testing function addResidents, first we will add -2000 Residents, Expected Result returning = false and _numOfResidents == 0");
        System.out.println("c1.addResidents = " + c1.addResidents(-2000) + "\nand now c1 getNumOfResidents = " + c1.getNumOfResidents());
        System.out.println("=====================================");
        System.out.println("new testing function addResidents, second we will add 2500 Residents, Expected Result returning = true and _numOfResidents == 2500");
        System.out.println("c1.addResidents = " + c1.addResidents(2500) + "\nand now c1 getNumOfResidents = " + c1.getNumOfResidents());
        System.out.println("=====================================");
        System.out.println("now testing function moveCentralStation");
        System.out.println("now let\'s change c1.setCentralStation(new Point(3, 6))");
        c1.setCentralStation(new Point(3, 6));
        System.out.println("right now we have c1 getCentralStation = " + c1.getCentralStation());
        System.out.println("now let\'s change c1.moveCentralStation(-7, 8), Expected Result nothing will change in the coordinates in c1");
        c1.moveCentralStation(-7, 8);
        System.out.println("c1 getCentralStation = " + c1.getCentralStation());
        System.out.println("now let\'s change c1.moveCentralStation(-2, -5), Expected Result c1 getCentralStation = (1, 1)");
        c1.moveCentralStation(-2, -5);
        System.out.println("c1 getCentralStation = " + c1.getCentralStation());
        System.out.println("=====================================");
        System.out.println("now testing function distanceBetweenCenterAndStation");
        System.out.println("now let\'s change c1.setCentralStation(new Point(4, 5))");
        c1.setCentralStation(new Point(4, 5));
        System.out.println("c1 getCityCenter = " + c1.getCityCenter());
        System.out.println("c1 getCentralStation = " + c1.getCentralStation());
        System.out.println("Expected Result c1.distanceBetweenCenterAndStation() == 5.0");
        System.out.println("c1.distanceBetweenCenterAndStation() = " + c1.distanceBetweenCenterAndStation() + " is it 5.0 ? " + (c1.distanceBetweenCenterAndStation() == 5.0));
        System.out.println("=====================================");
        System.out.println("now testing function newCity");
        System.out.println("new City cNew = c1.newCity(\"Arkham\", 10, 10)");
        City cNew = c1.newCity("Arkham", 10, 10);
        System.out.println("c1 is not equals cNew ? " + !c1.equals(cNew));
        System.out.println("\nc1 is: \n" + c1 + "\n");
        System.out.println("cNew is: \n" + cNew + "\n");
        System.out.println("=====================================");
        System.out.println("now testing function cityEstablishedBetweenDates");
        System.out.println("now let\'s change c1.setDateEstablished(new Date(5, 5, 2017))");
        c1.setDateEstablished(new Date(5, 5, 2017));
        System.out.println("c1 getDateEstablished = " + c1.getDateEstablished());
        System.out.println("Create a 3 new objects from Date, d1 = 1, 1, 2000, d2 = 3, 3, 2017, d3 = 20, 9, 2020");
        Date d1 = new Date(1, 1, 2000);
        Date d2 = new Date(3, 3, 2017);
        Date d3 = new Date(20, 9, 2020);
        System.out.println("Expected Result c1.cityEstablishedBetweenDates(d1, d3) == true");
        System.out.println("c1 cityEstablishedBetweenDates d1 d3 ? " + c1.cityEstablishedBetweenDates(d1, d3));
        System.out.println("Expected Result c1.cityEstablishedBetweenDates(c1.getDateEstablished(), d3) == true");
        System.out.println("c1 cityEstablishedBetweenDates c1.getDateEstablished() d3 ? " + c1.cityEstablishedBetweenDates(c1.getDateEstablished(), d3));
        System.out.println("Expected Result c1.cityEstablishedBetweenDates(d1, c1.getDateEstablished()) == true");
        System.out.println("c1 cityEstablishedBetweenDates d1 c1.getDateEstablished() ? " + c1.cityEstablishedBetweenDates(d1, c1.getDateEstablished()));
        System.out.println("Expected Result c1.cityEstablishedBetweenDates(d1, d2) == false");
        System.out.println("c1 cityEstablishedBetweenDates d1 d2 ? " + c1.cityEstablishedBetweenDates(d1, d2));
        System.out.println("=====================================");
        System.out.println("now testing function establishmentDateDiff");
        System.out.println("now let\'s change c1.setDateEstablished(new Date(20, 3, 1926))");
        c1.setDateEstablished(new Date(20, 3, 1926));
        System.out.println("c1 getDateEstablished = " + c1.getDateEstablished());
        System.out.println("realCity getDateEstablished = " + realCity.getDateEstablished());
        System.out.println("Expected Result c1.establishmentDateDiff(realCity) == 365");
        System.out.println(c1.establishmentDateDiff(realCity) + " is 365 ? " + (c1.establishmentDateDiff(realCity) == 365));
        System.out.println("The end for testing your class City");
    }
}