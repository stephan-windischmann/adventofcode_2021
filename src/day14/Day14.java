package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 {
  public static int solvePart1(String template, Map<String, String> rules, int steps) {
    for (int i = 0; i < steps; ++i) {
      for(int j = 0; j < template.length() - 1; j += 2) {
        String insert = rules.get(template.substring(j, j + 2));
        template = template.substring(0, j + 1) + insert + template.substring(j + 1);
      }
    }

    Map<Character, Integer> count = new HashMap<>();
    for (Character c : template.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    List<Integer> countList = new ArrayList<>(count.values());
    Collections.sort(countList);

    return countList.get(countList.size() - 1) - countList.get(0);
  }

  public static long solvePart2(String template, Map<String, String> rules, int steps) {
    Map<String, Long> pairs = new HashMap<>();
    for (int i = 0; i < template.length() - 1; ++i) {
      String curPair = template.substring(i, i + 2);
      pairs.put(curPair, pairs.getOrDefault(curPair, 0L) + 1);
    }

    for (int i = 0; i < steps; ++i) {
      Map<String, Long> newPairs = new HashMap<>();
      for (Map.Entry<String, Long> e : pairs.entrySet()) {
        String p = e.getKey();
        newPairs.put(
            p.charAt(0) + rules.get(p),
            newPairs.getOrDefault(p.charAt(0) + rules.get(p), 0L) + e.getValue());
        newPairs.put(
            rules.get(p) + p.charAt(1),
            newPairs.getOrDefault(rules.get(p) + p.charAt(1), 0L) + e.getValue());
      }
      pairs = newPairs;
    }

    Map<Character, Long> count = new HashMap<>();
    for (Map.Entry<String, Long> e : pairs.entrySet()) {
      count.put(
          e.getKey().charAt(0),
          count.getOrDefault(e.getKey().charAt(0), 0L) + e.getValue());
    }
    // Workaround for last character:
    count.put(
        template.charAt(template.length() - 1),
        count.getOrDefault(template.charAt(template.length() - 1), 0L) + 1);

    List<Long> countList = new ArrayList<>(count.values());
    Collections.sort(countList);

    return countList.get(countList.size() - 1) - countList.get(0);
  }
}