public class Tester {

  public static void main(String[] args) {
    // 1
    int[] r1 = { 5, 4, 5, 8, 12, 9, 9, 3 };
    int[] r2 = { 7, 3, 3, 12, 10, 2, 10, 7 };
    int[] r3 = { 2,7,9,1,3,0,3,3 };
    int[] r4 = { 9,2,5,7,8,9,4,3 };

    System.out.println(Ex13.shortestRoad(r1, r2));
    System.out.println(Ex13.shortestRoad(r1, r3));
    System.out.println(Ex13.shortestRoad(r1, r4));
    System.out.println(Ex13.shortestRoad(r2, r3));
    System.out.println(Ex13.shortestRoad(r2, r4));
    System.out.println(Ex13.shortestRoad(r3, r4));

    // 2
    int[] a1 = { -8, -10, -12, -14, -16, -18, -20, -24 };
    int[] a2 = { 10, 40, 70, 130 };
    int[] a3 = { 40, 70, 130 };
    int[] a4 = { 9, 7, 3 };
    int[] a5 = { 9, 7, 5, 3, 1, -1, -3, -5, -9 };
    int[] a6 = { 7, 5, 3, 1, -1, -3, -5, -9 };
    int[] a7 = { 0,1,3,4,5,6};
    System.out.println(Ex13.missingValue(a1));
    System.out.println(Ex13.missingValue(a2));
    System.out.println(Ex13.missingValue(a3));
    System.out.println(Ex13.missingValue(a4));
    System.out.println(Ex13.missingValue(a5));
    System.out.println(Ex13.missingValue(a6));
    System.out.println(Ex13.missingValue(a7));
    
    //3
    int[] b1 = { 1};
    int[] b2 = { 1, 3, 2, 3, 10, 10, 3, 2, 4 };
    int[] b3 = { 1, 2, 2, 1 };
    int[] b4 = { 5, 4, 2, 1, 3 };
    int[] b5 = { 0, 0, 1, 2, 1 };
    int[] b6 = { 0, 0, 0, 0, 0 };
    int[] b7 = { 2, 1, 3, 6, 2 };
    int[] b8 = { 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1 };
    int[] b9 = { 1, 3, 2, 3, 10, 10, 3, 2, 4, 6, 1, 3, 2, 3, 10, 10, 3, 2, 4 };
    System.out.println();
    System.out.println(Ex13.longestPalindrome(b1));
    System.out.println(Ex13.longestPalindrome(b2));
    System.out.println(Ex13.longestPalindrome(b3));
    System.out.println(Ex13.longestPalindrome(b4));
    System.out.println(Ex13.longestPalindrome(b5));
    System.out.println(Ex13.longestPalindrome(b6));
    System.out.println(Ex13.longestPalindrome(b7));
    System.out.println(Ex13.longestPalindrome(b8));
    System.out.println(Ex13.longestPalindrome(b9));

    //4
    System.out.println(Ex13.isSum(b4,17));
  }
}
