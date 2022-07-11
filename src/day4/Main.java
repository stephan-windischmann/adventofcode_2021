package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static Bingo loadInput(String filename) {
    Bingo bingo = new Bingo();
    Path p = Path.of(filename);

    try {
      List<String> data = Files.readAllLines(p);

      String calledNumbers = data.get(0);
      for (String s : calledNumbers.split(",")) {
        int n = Integer.parseInt(s.strip());
        bingo.addCalledNumber(n);
      }

      int i = 2;
      while (i < data.size()) {
        if (data.get(i).isBlank()) {
          ++i;
          continue;
        }

        int[][] board = new int[5][5];
        for (int j = 0; j < 5; ++j) {
          String line = data.get(i);
          ++i;
          int col = 0;
          for (String s : line.strip().split("\\s+")) {
            board[j][col] = Integer.parseInt(s);
            ++col;
          }
        }
        Board b = new Board(board);
        bingo.addBoard(b);
      }

    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return bingo;
  }

  public static void main(String[] args) {
    Bingo bingo = loadInput("./input/day4/input");

    int r1 = Day4.solvePart1(bingo);
    System.out.printf("Day 4 part 1 solution: %d\n", r1);

    int r2 = Day4.solvePart2(bingo);
    System.out.printf("Day 4 part 2 solution: %d\n", r2);
  }
}