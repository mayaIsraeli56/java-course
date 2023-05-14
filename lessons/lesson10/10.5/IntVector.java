public class IntVector {

  private int[] _arr;

  /**
   * Constructor for objects of class IntVector...
   */

  public IntVector(int size) {
    _arr = new int[size];
  }

  public IntVector(int[] a) {
    _arr = new int[a.length];

    for(int i=0; i< a.length ; i++) {
        _arr[i] = a[i];
    }
  }

  // methods
public int getByIndex(int i) {
    return _arr[i];
}

  public int equalSum() {
    return equalSum(0, _arr.length - 1, _arr[0], _arr[_arr.length -1]);
  }

  public int equalSum(int i, int j, int s1, int s2) {
    if ( i >= j -1) {
      return (s1 == s2) ? i : -1;
    }

    if (s1 == s2) {
      s1 += _arr[++i];
      s2 += _arr[--j];
    } else if (s1 < s2) {
      s1 += _arr[++i];
    } else {
      s2 += _arr[--j];
    }
    
    return equalSum(i,j,s1,s2);
  }
}
