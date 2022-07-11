package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day10 {
  public static int solvePart1(List<String> data) {
    int r = 0;

    for (String line : data) {
      Stack<Character> s = new Stack<>();
      for (char c : line.toCharArray()) {
        if (c == '(' || c == '[' || c == '{' || c == '<') {
          s.push(c);
          continue;
        }

        char last = s.pop();
        switch(c) {
          case ')':
            if (last != '(') {
              r += 3;
            }
            break;
          case ']':
            if (last != '[') {
              r += 57;
            }
            break;
          case '}':
            if (last != '{') {
              r += 1197;
            }
            break;
          case '>':
            if (last != '<') {
              r += 25137;
            }
            break;
        }
      }
    }

    return r;
  }

  private static Stack<Character> parseLine(String line) {
    Stack<Character> s = new Stack<>();
    for (char c : line.toCharArray()) {
      if (c == '(' || c == '[' || c == '{' || c == '<') {
        s.push(c);
        continue;
      }

      char last = s.pop();
      switch(c) {
        case ')':
          if (last != '(') {
            return new Stack<>();
          }
          break;
        case ']':
          if (last != '[') {
            return new Stack<>();
          }
          break;
        case '}':
          if (last != '{') {
            return new Stack<>();
          }
          break;
        case '>':
          if (last != '<') {
            return new Stack<>();
          }
          break;
      }
    }
    return s;
  }

  public static long solvePart2(List<String> data) {
    ArrayList<Long> scores = new ArrayList<>();

    for (String line : data) {
      Stack<Character> s = Day10.parseLine(line);
      if (s.isEmpty()) {
        continue;
      }

      long score = 0;
      while (!s.isEmpty()) {
        char c = s.pop();
        switch(c) {
          case '(':
            score *= 5;
            score += 1;
            break;
          case '[':
            score *= 5;
            score += 2;
            break;
          case '{':
            score *= 5;
            score += 3;
            break;
          case '<':
            score *= 5;
            score += 4;
            break;
        }
      }
      scores.add(score);
    }

    Collections.sort(scores);
    return scores.get(scores.size() / 2);
  }
}
