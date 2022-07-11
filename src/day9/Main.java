package day9;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
  public static Cave loadInput(String filename) {
    Cave cave = new Cave();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {

        cave.addRow(line);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return cave;
  }

  public static void main(String[] args) {
    Cave cave = loadInput("./input/day9/input");

    int r1 = Day9.solvePart1(cave);
    System.out.printf("Day 9 part 1 solution: %d\n", r1);

    int r2 = Day9.solvePart2(cave);
    System.out.printf("Day 8 part 2 solution: %d\n", r2);
  }
}