package lab.one;

// UIN: 2378
// Course ID: COP 3530 - CRN 10413

public class Driver {

  /**
   * Driver for the CircularQueueArray class, test queuing and dequeuing.
   *
   * @param args No command line arguments used in program.
   */
  public static void main(String[] args) {
    CircularQueueArray queue = new CircularQueueArray();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    queue.enqueue("D");
    queue.enqueue("E");
    queue.dequeue();
    queue.dequeue();
    queue.enqueue("F");
    queue.enqueue("G");
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
  }
}
