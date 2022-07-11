package day4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Bingo {

  private List<Board> boards;
  private List<Integer> calledNumbers;

  public Bingo() {
    this.boards = new ArrayList<>();
    this.calledNumbers = new ArrayList<>();
  }

  public void addBoard(Board board) {
    this.boards.add(board);
  }

  public void addCalledNumber(int number) {
    this.calledNumbers.add(number);
  }

  public Board getFirstWinner() {
    for (int called : this.calledNumbers) {
      for (Board board : this.boards) {
        board.play(called);
        if (board.hasBingo()) {
          return board;
        }
      }
    }

    return null;
  }

  public Board getLastWinner() {
    HashSet<Integer> won = new HashSet<>();
    for (int called : this.calledNumbers) {
      for (int i = 0; i < this.boards.size(); ++i) {
        if (won.contains(i)) {
          continue;
        }
        this.boards.get(i).play(called);
        if (this.boards.get(i).hasBingo()) {
          if (won.size() == this.boards.size() - 1) {
            return boards.get(i);
          } else {
            won.add(i);
          }
        }
      }
    }

    return null;
  }
}