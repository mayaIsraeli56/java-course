public class ToString {
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
}
