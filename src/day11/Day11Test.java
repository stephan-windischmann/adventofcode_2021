package day11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day11Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day11/input_test1";
    char[][] data = Main.loadInput(inputFile);

    int r = Day11.solvePart1(data, 2);
    assertEquals(9, r);

    inputFile = "./input/day11/input_test2";
    data = Main.loadInput(inputFile);

    r = Day11.solvePart1(data, 100);
    assertEquals(1656, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day11/input_test2";
    char[][] data = Main.loadInput(inputFile);

    int r = Day11.solvePart2(data);
    assertEquals(195, r);
  }
}