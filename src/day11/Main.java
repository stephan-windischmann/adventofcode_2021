package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static char[][] loadInput(String filename) {
    List<List<Character>> data = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {
        List<Character> l = new ArrayList<>();
        for (char c : line.toCharArray()) {
          l.add(c);
        }
        data.add(l);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    int w = data.get(0).size();
    int h = data.size();

    char[][] r = new char[h][w];
    for (int i = 0; i < h; ++i) {
      for (int j = 0; j < w; ++j) {
        r[i][j] = data.get(i).get(j);
      }
    }

    return r;
  }

  public static void main(String[] args) {
    char[][] data = loadInput("./input/day11/input");

    int r1 = Day11.solvePart1(data, 100);
    System.out.printf("Day 11 part 1 solution: %d\n", r1);

    data = loadInput("./input/day11/input");

    int r2 = Day11.solvePart2(data);
    System.out.printf("Day 11 part 2 solution: %d\n", r2);
  }
}
