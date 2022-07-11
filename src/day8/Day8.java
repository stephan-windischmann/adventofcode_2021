package day8;

import java.util.List;

public class Day8 {
  public static int solvePart1(List<InputLine> data) {
    int r = 0;

    for (InputLine line : data) {
      for (String s : line.getRight()) {
        if (s.length() == 2 || s.length() == 3 || s.length() == 4 || s.length() == 7) {
          ++r;
        }
      }
    }

    return r;
  }
}
