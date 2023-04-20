package Car;

public class Car {

    // constants declaration:
    int YEAR_DEFAULT = 2000;

    // attributes declarations:
    private String _factory;
    private int _year;
    private long _id;

    // constructors
    public Car(String factory, int year, long id) {
        if (String.valueOf(year).length() != 4) {
            year = YEAR_DEFAULT;
        }

        _factory = factory;
        _year = year;
        _id = id;
    }

    public Car(String factory, long id) {
        _factory = factory;
        _year = YEAR_DEFAULT;
        _id = id;
    }

    public Car(Car other) {
        _factory = other._factory;
        _year = other._year;
        _id = other._id;
    }

    
    // method definitions

    public String getFactory() {
        return _factory;
    }

    public void setFactory(String factory) {
        _factory = factory;
    }
    
    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        if (1000 <= year && year < 10000) {
            _year = year;
        }
    }

    public long getId() {
        return _id;
    }
    
    public void setId(long id) {
        _id = id;
    }
    
    public boolean equals(Car other) {
        return (_factory.equals(other._factory) &&
        _id == other._id &&
        _year == other._year);
    }

    public boolean older(Car c) {
        return c._year < _year;
    }
    
    public boolean younger(Car c) {
        return c.older(this);
    }

    public String toString() {
        // build and return the String of the object
        return +_year + ", " + _factory + ", " + _id;
    }
}
