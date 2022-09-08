package day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
  public static Input loadInput(String filename) {
    Path p = Path.of(filename);
    Input r = new Input();

    try {
      List<String> input = Files.readAllLines(p);

      r.setAlgorithm(input.get(0));

      char[][] picture = new char[input.size() - 2][input.get(2).length()];

      for (int i = 2; i < input.size(); ++i) {
        picture[i - 2] = input.get(i).toCharArray();
      }
      r.setPicture(picture);

    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return r;
  }

  public static void main(String[] args) {
    Input input = loadInput("./input/day20/input");

    int r1 = Day20.solvePart1(input);
    System.out.printf("Day 20 part 1 solution: %d\n", r1);

    int r2 = Day20.solvePart2(input);
    System.out.printf("Day 20 part 2 solution: %d\n", r2);
  }
}
