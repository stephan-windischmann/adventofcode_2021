package day19;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day19Test {

  @Test
  void solvePart1() {
    List<List<Point>> scanners = Main.loadInput("./input/day19/input_test");

    int r = Day19.solvePart1(scanners);

    assertEquals(79, r);
  }

  @Test
  void solvePart2() {
    List<List<Point>> scanners = Main.loadInput("./input/day19/input_test");

    int r = Day19.solvePart2(scanners);

    assertEquals(3621, r);
  }
}