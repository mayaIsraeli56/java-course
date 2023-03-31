public class CarStore {
    public static void main(String[] args) {

        Car car1 = new Car("mik", 2300, 84857);
        System.out.println("car1: " + car1);

        Car car2 = new Car("mik", 00, 84857);
        System.out.println("car2 (wrong id): " + car2);

        Car car3 = new Car("mik", 555555);
        System.out.println("car3 (only factory + id): " + car3);

        Car car4 = new Car(car1);
        System.out.println("car4 (other): " + car4);

        System.out.println("car4 factory (get): " + car4.getFactory());
        car4.setYear(3003);
        System.out.println("car4 (set year): " + car4._year);
        car4._year = 5;
        System.out.println("car4 (set year): " + car4._year);

        Car car11 = car1;
        Car car12 = new Car("mik", 2300, 84857);

        System.out.println("car1.equals(car11): " + car1.equals(car11));
        System.out.println("car1==car11: " + (car1==car11));
        System.out.println("car1.equals(car12): " + car1.equals(car12));
        System.out.println("car1==car12: " + (car1==car12));
        System.out.println( " car1 " + car1._year + " car4 " + car4._year + " car1.older(car4): " + (car1.older(car4)));
        System.out.println( " car1 " + car1._year + " car4 " + car4._year + " car1.younger(car4): " + (car1.younger(car4)));
      
    }

    public static class Car {
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

        public String toString() {
            // build and return the String of the object
            return +_year + ", " + _factory + ", " + _id;
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
            return c._year < _year ;
        }

        public boolean younger(Car c) {
            return c.older(this) ;
        }
    }
}
