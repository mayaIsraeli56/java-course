public class Tar6 {

  public static boolean disco(boolean[] a, boolean[] b) {
    return disco(a, b, 0);
  }

  private static boolean disco(boolean[] a, boolean[] b, int i) {
    if (equalArrays(a, b, 0)) {
      return true;
    } else if (i == a.length) {
      return false;
    }

    press(a, i);
    if (disco(a, b, i + 1)) {
      return true;
    }
    press(a, i);
    return disco(a, b, i + 1);
  }

  private static boolean equalArrays(boolean[] a, boolean[] b, int i) {
    if (i == a.length) {
      return true;
    }

    if (a[i] == b[i]) {
      return equalArrays(a, b, i + 1);
    }
    return false;
  }

  private static void press(boolean[] a, int i) {
    a[i] = !a[i];
    if (i > 0) {
      a[i - 1] = !a[i - 1];
    }
    if (i < a.length - 1) {
      a[i + 1] = !a[i + 1];
    }
  }
}
