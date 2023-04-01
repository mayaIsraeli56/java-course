import java.util.Scanner;

public class PalindromeTester {
    public static void main(String[] args) {
        String str, another = "y";
        int left, right;
        boolean isPalindrome;
        Scanner scan = new Scanner(System.in);

        while (another.equalsIgnoreCase("y")) {
            System.out.println("Enter a potential palindrome:");
            str = scan.nextLine();
            left = 0;
            right = str.length() - 1;
            isPalindrome = true;

            while (left < right && isPalindrome) {
                if (str.charAt(right) != str.charAt(left))
                    isPalindrome = false;
                left++;
                right--;
            }

            if (isPalindrome)
                System.out.println(str + " is palindrome");
            else
                System.out.println(str + " is not palindrome");

            System.out.print("Test another palindrome (y / n)? ");
            another = scan.nextLine();
        }
        scan.close();
    }
}
