import java.util.Scanner;

public class Hour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter two numbers - one for hour and one for minutes ");
        int hour = scan.nextInt();
        int min = scan.nextInt();

        if (hour >= 0 && hour <= 23 && min >= 0 && min <= 59) {
            String res = "";

            System.out.println("Do you whant a 12 or 24 format? ");
            int format = scan.nextInt();

            if (format == 12 || format == 24) {
                res = hour < 10 ? "0" : "";
                res += format == 24 ? hour : hour > 12 ? hour - 12 : hour;
                res += ":";
                res += min < 10 ? "0" + min : min;
                res += format == 24 ? "" : hour > 12 ? " PM" : " AM";

                System.out.println("the time is " + res);
            } else {
                System.out.println("Input should be 12 or 24");
            }

        } else
            System.out.println("The numbers can not present hours and min");
    }
}
