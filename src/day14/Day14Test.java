package day14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Day14Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day14/input_test";
    Map<String, String> rules = new HashMap<>();
    String template  = Main.loadInput(inputFile, rules);

    int r = Day14.solvePart1(template, rules, 10);
    assertEquals(1588, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day14/input_test";
    Map<String, String> rules = new HashMap<>();
    String template  = Main.loadInput(inputFile, rules);

    long r = Day14.solvePart2(template, rules, 40);
    assertEquals(2188189693529L, r);
  }
}