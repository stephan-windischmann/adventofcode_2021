package day20;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day20Test {

  @Test
  void solvePart1() {
    Input input = Main.loadInput("./input/day20/input_test");

    int r = Day20.solvePart1(input);

    assertEquals(35, r);
  }

  @Test
  void solvePart2() {
    Input input = Main.loadInput("./input/day20/input_test");

    int r = Day20.solvePart2(input);

    assertEquals(3351, r);
  }
}