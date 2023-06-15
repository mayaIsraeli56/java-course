public class Tars {
    public static void main(String[] args) {

        int[] a= {1,1,2,2,4,4,5};
        int[] b= {2,8,3,4,7,1,3,2};
    //    System.out.println(findSignal(a));
      //  System.out.println("gg");
      //  System.out.print("gg");
      //  System.out.println("gg");
      System.out.println(cheapest(b));
    }

  public static int findSignal(int[] a) {
    int lo = 0, hi = a.length -1, mid;

    while (lo < hi) {
      mid = (lo + hi) / 2;

      if (mid % 2 != 0) mid--;
      if(a[mid] == a[mid+1]) lo = mid+2;
      else hi = mid;
    }

    return a[hi];
  }

  public static int cheapest(int[] station) {
    return cheapest(station, 0);
  }

  public static int cheapest(int[] station, int i) {

    int lastIdx = station.length -1;

    if(i ==lastIdx ) return station[i];
    if(i ==lastIdx -1 ) return station[i] + station[i+1];

    return Math.min(cheapest(station, i+1), cheapest(station, i+2) ) + station[i];
  }
}
