public class Tar3 {
    public static int min(int[] arr) {
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;// index in a
        int j = 0;// index in b
        while (i + j < c.length) {
            // take from a
            if (j == b.length ||
                    (i < a.length && a[i] < b[j])) {
                c[i + j] = a[i];
                i++;
            } else { // take from b
                c[i + j] = b[j];
                j++;
            }
        } // finish while
        return c;
    }

    public static int maxOddEvenSeq3(int[] nums) {
        int i = 0, max = 1, count = 0;

        while (i < nums.length) {

            do {
                count++;
                i++;
            } while (i < nums.length && nums[i - 1] % 2 == nums[i] % 2);

            max = (count > max) ? count : max;
            count = 0;

        }
        return max;
    }

    public static int maxOddEvenSeq4(int[] nums) {
        int max = 1;

        for (int i = 1, count = 1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        return max;
    }

    public static int maxDifferent(int[] arr) {
        int min = arr[0], max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
            else if (max < arr[i])
                max = arr[i];
        }

        return max - min;
    }

    public static double variance(int[] nums) {
        double ave = 0, var = 0;
        for (int i = 0; i < nums.length; i++) {
            ave += nums[i];
        }
        ave /= nums.length;
        for (int i = 0; i < nums.length; i++) {
            var += Math.pow(nums[i] - ave, 2);
        }

        return var / nums.length;
    }

    public static int[] shiftLeft(int[] a) {
        int first = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }

        a[a.length - 1] = first;
        return a;
    }

    public static int[] shiftLeft(int[] a, int k) {

        int[] saved = new int[k];

        for (int i = 0; i < k; i++) {
            saved[i] = a[i];
        }

        for (int i = 0; i < a.length; i++) {

            if (i + k < a.length)
                a[i] = a[i + k];
            else
                a[i] = saved[i - k - 1];

        }
        return a;
    }

    public static int[] shiftRight(int[] a) {
        int last = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }

        a[0] = last;
        return a;
    }

    public static int[] shiftRight(int[] a, int k) {

        int[] saved = new int[k];

        for (int i = 0; i < k; i++) {
            saved[i] = a[a.length - 1 - i];
        }

        for (int i = a.length; i > 0; i--) {
            if (i - k > 0)
                a[i - 1] = a[i - k];
            else
                a[i - 1] = saved[k - i];
        }
        return a;
    }
}