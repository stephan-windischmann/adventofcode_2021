package day4;

public class Day4 {

  public static int solvePart1(Bingo bingo) {
    Board winner = bingo.getFirstWinner();
    if (winner == null) {
      return -1;
    }
    return winner.getScore();
  }

  public static int solvePart2(Bingo bingo) {
    Board winner = bingo.getLastWinner();
    if (winner == null) {
      return -1;
    }
    return winner.getScore();
  }
}