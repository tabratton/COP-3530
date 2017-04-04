package assignment.five;

import java.util.Random;

public class HW5 {
  public static void main(String[] args) {
    // create a tree-based list with 9 letters
    TreeList list = new TreeList('A');
    list.insertAfter('H', 0);
    list.insertAfter('D', 0);
    list.insertAfter('C', 0);
    list.insertAfter('B', 0);
    list.insertAfter('E', 3);
    list.insertBefore('F', 5);
    list.insertAfter('G', 5);
    list.insertAfter('I', 7);

    System.out.print("The list contains ");
    list.display();

    // delete all elements in a random order
    Random rand = new Random();
    while (list.getSize() != 0) {
      int i = rand.nextInt(list.getSize());
      System.out.println("\n\nDeleting the " + i + "th element: " + list
          .delete(i));
      System.out.print("The list contains ");
      if (list.getSize() != 0) {
        list.display();
      } else {
        System.out.print("no element.");
      }
    }
  }
}

