import java.util.Scanner;

public class Lexicon {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String temp;

    System.out.println("Give me 3 names");
    String n1 = scan.next();
    String n2 = scan.next();
    String n3 = scan.next();

    if (n1.compareTo(n2) > 0) { // n2 before n1
      temp = n1;
      n1 = n2;
      n2 = temp;
    }
    if (n2.compareTo(n3) > 0) { // n3 before n2
        temp = n3;
        n3 = n2;
        n2 = temp; 
      } 

    if (n1.compareTo(n2) > 0) { // n3 before n1
      temp = n2;
      n2 = n1;
      n1 = temp; 
    } 
   
    System.out.println(n1 + n2 + n3);

  }
}
