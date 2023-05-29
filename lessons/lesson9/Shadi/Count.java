public class Count {

  public static int count(int[] a, int x) {
    int left = 0, right = a.length, mid, low = left, hi = right;

    // find lower bound
    while (left <= right) {
      mid = (left + right) / 2;
      if (a[mid] >= x) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    // find higher bound
    while (low <= hi) {
      mid = (low + hi) / 2;
      if (a[mid] <= x) {
        low = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return low - left;
  }
  //   public static int count(int[] a, int x) {
  //     int left = 0, right = a.length, mid;

  //     while (left <= right) {
  //       mid = (left + right) / 2;

  //       if (a[mid] < x) {
  //         left = mid + 1;
  //       } else if (a[mid] > x) {
  //         right = mid - 1;
  //       } else {
  //         left = mid - 1;
  //         right = mid + 1;

  //         while (a[right] == x) {
  //           right++;
  //         }
  //         while (a[left] == x) {
  //           left--;
  //         }

  //         return right - left - 1;
  //       }
  //     }
  //     return -1;
  //   }
}
