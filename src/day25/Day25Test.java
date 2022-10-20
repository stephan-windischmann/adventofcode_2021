package day25;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day25Test {

  @Test
  void solvePart1() {
    char[][] data = Main.loadInput("./input/day25/input_test");

    int r = Day25.solvePart1(data);

    assertEquals(58, r);
  }
}