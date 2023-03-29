import java.util.Scanner;

public class Day {
    public static void main(String[] args) {
        final byte DAYS_IN_WEEK = 7;
        int n, week, day;
        String dayName;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 365");
        n = scan.nextInt();

        if (n < 1 || n > 365)
            System.out.println("not in the area");
        else {
            week = n / DAYS_IN_WEEK + 1;
            day = n - DAYS_IN_WEEK * (week -1);

            switch(day) {
                case 1:
                dayName="Sunday";
                  break;
                case 2:
                  dayName="Monday";
                  break;
                case 3:
                  dayName="Tuesday";
                  break;
                case 4:
                  dayName="Wednesday";
                  break;
                case 5:
                  dayName="Thursday";
                  break;
                case 6:
                  dayName="Friday";
                case 7:
                  dayName="Suterday";
                  break;
                  default:
                  dayName = "";
                  break;
              }

            System.out.println("week: " + week + " day: " + day + "day name: " + dayName);
        }    

    }
}
