package assignment.six;

public class HW6 {

  /*
   * Definitions of the parameters
   *    1) tree: the array where the sweeping window is implemented
   *    2) newEle: the new element to insert
   *    3) pos: where to insert the new element initially.
   *            note it does not mean newEle is going to
   *            stay at pos after this function
   *    4) increment
   *     a) true: insert newEle, that is all
   *     b) false: insert newEle and then remove the root
   */
  private static void insertHeapTreeAt(int[] tree, int newEle, int pos,
                                       boolean increment) {

    if (increment) {
      tree[pos] = newEle;
      minHeapify(tree, tree.length, pos);
    } else if (newEle < tree[0]) {
      int root = tree[0];
      tree[0] = newEle;
      tree[pos] = root;
      minHeapify(tree, tree.length, 0);
    }
  }

  private static void minHeapify(int[] array, int n, int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && array[left] > array[smallest]) {
      smallest = left;
    }

    if (right < n && array[right] > array[smallest]) {
      smallest = right;
    }

    if (smallest != i) {
      int swap = array[i];
      array[i] = array[smallest];
      array[smallest] = swap;

      minHeapify(array, n, smallest);
    }
  }

  /*
   * get the smallest k elements in array x in O(nlogn) time, where
   * n is the size of array x.
   *
   * It is supposed to return an array, containing the smallest k elements
   * in the increasing order.
   */
  private static int[] getSmallestK(int x[], int k) {

    if (k > x.length) return null;
    int[] result = new int[k + 1];

    // use the first k elements in x to construct an
    // almost complete binary tree, where father<=sons
    for (int i = k - 1; i >= 0; i--) {
      insertHeapTreeAt(result, x[i], i, true);
    }

    // for each element in the rest of array x,
    // insert it in the almost complete binary tree, and then
    // remove the root in the tree.
    for (int i = k; i < x.length; i++) {
      insertHeapTreeAt(result, x[i], k, false);
    }

    // now the first k elements in result are the smallest k elements in x

    // sort the first k elements in result in O(klogk) time

    // insert your code here
    for (int i = result.length / 2 - 1; i >= 0; i--) {
      minHeapify(result, result.length, i);
    }

    for (int i = result.length - 1; i >= 0; i--) {
      int temp = result[0];
      result[0] = result[i];
      result[i] = temp;

      minHeapify(result, i, 0);
    }


    return result;
  }

  public static void main(String[] args) {
    int[] data = {31, 44, 64, 5, 61, 43, 6, 88, 59, 90, 39, 97, 77, 62, 99,
        34, 57, 53, 60, 29};

    int[] smallestK = getSmallestK(data, 5);
    for (int i = 0; i < 5; i++) {
      System.out.print(smallestK[i] + ",");
    }
    System.out.println();
  }
}