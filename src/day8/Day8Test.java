package day8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day8Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day8/input_test1";
    List<InputLine> data = Main.loadInput(inputFile);

    int r = Day8.solvePart1(data);
    assertEquals(26, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day8/input_test1";
    List<InputLine> data = Main.loadInput(inputFile);

    int r = Day8.solvePart2(data);
    assertEquals(61229, r);
  }
}