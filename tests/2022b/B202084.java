public class B202084 {

  //   public static void findWord(char[][] a, String w) {
  //      int len = a.length;
  //      int width = a[0].length;
  //     int[][] m = new int[len][width];

  //     if (
  //       a == null ||
  //       w == null ||
  //       w.length() == 0 ||
  //       w.length() > len * width ||
  //       !findWord(a, w, m, 0, 0, 0)
  //     ) {
  //       System.out.println("Now such word");
  //     }
  //   }

  //   private static boolean findWord(
  //     char[][] a,
  //     String w,
  //     int[][] m,
  //     int i,
  //     int j,
  //     int c
  //   ) { // a= arr , w = word , m = mat, c= count
  //      char been = '#';
  //      int len = a.length;
  //      int width = a[0].length;

  //     if (i < 0 || i >= len || j < 0 || j >= width || m[i][j] == been) {
  //       return false;
  //     }

  //     char t = a[i][j]; // tmp
  //     a[i][j] = been;
  //     boolean found;

  //     if (w.charAt(c) == t) {

  //       m[i][j] = ++c;

  //       if (c == w.length()) {
  //         System.out.println(arr2String(m));
  //         return true;
  //       }

  //       found =
  //         findWord(a, w, m, i + 1, j, c) ||
  //         findWord(a, w, m, i - 1, j, c) ||
  //         findWord(a, w, m, i, j + 1, c) ||
  //         findWord(a, w, m, i, j - 1, c);

  //       m[i][j] = 0;

  //     } else {

  //       found =
  //         (j == width - 1 && c==0)
  //           ? findWord(a, w, m, i + 1, 0, 0)
  //           : findWord(a, w, m, i, j + 1, 0);
  //     }

  //     a[i][j] = t;
  //     return found;
  //   }

  public static void findWord(char[][] a, String w) {
    int len = a.length;
    int width = a[0].length;
    int[][] m = new int[len][width];

    if (
      a == null ||
      w == null ||
      w.length() == 0 ||
      w.length() > len * width ||
      !findWord(a, w, m, 0, 0)
    ) {
      System.out.println("Now such word");
    }
  }

  private static boolean findWord(
    char[][] a,
    String w,
    int[][] m,
    int i,
    int j
  ) { // a= arr , w = word , m = mat, c= count
    int len = a.length;
    int width = a[0].length;

    if (i >= len) {
      return false;
    }

    if (findWord(a, w, m, i, j, 0)) return true;

    // move to next
    return (j == width - 1)
      ? findWord(a, w, m, i + 1, 0)
      : findWord(a, w, m, i, j + 1);
  }

  private static boolean findWord(
    char[][] a,
    String w,
    int[][] m,
    int i,
    int j,
    int c
  ) { // a= arr , w = word , m = mat, c= count
    if (c == w.length()) {
      System.out.println(arr2String(m));
      return true;
    }

    char been = '#';
    int len = a.length;
    int width = a[0].length;

    if (
      i < 0 || i >= len || j < 0 || j >= width || w.charAt(c) != a[i][j] // including been
    ) {
      return false;
    }

    char t = a[i][j]; // tmp
    a[i][j] = been;
    m[i][j] = ++c;

    boolean found =
      findWord(a, w, m, i + 1, j, c) ||
      findWord(a, w, m, i - 1, j, c) ||
      findWord(a, w, m, i, j + 1, c) ||
      findWord(a, w, m, i, j - 1, c);

    a[i][j] = t;
    m[i][j] = 0;

    return found;
  }

  ///////////////////////////////////////
  
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
}
