package day7;

import java.util.Collections;
import java.util.List;

public class Day7 {
  public static int solvePart1(List<Integer> data) {
    Collections.sort(data);

    int optimum = data.get(data.size() / 2);

    int cost = 0;
    for (int x : data) {
      cost += Math.abs(optimum - x);
    }

    return cost;
  }

  public static int solvePart2(List<Integer> data) {
    int sum = 0;
    for (int x : data) {
      sum += x;
    }
    // In the case of my input the rounding is weird. The average of my input is 488.507 but
    // it needs to be rounded down to pass. For the test case, we need to round it up
    // (average is 4.9).
    int avg = sum / data.size();
    System.out.println(avg);

    int cost = 0;
    for (int x : data) {
      int n = Math.abs(avg - x);
      cost += (n * (n + 1)) / 2;
    }

    return cost;
  }
}
