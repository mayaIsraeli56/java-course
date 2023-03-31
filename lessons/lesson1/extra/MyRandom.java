import java.util.Random;
import java.util.Scanner;

public class MyRandom {

  public static void main(String[] args) {
    Random rndm = new Random();
    int n;
    for (int i = 0; i < 3; i++) {
      n = rndm.nextInt(-15, 16);
      System.out.print(n + " ");
    }
    double nD;
    for (int i = 0; i < 3; i++) {
      nD = rndm.nextDouble(-10.5, 10.5);
      System.out.print(nD + " ");
    }

    System.out.println("sin: " + Math.sin( Math.toRadians(30)));

    System.out.println("area: " + Math.pow(4.35, 2) * Math.PI);

    Scanner scan = new Scanner(System.in);
    System.out.println("give me a real num - I will round it ");
    double d = scan.nextDouble();
    System.out.println(Math.round(d * 100) / 100);

    double d2 = rndm.nextDouble() * 21 - 10.5;
    System.out.println("a random real number from -10.5 to 10.5 = " + d2);
    scan.close();
  }
}
