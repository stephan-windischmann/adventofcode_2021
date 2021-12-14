package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<Line> loadInput(String filename) {
    List<Line> data = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {
        String from = line.split("->")[0].strip();
        String to = line.split("->")[1].strip();
        int x1 = Integer.parseInt(from.split(",")[0]);
        int y1 = Integer.parseInt(from.split(",")[1]);
        int x2 = Integer.parseInt(to.split(",")[0]);
        int y2 = Integer.parseInt(to.split(",")[1]);
        data.add(new Line(new Point(x1, y1), new Point(x2, y2)));
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    List<Line> data = loadInput("./input/day5/input");

    int r1 = Day5.solvePart1(data);
    System.out.printf("Day 5 part 1 solution: %d\n", r1);

    int r2 = Day5.solvePart2(data);
    System.out.printf("Day 5 part 2 solution: %d\n", r2);
  }
}