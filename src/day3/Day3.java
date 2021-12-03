package day3;

import java.util.*;

public class Day3 {
  public static int solvePart1(List<Boolean[]> data) {
    int gamma = 0, epsilon = 0;

    for (int i = 0; i < data.get(0).length; ++i) {
      int countOne = 0;
      for (int j = 0; j < data.size(); ++j) {
        if (data.get(j)[i]) {
          ++countOne;
        }
      }
      if (countOne > data.size() / 2) {
        gamma |= 1 << ((data.get(0).length - 1) - i);
      } else {
        epsilon |= 1 << ((data.get(0).length - 1) - i);
      }
    }

    return gamma * epsilon;
  }

  public static int boolArrayToInt(Boolean[] arr) {
    int num = 0;

    for (int i = 0; i < arr.length; ++i) {
      if (arr[arr.length - 1 - i]) {
        num += Math.pow(2, i);
      }
    }
    return num;
  }

  public static Boolean[] reduceData(List<Boolean[]> data, boolean leastCommon) {
    int i = 0;
    while (data.size() > 1) {
      int countOne = 0;
      for (Boolean[] value : data) {
        if (value[i]) {
          ++countOne;
        }
      }

      boolean keep = countOne >= data.size() - countOne;
      if (leastCommon) {
        keep = !keep;
      }

      List<Boolean[]> newData = new ArrayList<>();
      for (Boolean[] booleans : data) {
        if (booleans[i] == keep) {
          newData.add(booleans);
        }
      }
      data = newData;
      ++i;
    }
    return data.get(0);
  }

  public static int solvePart2(List<Boolean[]> data) {
    Boolean[] oxRating = reduceData(new ArrayList<>(data), false);
    Boolean[] co2ScrubRating = reduceData(new ArrayList<>(data), true);

    return boolArrayToInt(oxRating) * boolArrayToInt(co2ScrubRating);
  }
}
