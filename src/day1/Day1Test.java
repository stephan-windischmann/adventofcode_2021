package day1;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day1/input_test1";
    List<Integer> data = Main.loadInput(inputFile);

    int r = Day1.solvePart1(data);
    assertEquals(7, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day1/input_test1";
    List<Integer> data = Main.loadInput(inputFile);

    int r = Day1.solvePart2(data);
    assertEquals(5, r);
  }
}