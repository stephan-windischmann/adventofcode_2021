package day6;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
  public static List<Lanternfish> loadInput(String filename) {
    List<Lanternfish> data = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      String[] input = Files.readString(p).strip().split(",");

      int maxAge = 6;
      for (String x : input) {
        int curAge = Integer.parseInt(x);
        Lanternfish fish = new Lanternfish(maxAge, curAge);
        data.add(fish);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    List<Lanternfish> data = loadInput("./input/day6/input");

    int r1 = Day6.solvePart1(data, 80);
    System.out.printf("Day 6 part 1 solution: %d\n", r1);

    data = loadInput("./input/day6/input");
    long r2 = Day6.solvePart2(data, 256);
    System.out.printf("Day 6 part 2 solution: %d\n", r2);
  }
}