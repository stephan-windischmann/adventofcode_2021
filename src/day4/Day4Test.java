package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day4Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day4/input_test1";
    Bingo bingo = Main.loadInput(inputFile);

    int r = Day4.solvePart1(bingo);
    assertEquals(4512, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day4/input_test1";
    Bingo bingo = Main.loadInput(inputFile);

    int r = Day4.solvePart2(bingo);
    assertEquals(1924, r);
  }
}