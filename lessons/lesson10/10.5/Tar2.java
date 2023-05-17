public class Tar2 {
  public static String arr2String(boolean[] a) {
    return arr2String(a, 0);
  }

  public static String arr2String(boolean[] a, int i) {
    if (i == a.length) {
      return "";
    }

    return a[i] + "\t" + arr2String(a, i + 1);
  }

  //////////////////////////////////////////////////////////////
  public static String arr2String(int[][] a) {
    return arr2String(a, 0, 0);
  }

  private static String arr2String(int[][] a, int i, int j) {
    if (i == a.length) {
      return "";
    }

    String currCell = a[i][j] + "\t";

    if (j < a[i].length - 1) {
      j++;
    } else {
      i++;
      j = 0;
      currCell += "\n";
    }

    return currCell + arr2String(a, i, j);
  }

  /////////////////////////////////
  public static String arr2String(boolean[][] a) {
    return arr2String(a, 0, 0);
  }

  private static String arr2String(boolean[][] a, int i, int j) {
    if (i == a.length) {
      return "";
    }

    String currCell = a[i][j] + "\t";

    if (j < a[i].length - 1) {
      j++;
    } else {
      i++;
      j = 0;
      currCell += "\n";
    }

    return currCell + arr2String(a, i, j);
  }

  public static int countNum(int[][] a, int num) {
    return countNum(a, num, 0, 0);
  }

  public static int countNum(int[][] a, int num, int i, int j) {
    if (i == a.length) {
      return 0;
    }

    int isNum = (a[i][j] == num) ? 1 : 0;

    if (j < a[i].length - 1) {
      j++;
    } else {
      i++;
      j = 0;
    }

    return isNum + countNum(a, num, i, j);
  }

  public static String strings(String s1, String s2) {
    return strings(s1, s2, 0);
  }

  private static String strings(String s1, String s2, int i) {
    boolean s1Ended = i > s1.length() - 1;
    boolean s2Ended = i > s2.length() - 1;

    if (s1Ended && s2Ended) {
      return "";
    }

    String s1Letter = (s1Ended) ? "" : s1.charAt(i) + "";
    String s2Letter = (s2Ended) ? "" : s2.charAt(i) + "";

    return s1Letter + s2Letter + strings(s1, s2, i + 1);
  }

  public static String stringsBetter(String s1, String s2) {
    if (s1.length() == 0 && s2.length() == 0)
      return "";

    if (s1.length() == 0)
      return s2;

    if (s2.length() == 0)
      return s1;

    return (s1.charAt(0) +
        "" +
        s2.charAt(0) +
        "" +
        strings(s1.substring(1), s2.substring(1)));
  }
}
