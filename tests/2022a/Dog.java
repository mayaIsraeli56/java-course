public class Dog extends Ani {

    protected String _n;

    public Dog (String n) {
        _n = n;
        System.out.println("new dog");
    }

    public void compare(Dog d) {
        if(d._n.equals(_n))
         System.out.println("dog - Y");
         else 
          System.out.println("dog - N");

    }
}
