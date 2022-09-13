package day22;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class Day22Test {

  @Test
  void solvePart1() {
    List<Integer[]> input = Main.loadInput("./input/day22/input_test1");
    int r = Day22.solvePart1(input);

    assertEquals(39, r);

    input = Main.loadInput("./input/day22/input_test2");
    r = Day22.solvePart1(input);

    assertEquals(590784, r);
  }

  @Test
  void solvePart2() {
    List<Integer[]> input = Main.loadInput("./input/day22/input_test1");
    long r = Day22.solvePart2(input);

    assertEquals(39L, r);

    input = Main.loadInput("./input/day22/input_test3");
    r = Day22.solvePart2(input);

    assertEquals(2758514936282235L, r);
  }
}