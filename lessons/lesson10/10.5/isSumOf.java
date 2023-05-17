public class isSumOf {
    public static boolean isSumOf(int[] s, int n) {
        return isSumOf(s,n,0, "");
    }

    public static boolean isSumOf(int[] s, int n, int i, String sumOf) {

        if ( i == s.length || n < 0) {
            return false;
        }

        if(n == 0) {
            System.out.println(sumOf);
            return true;
        }

        boolean opt1 = isSumOf(s, n - s[i], i, sumOf + s[i] + " "); // add this num to sum (once or more)
        boolean opt2 = isSumOf(s,n, i+1, sumOf); // skip num

        return (opt1 || opt2);
    }
}
