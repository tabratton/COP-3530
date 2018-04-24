package assignment.seven;

// UIN: 2378
// Assignment #6
// Course ID: COP 3530 - CRN 10413
// Date: 4/11/2017

import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

class TreeNode {
  public int info;
  public TreeNode left;
  public TreeNode right;
  public TreeNode father;
  public int leftCount;
  public boolean isLeft;

  public TreeNode() {
    leftCount = 0;
    info = 0;
    left = null;
    right = null;
    father = null;
    isLeft = false;
  }

  public TreeNode(int x) {
    leftCount = 0;
    info = x;
    left = null;
    right = null;
    father = null;
    isLeft = false;
  }

  public void setLeft(int x) {
    if (this.left != null) {
      System.out.println("void insertion");
      return;
    } else {
      TreeNode previous = new TreeNode(x);
      previous.father = this;
      this.left = previous;
      previous.isLeft = true;
    }
  }

  public void setRight(int x) {
    if (this.right != null) {
      System.out.println("void insertion");
    } else {
      TreeNode previous = new TreeNode(x);
      previous.father = this;
      this.right = previous;
      previous.isLeft = false;
    }
  }
}

class SearchTree {
  TreeNode root;
  private Stack<Integer> travNumbers = new Stack<>();

  SearchTree() {
    root = null;
  }

  boolean insert(int newInt) {
    if (root == null) {
      root = new TreeNode(newInt);
      inTrav();
      return true;
    }

    TreeNode node = root;
    // To keep track of whether the value has been inserted.
    boolean inserted = false;
    while (!inserted) {
      if (node.info == newInt) {
        inserted = true;
      }

      // Check to see if the value is less than the value in the node.
      if (node.info > newInt) {
        // If the left son of that node is null, insert the value there.
        if (node.left == null) {
          node.setLeft(newInt);
          inserted = true;
        } else {
          // Else traverse to the left son and run checks again.
          node = node.left;
        }
      }

      // Check to see if the value is greater than the value in the node.
      if (node.info < newInt) {
        // If the right son of that node is null, insert the value there.
        if (node.right == null) {
          node.setRight(newInt);
          inserted = true;
        } else {
          // Else traverse to the right son and run checks again.
          node = node.right;
        }
      }
    }

    inTrav();

    return true;
  }

  boolean delete(int d) {

    TreeNode temp = root;
    TreeNode previous = null;

    while (temp != null && temp.info != d) {
      previous = temp;
      temp = (d < temp.info) ? temp.left : temp.right;
    }

    if (temp == null) {
      return false;
    }
    TreeNode rp;
    TreeNode father;
    TreeNode s;
    if (temp.left == null) {
      rp = temp.right;
    } else if (temp.right == null) {
      rp = temp.left;
    } else {
      father = temp;
      rp = temp.left;
      s = rp.right;
      while (s != null) {
        father = rp;
        rp = s;
        s = rp.right;
      }
      if (father != temp) {
        father.right = rp.left;
        rp.left = temp.left;
      }
      rp.right = temp.right;
    }

    if (previous == null) {
      root = rp;
    } else if (temp == previous.left) {
      previous.left = rp;
    } else {
      previous.right = rp;
    }
    inTrav();
    return true;
  }

  public void inTrav() {
    inTrav(root);
    travNumbers.clear();
  }

  private void inTrav(TreeNode root) {
    if (root == null) {
      return;
    }

    inTrav(root.left);

    if (travNumbers.empty() || (travNumbers.peek() < root.info)) {
      travNumbers.push(root.info);
    } else {
      throw new RuntimeException();
    }

    inTrav(root.right);
  }

}

public class HW7 {
  public static void main(String[] args) {
    int size = 1000;
    // Generate 1000 distinct, random numbers.
    HashSet<Integer> numbers = new HashSet<>(size);
    Random rand = new Random();
    while (numbers.size() < size) {
      numbers.add(Math.abs(rand.nextInt()));
    }

    // Add all 1000 numbers to the tree.
    SearchTree tree = new SearchTree();
    for (Integer num : numbers) {
      tree.insert(num);
    }
    System.out.println("Elements inserted");

    // Keep track of deleted numbers
    HashSet<Integer> deletedPos = new HashSet<>(100);
    HashSet<Integer> deletedNum = new HashSet<>(100);
    // Delete 100 items.
    int numberOfDeleted = 0;
    while (numberOfDeleted < 100) {
      // Get a random position to delete.
      int item = rand.nextInt(size);
      // If the position to delete has not been selected already.
      if (!deletedPos.contains(item)) {
        deletedPos.add(item);
        int pos = 0;
        for (Integer num : numbers) {
          // If we are at the position and we have not already deleted the
          // number.
          if (pos == item && !deletedNum.contains(num)) {
            tree.delete(num);
            deletedNum.add(num);
            numberOfDeleted++;
          }
          pos++;
        }
      }
    }
  }
}