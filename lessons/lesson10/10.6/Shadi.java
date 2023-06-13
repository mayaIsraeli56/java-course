public class Shadi {

  public static int cheapestPath(int[] stations) {
    return cheapestPath(stations, 0);
  }

  public static int cheapestPath(int[] stations, int i) {
    if (i == stations.length - 1) return stations[i];

    if (i == stations.length - 2) return stations[i] + stations[i + 1];

    return Math.min(
      cheapestPath(stations, i + 1),
      cheapestPath(stations, i + 2)
    ) + stations[i];
  }

  public static int ways(int n, int m) {
     
  }
}
