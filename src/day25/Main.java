package day25;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
  public static char[][] loadInput(String filename) {
    Path p = Path.of(filename);

    try {
      List<String> data = Files.readAllLines(p);

      char[][] r = new char[data.size()][data.get(0).length()];

      for (int i = 0; i < data.size(); ++i) {
        for (int j = 0; j < data.get(i).length(); ++j) {
          r[i][j] = data.get(i).charAt(j);
        }
      }
      return r;
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return new char[0][0];
  }

  public static void main(String[] args) {
    char[][] data = loadInput("./input/day25/input");

    int r1 = Day25.solvePart1(data);
    System.out.printf("Day 25 part 1 solution: %d\n", r1);
  }
}
