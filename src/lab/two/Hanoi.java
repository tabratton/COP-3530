package lab.two;

import java.util.Scanner;

public class Hanoi {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of disks: ");
    int disks = scanner.nextInt();
    System.out.printf("The total number of moves to move %d disks is: %d%n",
        disks, findNumberOfMoves(disks));
    moveDisk(disks, 'A', 'C', 'B');
  }

  private static void moveDisk(int disk, char start, char end, char auxiliary) {
    if (disk == 1) {
      System.out.printf("MOVE disk %d FROM Peg %c TO Peg %c%n", disk, start,
          end);
      return;
    }

    moveDisk(disk - 1, start, auxiliary, end);
    System.out.printf("MOVE disk %d FROM Peg %c TO Peg %c%n", disk, start, end);
    moveDisk(disk - 1, auxiliary, end, start);
  }

  private static long findNumberOfMoves(int disks) {
    if (disks == 1) {
      return 1;
    } else {
      return (findNumberOfMoves(disks - 1) * 2) + 1;
    }
  }
}
