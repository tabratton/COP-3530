package assignment.three;

public class DynamicDriver {

  /**
   * Driver for testing the DynamicList class with IntData.
   *
   * @param args No command line arguments.
   */
  public static void main(String[] args) {
    DynamicList list = new DynamicList();
    list.insertLast(new IntData(1));
    list.insertLast(new IntData(2));
    list.insertLast(new IntData(3));
    list.print();

    DynamicList list2 = new DynamicList();
    list2.insertLast(new IntData(4));
    list2.insertLast(new IntData(5));
    list2.insertLast(new IntData(6));
    list2.print();

    list.concat(list2);
    list.print();
    System.out.println(list.sumList());

    list.reverseIteratively();
    list.print();

    // Assignment 3 Driver

    DynamicList list3 = new DynamicList();
    list3.insertLast(new IntData(5));
    list3.insertLast(new IntData(6));
    list3.insertLast(new IntData(7));
    list3.insertLast(new IntData(8));

    DynamicList list4 = new DynamicList();
    list4.insertLast(new IntData(5));
    list4.insertLast(new IntData(6));
    list4.insertLast(new IntData(8));
    list4.insertLast(new IntData(9));

    System.out.println();
    list3.print();
    list4.print();

    System.out.println("\nUnion: ");
    list3.union(list4);
    list3.print();

    DynamicList list5 = new DynamicList();
    list5.insertLast(new IntData(5));
    list5.insertLast(new IntData(6));
    list5.insertLast(new IntData(7));
    list5.insertLast(new IntData(8));

    System.out.println("\nIntersection: ");
    list5.intersection(list4);
    list5.print();

    DynamicList list6 = new DynamicList();
    list6.insertLast(new IntData(1));
    list6.insertLast(new IntData(2));
    list6.insertLast(new IntData(3));
    list6.insertLast(new IntData(4));
    list6.insertLast(new IntData(5));
    list6.insertLast(new IntData(6));
    list6.insertLast(new IntData(7));
    list6.insertLast(new IntData(8));

    System.out.println("\nDelete Every Second: ");
    list6.print();
    list6.deleteEverySecond();
    list6.print();
  }
}
