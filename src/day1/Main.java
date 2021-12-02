package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<Integer> loadInput(String filename) {
    List<Integer> data = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {
        data.add(Integer.valueOf(line));
      }
    } catch (IOException | NumberFormatException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    List<Integer> data = loadInput("./input/day1/input");

    int r1 = Day1.solvePart1(data);
    System.out.printf("Day 1 part 1 solution: %d\n", r1);

    int r2 = Day1.solvePart2(data);
    System.out.printf("Day 1 part 2 solution: %d\n", r2);
  }
}