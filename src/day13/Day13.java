package day13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day13 {
  public static void fold(Set<Coordinate> input, String instruction) {
    if (instruction.contains("x")) {
      foldX(input, Integer.parseInt(instruction.split("=")[1]));
    } else {
      foldY(input, Integer.parseInt(instruction.split("=")[1]));
    }
  }

  public static void foldX(Set<Coordinate> input, int x) {
    Iterator<Coordinate> iter = input.iterator();
    Set<Coordinate> moved = new HashSet<>();
    while (iter.hasNext()) {
      Coordinate c = iter.next();
      if(c.getX() == x) {
        iter.remove();
      }
      if(c.getX() > x) {
        iter.remove();
        int newX = c.getX() - ((c.getX() - x)*2);
        if (newX >= 0) {
          moved.add(new Coordinate(newX, c.getY()));
        }
      }
    }
    input.addAll(moved);
  }

  public static void foldY(Set<Coordinate> input, int y) {
    Iterator<Coordinate> iter = input.iterator();
    Set<Coordinate> moved = new HashSet<>();
    while (iter.hasNext()) {
      Coordinate c = iter.next();
      if(c.getY() == y) {
        iter.remove();
      }
      if(c.getY() > y) {
        iter.remove();
        int newY = c.getY() - ((c.getY() - y)*2);
        if (newY >= 0) {
          moved.add(new Coordinate(c.getX(), newY));
        }
      }
    }
    input.addAll(moved);
  }

  public static int solvePart1(Set<Coordinate> input, List<String> instructions) {
    fold(input, instructions.get(0));

    return input.size();
  }

  public static void solvePart2(Set<Coordinate> input, List<String> instructions) {
    for (String instr : instructions) {
      fold(input, instr);
    }

    int maxX = 0;
    int maxY = 0;

    for (Coordinate c : input) {
      maxX = Math.max(maxX, c.getX());
      maxY = Math.max(maxY, c.getY());
    }

    boolean[][] p = new boolean[maxY + 1][maxX + 1];

    for (Coordinate c : input) {
      p[c.getY()][c.getX()] = true;
    }

    for (boolean[] l : p) {
      for (boolean c : l) {
        if (c) {
          System.out.print("#");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
