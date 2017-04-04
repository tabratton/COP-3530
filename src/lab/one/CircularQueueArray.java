package lab.one;

// UIN: 2378
// Course ID: COP 3530 - CRN 10413

/**
 * Implementation of a circular queue using an array.
 */
public class CircularQueueArray {
  private static final int MAX_SIZE = 5;
  private Object[] array;
  private int front;
  private int rear;
  private int size;

  /**
   * Constructor for the class, initializes fields to default values.
   */
  public CircularQueueArray() {
    this.array = new Object[MAX_SIZE];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }

  /**
   * Checks to see if the queue is empty.
   *
   * @return True if queue is empty, false if not empty.
   */
  public boolean empty() {
    return this.size == 0;
  }

  /**
   * Adds object to the queue if the queue is not full.
   *
   * @param x An object to add to the queue.
   */
  public void enqueue(Object x) {
    if (!this.full()) {
      // Add object to the rear
      this.array[this.rear] = x;
      // Update rear, use % to make sure that it never goes beyond MAX_SIZE.
      this.rear = (this.rear + 1) % MAX_SIZE;
      // Update the current number of objects in the queue.
      this.size++;
      // Print current queue.
      this.print();
    } else {
      throw new RuntimeException();
    }
  }

  /**
   * Removes object from the queue if the queue is not empty.
   *
   * @return The object that is being removed.
   */
  public Object dequeue() {
    if (!this.empty()) {
      // Get the object that is currently at the front of the queue.
      Object temp = this.array[this.front];
      // Update the front, use % to make sure it never goes beyond MAX_SIZE
      this.front = (this.front + 1) % MAX_SIZE;
      // Update the current number of objects in the queue.
      this.size--;
      // Print current queue.
      this.print();
      // Return the "removed" object.
      return temp;
    } else {
      throw new RuntimeException();
    }
  }

  /**
   * Checks to see if the queue is full.
   *
   * @return True if the queue is full, false if not full.
   */
  public boolean full() {
    return this.size == MAX_SIZE;
  }

  /**
   * Get the current size of the queue.
   *
   * @return The number of objects in the queue.
   */
  public int size() {
    return this.size;
  }

  /**
   * Print the current status of the queue.
   */
  public void print() {
    // Create the "0 1 2 3 4" string.
    String indices = "";
    for (int i = 0; i < MAX_SIZE; i++) {
      indices += i + " ";
    }
    System.out.println(indices);

    // Create the string that shows elements in the queue.
    String elements = "";
    // If the queue is full, add everything in the array to the string.
    if (this.full()) {
      for (int i = 0; i < MAX_SIZE; i++) {
        elements += this.array[i] + " ";
      }
    // If the queue is empty, add nothing to the string.
    } else if (this.empty()) {
      for (int i = 0; i < MAX_SIZE; i++) {
        elements += " ";
      }
    // If the queue has some items in it, but is not full.
    } else {
      for (int i = 0; i < MAX_SIZE; i++) {
        // If the rear has not wrapped around to behind the front.
        if (this.rear >= this.front) {
          // Only add elements that are between the front and the rear
          if (i < this.rear && i >= this.front) {
            elements += this.array[i] + " ";
          } else {
            elements += "  ";
          }
        } else {
          // Else, if the rear is behind the front, only add elements that
          // are not between the rear and the front.
          if (i < this.rear || i >= this.front) {
            elements += this.array[i] + " ";
          } else {
            elements += "  ";
          }
        }
      }
    }
    System.out.println(elements);

    // Print the rest of the stats.
    System.out.println("Front: " + this.front);
    System.out.println("Rear: " + this.rear);
    System.out.println("Size: " + this.size());
    System.out.println("Empty: " + this.empty());
    System.out.println("Full: " + this.full());
    System.out.println();
  }
}

