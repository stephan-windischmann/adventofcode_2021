package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<Boolean[]> loadInput(String filename) {
    List<Boolean[]> data = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {
        Boolean[] bits = new Boolean[line.length()];
        for (int i = 0; i < line.length(); ++i) {
          if (line.charAt(i) == '1') {
            bits[i] = true;
          } else {
            bits[i] = false;
          }
        }
        data.add(bits);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    List<Boolean[]> data = loadInput("./input/day3/input");

    int r1 = Day3.solvePart1(data);
    System.out.printf("Day 3 part 1 solution: %d\n", r1);

    int r2 = Day3.solvePart2(data);
    System.out.printf("Day 3 part 2 solution: %d\n", r2);
  }
}