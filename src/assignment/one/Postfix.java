package assignment.one;

// UIN: 2378
// Assignment #1
// Course ID: COP 3530 - CRN 10413

import java.io.IOException;

public class Postfix {

  private static final int MAX_COLS = 80;

  public static void main(String[] args) throws IOException {
    System.out.println("Enter a infix  String: ");
    String infix = readString().trim();

    System.out.println("The original infix expr is:  " + infix);
    String pfix = postfix(infix);

    System.out.println("The Postfix expr is:  " + pfix);
    System.out.println("The value is :  " + eval(pfix));
  } // end main

  public static boolean isOperand(char ch) {
    // Since our program only takes in integers, only digits are operands.
    return Character.isDigit(ch);
  }

  public static int operPrecedence(char operator) {
    // + and - have the same precedence of 1
    if (operator == '+' || operator == '-') {
      return 1;
      // * and / have the same precedence of 2
    } else if (operator == '*' || operator == '/') {
      return 2;
      // $ is the only operator with the precedence of 3
    } else if (operator == '$') {
      return 3;
      // If it was not one of those characters, something is clearly wrong
    } else {
      return -1;
    }
  }

  public static boolean precedence(char topOfStack, char readSymbol) {
    // If a ( is on topOfStack of the stack or read, pushed the read symbol onto
    // the stack.
    if (readSymbol == '(' || topOfStack == '(') {
      return false;
      // When an ) is read, we must pop off all items on the stack until we
      // reach the corresponding (.
    } else if (readSymbol == ')') {
      return true;
      // If any other symbols are on the topOfStack of the stack or read, we must
      // use the operPrecedence method to determine precedence.
      // If the symbol on topOfStack of the stack has a higher precedence, we must
      // pop it off the stack.
    } else {
      return operPrecedence(topOfStack) >= operPrecedence(readSymbol);
    }
  }

  public static String readString() throws IOException {
    char[] charArray = new char[80];
    int position = 0;
    char ch;
    while ((ch = (char) System.in.read()) != '\n') {
      charArray[position++] = ch;
    }
    // turns a character array into a string, starting between zero and
    // position-1
    return String.copyValueOf(charArray, 0, position);

  } // end read string

  public static double eval(String infixString) {
    char ch;
    int position;
    double operand1;
    double operand2;
    double value;
    Stack operandStack = new Stack();
    for (position = 0; position < infixString.length(); position++) {
      ch = infixString.charAt(position);
      // operand-convert the character representation of the digit into double
      // and push it into the stack
      if (Character.isDigit(ch)) {
        operandStack.push((double) Character.digit(ch, 10));
      } else {
        // operator
        operand2 = operandStack.pop();
        operand1 = operandStack.pop();
        value = oper(ch, operand1, operand2);
        operandStack.push(value);
      } // else
    } // end for
    return operandStack.pop();
  } // end eval

  public static String postfix(String infixString) {
    int position;
    int outPosition = 0;
    char symbol;
    char[] postfixString = new char[MAX_COLS];
    CharStack operatorStack = new CharStack();
    for (position = 0; position < infixString.length(); position++) {
      symbol = infixString.charAt(position);
      if (isOperand(symbol)) {
        postfixString[outPosition++] = symbol;
      } else {
        while (!operatorStack.empty() && precedence(operatorStack.peek(),
            symbol)) {
          postfixString[outPosition++] = operatorStack.pop();
        } // end while
        if (symbol != ')') {
          operatorStack.push(symbol);
        } else {
          operatorStack.pop();
        }
      } // end else

    } // end for
    while (!operatorStack.empty()) {
      postfixString[outPosition++] = operatorStack.pop();
    }
    return String.copyValueOf(postfixString, 0, outPosition);
  } // end postfix

  public static double oper(char symbol, double operand1, double operand2) {
    double value;
    switch (symbol) {
      case '+':
        value = operand1 + operand2;
        break;
      case '-':
        value = operand1 - operand2;
        break;
      case '*':
        value = operand1 * operand2;
        break;
      case '/':
        value = operand1 / operand2;
        break;
      case '$':
        value = Math.pow(operand1, operand2);
        break;
      default:
        throw new RuntimeException("illegal operator: " + symbol);
    } // end switch
    return value;
  } // end oper

}
