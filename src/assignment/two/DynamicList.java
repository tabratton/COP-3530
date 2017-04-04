package assignment.two;

public class DynamicList {

  private DynamicNode list;

  public DynamicList() {
    list = null;
  }

  public boolean isEmpty() {
    return list == null;
  }

  /**
   * Inserts an object to the first position in the list.
   *
   * @param data The object to be inserted.
   */
  public void insertFirst(Object data) {
    DynamicNode newNode = new DynamicNode(data, null);
    if (!isEmpty()) {
      newNode.setNext(list);
    }
    list = newNode;
  }

  /**
   * Inserts an object after a specified node.
   *
   * @param previousNode The node to be inserted after.
   * @param data The object to be inserted.
   */
  public void insertAfter(DynamicNode previousNode, Object data) {
    if (previousNode == null) {
      System.out.println("void insertion");
      System.exit(1);
    }

    DynamicNode newNode = new DynamicNode(data, previousNode.getNext());
    previousNode.setNext(newNode);
  }

  /**
   * Deletes the first object in the list.
   *
   * @return The object that was deleted.
   */
  public Object deleteFirst() {
    if (isEmpty()) {
      System.out.println("void deletetion");
      System.exit(1);
    }

    Object temp = list.getInfo();
    if (list.getNext() == null) {
      list = null;
    } else {
      list = list.getNext();
    }
    return temp;
  }

  /**
   * Deletes the object after the specified node.
   *
   * @param previous The node that is before the one to be deleted.
   * @return The object that was deleted.
   */
  public Object deleteAfter(DynamicNode previous) {
    if (previous == null || previous.getNext() == null) {
      System.out.println("void deletion");
      System.exit(1);
    }

    DynamicNode newNode = previous.getNext();
    Object temp = newNode.getInfo();
    previous.setNext(newNode.getNext());
    return temp;
  }

  /**
   * Places the object into the list in a sorted position.
   *
   * @param object The object to be inserted
   */
  public void place(Sortable object) {
    DynamicNode previous;
    DynamicNode newNode = null;
    for (previous = list; previous != null && object.compareTo(previous
        .getInfo()) > 0; previous = previous.getNext()) {
      newNode = previous;
    }
    if (newNode == null) {
      insertFirst(object);
    } else {
      insertAfter(newNode, object);
    }
  }

  /**
   * Inserts the object into the last position of the list.
   *
   * @param object The object to be inserted.
   */
  public void insertLast(Object object) {
    DynamicNode previous = new DynamicNode(object, null);
    DynamicNode newNode;

    if (isEmpty()) {
      list = previous;
    } else {
      for (newNode = list; newNode.getNext() != null; newNode = newNode
          .getNext()) {

      }
      newNode.setNext(previous);
    }
  }

  /**
   * Searches the list for the given object.
   *
   * @param object The object to search for.
   * @return The node where the object is.
   */
  public DynamicNode search(Object object) {
    DynamicNode previous;
    for (previous = list; previous != null; previous = previous.getNext()) {
      if (previous.getInfo().equals(object)) {
        return previous;
      }
    }
    return null;
  } // end search

  /**
   * Removes the given object from the list.
   *
   * @param object The object to be removed.
   */
  public void removeX(Object object) {
    DynamicNode previous = list;
    DynamicNode newNode = null;
    while (previous != null) {
      if (previous.getInfo().equals(object)) {
        previous = previous.getNext();
        if (newNode == null) {
          deleteFirst();
        } else {
          deleteAfter(newNode);
        }
      } else {
        // advance to the next node in the list
        newNode = previous;
        previous = previous.getNext();
      }
    } // end while
  } // end removex

  /**
   * Prints a DynamicList.
   */
  public void print() {
    DynamicNode tempNode = this.list;
    // Print the information in each node of the list while the node is not
    // null.
    while (tempNode != null) {
      System.out.print(tempNode.getInfo() + " ");
      tempNode = tempNode.getNext();
    }
    System.out.println();
  }

  /**
   * Concatenates a given list to the end of the list the method is called on.
   *
   * @param secondList The DynamicLise to be concatenated.
   */
  public void concat(DynamicList secondList) {
    DynamicNode tempNode = this.list;
    // Iterate through the list to find the end of it.
    while (tempNode.getNext() != null) {
      tempNode = tempNode.getNext();
    }
    // Point the end of the list to the beginning of the given list.
    tempNode.setNext(secondList.list);
  }

  /**
   * Returns the sum of the DynamicList.
   *
   * @return The sum of the list.
   */
  public int sumList() {
    DynamicNode tempNode = this.list;
    int sum = 0;
    // Iterate through each node of the list and add its data to the sum.
    while (tempNode != null) {
      IntData data = (IntData) tempNode.getInfo();
      sum += data.getData();
      tempNode = tempNode.getNext();
    }
    return sum;
  }

  /**
   * Reverses the DynamicList.
   */
  public void reverseIteratively() {
    // Create a new DynamicList to store our nodes
    DynamicList reversedList = new DynamicList();
    DynamicNode tempNode = this.list;
    // Iterate through the original list
    while (tempNode != null) {
      // Insert each new node's data as the first thing in the new list.
      reversedList.insertFirst(tempNode.getInfo());
      // Move to the next node.
      tempNode = tempNode.getNext();
    }
    // Set our list to be the reversed list.
    this.list = reversedList.list;
  }

} // end dynamic list
