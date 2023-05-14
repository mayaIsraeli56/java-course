package Q4;

public class B extends A{
    
    public void f() {
        System.out.print("B");
    }

    public void g() {
        A a = this;
        System.out.print( a instanceof B);
	    System.out.print(a == this);
	    a.f();
	    this.f();
	    super.f();
    }
}
