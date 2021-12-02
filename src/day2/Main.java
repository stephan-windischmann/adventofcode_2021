package day2;

import day1.Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<String> loadInput(String filename) {
    List<String> data = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      data = Files.readAllLines(p);
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return data;
  }

  public static void main(String[] args) {
    List<String> data = loadInput("./input/day2/input");

    int r1 = Day2.solvePart1(data);
    System.out.printf("Day 2 part 1 solution: %d\n", r1);

    int r2 = Day2.solvePart2(data);
    System.out.printf("Day 2 part 2 solution: %d\n", r2);
  }
}