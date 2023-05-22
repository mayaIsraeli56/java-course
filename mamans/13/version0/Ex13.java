public class Ex13 {

  /**
   * time complexity = O(n)
   * space complexity = O(1)
   * @param road1
   * @param road2
   * @return
   */
  public static int shortestRoad(int[] road1, int[] road2) {
    int totalR1 = totalTime(road1); // total driving duration from A to B trought road 1
    int totalR2 = totalTime(road2); // total driving duration from A to B trought road 2
    int shortest = Math.min(totalR1, totalR2); // saves the shortest driving duration found yet

    int timeInR1 = 0; // driving duration from A to the switching point trought road 1
    int timeInR2 = 0; // driving duration from B to the switching point trought road 2

    /*
     * going trought all the "switchPoints" avilable - in which a car can cange it road
     * calculate:
     *  (1) the driving duration in a path that starts at road 1 and switch at switchPoint to road 2
     *  (2) the  path that starts at road 2 and switch at switchPoint to road 1
     * find the min between the two and the current min
     */
    for (int switchPoint = 0; switchPoint < road1.length - 1; switchPoint++) {
      timeInR1 += road1[switchPoint]; // add the current section from road1
      timeInR2 += road2[switchPoint]; // add the current section from road2
      shortest =
        Math.min(
          shortest, // current min
          Math.min(
            timeInR1 + totalR2 - timeInR2, // starts at road 1 and switch at switchPoint
            timeInR2 + totalR1 - timeInR1 // starts at road 2 and switch at switchPoint
          )
        );
    }

    return shortest;
  }

  private static int totalTime(int[] road) {
    int total = 0;

    for (int i = 0; i < road.length; i++) {
      total += road[i];
    }

    return total;
  }

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

  public static int longestPalindrome(int[] arr) {
    return longestPalindrome(arr, 0, arr.length - 1);
  }

  public static int longestPalindrome(int[] arr, int left, int right) {
    if (left >= right ) {
      return 1;
    }

    if (isPalindrom(arr, left, right)) {
      return left - right + 1;
    }

    return Math.max(
      longestPalindrome(arr, left - 1, right),
      longestPalindrome(arr, left, right - 1)
    );
  }

  private static boolean isPalindrom(int[] a, int left, int right) {
    if (left == right || left + 1 == right) {
      // 1 or 0 elements
      return true;
    }
    if (a[left] != a[right]) {
      return false;
    }
    return isPalindrom(a, left + 1, right - 1);
  }
}
