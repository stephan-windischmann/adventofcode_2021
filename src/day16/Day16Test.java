package day16;

import static org.junit.jupiter.api.Assertions.*;

import java.util.BitSet;
import org.junit.jupiter.api.Test;

class Day16Test {

  @Test
  void solvePart1() {
    String line = "D2FE28";
    BitSet input = Main.parseInput(line);
    int r = Day16.solvePart1(input);
    assertEquals(6, r);

    line = "8A004A801A8002F478";
    input = Main.parseInput(line);
    r = Day16.solvePart1(input);
    assertEquals(16, r);

    line = "620080001611562C8802118E34";
    input = Main.parseInput(line);
    r = Day16.solvePart1(input);
    assertEquals(12, r);

    line = "C0015000016115A2E0802F182340";
    input = Main.parseInput(line);
    r = Day16.solvePart1(input);
    assertEquals(23, r);

    line = "A0016C880162017C3686B18A3D4780";
    input = Main.parseInput(line);
    r = Day16.solvePart1(input);
    assertEquals(31, r);
  }

  @Test
  void solvePart2() {
    String line = "C200B40A82";
    BitSet input = Main.parseInput(line);
    long r = Day16.solvePart2(input);
    assertEquals(3, r);

    line = "04005AC33890";
    input = Main.parseInput(line);
    r = Day16.solvePart2(input);
    assertEquals(54, r);

    line = "880086C3E88112";
    input = Main.parseInput(line);
    r = Day16.solvePart2(input);
    assertEquals(7, r);

    line = "CE00C43D881120";
    input = Main.parseInput(line);
    r = Day16.solvePart2(input);
    assertEquals(9, r);

    line = "D8005AC2A8F0";
    input = Main.parseInput(line);
    r = Day16.solvePart2(input);
    assertEquals(1, r);

    line = "F600BC2D8F";
    input = Main.parseInput(line);
    r = Day16.solvePart2(input);
    assertEquals(0, r);

    line = "9C005AC2F8F0";
    input = Main.parseInput(line);
    r = Day16.solvePart2(input);
    assertEquals(0, r);

    line = "9C0141080250320F1802104A08";
    input = Main.parseInput(line);
    r = Day16.solvePart2(input);
    assertEquals(1, r);
  }
}