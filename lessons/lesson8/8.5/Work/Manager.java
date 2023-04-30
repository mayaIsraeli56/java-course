public class Manager extends Employee {

    final static double BONUS_FOR_5_EMPLOYIES = 1.05;
    final static double BONUS_FOR_10_EMPLOYIES = 1.1;

    int _subordinate;

    public Manager(String name, String id, double payPerHour, int subordinate) {
        super(name, id, payPerHour);
        _subordinate = subordinate;
    }

    public double computeSalary(int month) {
        double salary = _payPerHour * _workHoursInMonth[month];

        if (_subordinate > 5) {
            if (_subordinate > 10)
                salary *= BONUS_FOR_10_EMPLOYIES;
            else
                salary *= BONUS_FOR_5_EMPLOYIES;
        }

        return salary;
    }
}
