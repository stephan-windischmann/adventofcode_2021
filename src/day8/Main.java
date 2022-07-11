package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static List<InputLine> loadInput(String filename) {
    List<InputLine> data = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {

        String leftString = line.split("\\|")[0].strip();
        String rightSting = line.split("\\|")[1].strip();

        List<String> left = Arrays.asList(leftString.split("\\s+"));
        List<String> right = Arrays.asList(rightSting.split("\\s+"));

        data.add(new InputLine(left, right));
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    List<InputLine> data = loadInput("./input/day8/input");

    int r1 = Day8.solvePart1(data);
    System.out.printf("Day 8 part 1 solution: %d\n", r1);

    /*int r2 = Day8.solvePart2(data);
    System.out.printf("Day 8 part 2 solution: %d\n", r2);*/
  }
}