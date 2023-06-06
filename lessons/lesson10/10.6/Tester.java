public class Tester {
    public static void main(String[] args) {
        // System.out.println(Bunnies.reproduction(10));
        // System.out.println(Tar1.pow(9,3));

        // int[][] m = { {0,0,0,0,0}, {1,1,0,1,0}, {1,0,1,1,0}, {1,1,1,0,1}, {1,1,1,1,1}};
        // System.out.println(Tar1.maze(m));
        // System.out.println(Tar1.countPaths(1,3));

        // int[][] m2 = new int[5][5];
        // System.out.println(Knight.CoverBoard(m2,0,0));
        
        char[][] m3 =  { {'0','0','0','0'},{'0','0','0','0'},{'0','0','K','0'},{'H','0','0','0'} };
        char[][] m4 =  { {'0','0','0','0'},{'0','0','K','0'},{'0','0','0','0'},{'H','0','0','0'} };
        char[][] m5 =  { {'0','0','K','0'},{'0','0','0','0'},{'0','0','0','0'},{'H','0','0','0'} };
        System.out.println(King.minPath(m3, 0, 0,0));
         System.out.println(King.minPath(m4, 0, 0,0));
        System.out.println(King.minPath(m5, 0, 0,0));
    }
}
