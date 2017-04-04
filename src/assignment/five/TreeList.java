package assignment.five;

public class TreeList {
  TreeNode root;
  int size; // # of elements in the list

  // this constructor creates an empty list
  public TreeList() {
    size = 0;
    root = null;
  }

  // this constructor creates a list with only one node
  // that contains x
  public TreeList(Object x) {
    size = 1;
    root = new TreeNode(x);
  }

  public TreeNode getRoot() {
    return root;
  }

  // In the list, insert x before the (index)th element
  // index begins from zero
  public void insertBefore(Object x, int index) {
    // Find the node to insert before.
    TreeNode oldNode = getTreeNode(index);
    // Move current node data to the right son.
    oldNode.setRight(oldNode.info);
    // Insert the new node as the left son.
    oldNode.setLeft(x);
    // Set current node data to null.
    oldNode.info = null;
    TreeNode temp = oldNode.left;
    // Walk back up the tree and increase lCount by one if the node is a left
    // son of its father.
    while (temp != root) {
      if (temp.isLeft) {
        temp.father.lCount++;
      }
      temp = temp.father;
    }
    // Increase the size of the tree by one.
    size++;
  }

  // In the list, insert x after the (index)th element
  // index begins from zero
  public void insertAfter(Object x, int index) {
    // Find the node to insert after.
    TreeNode oldNode = getTreeNode(index);
    // Move current node data to the left son
    oldNode.setLeft(oldNode.info);
    // Insert the new node as the right son.
    oldNode.setRight(x);
    // Set current node data to null.
    oldNode.info = null;
    // Increase lCount of those node by 1 since we gained a left son.
    oldNode.lCount++;
    TreeNode temp = oldNode.right;
    // Walk back up the tree and increase lCount by one if the node is a
    // left son of its father.
    while (temp != root) {
      if (temp.isLeft) {
        temp.father.lCount++;
      }
      temp = temp.father;
    }
    // Increase size of the tree by one.
    size++;
  }

  // delete and return the (index)th element in the list
  // index begins from zero
  public Object delete(int index) {
    // Find the node to delete
    TreeNode oldNode = getTreeNode(index);
    // Store info to return later.
    Object data = oldNode.info;
    // If we are deleting the root, just set it to null and set size to 0.
    if (oldNode == root) {
      root = null;
      size = 0;
      return data;
    }
    // Find the parent and grandparent of the node.
    TreeNode parent = oldNode.father;
    TreeNode grandParent = parent.father;
    TreeNode temp;
    // If the parent is the root, simply set the root to the not deleted node
    // and reset isLeft and lCount.
    if (parent == root) {
      if (oldNode.isLeft) {
        root = parent.right;
      } else {
        root = parent.left;
      }
      root.isLeft = false;
      root.lCount = 0;
      temp = root;
      // If the parent is not the root, determine what combination of deleted
      // node orientation and parent orientation we have.
    } else {
      if (oldNode.isLeft) {
        // If the deleted node is left and the parent is left, then the left
        // node of the grandparent must become the right node of the parent.
        if (parent.isLeft) {
          grandParent.left = parent.right;
          grandParent.left.father = grandParent;
          grandParent.left.isLeft = true;
          // Else the right node of the parent must be the right node of the
          // grandparent.
        } else {
          grandParent.right = parent.right;
          grandParent.right.father = grandParent;
          grandParent.right.isLeft = false;
        }
        temp = parent.right;
      } else {
        // If the deleted node was right and the parent is left, then the
        // left node of the parent must become the left node of the grandparent.
        if (parent.isLeft) {
          grandParent.left = parent.left;
          grandParent.left.father = grandParent;
          grandParent.left.isLeft = true;
          // Else the left node of the parent must be the right node of the
          // grandparent.
        } else {
          grandParent.right = parent.left;
          grandParent.right.father = grandParent;
          grandParent.right.isLeft = false;
        }
        temp = parent.left;
      }
    }

    // Walk back up the tree and decrease lCount if the deleted node was a
    // left descendant of that node.
    while (temp != root) {
      if (temp.isLeft) {
        temp.father.lCount--;
      }
      temp = temp.father;
    }

    // Decrease size by 1 for the deleted node.
    size--;
    return data;
  }

  // look for the tree node that contains (index)th element in the list
  // index begins from zero
  public TreeNode getTreeNode(int index) {
    int result = index;
    TreeNode temp = root;
    // While the node is not a leaf.
    while (temp.left != null && temp.right != null) {
      // If the current result is less than the count of the node we have to
      // go left.
      if (result < temp.lCount) {
        temp = temp.left;
        // If it is greater we have to go right.
      } else {
        result -= temp.lCount;
        temp = temp.right;
      }
    }
    // Return the (index)th node.
    return temp;
  }

  // displays only the leaves in inorder
  public void display() {
    inTrav(root);
  }

  private void inTrav(TreeNode root) {
    if (root != null) {
      inTrav(root.left);
      if (root.left == null && root.right == null) {
        System.out.print(root.info + ",");
      }
      inTrav(root.right);
    }
  }

  public int getSize() {
    return size;
  }
}
