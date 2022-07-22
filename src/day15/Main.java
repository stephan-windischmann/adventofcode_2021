package day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<List<Integer>> loadInput(String filename) {
    List<List<Integer>> map = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {
        List<Integer> l = new ArrayList<>();
        for (char c : line.toCharArray()) {
          l.add(c - '0');
        }
        map.add(l);
      }
  } catch (
  IOException e) {
    System.out.println("Exception: " + e);
    System.exit(-1);
  }

    return map;
  }

  public static void main(String[] args) {
    List<List<Integer>> map = loadInput("./input/day15/input");

    int r1 = Day15.solvePart1(map);
    System.out.printf("Day 15 part 1 solution: %d\n", r1);

    int r2 = Day15.solvePart2(map);
    System.out.printf("Day 15 part 2 solution: %d\n", r2);
  }
}
