public class Tester6 {
    public static void main(String[] args) {
        int[][] a = { { 3, 2, 5 }, { 4, 7, 3 }, { -20, 7, -1 }, { 7, 7, 7 } };
        int[][] b = { { 3, 2, 5 }, { 4, 7, 3 }, { -20, 7, -50 }, { 7, 7, 7 } };
        int[][] c = { { 3, 2, 5, 90 }, { 4, 7, 3, 80 }, { -20, 7, -50, -79 } };
        int[][] d = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
        int[][] e = { { 3, 2, 5, 9 }, { 4, 7, 3, 8 }, { -20, 7, -1, 7 }, { 7, 7, 7, 2 } };
        int[][] f = { { 3, 2 }, { 4, 7 } };
        int[][] g = { { 3, 2, 5, 90 }, { 4, 7, 3, 80 }, { -20, 7, -50, -79 } };

        // pair1
        System.out.println("Tar6.pair1({{3,2,5},{4,7,3},{-20,7,-1},{7,7,7}}), result is " + Tar6.pair1(a));
        System.out.println("Tar6.pair1({{3,2,5},{4,7,3},{-20,7,-50},{7,7,7}}), result is " + Tar6.pair1(b));
        System.out.println("Tar6.pair1({{3,2,5,90},{4,7,3,80},{-20,7,-50,-79}}), result is " + Tar6.pair1(c));
        System.out.println("Tar6.pair1({ { 1, 1, 1,1 }, { 1, 1, 1,1 }, { 1, 1, 1,1 } }), result is " + Tar6.pair1(d));

        // avg
        System.out.println("For call Tar6.avg({{3,2,5,9},{4,7,3,8},{-20,7,-1,7},{7,7,7,2}}), Tar6.avg is " + Tar6.avg(e));
        System.out.println("For call Tar6.avg({{3,2},{4,7}}), Tar6.avg is " + Tar6.avg(f));
        System.out.println("For call Tar6.avg({{3,2,5,90},{4,7,3,80},{-20,7,-50,-79}}), Tar6.avg is " + Tar6.avg(g));

        //////////////////////////Baybies//////////////////////////

        Babies b1 = new Babies();
        
        System.out.println("For call check(), answer is:"); 
        b1.check();
        System.out.println("For call max(), answer is:"); 
        b1.max();

                //////////////////////////Baybies//////////////////////////

        Course c1 = new Course();
        
        System.out.println("\n\nFor call maxInLast(), answer is:"); 
        c1.maxInLast();

        System.out.println("For call mostImportant(), answer is:"); 
        c1.mostImportant();
    }
}
