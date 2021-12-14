package day7;

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
      String[] input = Files.readString(p).strip().split(",");

      for (String x : input) {
        int curPos = Integer.parseInt(x);
        data.add(curPos);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    List<Integer> data = loadInput("./input/day7/input");

    int r1 = Day7.solvePart1(data);
    System.out.printf("Day 7 part 1 solution: %d\n", r1);

    int r2 = Day7.solvePart2(data);
    System.out.printf("Day 7 part 2 solution: %d\n", r2);
  }
}