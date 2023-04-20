package Acounts;

public class Tester {
    public static void main(String[] args) {
        Acount acount1 = new Acount("Maya", "Tpahot", 05345345, 435324.5);
        System.out.println("acount1: " + acount1);

        Acount acount2 = new Acount(acount1);
        System.out.println("acount2: " + acount2);

        // System.out.println("acount2: " + acount2.deposit(90.99));
        // System.out.println("acount2: " + acount2.deposit(10, 2));

        Acount acount3 = new Acount("M", "T", 045, 435);

        System.out.println("acount1.equals(acount2): " + acount1.equals(acount2));
        System.out.println("acount1==acount2: " + (acount1 == acount2));

        System.out.println("acount1.equals(acount3): " + acount1.equals(acount3));
        System.out.println("acount1==acount3: " + (acount1 == acount3));
    }
}
