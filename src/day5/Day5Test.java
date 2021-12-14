package day5;

import static org.junit.jupiter.api.Assertions.*;

;
import java.util.List;
import org.junit.jupiter.api.Test;

class Day5Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day5/input_test1";
    List<Line> data = Main.loadInput(inputFile);

    int r = Day5.solvePart1(data);
    assertEquals(5, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day5/input_test1";
    List<Line> data = Main.loadInput(inputFile);

    int r = Day5.solvePart2(data);
    assertEquals(12, r);
  }
}