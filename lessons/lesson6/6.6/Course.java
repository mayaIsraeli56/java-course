public class Course {

    private int[] registered = { 35, 8, 17, 16, 20 };

    private double[][] arrived = { { 34, 8, 11, 15, 5 },
            { 30, 6, 12, 15, 4 },
            { 20, 5, 12, 14, 5 },
            { 29, 4, 13, 14, 7 },
            { 30, 6, 12, 15, 3 },
            { 20, 5, 12, 14, 4 },
            { 32, 4, 13, 14, 7 },
            { 28, 6, 12, 15, 11 },
            { 27, 5, 12, 16, 4 },
            { 16, 4, 13, 14, 7 },
            { 29, 4, 13, 14, 7 },
            { 31, 3, 15, 13, 12 } };

    public void maxInLast() {
        double maxRate = -1;
        int maxGroup = -1;

        for (int j = 0; j < arrived[arrived.length - 1].length; j++) {
            double rate = (double) arrived[arrived.length - 1][j] / registered[j];
            if (maxRate < rate) {
                maxRate = rate;
                maxGroup = j;
            }
        }

        System.out.println(maxGroup);
    }

    public void mostImportant() {

        int maxLesson = -1;

        for (int i = 0, arriveSum = 0, maxSum=-1; i < arrived.length; i++, arriveSum = 0) {

            for (int j = 0; j < arrived[i].length; j++) {
                arriveSum += arrived[i][j];
            }

            if (maxSum < arriveSum) {
                maxSum = arriveSum;
                maxLesson = i;
            }
        }
        System.out.println(maxLesson);
    }
}
