import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        double salary = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your basic salary");
        int base = scan.nextInt();

        System.out.println("Please enter your work hours");
        double workHours = scan.nextInt();

        System.out.println("Please enter the num of work day (1-7)");
        int day = scan.nextInt();

        salary = workHours * base;

        if (day >= 1 && day <= 7) {
            switch (day) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    salary += workHours > 8 ? (workHours - 8) * (base * 0.25) : 0;
                    break;
                case 6:
                    salary += workHours > 6 ? (workHours - 6) * (base * 0.5) : 0;
                    break;
                case 7:
                    salary += workHours > 4 ? (workHours - 4) * (base * 2) : 0;
                    break;
                default:
                    System.out.println("Unvalid input for day");
                    break;
            }
            System.out.println("salary " + salary);
        } else
            System.out.println("Unvalid input for day");
    }
}
