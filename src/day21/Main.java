package day21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<Integer> loadInput(String filename) {
    List<Integer> startPos = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      List<String> input = Files.readAllLines(p);

      String[] line = input.get(0).split("\s");
      startPos.add(Integer.parseInt(line[line.length - 1]));
      line = input.get(1).split("\s");
      startPos.add(Integer.parseInt(line[line.length - 1]));

    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return startPos;
  }

  public static void main(String[] args) {
    List<Integer> startPos = loadInput("./input/day21/input");

    int r1 = Day21.solvePart1(startPos);
    System.out.printf("Day 21 part 1 solution: %d\n", r1);

    long r2 = Day21.solvePart2(startPos);
    System.out.printf("Day 21 part 2 solution: %d\n", r2);
  }
}
