package assignment.two;


public class DynamicNode {
  Object info;
  DynamicNode next;
  /* getInfo(), setInfo(), setNext(), getNext() */

  // constructor
  public DynamicNode() {

  }

  // constructor
  public DynamicNode(Object info, DynamicNode node) {
    this.info = info;
    next = node;
  }

  // get data in a node
  public Object getInfo() {
    return info;
  }

  // get reference in a node
  public DynamicNode getNext() {
    return next;
  }

  // set value of the object
  public void setInfo(Object info) {
    this.info = info;

  }

  // set reference to a node
  public void setNext(DynamicNode node) {

    next = node;
  }

} // end dynamic node class
