package day2;

import java.util.List;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
  @Test
  void solvePart1() {
    String inputFile = "./input/day2/input_test1";
    List<String> data = Main.loadInput(inputFile);

    int r = Day2.solvePart1(data);
    assertEquals(150, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day2/input_test1";
    List<String> data = Main.loadInput(inputFile);

    int r = Day2.solvePart2(data);
    assertEquals(900, r);
  }
}