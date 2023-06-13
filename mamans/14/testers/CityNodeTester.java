
public class CityNodeTester
{
    public static void print(String msg)
    {
        System.out.println(msg + "\n");
    }
    public static void main(String[] args)
    {
        System.out.println("Tester from CityNode.java");
        print("Create new object form City c = City(\"Haifa\", 25, 9, 1925, 5, 6, 7, 8, 123, 8);");
        City c = new City("Haifa", 25, 9, 1925, 5, 6, 7, 8, 123, 8);
        print("c = " + c);
        print("Create new object from CityNode cn = new CityNode(c)");
        CityNode cn = new CityNode(c);
        print("cn.getCity() = " + cn.getCity());
        print("cn.getNext() == null ? " + (cn.getNext() == null));
        print("Create new object form City c2 = City(\"Akko\", 19, 5, 1921, 4, 3, 2, 1, 555, 3);");
        City c2 = new City("Akko", 19, 5, 1921, 4, 3, 2, 1, 555, 3);
        print("c2 = " + c2);
        print("Create new object from CityNode cn2 = new CityNode(c2, cn");
        CityNode cn2 = new CityNode(c2, cn);
        print("cn2.getCity() = " + cn2.getCity());
        print("cn2.getNext() == cn ? " + (cn2.getNext() == cn));
        print("Create new object from CityNode cn3 = new CityNode(cn2)");
        CityNode cn3 = new CityNode(cn2);
        print("cn3.getCity() = " + cn3.getCity());
        print("cn3.getNext() == cn ? " + (cn3.getNext() == cn));
        print("End Tester CityNode.java");
    }
}
