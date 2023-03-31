import java.util.Scanner;

public class CostumeRound {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Give me a real num");
    double n = scan.nextDouble();

    System.out.println("How many digits after the decimal point to leave?");
    int digitsAfterDoot = scan.nextInt();

    int accuracy = (int)Math.pow(10, digitsAfterDoot);
    System.out.println("Rounded num:" + Math.round(n * accuracy) /accuracy);
  }
}
