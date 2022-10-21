package day23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day23Test {

  @Test
  void solvePart1() {
    Room room = Main.loadInput("./input/day23/input_test");

    int r = Day23.solvePart1(room);
    assertEquals(12521, r);
  }

  @Test
  void solvePart2() {
    RoomPart2 room = Main.loadInputPart2("./input/day23/input_test_part2");

    int r = Day23.solvePart2(room);
    assertEquals(44169, r);
  }
}