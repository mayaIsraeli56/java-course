/**
 * Ex14.java - complexity and recursion problems.
 *
 * @author Maya Israeli
 * @version 25.5.2023
 */

public class Ex13 {

  // Q1
  // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * The method returns driving duration in minutes on the shortest route from A
   * to B.
   * The method receives two one-dimensional arrays describing a trip from A to B.
   * Each element i in the array is equal to the number of minutes it takes to
   * travel on section i of the road.
   * The driver can start on road 1 or road 2, and can cross a road at most once.
   *
   * Time Complexity: O(n) -
   * iterating once over road1 and road2 (at the same time) to sum up their
   * elements
   * iterating over the arrays once to find the optimal exchange point
   * Total of 2 itetations, no nested loops. O(n + n) = O(n).
   *
   * Space Complexity: O(1) - constant number of variables.
   *
   * @param road1 array of positive integers, element i in the array represents
   *              the driving duration on section i of road 1.
   * @param road2 array of positive integers, element i in the array represents
   *              the driving duration on section i of road 2.
   * @return integer that represents the travel time in minutes on the shortest route from A to B
   */

  public static int shortestRoad(int[] road1, int[] road2) {
    int len = road1.length; // the roads are in the same length

    int pathR1 = 0; // the driving duration of the routes that starts at road1
    int pathR2 = 0; // the driving duration of the routes that starts at road2

    // sums up the total driving duration for each road - without changing a road
    for (int i = 0; i < len; i++) {
      pathR1 += road1[i];
      pathR2 += road2[i];
    }

    int shortest = Math.min(pathR1, pathR2); // saves the shortest driving duration found yet

    /*
     * For each road interchange point (switchPoint) it calculates:
     * 1. driving duration in a path that starts at road 1 and switch at
     * switchPoint to road 2
     * 2. driving duration in a path that starts at road 2 and switch at switchPoint
     * to road 1
     * It finds the min between the two and the overall minimum.
     */
    for (int switchPoint = len - 1; switchPoint > 0; switchPoint--) {
      pathR1 += road2[switchPoint] - road1[switchPoint]; // switch the current section
      pathR2 += road1[switchPoint] - road2[switchPoint]; // switch the current section
      shortest = Math.min(shortest, Math.min(pathR1, pathR2));
    }

    // time in minutes on the shortest route
    return shortest;
  }

  // Q2
  // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * A method that receives a one-dimensional array
   * containing numbers that are part of arithmetic sequence.
   * One number in the series is missing, and the method returns this missing
   * value.
   * 
   * Time Complexity: O(logn) -
   *
   * Space Complexity: O() - 
 
   *
   * @param arr one-dimensional array containing numbers that are part of
   *            arithmetic progression,
   *            one number in the series is skipped.
   * @return the missing number in the series.
   */
  public static int missingValue(int[] arr) {
    
    int len = arr.length;
    int lo = 0, hi = len - 1; // The indexes that limit the search area
    int diff = (arr[hi] - arr[lo]) / len; // the common difference of successive members
    int mid, a1 = arr[0];

    // Finds the serial number of the missing value i by reducing the options by half in each iteration
    while (lo <= hi) {
      mid = (lo + hi) / 2;
      if (arr[mid] == a1 + mid * diff) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return arr[hi] + diff;
  }

  
  // Q3
  // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * A recursive method, returns the length of the longest palindromic sequence in
   * a given array.
   *
   * @param arr The array for finding the length of the longest palindromic
   *            sequence in it.
   * @return integer that represents the length of the longest palindromic
   *         sequence in arr (1-arr.length)
   */
  public static int longestPalindrome(int[] arr) {
    return longestPalindrome(arr, 0, arr.length - 1);
  }

  private static int longestPalindrome(int[] arr, int left, int right) {
    final int MIN_LENGTH = 1; // the length of the shortest palindrome
    final int LAST_IDX = arr.length - 1; // the length of the shortest palindrome
    final int FIRST_IDX = 0; // first index in the array

    // base case - all sequences with a length greater than 1 have been checked and
    // are not palindromes
    if (left == right) {
      return MIN_LENGTH;
    }

    // if the current sequences is a palindrom it is the longest one in the array
    if (isPalindrom(arr, left, right)) {
      return right - left + 1; // the palindrom length
    }

    /*
     * A recursive call to the function, sending the indexes of the next sequence.
     * If there is another sequence of the same length that has not yet been checked
     * - sends it.
     * Otherwise, sends a sequence that is shorter by one.
     * For each length, the position of "left" starts at the beginning of the array,
     * and the indexes increasing as long as right is not out of bound.
     */
    return (right != LAST_IDX)
        ? longestPalindrome(arr, left + 1, right + 1)
        : longestPalindrome(arr, FIRST_IDX, right - left - 1);
  }

  // A boolean method that returns true if the given array contains a palindrome
  // between the given indexes
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

  // Q4
  // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * A recursive method, returns true if the recived array have a subset, which
   * fulfills the following conditions:
   * 1. It's members sum is equal to the recived integer (num).
   * 2. A member could be added to the sum no more thשn once.
   * 3. Every 3 members can not be in adjacent cells in the array.
   *
   * @param arr A one-dimensional array filled with positive integers.
   * @param num An integer, the sum to be reched.
   * @return true if the required subset has been found
   *
   *         Time Complexity: O(2^n) - calls itself twice in each iteration.
   *         Space Complexity: O(n) - constant number of variables.
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
      // returns whether goal can be achieved by subtracting this cell or by skipping
      // it
      return (isSum(arr, num - arr[i], i + 1, count + 1) || isSum(arr, num, i + 1, 0));
    }

    // two adjacent cells has already been add - cell must be skipped
    return isSum(arr, num, i + 1, 0);
  }
}
