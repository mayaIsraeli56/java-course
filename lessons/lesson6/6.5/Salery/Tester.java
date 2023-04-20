package Salery;

public class Tester {
    public static void main(String[] args) {

        int[][] salaries = {
                { 10500, 10300, 11000, 10600, 0, 1, 2, 3, 4, 5, 6, 7 },
                { 90000, 95000, 95000, 10000, 0, 1, 2, 3, 4, 5, 6, 7 },
                { 99000, 98000, 98500, 99000, 0, 1, 2, 3, 4, 5, 6, 7 },
                { 10000, 10200, 10100, 10150, 0, 1, 2, 3, 4, 5, 6, 7 }
        };
        String[] names = { "Yossi", "Dana", "Moshe", "Galit" };

        SalariesStatistics s1 = new SalariesStatistics(salaries, names);

        System.out.println(s1.bestSalary("Yossi"));
        System.out.println(s1.maxInMonth(1));
        System.out.println(s1.maxInMonth(1));
        System.out.println(s1.avrByMonth(1));
        System.out.println(s1.bestMonth());
        System.out.println(s1.bestWorker());
    }
}
