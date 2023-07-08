public class B202296 {

  public static int kAlmostSearch(int[] a, int n) {

    int l = 0, h = a.length - 1, m1, m2;

    while (l <= h) {
      m1 = (h + l) / 2;
      m2 = m1 - 1;

      while (m1 < h && a[m1] == 0) m1++;

      if (n == a[m1]) return m1;
      if (n > a[m1]) l = m1 + 1; else { //n < a[m1]
        while (m2 > l && a[m2] == 0) m2--;

        if (n == a[m2]) return m2;
        if (n > a[m2]) return -1;
        h = m2 - 1; // n < a[m2]
      }

    }

    return -1;
  }
}
