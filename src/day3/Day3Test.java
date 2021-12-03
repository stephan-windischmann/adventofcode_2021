package day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day3/input_test1";
    List<Boolean[]> data = Main.loadInput(inputFile);

    int r = Day3.solvePart1(data);
    assertEquals(198, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day3/input_test1";
    List<Boolean[]> data = Main.loadInput(inputFile);

    int r = Day3.solvePart2(data);
    assertEquals(230, r);
  }
}