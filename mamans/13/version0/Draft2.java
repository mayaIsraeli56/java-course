public class Draft2 {

  public static int missingValue(int[] arr) {
    int len = arr.length;
    int lo = 0, hi = len - 1;
    int diff = (arr[hi] - arr[lo]) / len;
    int mid, a1 = arr[lo];

    while (lo <= hi) {
      mid = (lo + hi) / 2;
      if (arr[mid] == a1 + mid * diff) {
        lo = mid +1;
      } else {
        hi = mid -1;
      }
    }
    return arr[hi] + diff;
  }

  public static int shortestRoad(int[] road1, int[] road2) {
    int len = road1.length; // the roads are in the same length

    int pathR1 = 0; // total driving duration from A to B through road 1
    int pathR2 = 0; // total driving duration from A to B through road 2

    // sums up the total driving duration for each road
    for (int i = 0; i < len; i++) {
      pathR1 += road1[i];
      pathR2 += road2[i];
    }

    int shortest = Math.min(pathR1, pathR2); // saves the shortest driving duration found yet

    /*
     * For each road interchange point (switchPoint) it calculates:
     * 1. driving duration in a path that starts at road 1 and switch at
     * switchPoint to road 2
     * 2. driving duration in a path that starts at road 2 and switch at switchPoint
     * to road 1
     * It finds the min between the two and the overall minimum.
     */
    for (int switchPoint = len - 1; switchPoint > 0; switchPoint--) {
      pathR1 += road2[switchPoint] - road1[switchPoint]; // add the current section from road1
      pathR2 += road1[switchPoint] - road2[switchPoint]; // add the current section from road2

      shortest =
        Math.min(
          shortest, // current overall min
          Math.min(pathR1, pathR2)
        );
    }

    // time in minutes on the shortest route
    return shortest;
  }

  public static int shortestRoadBAD(int[] road1, int[] road2) {
    int len = road1.length; // the roads are in the same length

    int totalR1 = 0; // total driving duration from A to B through road 1
    int totalR2 = 0; // total driving duration from A to B through road 2

    // sums up the total driving duration for each road
    for (int i = 0; i < len; i++) {
      totalR1 += road1[i];
      totalR2 += road2[i];
    }

    int shortest = Math.min(totalR1, totalR2); // saves the shortest driving duration found yet

    int timeInR1 = 0; // driving duration from A to the switching point through road 1
    int timeInR2 = 0; // driving duration from B to the switching point through road 2

    /*
     * For each road interchange point (switchPoint) it calculates:
     * 1. driving duration in a path that starts at road 1 and switch at
     * switchPoint to road 2
     * 2. driving duration in a path that starts at road 2 and switch at switchPoint
     * to road 1
     * It finds the min between the two and the overall minimum.
     */
    for (int switchPoint = 0; switchPoint < len - 1; switchPoint++) {
      timeInR1 += road1[switchPoint]; // add the current section from road1
      timeInR2 += road2[switchPoint]; // add the current section from road2
      shortest =
        Math.min(
          shortest, // current overall min
          Math.min(
            timeInR1 + totalR2 - timeInR2, // starts at road 1 and switch at switchPoint to road 2
            timeInR2 + totalR1 - timeInR1 // starts at road 2 and switch at switchPoint to road 1
          )
        );
    }

    // time in minutes on the shortest route
    return shortest;
  }
}
