public class B extends A {

  private int _bVal;

  public B(int aVal, int bVal) {
    super(aVal);
    _bVal = bVal;
  }

  public boolean foo(int n) {
    return n == _bVal;
  }

  public boolean equals(A obj) {
    if (!(obj instanceof B)) return false;

    return super.equals(obj) && _bVal == ((B) obj)._bVal;
  }
}
