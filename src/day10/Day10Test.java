package day10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day10Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day10/input_test1";
    List<String> data = Main.loadInput(inputFile);

    int r = Day10.solvePart1(data);
    assertEquals(26397, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day10/input_test1";
    List<String> data = Main.loadInput(inputFile);

    long r = Day10.solvePart2(data);
    assertEquals(288957, r);
  }
}