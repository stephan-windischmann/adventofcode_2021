package day8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private static boolean contains(String needle, String haystack) {
    for (char c : needle.toCharArray()) {
      if (!haystack.contains(Character.toString(c))) {
        return false;
      }
    }
    return true;
  }
  public static int solvePart2(List<InputLine> data) {
    int r = 0;

    for (InputLine line : data) {
      // Write all 10 to set
      Set<String> inputs = new HashSet<>(line.getLeft());

      Map<String, Integer> linesToNumber = new HashMap<>();
      String[] numberToLines = new String[10];

      // First collect easy digits
      Iterator<String> iter = inputs.iterator();
      while (iter.hasNext()) {
        String s = iter.next();
        switch (s.length()) {
          case 2 -> {
            linesToNumber.put(s, 1);
            numberToLines[1] = s;
            iter.remove();
          }
          case 3 -> {
            linesToNumber.put(s, 7);
            numberToLines[7] = s;
            iter.remove();
          }
          case 4 -> {
            linesToNumber.put(s, 4);
            numberToLines[4] = s;
            iter.remove();
          }
          case 7 -> {
            linesToNumber.put(s, 8);
            numberToLines[8] = s;
            iter.remove();
          }
        }
      }


      // 3 is only len 5 that contains all inputs of 1
      iter = inputs.iterator();
      while (iter.hasNext()) {
        String s = iter.next();
        if (s.length() == 5) {
          if (contains(numberToLines[1], s)) {
            linesToNumber.put(s, 3);
            numberToLines[3] = s;
            iter.remove();
            break;
          }
        }
      }

      // 9 is the only len 6 that contains all input of 4
      iter = inputs.iterator();
      while (iter.hasNext()) {
        String s = iter.next();
        if (s.length() == 6) {
          if (contains(numberToLines[4], s)) {
            linesToNumber.put(s, 9);
            numberToLines[9] = s;
            iter.remove();
            break;
          }
        }
      }

      // 5 is only len 5 that matches all but one input in 9
      iter = inputs.iterator();
      while (iter.hasNext()) {
        String s = iter.next();
        if (s.length() == 5) {
          if (contains(s, numberToLines[9])) {
            linesToNumber.put(s, 5);
            numberToLines[5] = s;
            iter.remove();
            break;
          }
        }
      }

      // The last remaining len 5 must be 2
      iter = inputs.iterator();
      while (iter.hasNext()) {
        String s = iter.next();
        if (s.length() == 5) {
            linesToNumber.put(s, 2);
            numberToLines[2] = s;
            iter.remove();
            break;
        }
      }

      // 0 is the only remaining len 6 that contains all inputs of 1
      iter = inputs.iterator();
      while (iter.hasNext()) {
        String s = iter.next();
        if (s.length() == 6) {
          if (contains(numberToLines[1], s)) {
            linesToNumber.put(s, 0);
            numberToLines[0] = s;
            iter.remove();
            break;
          }
        }
      }

      // The last remaining entry in the set must be 6
      iter = inputs.iterator();
      String s = iter.next();
      linesToNumber.put(s, 6);
      numberToLines[6] = s;
      iter.remove();

      StringBuilder output = new StringBuilder();
      for (String d : line.getRight()) {
        output.append(linesToNumber.get(d));
      }
      r += Integer.parseInt(output.toString());
    }

    return r;
  }
}
