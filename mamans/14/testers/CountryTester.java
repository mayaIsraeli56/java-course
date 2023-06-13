
public class CountryTester
{
    public static void print(String msg)
    {
        System.out.println(msg + "\n");
    }
    
    public static void line()
    {
        print("**************************************");
    }
    public static void main(String[] args)
    {
        System.out.println("Tester from Country.java");
        print("Create new object from Country coun = new Country(\"Temeria\");");
        Country coun = new Country("Temeria");
        print("coun.getCountryName() = " + coun.getCountryName());
        print("coun.establishMaxDiff() == -1 ? " + (coun.establishMaxDiff() == -1));
        print("coun.toString() = " + coun);
        print("coun.southernmostCity() == null ? " + (coun.southernmostCity() == null));
        print("Create new object form City c = City(\"Visima\", 25, 9, 1925, 7, 8, 3, 4, 123, 8);");
        City c = new City("Visima", 25, 9, 1925, 7, 8, 3, 4, 123, 8);
        print("c = " + c);
        print("Create new object form City c2 = City(\"Novigrad\", 19, 5, 1921, 2, 1, 3, 3, 555, 3);");
        City c2 = new City("Novigrad", 19, 5, 1921, 2, 1, 3, 3, 555, 3);
        print("c2 = " + c2);
        print("Create new object form City c3 = City(\"Flotzem\", 19, 5, 1921, 7, 7, 4, 4, 164, 1);");
        City c3 = new City("Flotzem", 19, 5, 1921, 7, 7, 4, 4, 164, 1);
        print("c3 = " + c3);
        print("Create new object form City c4 = City(\"Flotzem\", 19, 5, 1921, 7, 7, 4, 4, 164, 1);");
        City c4 = new City("Flotzem", 19, 5, 1921, 7, 7, 4, 4, 164, 1);
        print("c4 = " + c4);
        line();
        print("coun.toString() = " + coun);
        print("Now add 4 cities into coun");
        print("c1 is into coun ? " + coun.addCity("Visima", 25, 9, 1925, 7, 8, 3, 4, 123, 8));
        print("coun.longestDistance() == 0 ? " + (coun.longestDistance() == 0));
        print("coun.establishMaxDiff() == 0 ? " + (coun.establishMaxDiff() == 0));
        print("c2 is into coun ? " + coun.addCity("Novigrad", 19, 5, 1921, 2, 1, 3, 3, 555, 3));
        print("c3 is into coun ? " + coun.addCity("Flotzem", 19, 5, 1921, 7, 7, 4, 4, 164, 1));
        print("c4 is into coun ? " + coun.addCity("Flotzem", 19, 5, 1921, 7, 7, 4, 4, 164, 1));
        print("coun.getNumOfCities() == 3 ? " + (coun.getNumOfCities() == 3));
        print("coun.toString() = " + coun);
        line();
        print("coun.getNumOfResidents() = " + coun.getNumOfResidents() + " " + (coun.getNumOfResidents() == 842) + " == 123 + 555 + 164 = 842 ");
        print("coun.longestDistance() = 8.602325267042627 ? " + coun.longestDistance() + " " + (coun.longestDistance() == 8.602325267042627));
        line();
        print("coun.numCitiesNorthOf(\"NoneCity\") == -1 ? " + (coun.numCitiesNorthOf("NoneCity") == -1));
        print("coun.numCitiesNorthOf(\"Visima\") == 0 ? " + (coun.numCitiesNorthOf("Visima") == 0));
        print("coun.numCitiesNorthOf(\"Novigrad\") == 2 ? " + (coun.numCitiesNorthOf("Novigrad") == 2));
        line();
        print("coun.southernmostCity() = " + coun.southernmostCity());
        line();
        print("Create two new Dates d1 = 25/06/1920, d2 = 01/01/2000, d3 = 21/09/2001");
        Date d1 = new Date(25, 6, 1920);
        Date d2 = new Date(1, 1, 2000);
        Date d3 = new Date(21, 9, 2001);
        print("coun.wereCitiesEstablishedBeforeOrAfter(d1, d2) == false ? it is " + (coun.wereCitiesEstablishedBeforeOrAfter(d1, d2) ? "No" : "Yes"));
        print("coun.wereCitiesEstablishedBeforeOrAfter(d3, d2) == true ? it is " + (coun.wereCitiesEstablishedBeforeOrAfter(d3, d2) ? "Yes" : "No"));
        line();
        print("coun.establishMaxDiff() == 1590 ? " + (coun.establishMaxDiff() == 1590));
        line();
        print("Create new object from City unifyCity = coun.unifyCities(\"Flotzem\", \"Novigrad\")");
        City unifyCity = coun.unifyCities("Flotzem", "Novigrad");
        print("unifyCity = " + unifyCity);
        line();
        print("coun.toString() = " + coun);
        line();
        print("End Tester Country.java");
    }
}
