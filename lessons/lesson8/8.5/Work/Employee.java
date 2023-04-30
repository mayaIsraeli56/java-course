public abstract class Employee {
    public static int MONTHS_IN_YEAR = 12;
    public static String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov",
            "Dec" };

    String _name;
    String _id;
    double _payPerHour;
    int[] _workHoursInMonth;

    public Employee(String name, String id, double payPerHour) {
        _name = name;
        _id = id;
        _payPerHour = payPerHour;
        _workHoursInMonth = new int[MONTHS_IN_YEAR];
    }

    public void setWorkingHours(int month, int hours) {
        if (month < MONTHS_IN_YEAR && month >= 0) {
            _workHoursInMonth[month] = hours;
        }
    }

    public String toString() {
        String str = "Name: " + _name + ", ID: " + _id + ", Pay per hour: " + _payPerHour + " shekels\n";

        for (int i = 0; i < MONTHS_IN_YEAR; i++) {
            str += MONTHS[i] + " -" + _workHoursInMonth[i] + ", ";
        }

        return str;
    }

    public String getName() {
        return _name;
    }

    public void setPayPerHour(int payPerHour) {
        _payPerHour = payPerHour;
    }

    public abstract double computeSalary (int month);


    /////////////////////////////////////////////////////////////////////////

    // public String getId() {
    //     return _id;
    // }

    // public double getPayPerHour() {
    //     return _payPerHour;
    // }

    // public void setName(String name) {
    //     _name = name;
    // }

    // public void setId(String id) {
    //     _id = id;
    // }

   
}