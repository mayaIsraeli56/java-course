public class Q2 {

  public static int kAlmostSearch(int[] a, int num) {
    int left = 0;
    int right = a.length - 1;
    int absMid, dynmcMid;

    while (left <= right) {

      absMid = (left + right) / 2;
      dynmcMid = absMid;

      while (a[dynmcMid] == 0 && dynmcMid > left) {
        dynmcMid--;
      }

      if(a[dynmcMid] < num) {
        left = absMid + 1;
      } else if(a[dynmcMid] > num) {
        right = absMid - 1;
      } else {
        return dynmcMid;
      }
  
    }

    return -1;
  }
}
