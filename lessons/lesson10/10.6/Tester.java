public class Tester {

  public static void main(String[] args) {
    // System.out.println(Bunnies.reproduction(10));
    // System.out.println(Tar1.pow(9,3));

    // int[][] m = { {0,0,0,0,0}, {1,1,0,1,0}, {1,0,1,1,0}, {1,1,1,0,1}, {1,1,1,1,1}};
    // System.out.println(Tar1.maze(m));
    // System.out.println(Tar1.countPaths(1,3));

    // int[][] m2 = new int[5][5];
    // System.out.println(Knight.CoverBoard(m2,0,0));

    // char[][] m3 = {
    //   { '0', '0', '0', '0' },
    //   { '0', '0', '0', '0' },
    //   { '0', '0', 'K', '0' },
    //   { 'H', '0', '0', '0' },
    // };
    // char[][] m4 = {
    //   { '0', '0', '0', '0' },
    //   { '0', '0', 'K', '0' },
    //   { '0', '0', '0', '0' },
    //   { 'H', '0', '0', '0' },
    // };
    // char[][] m5 = {
    //   { '0', '0', 'K', '0' },
    //   { '0', '0', '0', '0' },
    //   { '0', '0', '0', '0' },
    //   { 'H', '0', '0', '0' },
    // };
    // System.out.println(King.minPath(m3, 0, 0, 0));
    // System.out.println(King.minPath(m4, 0, 0, 0));
    // System.out.println(King.minPath(m5, 0, 0, 0));

    // int[] a1 = { 2, 8, 3, 4, 7, 1, 3, 2 };
    // System.out.println(Shadi.cheapestPath(a1));

    // int[][] m6 = {
    //   {4,5,6,7,1},
    //   {3,5,1,7,4},
    //   {4,5,6,5,8},
    //   {3,4,7,7,9},
    //   {6,2,2,7,6},
    // };

    // System.out.println(Knight2.maxSumKnight(m6));

    char[][] m7 = {
      { 'a', 'a', 'a', 'a', 'a' },
      { 's', 'h', 'a', 'a', 'a' },
      { 'a', 'a', 'l', 'o', 'm' },
      { 'a', 'a', 'a', 'a', 'm' },
      { 's', 'h', 'a', 'l', 'o' },
    };

    char[][] m8 = { { 'a', 'b' }, { 'c', 'd' } };

    B202084.findWord(m7, "shalom");
    B202084.findWord(m8, "cdba");
  }
}
