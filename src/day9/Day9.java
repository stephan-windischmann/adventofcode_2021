package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {
  public static int solvePart1(Cave cave) {
    int r = 0;

    for (int i = 0; i < cave.getWidth(); ++i) {
      for (int j = 0; j < cave.getHeight(); ++j) {
        if (cave.isLowPoint(i, j)) {
          r += (1 + cave.getDepth(i, j));
        }
      }
    }

    return r;
  }

  public static int solvePart2(Cave cave) {
    List<Integer> basinSizes = new ArrayList<>();

    for (int i = 0; i < cave.getWidth(); ++i) {
      for (int j = 0; j < cave.getHeight(); ++j) {
        if (cave.isLowPoint(i, j)) {
          basinSizes.add(cave.getBasinSize(i, j));
        }
      }
    }
    Collections.sort(basinSizes);
    Collections.reverse(basinSizes);
    return basinSizes.get(0) * basinSizes.get(1) * basinSizes.get(2);
  }
}
