public class Tar1 {

  public static String theEmperorCode(int[] key, String msg) {
    Queue q = new Queue();
    for (int i = 0; i < key.length; i++) q.enqueue(key[i]);

    String encoded = "";
    for (int i = 0; i < msg.length(); i++) {
      int keyValue = q.dequeue();
      encoded += (char) (msg.charAt(i) + keyValue);
      q.enqueue(keyValue);
    }

    return encoded;
  }

  public static String decipherEmperorCode(int[] key, String msg) {
    Queue q = new Queue();
    for (int i = 0; i < key.length; i++) q.enqueue(key[i]);

    String decode = "";
    for (int i = 0; i < msg.length(); i++) {
      int keyValue = q.dequeue();
      decode += (char) (msg.charAt(i) - keyValue);
      q.enqueue(keyValue);
    }

    return decode;
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

  public static boolean equals(Queue q1, Queue q2) {
    if (size(q1) != size(q2)) return false;

    Queue temp1 = new Queue();
    Queue temp2 = new Queue();
    boolean flag = true;

    while (!q1.isEmpty()) {
      int x = q1.dequeue();
      int y = q2.dequeue();

      if (x != y) flag = false;

      temp1.enqueue(x);
      temp2.enqueue(y);
    }

    while (!temp1.isEmpty() && !temp2.isEmpty()) {
      q1.enqueue(temp1.dequeue());
      q2.enqueue(temp2.dequeue());
    }

    return flag;
  }

  public static int size(Queue q) {
    int count = 0;

    Queue temp = new Queue();

    while (!q.isEmpty()) {
      temp.enqueue(q.dequeue());
      count++;
    }

    while (!temp.isEmpty()) {
      q.enqueue(temp.dequeue());
    }

    return count;
  }

//   public static void moveHalf(Queue q) {
//     Queue temp = new Queue();
//     int i = 0;
//     int size = size(q);
    
//     while (!q.isEmpty() && i < size / 2) {
//       int x = q.dequeue();
//       temp.enqueue(x);
//       i++;
//     }

//     while (!temp.isEmpty()) {
//       q.enqueue(temp.dequeue());
//     }
//   }

  public static void moveHalf(Queue q) {
        
		Queue tmp = new Queue();
		int half = size(q)/2;
		
		for(int i = 0 ; i < half ; i++) {
		    tmp.enqueue(q.dequeue());
		}

    	for(int i = 0 ; i < half ; i++) {
		    q.enqueue(tmp.dequeue());
		}
	}
}
