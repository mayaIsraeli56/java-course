public class Worker extends Employee {

    final static double NIGTH_BONUS = 1.1;
    final static int PAY_FOR_BREAKFAST = 50;

    int _shift; // 1-morning, 2-evning, 3-night

    public Worker(String name, String id, double payPerHour, int shift) {
        super(name, id, payPerHour);
        _shift = shift;
    }

    public double computeSalary(int month) {
        double salary = _payPerHour * _workHoursInMonth[month];

        if (_shift == 3)
            salary *= NIGTH_BONUS;
        else if (_shift == 1)
            salary += PAY_FOR_BREAKFAST;

        return salary;
    }
}
