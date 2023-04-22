public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(1);
        Object p2 = new Person(1);
        System.out.println(p2.equals(p1));
        System.out.println(p1.equals(p1));
    }
}
