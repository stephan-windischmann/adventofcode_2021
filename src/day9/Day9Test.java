package day9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Day9Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day9/input_test1";
    Cave cave = Main.loadInput(inputFile);

    int r = Day9.solvePart1(cave);
    assertEquals(15, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day9/input_test1";
    Cave cave = Main.loadInput(inputFile);

    int r = Day9.solvePart2(cave);
    assertEquals(1134, r);
  }
}