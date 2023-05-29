public class Tar1 {

  public static void sort123A(int[] a) {
    int noFlags = 3;
    int sorted = 0;

    for (int flag = 0; flag < noFlags - 1; flag++) {
      for (int i = sorted; i < a.length; i++) {
        if (a[i] == flag) {
          swap(a, sorted, i);
          sorted++;
        }
      }
    }
  }

  public static void sort123C(int[] a) {
    int i0 = 0;
    int i1 = 0;
    int i2 = a.length - 1;

    while (i1 <= i2) {
      if (a[i1] == 0) {
        swap(a, i0, i1);
        i0++;
        i1++;
      } else if (a[i1] == 1) {
        i1++;
      } else if (a[i1] == 2) {
        swap(a, i1, i2);
        i2--;
      }
    }
  }

  public static void sortMod5B(int[] a) {
    int mod = 5;
    int sorted = 0;

    for (int remainer = 0; remainer < mod - 1; remainer++) {
      for (int i = sorted; i < a.length; i++) {
        if (a[i] % 5 == remainer) {
          swap(a, sorted, i);
          sorted++;
        }
      }
    }
  }

  public static void sortMod5(int[] a) {
    int i0 = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = a.length - 1;

    while (i3 <= i4) {
      int remainer = a[i3] % 5;

      switch (remainer) {
        case 0:
          swap(a, i0, i3);
          i0++;
        case 1:
          swap(a, i1, i3);
          i1++;
        case 2:
          swap(a, i2, i3);
          i2++;
        case 3:
          i3++;
          break;
        case 4:
          swap(a, i3, i4);
          i4--;
          break;
      }
    }
  }

  public static boolean find1A(int[] a, int[] b, int num) {
    // b is sorted
    for (int i = 0; i < a.length; i++) {
      int left = 0;
      int right = b.length - 1;

      while (right - left >= 0) {
        int j = (right + left) / 2;

        if (a[i] + b[j] == num) {
          return true;
        } else if (a[i] + b[j] < num) {
          left = j + 1;
        } else {
          right = j - 1;
        }
      }
    }
    return false;
  }

  public static boolean find1B(int[] a, int[] b, int num) {
    // b is sorted
    for (int i = 0; i < a.length; i++) {
      if (binarySearch(b, num - a[i]) != -1) return true;
    }
    return false;
  }

  public static boolean find2(int[] a, int[] b, int num) {
    // b is sorted
    //for (int i = 0; i < a.length; i++) {

    int leftA = 0;
    int rightA = a.length - 1;

    while (rightA - leftA >= 0) {
      int i = (rightA + leftA) / 2;

      int leftB = 0;
      int rightB = b.length - 1;
      int j = 0;

      while (rightB - leftB >= 0) {
        j = (rightB + leftB) / 2;

        if (a[i] + b[j] == num) {
          return true;
        } else if (a[i] + b[j] < num) {
          leftB = j + 1;
        } else {
          rightB = j - 1;
        }
      }

      if (a[i] + b[j] < num) {
        leftA = i + 1;
      } else {
        rightA = i - 1;
      }
    }
    return false;
  }

  public static boolean find2B(int[] a, int[] b, int num) {
    int lo = 0;
    int hi = b.length - 1;
    while (lo < a.length && hi >= 0) {
      if (a[lo] + b[hi] == num) { // found
        return true;
      } else if (a[lo] + b[hi] < num) {
        // need to enlarge the sum
        lo++;
      } else { // a[lo] + b[hi] > num
        // need reduce the sum
        hi--;
      }
    }
    // finish but not found
    return false;
  }

  public static int findMaxofUpDownArray(int[] a) { //O(log n)
    int low = 0, high = a.length - 1, mid;

    while (low <= high) {
      mid = (low + high) / 2;

      if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
        return a[mid];
      } else if (a[mid] < a[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -999;
  }

  public static int binarySearch(int[] a, int x) {
    int low = 0, high = a.length - 1, mid;

    while (low <= high) {
      mid = (low + high) / 2;

      if (a[mid] == x) {
        return mid;
      } else if (a[mid] < x) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  public static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
