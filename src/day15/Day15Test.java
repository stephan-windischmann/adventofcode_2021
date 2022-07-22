package day15;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Day15Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day15/input_test";
    List<List<Integer>> map = Main.loadInput(inputFile);

    int r = Day15.solvePart1(map);
    assertEquals(40, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day15/input_test";
    List<List<Integer>> map = Main.loadInput(inputFile);

    int r = Day15.solvePart2(map);
    assertEquals(315, r);
  }
}