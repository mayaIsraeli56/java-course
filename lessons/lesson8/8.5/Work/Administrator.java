public class Administrator extends Employee {

    public Administrator(String name, String id, double payPerHour) {
        super(name, id, payPerHour);
    }

    public double computeSalary(int month) {
        return _payPerHour * _workHoursInMonth[month];
    }
}
