package day17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day17Test {

  @Test
  void solvePart1() {
    Area area = Main.loadInput("./input/day17/input_test");

    int r = Day17.solvePart1(area);

    assertEquals(45, r);
  }

  @Test
  void solvePart2() {
    Area area = Main.loadInput("./input/day17/input_test");

    int r = Day17.solvePart2(area);

    assertEquals(112, r);
  }
}