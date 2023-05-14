public class Tar5 {
     // public static int howManySorted(int n, int max) {
  //   return howManySorted(n, max, 1, 1);
  // }

  // public static int howManySorted(int n, int max, int i, int j) {
  //   int count=0;
  //   if (j < max) {
  //     count+= howManySorted(n, max, i, j + 1);
  //   }

  //   if (i < n) {
  //     count+= howManySorted(n, max, i + 1, j);
  //   } else {
  //     count+=1;
  //   }

  //   return count;
  // }

  public static int howManySorted(int n, int max) {
    if (max == 0) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }

    return howManySorted(n - 1, max) + howManySorted(n, max - 1);
  }

  public static int howManySorted2(int n, int max) {
    if (n == 1) return max;

    if (max == 0) return 0;

    return howManySorted(n - 1, max) + howManySorted(n, max - 1);
  }
}
