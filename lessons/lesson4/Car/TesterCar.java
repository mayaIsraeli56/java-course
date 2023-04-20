package Car;

public class TesterCar {
    public static void main(String[] args) {

        ////////////////////////// CATALOG/////////////////////////////////
        CarCatalog cat1 = new CarCatalog();
        cat1.add("f", 2000, 0);
        cat1.add("f", 2004, 6);
        cat1.add("f", 2001, 1);
        cat1.add("f", 2002, 2);
        cat1.add("f", 2004, 4);
        cat1.add("f", 2003, 3);
        cat1.add("f", 2004, 5);
        cat1.add("f", 2004, 7);

        // System.out.println(cat1);
        // System.out.println("\nremoved car: " + cat1.remove(3)+"\n");
        // System.out.println(cat1);
        // Car c = cat1.youngest();
        // c.setId(6);
        // System.out.println(cat1.youngest());
        // System.out.println(cat1);
        System.out.println(cat1.popularYear());

        ////////////////////////// CAR/////////////////////////////////
        // Car car1 = new Car("mik", 2300, 84857);
        // System.out.println("car1: " + car1);

        // Car car2 = new Car("mik", 00, 84857);
        // System.out.println("car2 (wrong id): " + car2);

        // Car car3 = new Car("mik", 555555);
        // System.out.println("car3 (only factory + id): " + car3);

        // Car car4 = new Car(car1);
        // System.out.println("car4 (other): " + car4);

        // System.out.println("car4 factory (get): " + car4.getFactory());
        // car4.setYear(3003);

    }
}
