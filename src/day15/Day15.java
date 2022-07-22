package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Day15 {
  private static void shortestPath(int x, int y, List<List<Integer>> map, int[][] cost) {
    class PointCostComparator implements Comparator<Coordinate> {
      @Override
      public int compare(Coordinate x, Coordinate y) {
        if (cost[x.getY()][x.getX()] < cost[y.getY()][y.getX()]) {
          return -1;
        }
        if (cost[x.getY()][x.getX()] > cost[y.getY()][y.getX()]) {
          return 1;
        }
        return 0;
      }
    }

    PriorityQueue<Coordinate> q = new PriorityQueue<>(10, new PointCostComparator());
    Set<Coordinate> s = new HashSet<>();
    for(int i = 0; i < map.size(); ++i) {
      for(int j = 0; j < map.size(); ++j) {
        s.add(new Coordinate(j, i));
      }
    }

    Coordinate start = new Coordinate(x, y);
    q.add(start);
    s.remove(start);

    while(!q.isEmpty()) {
      Coordinate current = q.remove();

      int curX = current.getX();
      int curY = current.getY();

      // Get neighbors
      if (curX > 0) {
        int newX = curX - 1;
        int newY = curY;
        if (cost[curY][curX] + map.get(newY).get(newX) < cost[newY][newX]) {
          cost[newY][newX] = cost[curY][curX] + map.get(newY).get(newX);
        }
        Coordinate coord = new Coordinate(newX, newY);
        if (s.contains(coord)) {
          q.add(coord);
          s.remove(coord);
        }
      }

      if (curY > 0) {
        int newX = curX;
        int newY = curY - 1;
        if (cost[curY][curX] + map.get(newY).get(newX) < cost[newY][newX]) {
          cost[newY][newX] = cost[curY][curX] + map.get(newY).get(newX);
        }
        Coordinate coord = new Coordinate(newX, newY);
        if (s.contains(coord)) {
          q.add(coord);
          s.remove(coord);
        }
      }
      if (curX + 1 < map.get(0).size()) {
        int newX = curX + 1;
        int newY = curY;
        if (cost[curY][curX] + map.get(newY).get(newX) < cost[newY][newX]) {
          cost[newY][newX] = cost[curY][curX] + map.get(newY).get(newX);
        }
        Coordinate coord = new Coordinate(newX, newY);
        if (s.contains(coord)) {
          q.add(coord);
          s.remove(coord);
        }
      }
      if (curY + 1 < map.size()) {
        int newX = curX;
        int newY = curY + 1;
        if (cost[curY][curX] + map.get(newY).get(newX) < cost[newY][newX]) {
          cost[newY][newX] = cost[curY][curX] + map.get(newY).get(newX);
        }
        Coordinate coord = new Coordinate(newX, newY);
        if (s.contains(coord)) {
          q.add(coord);
          s.remove(coord);
        }
      }
    }
  }

  public static int solvePart1(List<List<Integer>> map) {
    int h = map.size();
    int w = map.get(0).size();

    int[][] cost = new int[h][w];
    for (int[] ints : cost) {
      Arrays.fill(ints, Integer.MAX_VALUE);
    }
    cost[0][0] = 0;
    shortestPath(0, 0, map, cost);

    return cost[h - 1][w - 1];
  }

  public static int solvePart2(List<List<Integer>> map) {
    int h = map.size() * 5;
    int w = map.get(0).size() * 5;
    List<List<Integer>> bigMap = new ArrayList<>();
    for (int i = 0; i < h; ++i) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < w; ++j) {
        row.add(0);
      }
      bigMap.add(row);
    }
    for (int i = 0; i < map.size() ; ++i) {
      for (int j = 0; j < map.get(0).size(); ++j) {
        bigMap.get(i).set(j, map.get(i).get(j));
        for (int x = 0; x < 5; ++x) {
          for (int y = 0; y < 5; ++y) {
            int newVal = (map.get(i).get(j) + x + y) > 9 ? (bigMap.get(i).get(j) + x + y) % 9 :
                (bigMap.get(i).get(j) + x + y);
            bigMap.get(map.size() * y + i).set((map.get(0).size() * x + j), newVal);
          }
        }
      }
    }

    int[][] cost = new int[h][w];
    for (int[] ints : cost) {
      Arrays.fill(ints, Integer.MAX_VALUE);
    }
    cost[0][0] = 0;
    shortestPath(0, 0, bigMap, cost);

    return cost[h - 1][w - 1];
  }
}
