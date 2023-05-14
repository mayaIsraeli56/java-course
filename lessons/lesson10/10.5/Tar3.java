public class Tar3 {
    public static int distance(String s1, String s2) {
        return distance(s1, s2, 0, 0);
      }
    
      public static int distance(String s1, String s2, int i, int j) {
        int len1 = s1.length();
        int len2 = s2.length();
    
        // end of s1
        if (i == len1) {
          return len2 - len1;
        }
    
        // end of s2 + not the end of s1
        if (j == len2) {
          return -1;
        }
    
        if (s1.charAt(i) == s2.charAt(j)) {
          i++;
        }
    
        return distance(s1, s2, i, j + 1);
      }
    
      public static int distanceOther(String s1, String s2) {
        if (s1.length() == 0) return s2.length();
    
        if (s2.length() == 0) return -1;
    
        int val, addDistance;
    
        if (s1.charAt(0) == s2.charAt(0)) {
          val = distance(s1.substring(1), s2.substring(1));
    
          addDistance = 0;
        } else {
          val = distance(s1, s2.substring(1));
    
          addDistance = 1;
        }
    
        if (val == -1) return -1; else return addDistance + val;
      }
    
      public static boolean match(int[] a, int[] pattern) {
        return match(a, pattern, 0);
      }
    
      public static boolean match(int[] a, int[] p, int i) {
        if (i > a.length - p.length) {
          return false;
        }
    
        if (match(a, p, i, 0)) {
          return true;
        }
    
        return match(a, p, i + 1);
      }
    
      public static boolean match(int[] a, int[] p, int startIdxA, int IdxP) {
        if (IdxP == p.length) {
          return true;
        }
    
        int aNum = a[startIdxA + IdxP];
        int pDigit = p[IdxP];
    
        if (
          ((pDigit == 0 || pDigit == 1) && aNum < 10) ||
          ((pDigit == 0 || pDigit == 2) && (aNum > 9 && aNum < 100))
        ) {
          return match(a, p, startIdxA, IdxP + 1);
        }
    
        return false;
      }
    
      ///////////////////////////////////////////////
    
      public static boolean match2(int[] a, int[] pattern) {
        return match2(a, 0, pattern, 0);
      }
    
      public static boolean match2(int[] a, int i, int[] p, int j) {
        if (j == p.length) return true;
        if (i == a.length) return false;
    
        if (
          ((p[j] == 0 || p[j] == 1) && a[i] < 10) ||
          ((p[j] == 0 || p[j] == 2) && (a[i] > 9 && a[i] < 100))
        ) {
          return match2(a, i + 1, p, j + 1);
        }
    
        return match2(a, i + 1, p, 0);
      }
}
