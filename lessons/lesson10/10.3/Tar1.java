public class Tar1 {

  public static int binarySearch(int[] a, int x) {
    int low = 0, high = a.length - 1;
    return binarySearch(a, x, high, low);
  }

  public static int binarySearch(int[] a, int x, int high, int low) {
    if (low <= high) {
      int mid = (high + low) / 2;

      if (a[mid] == x) return mid;

      if (a[mid] < x) return binarySearch(a, x, high, mid + 1);

      return binarySearch(a, x, mid - 1, low);
    }
    return -1;
  }

  // find num in an unsorted sub array of a that start with idx i
  public static int find(int[] a, int num) {
    return find(a, 0, num);
  }

  private static int find(int[] a, int i, int num) {
    if (i >= a.length) {
      return -1;
    }

    if (a[i] == num) {
      return i;
    }

    return find(a, i + 1, num);
  }

  // find min in array
  public static int min(int[] a) {
    return min(a, 0);
  }

  private static int min(int[] a, int i, int curMin) {
    if (i >= a.length) {
      return curMin;
    }

    if (a[i] < curMin) {
      return min(a, i + 1, a[i]);
    }

    return min(a, i + 1, curMin);
  }

  private static int min(int[] a, int i) {
    if (i >= a.length - 1) {
      return a[a.length - 1];
    }

    return Math.min(a[i], min(a, i + 1));
  }

  public static int minIdx(int[] a) {
    return minIdx(a, 0);
  }

  private static int minIdx(int[] a, int i) {
    if (i >= a.length - 1) {
      return a.length - 1;
    }

    int restMinIdx = minIdx(a, i + 1);
    if (a[i] < a[restMinIdx]) {
      return i;
    }
    return restMinIdx;
  }

  public static String arr2String(int[] a) {
    return arr2String(a, 0);
  }

  private static String arr2String(int[] a, int i) {
    if (i >= a.length) {
      return "";
    }

    return a[i] + " " + arr2String(a, i + 1);
  }

  public static boolean isPalindrom(int[] a) {
    return isPalindrom(a, 0);
  }

  private static boolean isPalindrom(int[] a, int i) {
    int len = a.length;
    if (i >= len / 2) {
      return true;
    }

    return a[i] == a[len -1 -i] && isPalindrom(a, i+1);
  }

  public static int countX(int [] a, int x) {
    return countX(a, x, 0);
  }

  private static int countX(int [] a, int x, int i) {
    if (i == a.length -1) {
      return (a[i] == x) ? 1: 0;
    }

    return ((a[i] == x) ? 1 : 0 ) + countX(a,x,i+1);
  }

}
