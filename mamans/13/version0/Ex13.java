/**
 * Ex14.java - complexity and recursion problems.
 *
 * @author Maya Israeli
 * @version 25.5.2023
 */

public class Ex13 {

  // Q1 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * The method returns driving duration in minutes on the shortest route from A to B.
   * The method receives two one-dimensional arrays describing a trip from A to B.
   * Each element i in the array is equal to the number of minutes it takes to travel on section i of the road.
   * The driver can start on road 1 or road 2, and can cross a road at most once.
   *
   * Time Complexity: O(n) -
   *    iterating over road1 once in "totalTime" to sum its elements
   *    iterating over road2 once in "totalTime" to sum its elements
   *    iterating over the arrays once to find the optimal exchange point
   *    Total of 3 itetations, no nested loops.  O(n + n + n)  = O(n).
   *
   * Space Complexity: O(1) - constant number of variables.
   *
   * @param road1 array of positive integers, element i in the array represents the driving duration on section i of road 1.
   * @param road2 array of positive integers, element i in the array represents the driving duration on section i of road 2.
   * @return travel time in minutes on the shortest route from A to B
   */

  public static int shortestRoad(int[] road1, int[] road2) {
    int totalR1 = totalTime(road1); // total driving duration from A to B through road 1
    int totalR2 = totalTime(road2); // total driving duration from A to B through road 2
    int shortest = Math.min(totalR1, totalR2); // saves the shortest driving duration found yet

    int timeInR1 = 0; // driving duration from A to the switching point through road 1
    int timeInR2 = 0; // driving duration from B to the switching point through road 2

    /*
     * For each road interchange point (switchPoint) it calculate:
     * 1. driving duration in a path that starts at road 1 and switch at
     *    switchPoint to road 2
     * 2. driving duration in a path that starts at road 2 and switch at switchPoint to road 1
     *    find the min between the two and the overall minimum.
     */
    for (int switchPoint = 0; switchPoint < road1.length - 1; switchPoint++) {
      timeInR1 += road1[switchPoint]; // add the current section from road1
      timeInR2 += road2[switchPoint]; // add the current section from road2
      shortest =
        Math.min(
          shortest, // current overall min
          Math.min(
            timeInR1 + totalR2 - timeInR2, // starts at road 1 and switch at switchPoint to road 2
            timeInR2 + totalR1 - timeInR1 // starts at road 2 and switch at switchPoint to road 1
          )
        );
    }

    // time in minutes on the shortest route
    return shortest;
  }

  /*
   * A method that returns the sum of elements in a given array
   * Time Complexity: O(n) - iterating over the array once.
   * Space Complexity: O(1) - constant number of variables.
   */
  private static int totalTime(int[] road) {
    int total = 0;

    for (int i = 0; i < road.length; i++) {
      total += road[i];
    }

    return total;
  }

  // Q2 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * A method that receives a one-dimensional array
   * containing numbers that are part of arithmetic progression.
   * One number in the series is missing, and the method returns this missing number.
   *
   * @param arr one-dimensional array containing numbers that are part of arithmetic progression,
   *            one number in the series is skipped.
   * @return the missing number in the series.
   */
  public static int missingValue(int[] arr) {
    int len = arr.length;
    int lo = 0, hi = len - 1;
    int delta = (arr[hi] - arr[lo]) / len;
    int mid, a1 = arr[0];

    while (lo < hi) {
      mid = lo + (hi - lo) / 2;
      if (arr[mid] == a1 + mid * delta) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    // lo == hi
    if (arr[lo] == a1 + lo * delta) {
      return arr[lo] + delta;
    }

    return arr[lo] - delta;
  }

  // Q3 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * A recursive method, returns the length of the longest palindromic sequence in a given array.
   *
   * @param arr The array for finding the length of the longest palindromic sequence in it.
   * @return integer that represents the length of the longest palindromic sequence in arr (1-arr.length)
   */
  public static int longestPalindrome(int[] arr) {
    return longestPalindrome(arr, 0, arr.length - 1);
  }

  private static int longestPalindrome(int[] arr, int left, int right) {
    final int MIN_LENGTH = 1; // the length of the shortest palindrome
    final int LAST_IDX = arr.length - 1; // the length of the shortest palindrome
    final int FIRST_IDX = 0; // first index in the array

    // base case - all sequences with a length greater than 1 have been checked and are not palindromes
    if (left == right) {
      return MIN_LENGTH;
    }

    // if the current sequences is a palindrom it is the longest one in the array
    if (isPalindrom(arr, left, right)) {
      return right - left + 1; // the palindrom length
    }

    /*
     *  A recursive call to the function, sending the indexes of the next sequence.
     *  If there is another sequence of the same length that has not yet been checked - sends it.
     *  Otherwise, sends a sequence that is shorter by one.
     *  For each length, the position of "left" starts at the beginning of the array,
     *  and the indexes increasing as long as right is not out of bound.
     */
    return (right != LAST_IDX)
      ? longestPalindrome(arr, left + 1, right + 1)
      : longestPalindrome(arr, FIRST_IDX, right - left - 1);
  }

  // A boolean method that returns true if the given array contains a palindrome between the given indexes
  private static boolean isPalindrom(int[] a, int left, int right) {
    if (left >= right) { // all cells has been checked and did not returned false - it is a palindrom
      return true;
    }

    if (a[left] != a[right]) { // checks if the numbers in the edges are equal
      return false;
    }

    // checks the rest of the sequence without the edges
    return isPalindrom(a, left + 1, right - 1);
  }

  // Q4 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * A recursive method, returns true if the recived array have a subset, which fulfills the following conditions:
   * 1. It's members sum is equal to the recived integer (num).
   * 2. A member could be added to the sum no more thשn once.
   * 3. Every 3 members can not be in adjacent cells in the array.
   *
   * @param arr A one-dimensional array filled with positive integers.
   * @param num An integer, the sum to be reched.
   * @return true if the required subset has been found
   *
   * Time Complexity: O(2^n) - calls itself twice in each iteration.
   * Space Complexity: O(n) - constant number of variables.
   */

  public static boolean isSum(int[] arr, int num) {
    // calls for the private method
    return isSum(arr, num, 0, 0);
  }

  /*
   * returns true if the required subset has been found -
   * For each cell it recursively checks two options subtracting or skipping,
   * while keeping the third rule using a counter.
   */
  private static boolean isSum(int[] arr, int num, int i, int count) {
    // base case - the numbers subtracted from num are the required subset
    if (num == 0) {
      return true;
    }

    // returns false if a matching number wasn't found.
    if (num < 0 || i == arr.length) {
      return false;
    }

    // "count" watches after the subtractaction of three adjacent cells
    if (count != 2) { // this cell can be subtracted from num
      // returns whether goal can be achieved by subtracting this cell or by skipping it
      return (
        isSum(arr, num - arr[i], i + 1, count + 1) || isSum(arr, num, i + 1, 0)
      );
    }

    // two adjacent cells has already been add - cell must be skipped
    return isSum(arr, num, i + 1, 0);
  }
}
