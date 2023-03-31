import java.util.Scanner;

public class MyString {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String strl = "abc abcdefghi";
    System.out.println(strl.length());
    System.out.println(strl.indexOf("d"));
    System.out.println(strl.indexOf("b",strl.indexOf("b")+1));
    System.out.println(strl.substring(3));
    System.out.println(strl.substring(strl.indexOf("d")));
    String strl2 = strl.replace("a", "z");
    System.out.println(strl2);
    String strl3 = strl.concat(strl2);
    System.out.println(strl3);

    System.out.println("Give me 3 names");
    String n1 = scan.next();
    String n2 = scan.next();
    String n3 = scan.next();

    if (n1.compareTo(n2) < 0) {
      if (n2.compareTo(n3) < 0) System.out.println("n1 -> n2 -> n3");
      else if(n1.compareTo(n3) < 0 ) System.out.println("n1 -> n3 -> n2");
      else System.out.println("n3 -> n1 -> n2");
    } else {
        if (n1.compareTo(n3) < 0) System.out.println("n2 -> n1 -> n3");
        else if(n3.compareTo(n2) < 0 ) System.out.println("n3 -> n2 -> n1");
        else System.out.println("n2 -> n3 -> n1");
    }
  }
}
