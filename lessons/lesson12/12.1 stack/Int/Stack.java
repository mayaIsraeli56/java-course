public class Stack {

  private IntNode _top;

  public Stack() {
    _top = null;
  }

  public boolean isEmpty() {
    return _top == null;
  }

  public void push(int num) {
    IntNode temp = new IntNode(num, _top);
    _top = temp;
  }

  public int pop() {
    int temp = _top.getValue();
    _top = _top.getNext();
    return temp;
  }

  public int top() {
    int temp = pop();
    push(temp);
    return temp;
  }

  public String toString() {
    String s = "";
    Stack s1 = new Stack();
    while (!isEmpty()) {
      int temp = pop();
      s1.push(temp);
      s = s + temp + "\t";
    }
    while (!s1.isEmpty()) {
      int temp = s1.pop();
      push(temp);
    }
    return s;
  }

  public static void printFromEnd(Stack s) {
    if (!s.isEmpty()) {
      int x = s.pop();
      System.out.println(x);
      printFromEnd(s);
      s.push(x);
    }
  }

  public static void printFromStart(Stack s) {
    if (!s.isEmpty()) {
      int x = s.pop();
      printFromStart(s);
      System.out.println(x);
      s.push(x);
    }
  }

  public static int noNodes(Stack s) {
	if (s.isEmpty())
		return 0;
	else {
		int x = s.pop();
		int temp = 1 + noNodes(s);
		s.push(x);
		return temp;
	}
}

public static boolean equals(Stack s1, Stack s2)
{
	if (s1.isEmpty() && s2.isEmpty())
		return true;
	if (s1.isEmpty() || s2.isEmpty())
		return false;
	else
	{
		int x = s1.pop();
		int y = s2.pop();
		boolean res = (x == y) && why(s1, s2);
		s1.push(x);
		s2.push(y);
		return res;
	}
}
}
