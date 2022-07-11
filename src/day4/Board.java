package day4;

import com.sun.jdi.ArrayReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
  private final int[][] board;
  private final HashMap<Integer, Position> numbers;
  private int lastCalled;

  public Board(int[][] board) {
    this.board = board;
    this.numbers = new HashMap<>();
    for (int i = 0; i < 5; ++i) {
      for (int j = 0; j < 5; ++j) {
        numbers.put(this.board[i][j], new Position(j, i));
      }
    }
  }

  public void play(int number) {
    lastCalled = number;
    if (this.numbers.containsKey(number)) {
      Position pos = this.numbers.get(number);
      this.board[pos.getY()][pos.getX()] = -1;
    }
  }

  private boolean checkRow(int row) {
    for (int i = 0; i < 5; ++i) {
      if (this.board[row][i] != -1) {
        return false;
      }
    }
    return true;
  }

  private boolean checkColumn(int col) {
    for (int i = 0; i < 5; ++i) {
      if (this.board[i][col] != -1) {
        return false;
      }
    }
    return true;
  }

  public boolean hasBingo() {
    for (int i = 0; i < 5; ++i) {
      if (this.checkRow(i)) {
        return true;
      }
      if (this.checkColumn(i)) {
        return true;
      }
    }
    return false;
  }

  public int getScore() {
    int score = 0;

    for (int i = 0; i < 5; ++i) {
      for (int j = 0; j < 5; ++j) {
        if (board[i][j] != -1) {
          score += this.board[i][j];
        }
      }
    }

    return score * this.lastCalled;
  }

  public void printBoard() {
    for (int i = 0; i < 5; ++i) {
      for (int j = 0; j < 5; ++j) {
        System.out.printf("%d ", this.board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }
}
