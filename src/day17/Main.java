package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
  public static Area loadInput(String filename) {
    Path p = Path.of(filename);

    Area area = null;

    try {
      String line = Files.readAllLines(p).get(0);

      line = line.substring(13);
      String x = line.split(",")[0].strip().substring(2);
      String y = line.split(",")[1].strip().substring(2);

      int xMin = Integer.parseInt(x.split("\\.\\.")[0]);
      int xMax = Integer.parseInt(x.split("\\.\\.")[1]);
      int yMin = Integer.parseInt(y.split("\\.\\.")[0]);
      int yMax = Integer.parseInt(y.split("\\.\\.")[1]);

      area = new Area(xMin, xMax, yMin, yMax);

    } catch (
        IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return area;
  }

  public static void main(String[] args) {
    Area area = loadInput("./input/day17/input");

    int r1 = Day17.solvePart1(area);
    System.out.printf("Day 17 part 1 solution: %d\n", r1);

    int r2 = Day17.solvePart2(area);
    System.out.printf("Day 17 part 1 solution: %d\n", r2);
  }
}
