package day10;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
  public static List<String> loadInput(String filename) {
    Path p = Path.of(filename);

    try {
      return Files.readAllLines(p);
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }
    return null;
  }

  public static void main(String[] args) {
    List<String> data = loadInput("./input/day10/input");

    int r1 = Day10.solvePart1(data);
    System.out.printf("Day 10 part 1 solution: %d\n", r1);

    long r2 = Day10.solvePart2(data);
    System.out.printf("Day 10 part 2 solution: %d\n", r2);
  }
}