
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
     public static void main(String[] args) {
        
         A a1 = new A();
         A b1 = (A)new B();
         
         B b2 = (B)b1;
         
        
         System.out.println(b2.getb());
    }
}
