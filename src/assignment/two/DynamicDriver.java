package assignment.two;

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

  }
}
