public class B extends A {
    private int _bVal;

    public B(int aVal, int bVal) {
        super(aVal);
        _bVal = bVal;
    }
    
    public boolean foo(int n) {
        return n== _bVal;
    }
}
