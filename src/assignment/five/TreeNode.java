package assignment.five;

public class TreeNode {
  public Object info;
  public TreeNode left;
  public TreeNode right;
  public TreeNode father;
  int lCount; // how many leaves are in the left subtree
  boolean isLeft;

  public TreeNode() {
    lCount = 0;
    info = left = right = father = null;
    isLeft = false;
  }

  public TreeNode(Object x) {
    lCount = 0;
    info = x;
    left = right = father = null;
    isLeft = false;
  }

  public void setLeft(Object x) {
    if (this.left != null) {
      System.out.println("void insertion");
    } else {
      TreeNode p = new TreeNode(x);
      p.father = this;
      this.left = p;
      p.isLeft = true;
    }
  }

  public void setRight(Object x) {
    if (this.right != null) {
      System.out.println("void insertion");
    } else {
      TreeNode p = new TreeNode(x);
      p.father = this;
      this.right = p;
      p.isLeft = false;
    }
  }
}