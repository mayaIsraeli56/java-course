public class Tester {

  public static void main(String[] args) {

    //1
    int[] r1 = { 5, 4, 5, 8, 12, 9, 9, 3 };
    int[] r2 = { 7, 3, 3, 12, 10, 2, 10, 7 };

    System.out.println(Ex13.shortestRoad(r1, r2));

    //2
    int[] a1 = {-8,-10,-12,-14,-16,-18,-20,-24 };
    System.out.println(Ex13.missingValue(a1));

    //3
    int[] a2 = {1,3,2,3,10,10,3,2,4};
    int[] a3 = {1,2,2,1};
    System.out.println(Ex13.longestPalindrome(a3));

    //4
    int[] a4 = {5,4,2,1,3};
    System.out.println(Ex13.isSum(a4,17));
  }
}
