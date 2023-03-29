import java.util.Scanner;

public class ThreeDigit {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int sum = 0;
        System.out.println("Please enter a positive 3 digits num");
        int n = scan.nextInt();

        if (n > 99 && n < 1000) {
            sum += n % 10;
            sum += (n / 10) % 10;
            sum += (n / 100) % 10;
            System.out.println("sum: " + sum);
        } else {
            System.out.println("not a 3 digits num");
        }
        scan.close();
    }
}
