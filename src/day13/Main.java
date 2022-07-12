package day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
  public static List<String> loadInput(String filename, Set<Coordinate> data) {
    List<String> instructions = new ArrayList<>();

    Path p = Path.of(filename);

    try  {
      List<String> input = Files.readAllLines(p);

      List<String> coordinates = input.stream().filter(c -> c.split(",").length == 2).toList();
      instructions = input.stream().filter(c -> c.startsWith("fold")).toList();

      for (String s : coordinates) {
        int x = Integer.parseInt(s.split(",")[0]);
        int y = Integer.parseInt(s.split(",")[1]);

        Coordinate c = new Coordinate(x, y);
        data.add(c);
      }

    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return instructions;
  }

  public static void main(String[] args) {
    Set<Coordinate> data = new HashSet<>();
    List<String> instructions = loadInput("./input/day13/input", data);

    int r1 = Day13.solvePart1(data, instructions);
    System.out.printf("Day 13 part 1 solution: %d\n", r1);

    data = new HashSet<>();
    instructions = loadInput("./input/day13/input", data);
    Day13.solvePart2(data, instructions);
  }
}
