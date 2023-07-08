public class wongi1 {

  public static String combineLetters(String digits) {
    return combineLetters(digits, 0, "");
  }

  private static String combineLetters(String digits, int j, String comb) {

    if (digits.length() == 0) return comb + " ";

    char cur = decode(digits.charAt(0), j);

    if (cur == '#') return "";

    return (
      combineLetters(digits.substring(1), 0, comb + cur) +
      combineLetters(digits, j + 1, comb)
    );
  }

  private static char decode(char digit, int j) {
    int key = 50;
    char[][] decode = {
      { 'A', 'B', 'C' },
      { 'D', 'E', 'F' },
      { 'G', 'H', 'I' },
      { 'J', 'K', 'L' },
      { 'M', 'N', 'O' },
      { 'P', 'Q', 'R', 'S' },
      { 'T', 'U', 'V' },
      { 'W', 'X', 'Y', 'Z' },
    };

    int i = (int) digit - key;

    if (i < 0 || i >= decode.length || j >= decode[i].length) return '#';

    return decode[i][j];
  }
}
