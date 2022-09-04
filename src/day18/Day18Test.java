package day18;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day18Test {

  @Test
  void solvePart1() {
    List<SnailfishNumber> numbers = Main.loadInput("./input/day18/input_test");

    int r = Day18.solvePart1(numbers);

    assertEquals(4140, r);
  }

  @Test
  void solvePart2() {
    List<SnailfishNumber> numbers = Main.loadInput("./input/day18/input_test");

    int r = Day18.solvePart2(numbers);

    assertEquals(3993, r);
  }
}