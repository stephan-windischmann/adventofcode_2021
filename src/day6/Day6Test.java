package day6;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Day6Test {

  @Test
  void solvePart1() {
    String inputFile = "./input/day6/input_test1";
    List<Lanternfish> data = Main.loadInput(inputFile);

    int r = Day6.solvePart1(data, 80);
    assertEquals(5934, r);
  }

  @Test
  void solvePart2() {
    String inputFile = "./input/day6/input_test1";
    List<Lanternfish> data = Main.loadInput(inputFile);

    long r = Day6.solvePart2(data, 256);
    assertEquals(26984457539L, r);
  }
}