package day5;

import java.util.HashMap;
import java.util.List;

public class Day5 {
  private static HashMap<Point, Integer> map;

  public static int solvePart1(List<Line> data) {
    map = new HashMap<>();

    for (Line line : data) {
      if (line.getFrom().getX() == line.getTo().getX()) {
        int start = Math.min(line.getFrom().getY(), line.getTo().getY());
        int end = Math.max(line.getFrom().getY(), line.getTo().getY());
        for (int i = start; i <= end; ++i) {
          Point p = new Point(line.getFrom().getX(), i);
          map.put(p, map.getOrDefault(p, 0) + 1);
        }
      }
      if (line.getFrom().getY() == line.getTo().getY()) {
        int start = Math.min(line.getFrom().getX(), line.getTo().getX());
        int end = Math.max(line.getFrom().getX(), line.getTo().getX());
        for (int i = start; i <= end; ++i) {
          Point p = new Point(i, line.getFrom().getY());
          map.put(p, map.getOrDefault(p, 0) + 1);
        }
      }
    }

    int r = 0;
    for (Point p : map.keySet()) {
      if (map.get(p) > 1) {
        ++r;
      }
    }

    return r;
  }

  public static int solvePart2(List<Line> data) {
    for (Line line : data) {
      if (line.getFrom().getX() != line.getTo().getX() &&
          line.getFrom().getY() != line.getTo().getY()) {
        int x = line.getFrom().getX(), y = line.getFrom().getY();
        while (true) {
          Point p = new Point(x, y);
          map.put(p, map.getOrDefault(p, 0) + 1);
          if (x == line.getTo().getX() && y == line.getTo().getY()) {
            break;
          }
          if (line.getTo().getX() > line.getFrom().getX()) {
            ++x;
          } else {
            --x;
          }
          if (line.getTo().getY() > line.getFrom().getY()) {
            ++y;
          } else {
            --y;
          }
        }
      }
    }

    int r = 0;
    for (Point p : map.keySet()) {
      if (map.get(p) > 1) {
        ++r;
      }
    }

    return r;
  }
}
