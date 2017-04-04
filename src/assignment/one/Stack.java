package assignment.one;

// UIN: 2378
// Assignment #1
// Course ID: COP 3530 - CRN 10413

public class Stack {
  // Maximum size of the stack
  private static final int STACK_SIZE = 100;
  // The current position of the top of the stack in the array
  private int top;
  // The array that stores the stack data
  private double[] stack;

  // Initialize a new stack with the maximum stack size and move the top to
  // the starting position.
  public Stack() {
    this.stack = new double[STACK_SIZE];
    this.top = -1;
  }

  // Puts the given value on the top of the stack.
  public void push(double value) {
    this.stack[++top] = value;
  }

  // Returns the value on top of the stack without removing it.
  public double peek() {
    return this.stack[top];
  }

  // Returns the value on the top of the stack and remove it.
  public double pop() {
    return this.stack[top--];
  }

  // Checks to see if the stack is empty.
  public boolean empty() {
    return top < 0;
  }
}
