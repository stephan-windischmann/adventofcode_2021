package day7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day7Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day7/input_test1";
    List<Integer> data = Main.loadInput(inputFile);

    int r = Day7.solvePart1(data);
    assertEquals(37, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day7/input_test1";
    List<Integer> data = Main.loadInput(inputFile);

    int r = Day7.solvePart2(data);
    assertEquals(168, r);
  }
}