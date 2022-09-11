package day21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class Day21Test {

  @Test
  void solvePart1() {
    List<Integer> startPos = Main.loadInput("./input/day21/input_test");
    int r = Day21.solvePart1(startPos);

    assertEquals(739785, r);
  }

  @Test
  void solvePart2() {
    List<Integer> startPos = Main.loadInput("./input/day21/input_test");
    long r = Day21.solvePart2(startPos);

    assertEquals(444356092776315L, r);
  }
}