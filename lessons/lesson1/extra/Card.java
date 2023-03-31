import java.util.Random;
import java.util.Scanner;

public class Card {

  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int cardNum = rand.nextInt(13) + 1;
    int cardType= rand.nextInt(4);
    String type;

    switch (cardType) {
        case 0 : 
        type = "club";
        break;
        case 1 : 
        type = "diamond";
        break;
        case 2 : 
        type = "Heart";
        break;
        case 3 : 
        type = "spade";
        break;
        default: 
        type = "(it seems like there was a problem)";
    }

    System.out.println("num: " + cardNum + "   type: " + type );
    scan.close();
  }
}
