public class Tester {
    public static void main(String[] args) {
        Administrator a1 = new Administrator("a1", "123", 2);
        Worker w1 = new Worker("w1", "456", 3, 1);
        Manager m1 = new Manager("m1", "789", 4, 6);

        System.out.println("\na1: \n" + a1);
        System.out.println("\nw1: \n" + w1);
        System.out.println("\nm1: \n" + m1);

        Factory f1 = new Factory();
        f1.hire();
        int[] hour = {200};
        f1.updateHours(hour, 0);
        f1.printSalaries(1);
    }
}
