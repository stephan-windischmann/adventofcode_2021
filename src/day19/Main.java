package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<List<Point>> loadInput(String filename) {
    List<List<Point>> scanners = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      List<Point> currentReading = new ArrayList<>();
      for (String line : Files.readAllLines(p)){
        if (line.startsWith("---")) {
          continue;
        }
        if (line.isBlank()) {
          scanners.add(currentReading);
          currentReading = new ArrayList<>();
          continue;
        }
        int x = Integer.parseInt(line.split(",")[0]);
        int y = Integer.parseInt(line.split(",")[1]);
        int z = Integer.parseInt(line.split(",")[2]);
        currentReading.add(new Point(x, y, z));
      }
      scanners.add(currentReading);
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return scanners;
  }

  public static void main(String[] args) {
    List<List<Point>> scanners = Main.loadInput("./input/day19/input");

    int r1 = Day19.solvePart1(scanners);
    System.out.printf("Day 19 part 1 solution: %d\n", r1);

    scanners = Main.loadInput("./input/day19/input"); // Reload input
    int r2 = Day19.solvePart2(scanners);
    System.out.printf("Day 19 part 1 solution: %d\n", r2);
  }
}
