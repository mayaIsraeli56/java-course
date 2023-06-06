public class Draft {

  static int count1 = 0;
  static int count2 = 0;
  static int count3 = 0;

  public static int longestPalindrome1(int[] arr) {
    int ans = longestPalindrome1(arr, 0, arr.length - 1);
    System.out.println("count1: " + count1);
    return ans;
  }

  private static int longestPalindrome1(int[] arr, int left, int right) {
    int lastIdx = arr.length - 1; // last index in the array

    // base case - all sequences with a length greater than 1 have been checked and
    // are not palindromes
    if (left == right) {
      return 1;
    }

    // if the current sequences is a palindrom, it is the longest one in the array
    if ( isPalindrom(arr, left, right)) {
      return right - left + 1; // palindrom length
    }

    /*
     * A recursive call to the function, sending the indexes of the next sequence.
     * If there is another sequence of the same length that has not yet been checked
     * - sends it.
     * Otherwise, sends a sequence that is shorter by one.
     * For each length, the position of "left" starts at the beginning of the array,
     * and the indexes increasing as long as right is not out of bound.
     */
    return (right != lastIdx)
      ? longestPalindrome(arr, left + 1, right + 1)
      : longestPalindrome(arr, 0, right - left - 1);
  }

  // A boolean method that returns true if the given array is a palindrome
  // between the given indexes
  private static boolean isPalindrom(int[] a, int left, int right) {
    count1++;
    if (left >= right) { // all cells has been checked and did not returned false - it is a palindrom
      return true;
    }

    if (a[left] != a[right]) { // checks if the numbers in the edges are equal
      return false;
    }

    // checks the rest of the sequence without the edges
    return isPalindrom(a, left + 1, right - 1);
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public static int longestPalindrome2(int[] arr) {
    int ans = longestPalindrome2(arr, 0, arr.length - 1);
    System.out.println("count2: " + count2);
    return ans;
  }

  private static int longestPalindrome2(int[] arr, int left, int right) {
    final int LAST_IDX = arr.length - 1;
    final int FIRST_IDX = 0;

    // stop
    if (left == right) {
      return 1;
    }

    if (isPalindrom2(arr, left, right)) {
      return right - left + 1;
    }

    return (right != LAST_IDX)
      ? longestPalindrome2(arr, left + 1, right + 1)
      : longestPalindrome2(arr, FIRST_IDX, right - left -1);
  }

  private static boolean isPalindrom2(int[] a, int left, int right) {
    count2++;
    if (left >= right) { // all cells has been checked and did not returned false - it is a palindrom
      return true;
    }

    if (a[left] != a[right]) { //
      return false;
    }
    return isPalindrom(a, left + 1, right - 1);
  }

  //////////////////////////////////////////////////////////////////////////////
  public static int longestPalindrome3(int[] arr) {
    int ans = longestPalindrome3(arr, 0, arr.length - 1);
    System.out.println("count3: " + count3);
    return ans;
  }

  private static int longestPalindrome3(int[] arr, int i, int j) {
    count3++;
    //two base cases
    if (i == j) {
      return 1;
    }
    if (i > j) {
      return 0;
    }

    //check if first element and last element are equal. if so, we will call the function again and check
    //and remember to add +2, but now we will check if the next element is equal to the one before end, and so on.
    if (arr[i] == arr[j]) {
      int subLength = longestPalindrome3(arr, i + 1, j - 1);
      if (subLength == j - i - 1) {
        return 2 + subLength;
      }
    }

    //the above not happening, we will call for two functions and take the maximum of them.
    //the first function will increase i by 1 and the other will decrease j-1.
    //in that situation we will check for all possible combinations of the array.
    return Math.max(
      longestPalindrome3(arr, i + 1, j),
      longestPalindrome3(arr, i, j - 1)
    );
  }

  ///////////////////////////////////////////////////////////////////////////////////////

  private static int longestPalindrome(int[] arr, int left, int right) {
    final int MIN_LENGTH = 1; // the length of the shortest palindrome
    final int LAST_IDX = arr.length - 1; // the length of the shortest palindrome

    // base case - left and right are pointing at the last cell after all other cells have been checked
    if (left == LAST_IDX) {
      return MIN_LENGTH;
    }

    /*
     * Option 1 is to check if the current sub array between left and right is a palindrome -
     *  if so opt1 saves its length else it saves the min
     */
    int opt1 = (isPalindrom(arr, left, right)) ? right - left + 1 : MIN_LENGTH;

    /* Option 2 is to check if the next sub array is a palindrome.
     * The next subarray is chosen by a specific order:
     * For each left cell recursively checks all subarrays whose right border is to the right of "left",
     * then moves on to the next left cell.
     */
    int opt2 = (right > left + 1)
      ? longestPalindrome(arr, left, right - 1)
      : longestPalindrome(arr, left + 1, LAST_IDX);

    // longest palindromic sequence in the received subarray is the max between the two options
    return Math.max(opt1, opt2);
  }
}




// int[] a2 = { 1, 3, 2, 3, 10, 10, 3, 2, 4 };
// int[] a3 = { 1, 2, 2, 1 };
// int[] a4 = { 5, 4, 2, 1, 3 };
// int[] a5 = { 0, 0, 1, 2, 1 };
// int[] a6 = { 0, 0, 0, 0, 0 };
// int[] a7 = { 2, 1, 3, 6, 2 };
// int[] a8 = { 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1 };
// int[] a9 = { 1, 3, 2, 3, 10, 10, 3, 2, 4, 6, 1, 3, 2, 3, 10, 10, 3, 2, 4 };
// int[] a10 = {
//   1,
//   2,
//   2,
//   1,
//   1,
//   2,
//   2,
//   1,
//   1,
//   2,
//   2,
//   1,
//   1,
//   2,
//   2,
//   1,
//   1,
//   2,
//   2,
//   1,
//   1,
//   2,
//   2,
//   1,
//   1,
//   2,
//   2,
//   1,
//   1,
//   2,
//   2,
//   1,
// };
// //System.out.println(Ex13.longestPalindrome(a7));
// System.out.println(Draft.longestPalindrome1(a1));
// System.out.println(Draft.longestPalindrome2(a1));
// System.out.println(Draft.longestPalindrome3(a1));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a2));
// System.out.println(Draft.longestPalindrome2(a2));
// System.out.println(Draft.longestPalindrome3(a2));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a3));
// System.out.println(Draft.longestPalindrome2(a3));
// System.out.println(Draft.longestPalindrome3(a3));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a4));
// System.out.println(Draft.longestPalindrome2(a4));
// System.out.println(Draft.longestPalindrome3(a4));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a5));
// System.out.println(Draft.longestPalindrome2(a5));
// System.out.println(Draft.longestPalindrome3(a5));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a6));
// System.out.println(Draft.longestPalindrome2(a6));
// System.out.println(Draft.longestPalindrome3(a6));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a7));
// System.out.println(Draft.longestPalindrome2(a7));
// System.out.println(Draft.longestPalindrome3(a7));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a8));
// System.out.println(Draft.longestPalindrome2(a8));
// System.out.println(Draft.longestPalindrome3(a8));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a9));
// System.out.println(Draft.longestPalindrome2(a9));
// System.out.println(Draft.longestPalindrome3(a9));
// System.out.println();

// System.out.println(Draft.longestPalindrome1(a10));
// System.out.println(Draft.longestPalindrome2(a10));
// System.out.println(Draft.longestPalindrome3(a10));
// System.out.println();