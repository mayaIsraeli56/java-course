public class Tar1 {
    public static double pow(int k, int n) {
        if (n == 0) {
            return 1;
        }

        double t = pow(k, n / 2);
        if (n % 2 == 0) {
            return t * t;
        }

        return k * t * t;
    }

    public static boolean maze(int[][] maze) {
        return maze(maze, 1, 0);
    }

    public static boolean maze(int[][] maze, int i, int j) {
        final int BEEN = -1;
        final int AVIL = 0;

        int endI = maze.length - 1;
        int endJ = maze[0].length - 1;

        if (i < 0 || j < 0 || i > endI || j > endJ || maze[i][j] != AVIL) {
            return false;
        }

        if (i == endI && j == endJ) {
            return true;
        }

        maze[i][j] = BEEN;
        boolean right = maze(maze, i + 1, j);
        boolean left = maze(maze, i - 1, j);
        boolean bottom = maze(maze, i, j + 1);
        boolean top = maze(maze, i, j - 1);
        maze[i][j] = AVIL;

        return right || left || bottom || top;
    }

    public static int countPaths(int x, int y) {

        if (x == 0 || y == 0) {
            return 1;
        }

        return countPaths(x -1, y) + countPaths(x, y-1);

    }
}
