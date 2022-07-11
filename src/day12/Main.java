package day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static Map<String, List<String>> loadInput(String filename) {
    Map<String, List<String>> data = new HashMap<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {
        String from = line.split("-")[0];
        String to = line.split("-")[1];

        List<String> l;
        if (data.containsKey(from)) {
          l = data.get(from);
        } else {
          l = new ArrayList<>();
        }
        l.add(to);
        data.put(from, l);

        if (data.containsKey(to)) {
          l = data.get(to);
        } else {
          l = new ArrayList<>();
        }
        l.add(from);
        data.put(to, l);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    Map<String, List<String>> input = loadInput("./input/day12/input");

    int r1 = Day12.solvePart1(input);
    System.out.printf("Day 12 part 1 solution: %d\n", r1);

    int r2 = Day12.solvePart2(input);
    System.out.printf("Day 12 part 2 solution: %d\n", r2);
  }
}
