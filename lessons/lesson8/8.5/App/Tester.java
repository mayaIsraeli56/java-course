public class Tester {
    public static void main(String[] args) {
        CD cd1 = new CD("CD1", 2000, "artist", 3);
        CD cd2 = new CD(cd1);

        Video v1 = new Video("v1", 2000, "dir");
        Video v2 = new Video(v1);

        cd2.setTitle("CD2");
        v2.setTitle("v2");

        System.out.println("v1: "+ v1);
        System.out.println("v2: "+ v2);
        System.out.println("\ncd1: "+ cd1);
        System.out.println("cd2: "+cd2);

        ItemsCollection colec = new ItemsCollection();
        colec.addItem(v1);
        colec.addItem(v2);
        colec.addItem(cd1);
        colec.addItem(cd1);
        System.out.println("\ncolec: "+ colec);

        colec.playItem(0);
        System.out.println("\ngetNumberOfCDs: "+   colec.getNumberOfCDs());
        colec.oldiesButGoldies(8888);
    }
}