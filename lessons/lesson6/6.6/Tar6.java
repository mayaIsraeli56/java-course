public class Tar6 {
    public static boolean pair1(int[][] a) {
        /* Complete your code here */

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                for (int k = i; k < a.length; k++) {
                    for (int m = 0; m < a[k].length; m++) {

                        if ((k == i && m > j || k > i) && a[i][j] + a[k][m] == 1)
                            return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean pair1B(int[][] a) {

        for (int i = 0; i < a.length; i++)

            for (int j = 0; j < a[0].length; j++)

                for (int k = 0; k < a.length; k++)

                    for (int m = 0; m < a[0].length; m++)

                        if (a[i][j] + a[k][m] == 1)

                            return true;

        return false;

    }

    public static double avg(int[][] m) {

        double sum = 0;
        int squers = 0;

        for (int i = m.length / 2; i < m.length; i++) {
            for (int j = 0; j < m[i].length / 2; j++, squers++) {
                sum += m[i][j];
            }
        }

        return sum / squers;
    }

    public static double avgB(int[][] m) {

        double sum = 0;

        for (int i = m.length / 2; i < m.length; i++)

            for (int j = 0; j < m[0].length / 2; j++)

                sum += m[i][j];

        return sum / ((m.length - m.length / 2) * (m[0].length / 2));
    }

}
