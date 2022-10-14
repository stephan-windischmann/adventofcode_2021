package day24;

import java.util.ArrayList;
import java.util.List;

public class Day24 {
  // Input program decoded for increased performance.
  public static long aluProgram(int depth, int w, long z) {
    int[] a = new int[]{12, 11, 13, 11, 14, -10, 11, -9, -3, 13, -5, -10, -4, -5};
    int[] b = new int[]{1, 1, 1, 1, 1, 26, 1, 26, 26, 1, 26, 26, 26, 26};
    int[] c = new int[]{4, 11, 5, 11, 14, 7, 11, 4, 6, 5, 9, 12, 14, 14};

    if (z % 26 + a[depth] == w) {
      return z / b[depth];
    } else {
      return 26 * (z / b[depth]) + w + c[depth];
    }
  }

  public static void solvePart1Helper(int depth, long z, String solution, List<String> valid) {
    // Max allowed z value per depth
    long[] maxZ = new long[]{8031810176L, 8031810176L, 8031810176L, 8031810176L, 8031810176L,
        8031810176L, 308915776, 308915776, 11881376, 456976, 456976, 17576, 676, 26};
    if (depth == 14) {
      if (z == 0) {
        valid.add(solution);
      }
      return;
    }

    if (z >= maxZ[depth]) {
      return;
    }

    List<String> solutions = new ArrayList<>();
    for (int i = 1; i < 10; ++i) {
      long newZ = aluProgram(depth, i, z);
      solvePart1Helper(depth + 1, newZ, solution + String.valueOf(i), valid);
    }
  }

  public static String solvePart1() {
    List<String> valid = new ArrayList<>();

    solvePart1Helper(0, 0, "", valid);

    return valid.get(valid.size() - 1);
  }

  public static String solvePart2() {
    List<String> valid = new ArrayList<>();

    solvePart1Helper(0, 0, "", valid);

    return valid.get(0);
  }
}
