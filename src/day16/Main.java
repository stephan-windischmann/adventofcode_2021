package day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static BitSet parseInput(String line) {
    Map<Character, boolean[]> mapping = new HashMap<>();

    mapping.put('0', new boolean[]{false, false, false, false});
    mapping.put('1', new boolean[]{false, false, false, true});
    mapping.put('2', new boolean[]{false, false, true, false});
    mapping.put('3', new boolean[]{false, false, true, true});
    mapping.put('4', new boolean[]{false, true, false, false});
    mapping.put('5', new boolean[]{false, true, false, true});
    mapping.put('6', new boolean[]{false, true, true, false});
    mapping.put('7', new boolean[]{false, true, true, true});
    mapping.put('8', new boolean[]{true, false, false, false});
    mapping.put('9', new boolean[]{true, false, false, true});
    mapping.put('A', new boolean[]{true, false, true, false});
    mapping.put('B', new boolean[]{true, false, true, true});
    mapping.put('C', new boolean[]{true, true, false, false});
    mapping.put('D', new boolean[]{true, true, false, true});
    mapping.put('E', new boolean[]{true, true, true, false});
    mapping.put('F', new boolean[]{true, true, true, true});

    BitSet r = new BitSet(line.length() * 4);

    int i = 0;
    for (char c : line.toCharArray()) {
      boolean[] cur = mapping.get(c);
      if (cur[0]) {
        r.set(i);
      }
      if (cur[1]) {
        r.set(i + 1);
      }
      if (cur[2]) {
        r.set(i + 2);
      }
      if (cur[3]) {
        r.set(i + 3);
      }
      i += 4;
    }

    return r;
  }

  public static BitSet loadInput(String filename) {
    Path p = Path.of(filename);

    try {
      String line = Files.readAllLines(p).get(0);
      return parseInput(line);
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }
    return new BitSet();
  }

  public static void main(String[] args) {
    BitSet input = loadInput("./input/day16/input");

    int r1 = Day16.solvePart1(input);
    System.out.printf("Day 16 part 1 solution: %d\n", r1);

    long r2 = Day16.solvePart2(input);
    System.out.printf("Day 16 part 1 solution: %d\n", r2);
  }
}
