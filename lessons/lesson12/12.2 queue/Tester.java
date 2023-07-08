public class Tester {

  public static void main(String[] args) {
    // int[] a1 = { 2, 3, 0, 3, 5, 6, 8, 10 };
    // System.out.println(Tar1.theEmperorCode(a1, "ausdgkfilgalf"));
    // System.out.println(Tar1.decipherEmperorCode(a1, "cxsglqnsnjaok"));

    // Queue q1 = new Queue();
    // q1.enqueue(1);
    // q1.enqueue(2);
    // q1.enqueue(3);
    // q1.enqueue(4);

    // Queue q2 = new Queue();
    // q2.enqueue(1);
    // q2.enqueue(2);
    // q2.enqueue(6);
    // q2.enqueue(4);
    // System.out.println(Tar1.equals(q1,q2));

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
  }
}
