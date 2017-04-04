package assignment.four;

public class TreeNode<T extends Comparable<T>> {
  public T info;
  public TreeNode<T> left;
  public TreeNode<T> right;
  public TreeNode<T> parent;
  public boolean isLeft;
  public boolean isRight;

  // constructors
  public TreeNode() {
    info = null;
    left = null;
    right = null;
    parent = null;
    isLeft = false;
    isRight = false;

  }

  public TreeNode(T x) {
    info = x;
    left = null;
    right = null;
    parent = null;
    isLeft = false;
    isRight = false;

  }

  public TreeNode(T x, TreeNode<T> l, TreeNode<T> r, TreeNode<T> f) {
    info = x;
    left = l;
    right = r;
    parent = f;
    isLeft = false;
    isRight = false;
  }

  public T getInfo() {
    return info;
  }

  public TreeNode<T> getParent() {
    return parent;
  }


  /**
   * @return the node to the left
   */
  public TreeNode<T> getLeft() {
    return left;
  }

  /**
   * @return the node to the right
   */
  public TreeNode<T> getRight() {
    return right;
  }

  public void setLeft(T x) {
    if (this.left != null) { // check first
      System.out.println("void insertion");
    } else {
      TreeNode<T> p = new TreeNode<>(x);
      this.left = p;
      p.parent = this;
      p.isLeft = true;
    }
  }

  public void setRight(T x) {
    if (this.right != null) { // check first
      System.out.println("void insertion");
    } else {
      TreeNode<T> p = new TreeNode<>(x);
      this.right = p;
      p.parent = this;
      p.isRight = true;
    }
  }
}

