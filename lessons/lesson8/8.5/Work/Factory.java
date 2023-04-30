import java.util.Scanner;

public class Factory {

    public static final int MAX_EMPLOYEES = 100;
    Employee[] _employees;
    private int noEmployees;

    Factory() {
        _employees = new Employee[MAX_EMPLOYEES];
        noEmployees = 0;
    }

    public void hire() {

        if (noEmployees < MAX_EMPLOYEES) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter employee type (1-administrator, 2-worker, 3-manager)");
            int type = scan.nextInt();
            scan.nextLine();

            System.out.println("Enter name");
            String name = scan.next();

            System.out.println("Enter ID");
            String id = scan.next();

            System.out.println("Enter payment per hour");
            double payPerHour = scan.nextDouble();

            Employee toHire = null;

            switch (type) {
                case 1:
                    // Administrator
                    toHire = new Administrator(name, id, payPerHour);
                    break;
                case 2:
                    // Worker
                    System.out.println("Enter your shift (1-morning, 2-evning, 3-night)");
                    int shift = scan.nextInt();
                    toHire = new Worker(name, id, payPerHour, shift);
                    break;
                case 3:
                    // Manager
                    System.out.println("Enter the number of your workers");
                    int subordinate = scan.nextInt();
                    toHire = new Manager(name, id, payPerHour, subordinate);
                    break;
                default:
                    System.out.println("Eror. Employee type must be 1/2/3");
            }

            if (toHire != null)
                _employees[noEmployees++] = toHire;

        }
    }

    public void updateHours(int[] hours, int month) {

        if (noEmployees != hours.length) {
            System.out.println("Eror. hours is not in the correct length");
            return;
        }

        for (int i = 0; i < noEmployees; i++) {
            _employees[i].setWorkingHours(month, hours[i]);
        }
    }

    public void printSalaries(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Eror. month is not in the correct");
            return;
        }

        for (int i = 0; i < noEmployees; i++) {   
            System.out.println(_employees[i].getName() + ", "+  _employees[i].computeSalary(month-1) +"\n");
        }
    }
}
