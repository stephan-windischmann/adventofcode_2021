package day12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Day12Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day12/input_test1";
    Map<String, List<String>> input = Main.loadInput(inputFile);

    int r = Day12.solvePart1(input);
    assertEquals(10, r);

    inputFile = "./input/day12/input_test2";
    input = Main.loadInput(inputFile);

    r = Day12.solvePart1(input);
    assertEquals(19, r);

    inputFile = "./input/day12/input_test3";
    input = Main.loadInput(inputFile);

    r = Day12.solvePart1(input);
    assertEquals(226, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day12/input_test1";
    Map<String, List<String>> input = Main.loadInput(inputFile);

    int r = Day12.solvePart2(input);
    assertEquals(36, r);

    inputFile = "./input/day12/input_test2";
    input = Main.loadInput(inputFile);

    r = Day12.solvePart2(input);
    assertEquals(103, r);

    inputFile = "./input/day12/input_test3";
    input = Main.loadInput(inputFile);

    r = Day12.solvePart2(input);
    assertEquals(3509, r);
  }
}