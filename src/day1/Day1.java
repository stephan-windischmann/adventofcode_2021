package day1;

import java.util.List;

public class Day1 {
  public static int solvePart1(List<Integer> data) {
    int r = 0;
    for (int i = 1; i < data.size(); ++i) {
      if (data.get(i) > data.get(i - 1)) {
        ++r;
      }
    }
    return r;
  }

  public static int solvePart2(List<Integer> data) {
    int r = 0;

    if (data.size() < 4) {
      return r;
    }

    int window = data.get(0) + data.get(1) + data.get(2);

    for (int i = 3; i < data.size(); ++i) {
      if (data.get(i) > data.get(i - 3)) {
        ++r;
      }
    }

    return r;
  }
}
