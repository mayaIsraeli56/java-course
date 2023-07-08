public class Tar1 {

  //Q1
  public static boolean checkPal1(Queue q1, int numOfEl) {
    int tempVal = 0;

    for (int i = 1; i <= (numOfEl - (numOfEl % 2)) / 2; i++) {
      tempVal = q1.dequeue();

      for (int j = 1; j <= (numOfEl - i * 2); j++) q1.enqueue(q1.dequeue());

      if (tempVal != q1.dequeue()) return false;
    }

    return true;
  }

  //Q2
  public static int what(TreeNode t) {
    if (t.getLeftSon() == null && t.getRightSon() == null) return 0;

    if (t.getLeftSon() != null && t.getRightSon() != null) {
      return 2 + what(t.getLeftSon()) + what(t.getRightSon());
    }

    if (t.getLeftSon() != null) return 1 + what(t.getLeftSon());

    return 1 + what(t.getRightSon());
  }

  public static void doWhat(TreeNode t) {
    if (t != null) {
      int x = what(t);
      t.setNumber(x);
      doWhat(t.getLeftSon());
      doWhat(t.getRightSon());
    }
  }

  public static void printPreOrder(TreeNode root) {
    if (root != null) {
      System.out.print(root.getNumber() + " ");
      printPreOrder(root.getLeftSon());
      printPreOrder(root.getRightSon());
    }
  }

  public static void print(Queue q) {
    Queue temp = new Queue();
    while (!q.isEmpty()) {
      int x = q.dequeue();
      System.out.println(x);
      temp.enqueue(x);
    }

    while (!temp.isEmpty()) {
      q.enqueue(temp.dequeue());
    }
  }
}
