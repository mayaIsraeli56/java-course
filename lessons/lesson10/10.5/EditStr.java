public class EditStr {

    public static int edit(String str1, String str2) {

        if (str1.equals(str2)) {
            return 0;
        }

        int len1 = str1.length();
        int len2 = str2.length();

        int removeChar = len1 + len2;
        int addChar = removeChar;

        if (len1 > 0 && len2 > 0) {

            if (str1.charAt(0) == str2.charAt(0)) { // move to next character
                return edit(str1.substring(1), str2.substring(1));
            }

            if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) { // remove last char
                return edit(str1.substring(0, len1 - 1), str2.substring(0, len2 - 1));
            }

        }

        if (len1 > 0) {
            removeChar = edit(str1.substring(1), str2) + 1;
        }

        // add a char from 2 to 1
        if (len2 > 0) {
            addChar = edit(str2.charAt(0) + str1, str2) + 1;
        }

        return Math.min(addChar, removeChar);
    }

    public static int editB(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 == 0) {
            return len2;
        }

        if (len2 == 0) {
            return len1;
        }

        if (str1.charAt(0) == str2.charAt(0)) { // move to next character
            return edit(str1.substring(1), str2.substring(1));
        }

        if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) { // remove last char
            return edit(str1.substring(0, len1 - 1), str2.substring(0, len2 - 1));
        }

        // add a char from 1
        int removeChar = edit(str1.substring(1), str2) + 1;

        // add a char from 2 to 1
        int addChar = edit(str2.charAt(0) + str1, str2) + 1;

        return Math.min(addChar, removeChar);
    }

    public static int editC(String str1, String str2) {
        return editC(str1, str2, 0,0,0);
   }
   
   private static int editC(String str1, String str2, int i, int j, int count) {
   
        if (i == str1.length())
   
             return count + str2.length() - j;
   
        if (j == str2.length())
   
             return count + str1.length() - i;
   
        if (str1.charAt(i) == str2.charAt(j))
   
             return editC(str1, str2, i + 1, j + 1, count);
   
        else {
   
             int opt1 = editC(str1, str2, i, j + 1, count + 1); 
   
             int opt2 = editC( str1, str2, i + 1, j, count + 1);
   
             return Math.min(opt1, opt2);
   
        }
   
   }
}
