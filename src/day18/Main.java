package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static int parseSnailfishNumber(String line, int i, SnailfishNumber num) {
    if (line.charAt(i) == '[') {
      ++i;
      SnailfishNumber l = new SnailfishNumber();
      SnailfishNumber r = new SnailfishNumber();
      i = parseSnailfishNumber(line, i, l);
      ++i;
      i = parseSnailfishNumber(line, i, r);
      num.left = l;
      num.right = r;
      ++i;
    } else {
      StringBuilder n = new StringBuilder();
      while (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
        n.append(line.charAt(i));
        ++i;
      }
      num.setValue(Integer.parseInt(n.toString()));
    }

    return i;
  }

  public static List<SnailfishNumber> loadInput(String filename) {
    Path p = Path.of(filename);

    ArrayList<SnailfishNumber> r = new ArrayList<>();

    try {
      for (String line : Files.readAllLines(p)) {
        SnailfishNumber num = new SnailfishNumber();
        parseSnailfishNumber(line, 0, num);
        r.add(num);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return r;
  }

  public static void main(String[] args) {
    List<SnailfishNumber> numbers = loadInput("./input/day18/input");

    int r1 = Day18.solvePart1(numbers);
    System.out.printf("Day 18 part 1 solution: %d\n", r1);

    numbers = loadInput("./input/day18/input");
    int r2 = Day18.solvePart2(numbers);
    System.out.printf("Day 18 part 2 solution: %d\n", r2);
  }
}
