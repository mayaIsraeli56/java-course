public class Tar2 {

  public static int[] merge(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    return mergeA(a, b, c, 0, 0);
  }

  public static int[] merge(int[] a, int[] b, int[] c, int iA, int iB) {
    int lenA = a.length;
    int lenB = b.length;

    if (iA + iB == lenA + lenB) {
      return c;
    } else if (iA < lenA && iB < lenB) {
      c[iA + iB] = (a[iA] < b[iB]) ? a[iA++] : b[iB++];
    } else if (iA < lenA) { // iB == lenB
      c[iA + iB] = a[iA++];
    } else {
      c[iA + iB] = b[iB++];
    }
    return merge(a, b, c, iA, iB);
  }

  public static int[] mergeA(int[] a, int[] b, int[] c, int iA, int iB) {
    int lenA = a.length;
    int lenB = b.length;

    if (iA + iB == lenA + lenB) {
      return c;
    }

    if (iB == lenB || iA < lenA && a[iA] < b[iB]) {
      c[iA + iB] = a[iA++];
    } else {
      c[iA + iB] = b[iB++];
    }
    return merge(a, b, c, iA, iB);
  }

  public static void orderOddEven(int[] a) {
    orderOddEven(a, 0, a.length - 1);
  }

  public static void orderOddEven(int[] a, int left, int right) {
    if (left >= right) {
      return;
    }

    if (a[left] % 2 == 1) {
      orderOddEven(a, left + 1, right);
    } else if (a[right] % 2 == 0) {
      orderOddEven(a, left, right - 1);
    } else {
      int tmp = a[left];
      a[left] = a[right];
      a[right] = tmp;
      orderOddEven(a, left + 1, right - 1);
    }
  }

  public static boolean isSub(int[] base, int[] sub) {
    if (base.length < sub.length) {
      return false;
    }
    return isSub(base, sub, 0, 0);
  }

  public static boolean isSub(int[] base, int[] sub, int i, int j) {
    if (i > base.length - sub.length + j) {
      return false;
    }

    if (base[i] == sub[j]) {
      if (j == sub.length - 1) {
        return true;
      }
      return isSub(base, sub, i + 1, j + 1);
    }
    return isSub(base, sub, i + 1, 0);
  }

  public static boolean isSub2(int[] base, int[] sub) {
    if (base.length < sub.length) {
      return false;
    }
    return isSub2(base, sub, 0);
  }

  public static boolean isSub2(int[] base, int[] sub, int i) {
    if (i > base.length - sub.length) {
      return false;
    }

    if (isSub2(base, sub, i, 0)) {
      return true;
    }

    return isSub2(base, sub, i + 1);
  }

  public static boolean isSub2(int[] base, int[] sub, int i, int j) {
    if (j == sub.length) {
      return true;
    }

    if (base[i] == sub[j]) {
      return isSub2(base, sub, i + 1, j + 1);
    }

    return false;
  }

  public static boolean div4Or7(int[] a) {
    if (div4Or7(a, 4, 0) || div4Or7(a, 7, 0)) {
      return true;
    }
    return false;
  }

  public static boolean div4Or7(int[] a, int n, int i) {
    if (i == a.length) {
      return true;
    }

    if (a[i] % n == 0) {
      return div4Or7(a, n, i + 1);
    }

    return false;
  }

  public static double mul(double[] a) {
    return mul(a, 0);
  }

  private static double mul(double[] a, int i) {
    if (i == a.length - 1) return a[i];

    return a[i] * mul(a, i + 1);
  }

  /* Complete your code here */
  public static boolean kArray(int[] a) {
    if (a.length < 3) return true;

    return kArray(a, 0, Math.abs(a[0] - a[1]));
  }

  public static boolean kArray(int[] a, int i, int k) {
    if (i == a.length - 1) return true;

    return Math.abs(a[i] - a[i + 1]) == k && kArray(a, i + 1, k);
  }

  public static int smallest(int[] a) {
    return smallest(a, 0);
  }

  // שיטה סטטית רקורסיבית המקבלת מערך של מספרים שלמים ומחזירה את האינדקס של התא בעל הערך הקטן ביותר
  private static int smallest(int[] a, int i) {
    if (i == a.length - 1) return i;

    int val = smallest(a, i + 1);

    if (a[val] < a[i]) return val; else return i;
  }
}
