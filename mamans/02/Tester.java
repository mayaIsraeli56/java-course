public class Tester {

  public static void main(String[] args) {
    // int[] a1 = { 2, 3, 0, 3, 5, 6, 8, 10 };

    // Queue q2 = new Queue();
    // q2.enqueue(1);
    // q2.enqueue(2);
    // q2.enqueue(6);
    // q2.enqueue(4);
    // System.out.println(Tar1.equals(q1,q2));

    ////////////////Q1//////////////////////
    Queue q3 = new Queue();
    q3.enqueue(1);
    q3.enqueue(2);
    q3.enqueue(6);
    q3.enqueue(4);

    q3.enqueue(4);
    q3.enqueue(5);
    q3.enqueue(5);
    q3.enqueue(4);

    q3.enqueue(4);
    q3.enqueue(6);
    q3.enqueue(2);
    q3.enqueue(1);

    System.out.println(Tar1.checkPal1(q3, 12));

    
    ////////////////Q2//////////////////////

    TreeNode t1 = new TreeNode(-1);
    TreeNode t2 = new TreeNode(3);
    TreeNode t3 = new TreeNode(0);
    TreeNode t4 = new TreeNode(0);
    TreeNode t5 = new TreeNode(-5);
    TreeNode t6 = new TreeNode(-4);
    TreeNode t7 = new TreeNode(-4);

    t1.setLeftSon(t2);
    t1.setRightSon(t3);
    t2.setRightSon(t4);
    t4.setLeftSon(t5);
    t4.setRightSon(t6);
    t3.setRightSon(t7);
    
    Tar1.printPreOrder(t1);
    System.out.println();
    Tar1.doWhat(t1);
    Tar1.printPreOrder(t1);

  }
}
