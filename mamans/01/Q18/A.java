public abstract class A {

  protected int _aVal;

  public A() {
    _aVal = 3;
  }

  public A(int aVal) {
    _aVal = aVal;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof A)) 
        return false;

    return  _aVal==((A)obj)._aVal;
  }

  public abstract boolean foo(int n);
}

