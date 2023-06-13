public class Tar1 {

  public static boolean checkParenthesis(String s) {
    CharStack stack = new CharStack();
    char c;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (isOpenBracket(c)) stack.push(c); else if (isCloseBracket(c)) {
        if (stack.isEmpty() || !isCorrectClose(stack.pop(), c)) return false;
      }
    }
    if (stack.isEmpty()) return true;
    return false;
  }

  public static boolean checkParenthesisRec(String s) {
    CharStack st = new CharStack();
    return checkParenthesisRec(s, st);
  }

  public static boolean checkParenthesisRec(String s, CharStack st) {
    if (s.length() == 0) {
      return st.isEmpty();
    }

    char c = s.charAt(0);

    if (isOpenBracket(c)) {
      st.push(c);
    } else if (isCloseBracket(c)) {
      if (st.isEmpty() || !isCorrectClose(st.pop(), c)) {
        return false;
      }
    }

    return checkParenthesisRec(s.substring(1), st);
  }

  private static boolean isCorrectClose(char cOpen, char cClose) {
    if (
      cOpen == '{' &&
      cClose == '}' ||
      cOpen == '[' &&
      cClose == ']' ||
      cOpen == '(' &&
      cClose == ')'
    ) return true; else return false;
  }

  private static boolean isCloseBracket(char c) {
    return (c == '}' || c == ']' || c == ')');
  }

  private static boolean isOpenBracket(char c) {
    return (c == '{' || c == '[' || c == '(');
  }
}
