package Car;

public class CarCatalog {
    public static final int MAX_CARS = 100;
    private Car[] _cars;
    private int _noCars;

    public CarCatalog() {
        _cars = new Car[MAX_CARS];
        _noCars = 0;
    }

    public boolean add(String factory, int year, long id) {

        if (_noCars == MAX_CARS)
            return false;

        if (indexOf(id) != -1) {
            return false;
        }

        _cars[_noCars++] = new Car(factory, year, id);
        return true;
    }

    public String toString() {

        if (_noCars == 0) {
            return "No Cars in array";
        }

        String s = "Car Catalog ";

        for (int i = 0; i < _noCars; i++) {
            s += "\n   " + (i + 1) + ") " + _cars[i].toString();
        }
        return s;
    }

    public Car remove(long id) {
        int index = indexOf(id);
        if (index == -1)
            return null;

        Car removedCar = _cars[index];

        for (int i = index; i < _noCars - 1; i++) {
            _cars[i] = _cars[i + 1];
        }
        _cars[_noCars-- - 1] = null;

        return removedCar;
    }

    public int indexOf(long id) {
        for (int i = 0; i < _noCars; i++) {
            if (_cars[i].getId() == id)
                return i;
        }
        // not found
        return -1;
    }

    public Car youngest() {
        if (_noCars == 0)
            return null;

        Car youngest = _cars[0];
        for (int i = 1; i < _noCars; i++) {
            if (_cars[i].younger(youngest))
                youngest = _cars[i];
        }
        return new Car(youngest);
    }

    public int popularYear() {

        if (_noCars == 0)
            return -1;

        int popYear = _cars[0].getYear();
        int max = 1;

        for (int i = 0, count = 1; i < _noCars; i++, count = 1) {
            for (int j = 0; j < _noCars; j++) {
                if (_cars[i].getYear() == _cars[j].getYear())
                    count++;
            }

            if (max < count) {
                max = count;
                popYear = _cars[i].getYear();
            }
        }

        return popYear;
    }
}
