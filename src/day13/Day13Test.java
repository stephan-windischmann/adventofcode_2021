package day13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class Day13Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day13/input_test";
    Set<Coordinate> data = new HashSet<>();
    List<String> instructions = Main.loadInput(inputFile, data);

    int r = Day13.solvePart1(data, instructions);
    assertEquals(17, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day13/input_test";
    Set<Coordinate> data = new HashSet<>();
    List<String> instructions = Main.loadInput(inputFile, data);

    Day13.solvePart2(data, instructions);
  }
}