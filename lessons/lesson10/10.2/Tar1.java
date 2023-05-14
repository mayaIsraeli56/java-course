import javax.print.DocFlavor.STRING;

public class Tar1 {

  public static long power(int a, int n) { // Math.pow(a,n)
    if (n == 0) return 1;

    long tmp = power(a, n / 2);

    if (n % 2 == 0) return tmp * tmp; else return a * tmp * tmp;
  }

  public static void binaryNambers(int n, String s) {
    if (n == 0) System.out.println(s); else {
      binaryNambers(n - 1, s + 0);
      binaryNambers(n - 1, s + 1);
    }
  }

  public static void printReverse(String s) {
    if (s.length() > 0) {
      printReverse(s.substring(1));
      System.out.print(s.charAt(0));
    }
  }

  public static String replaceXY(String str) {
    if (str.length() > 0) {
      char firstCh = str.charAt(0);
      if (firstCh == 'x') firstCh = 'y';

      return firstCh + replaceXY(str.substring(1));
    }
    return "";
  }

  public static boolean isPalindrom(String str) {
    if (str.length() <= 1) {
      return true;
    }
    char first = str.charAt(0);
    char last = str.charAt(str.length() - 1);

    return first == last && isPalindrom(str.substring(1, str.length() - 1));
  }

  public static int countS1inStr(String str, String s1) {
    int s1Len = s1.length();

    if (str.length() < s1Len) {
      return 0;
    }

    int count = 0;

    if (str.substring(0, s1Len).equals(s1)) {
      count = 1;
    }

    return count + countS1inStr(str.substring(1), s1);
  }

  public static String strReverse(String s) {
    if (s.length() == 0) {
      return "";
    }

    return strReverse(s.substring(1)) + s.charAt(0);
  }

  public static String markChar(String str, char ch) {
    if (str.length() == 0) {
      return str;
    }

    // get the first char
    char first = str.charAt(0);
    //if first = ch => add # before and after ch
    String pre = first == ch ? "#" + first + "#" : first + "";
    // get the rest of the marked string
    String rest = markChar(str.substring(1), ch);
    return pre + rest;
  }

  public static String endWithZ(String str) {
    if (str.length() == 0) {
      return str;
    }

    char first = str.charAt(0);
    String rest = endWithZ(str.substring(1));

    return (first == 'z' || first == 'Z') ? rest + first : first + rest;
  }

  public static String startWithA(String str) {
    if (str.length() == 0) {
      return str;
    }

    int lastIdx = str.length() - 1;
    char last = str.charAt(lastIdx);
    String rest = startWithA(str.substring(0, lastIdx));

    return (last == 'a' || last == 'A') ? last + rest : rest + last;
  }

  public static String getNumber(String str) {
    if (str.length() == 0) {
      return str;
    }

    char curr = str.charAt(0);
    String rest = getNumber(str.substring(1));

    return (curr >= '0' && curr <= '9') ? curr + rest : rest;
  }

  public static String getNumberBetter(String str) {
    if (str.length() == 0) {
      return str;
    }

    int lastIdx = str.length() - 1;
    char last = str.charAt(lastIdx);
    char first = str.charAt(0);

    // is digit
    boolean isFirstNum = '0' <= first && first <= '9';
    boolean isLastNum = '0' <= last && last <= '9';

    if (isFirstNum && isLastNum) { //found the number
      return str;
    } else if (isLastNum) { // find last
      return getNumber(str.substring(1));
    } // else - find start
    return getNumber(str.substring(0, str.length() - 1));
  }

  public static int necklace(int n) {
    if (n <= 1) return 1;

    return necklace(n - 1) + necklace(n - 2);
  }

  public static int strings(int n) {
    if (n == 1) return 4;

    return strings(n - 1) + 4;
  }

  public static int odd(int num) {
    if (num < 10) return num % 2;

    return num % 2 + odd(num / 10);
  }

  public static int biggest(int num1, int num2) {
    if (num1 < 10) return Math.max(num1 % 10, num2 % 10);

    return Math.max(num1 % 10, num2 % 10) + 10 * biggest(num1 / 10, num2 / 10);
  }

  public static int times(String s, char ch) {
    int addition = (s.charAt(0) == ch) ? 1 : 0;

    if (s.length() == 1) {
      return addition;
    }

    return addition + times(s.substring(1), ch);
  }

  public static String noNumbers(String s) {
    if (s.length() == 0) return "";

    char ch = s.charAt(0);

    if (ch >= '0' && ch <= '9') return noNumbers(s.substring(1));

    return ch + noNumbers(s.substring(1));
  }

  public static boolean upString(String s) {
    if (s.length() <= 1) return true;

    if (s.length() == 2) return s.charAt(0) <= s.charAt(1);

    return s.charAt(0) <= s.charAt(1) && upString(s.substring(1));
  }

  public static boolean isPalindrome(String s) {
    /* Complete your code here */
    int len = s.length();

    if (len <= 1) return true;

    return (
      s.charAt(0) == s.charAt(len - 1) && isPalindrome(s.substring(1, len - 1))
    );
  }

  public static boolean isStringOk(String s) {
    return isAllAbc(s) || isAllNum(s);
  }

  private static boolean isAllAbc(String s) {
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z')) {
        return false;
      }
    }
    return true;
  }

  private static boolean isAllNum(String s) {
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch < '0' || ch > '9') {
        return false;
      }
    }
    return true;
  }

  public static boolean isStringOkRecor(String s) {
    return isEnglish(s) || isDigits(s);
  }

  private static boolean isEnglish(String s) {
    if (s.length() == 0) return true;

    char ch = s.charAt(0);
    return (
      ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) &&
      isEnglish(s.substring(1))
    );
  }

  private static boolean isDigits(String s) {
    if (s.length() == 0) return true;

    char ch = s.charAt(0);
    return (ch >= '0' && ch <= '9') && isDigits(s.substring(1));
  }

  public static int compare(String s1, String s2) {
    if (s1.length() == 0) {
      if (s2.length() == 0) {
        return 0;
      }
      return 1;
    }

    if (s2.length() == 0) {
      return -1;
    }

    char ch1 = s1.charAt(0);
    char ch2 = s2.charAt(0);

    if (ch1 < ch2) return 1;

    if (ch1 > ch2) return -1;

    return compare(s1.substring(1), s2.substring(1));
  }

  public static boolean up(String s) {
    int len = s.length();
    if (len <= 2) {
      return true;
    }

    if (len == 3) {
      return up(s, 0);
    }

    if (len == 4) {
      return up(s, 0) && up(s, 1);
    }

    return (up(s, 0) && up(s, 1) && up(s.substring(2)));
  }

  public static boolean up(String s, int startIdx) {
    return s.charAt(startIdx) < s.charAt(startIdx + 2);
  }

  public static void f(int[][] a, int a1, int b1, int a2, int b2) {
    int temp = a[a1][b1];
    a[a1][b1] = a[a2][b2];
    a[a2][b2] = temp;
    if (b1 < a[0].length - 1) f(a, a1, b1 + 1, a2, b2 - 1); else if (
      a1 + 1 < a2 - 1
    ) f(a, a1 + 1, 0, a2 - 1, a[0].length - 1);
  }

  public static void printArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) System.out.print(a[i][j] + "\t");
      System.out.println();
    }
  }
}
