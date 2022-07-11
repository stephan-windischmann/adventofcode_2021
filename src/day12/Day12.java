package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12 {
    public static boolean isSmallCave(String cave) {
    return cave.equals(cave.toLowerCase());
  }

  public static boolean visitedSmallCaveTwice(List<String> path) {
    Map<String, Integer> count = new HashMap<>();

    for (String cave : path) {
      if (isSmallCave(cave)) {
        count.put(cave, count.getOrDefault(cave, 0) + 1);
      }
    }

    for (int c : count.values()) {
      if (c == 2) {
        return true;
      }
    }
    return false;
  }

  public static int solvePart1(Map<String, List<String>> input) {
    return dfsPart1(input, "start", new ArrayList<>());
  }

  public static int dfsPart1(Map<String, List<String>> input, String cur, List<String> path) {
    if (cur.equals("end")) {
      return 1;
    }

    if (isSmallCave(cur) && path.contains(cur)) {
      return 0;
    }

    List<String> newPath = new ArrayList<>(path);
    newPath.add(cur);

    int r = 0;

    for (String next : input.get(cur)) {
      r += dfsPart1(input, next, newPath);
    }

    return r;
  }

  public static int solvePart2(Map<String, List<String>> input) {
    return dfsPart2(input, "start", new ArrayList<>());
  }

  public static int dfsPart2(Map<String, List<String>> input, String cur, List<String> path) {
    if (cur.equals("end")) {
      return 1;
    }
    if (cur.equals("start") && path.contains("start")) {
      return 0;
    }

    if (isSmallCave(cur) && visitedSmallCaveTwice(path) && path.contains(cur)) {
      return 0;
    }

    List<String> newPath = new ArrayList<>(path);
    newPath.add(cur);

    int r = 0;

    for (String next : input.get(cur)) {
      r += dfsPart2(input, next, newPath);
    }

    return r;
  }
}
