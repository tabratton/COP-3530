package assignment.four;

public class Tree<T extends Comparable<T>> {

  TreeNode<T> root;

  // constructor
  public Tree() {
    root = null;
  }

  public Tree(T x) {
    root = new TreeNode<>(x);
  }

  public TreeNode<T> getRoot() {
    return root;
  }

  void preTrav(TreeNode<T> tree) {
    if (tree != null) {
      System.out.println(tree.info); // visit the root
      preTrav(tree.left); // traverse the left subtree
      preTrav(tree.right); // traverse the right subtree
    }
  }
}
