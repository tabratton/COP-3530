package assignment.four;

import java.util.Stack;

public class BSTDriver {

  public static <T extends Comparable<T>> Tree<T> makeTree(T x) {
    return new Tree<T>(x);
  }

  public static <T extends Comparable<T>> Tree<T> constructTree(T[] values) {
    // Create tree with given root value
    Tree<T> tree = makeTree(values[0]);

    // Add all values to the tree.
    for (int i = 1; i < values.length; i++) {
      // Start searching at the root
      TreeNode<T> node = tree.getRoot();
      // To keep track of whether the value has been inserted.
      boolean inserted = false;
      while (!inserted) {
        // Check to see if the value is equal the specified node, and skip it
        // if it is.
        if (node.info.compareTo(values[i]) == 0) {
          inserted = true;
        } // end if

        // Check to see if the value is less than the value in the node.
        if (node.info.compareTo(values[i]) > 0) {
          // If the left son of that node is null, insert the value there.
          if (node.getLeft() == null) {
            node.setLeft(values[i]);
            inserted = true;
          } else {
            // Else traverse to the left son and run checks again.
            node = node.getLeft();
          } // end if-else
        } // end if

        // Check to see if the value is greater than the value in the node.
        if (node.info.compareTo(values[i]) < 0) {
          // If the right son of that node is null, insert the value there.
          if (node.getRight() == null) {
            node.setRight(values[i]);
            inserted = true;
          } else {
            // Else traverse to the right son and run checks again.
            node = node.getRight();
          } // end if-else
        } // end if
      } // end while
    } // end for

    // Return the completed tree.
    return tree;
  }


  public static <T extends Comparable<T>> void preTrav(TreeNode<T> tree) {
    Stack<TreeNode<T>> stack = new Stack<>(); // create new stack object
    TreeNode<T> node = tree;
    // Push the root onto the stack.
    stack.push(node);

    while (!stack.empty()) {
      // Print the root
      node = stack.pop();
      System.out.print(node.getInfo() + " ");

      // If the right son exists push it onto the stack.
      if (node.getRight() != null) {
        stack.push(node.getRight());
      }

      // If the left son exists push it onto the stack.
      if (node.getLeft() != null) {
        stack.push(node.getLeft());
      }
    }
    System.out.println();
  }


  public static <T extends Comparable<T>> void postTrav(TreeNode<T> tree) {
    // Stack used to track to traversal of the tree
    Stack<TreeNode<T>> traversalStack = new Stack<>();
    // Stack used to order the output properly.
    Stack<TreeNode<T>> outputStack = new Stack<>();

    traversalStack.push(tree);

    while (!traversalStack.empty()) {
      TreeNode<T> node = traversalStack.pop();
      outputStack.push(node);

      // Push the left son onto the stack if it exists.
      if (node.getLeft() != null) {
        traversalStack.push(node.getLeft());
      } // end if

      // Push the right son onto the stack if it exists.
      if (node.getRight() != null) {
        traversalStack.push(node.getRight());
      } // end if
    } // end while

    // Print out all of the post ordered nodes.
    while (!outputStack.empty()) {
      System.out.print(outputStack.pop().getInfo() + " ");
    }
    System.out.println();
  }


  public static <T extends Comparable<T>> void inTrav(TreeNode<T> tree) {
    Stack<TreeNode<T>> stack = new Stack<>(); // create new stack object
    TreeNode<T> node = tree;

    while (!stack.empty() || node != null) {
      // Traverse to the end of the left sub tree
      while (node != null) {
        stack.push(node);
        node = node.getLeft();
      } // end while

      // While there are still nodes in the stack, pop them off print them,
      // then switch to the closest right sub tree.
      if (!stack.empty()) {
        node = stack.pop();
        System.out.print(node.getInfo() + " ");
        node = node.getRight();
      } // end if
    } // end while
    System.out.println();
  }


  public static <T extends Comparable<T>> boolean isStrictlyBinary(TreeNode<T>
                                                                       tree) {
    // Check to make sure the node isn't null
    if (tree != null) {
      // If the tree has only one son return false.
      if ((tree.getLeft() == null && tree.getRight() != null) || (
          tree.getRight() == null && tree.getLeft() != null)) {
        return false;
      }
      // If the node has two sons, check to see if they are strictly binary.
      return isStrictlyBinary(tree.getLeft()) && isStrictlyBinary(tree
          .getRight());
    }
    return true;
  }


  public static <T extends Comparable<T>> boolean isCompleteBinary(TreeNode<T>
                                                                       tree) {
    Stack<TreeNode<T>> stack = new Stack<>(); // create new stack object
    TreeNode<T> node = tree;
    int totalNodes = 0;
    int depth = maxDepth(node);

    // Find the number of nodes in the tree.
    while (!stack.empty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.getLeft();
      } // end while

      if (!stack.empty()) {
        node = stack.pop();
        totalNodes++;
        node = node.getRight();
      } // end if
    } // end while

    // Formula from the book for determining the total nodes in a complete
    // binary tree.
    int theoreticalTotalNodes = (int) Math.pow(2, depth + 1) - 1;
    // If the tree's actual total nodes equal the theoretical total nodes in
    // a complete binary tree, it is a complete binary tree.
    return totalNodes == theoreticalTotalNodes;
  }

  public static <T extends Comparable<T>> int maxDepth(TreeNode<T> node) {
    // If a node is null then we have gone one level too far, return -1.
    if (node == null) {
      return -1;
    } else {
      // Find the depth of the left and right sub trees.
      int leftDepth = maxDepth(node.getLeft());
      int rightDepth = maxDepth(node.getRight());
      // Return the greatest depth
      if (leftDepth > rightDepth) {
        return (leftDepth + 1);
      } else {
        return (rightDepth + 1);
      }
    }
  }

  public static <T extends Comparable<T>> boolean isAlmostBinary(TreeNode<T>
                                                                     tree) {

    // Not implemented.
    return false;
  }


  public static void main(String args[]) {
    Tree<Integer> tree1 = constructTree(new Integer[]{7, 1, 9, 0, 3, 8, 10,
        2, 5, 4, 6});
    Tree<Character> tree2 = constructTree(new Character[]{'D', 'B', 'F', 'A',
        'C', 'E', 'H', 'G', 'I'});

    //test all methods
    System.out.println("Tree 1:");
    System.out.print("Non-Recursive Preorder Traversal: ");
    preTrav(tree1.getRoot());
    System.out.print("Non-Recursive Postorder Traversal: ");
    postTrav(tree1.getRoot());
    System.out.print("Non-Recursive Inorder Traversal: ");
    inTrav(tree1.getRoot());
    System.out.println("Is the Strictly Binary?: " + isStrictlyBinary(
        tree1.getRoot()));
    System.out.println("Is the Complete?: " + isCompleteBinary(
        tree1.getRoot()));
    System.out.println("Is the Almost Complete?: " + isAlmostBinary(
        tree1.getRoot()));

    System.out.println();

    System.out.println("Tree 2:");
    System.out.print("Non-Recursive Preorder Traversal: ");
    preTrav(tree2.getRoot());
    System.out.print("Non-Recursive Postorder Traversal: ");
    postTrav(tree2.getRoot());
    System.out.print("Non-Recursive Inorder Traversal: ");
    inTrav(tree2.getRoot());
    System.out.println("Is the Strictly Binary?: " + isStrictlyBinary(
        tree2.getRoot()));
    System.out.println("Is the Complete?: " + isCompleteBinary(
        tree2.getRoot()));
    System.out.println("Is the Almost Complete?: " + isAlmostBinary(
        tree2.getRoot()));

  }
}

