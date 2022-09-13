package day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day22 {
  private static void execInstruction(
      Integer[] instruction, Set<List<Integer>> cubes, List<Integer> region) {
    if (instruction[2] < region.get(0) || instruction[1] > region.get(1) ||
        instruction[4] < region.get(2) || instruction[3] > region.get(3) ||
        instruction[6] < region.get(4) || instruction[5] > region.get(5)) {
      return;
    }

    int xMin = Math.max(instruction[1], region.get(0));
    int xMax = Math.min(instruction[2], region.get(1));
    int yMin = Math.max(instruction[3], region.get(2));
    int yMax = Math.min(instruction[4], region.get(3));
    int zMin = Math.max(instruction[5], region.get(4));
    int zMax = Math.min(instruction[6], region.get(5));

    for (int x = xMin; x <= xMax; ++x) {
      for (int y = yMin; y <= yMax; ++y) {
        for (int z = zMin; z <= zMax; ++z) {
          List<Integer> coord = Arrays.asList(x, y, z);
          if (instruction[0] == 1) {
            cubes.add(coord);
          } else {
            cubes.remove(coord);
          }
        }
      }
    }
  }

  public static Set<List<Integer>> rebootReactor(List<Integer[]> input, List<Integer> region) {
    Set<List<Integer>> cubes = new HashSet<>();

    for (Integer[] instruction : input) {
      execInstruction(instruction, cubes, region);
    }

    return cubes;
  }

  public static int solvePart1(List<Integer[]> input) {
    List<Integer> region = Arrays.asList(-50, 50, -50, 50, -50, 50);

    Set<List<Integer>> cubes = rebootReactor(input, region);

    return cubes.size();
  }

  private static Cuboid getIntersection(Cuboid newCuboid, Cuboid c) {
    int xMin = Math.max(newCuboid.getxMin(), c.getxMin());
    int xMax = Math.min(newCuboid.getxMax(), c.getxMax());
    int yMin = Math.max(newCuboid.getyMin(), c.getyMin());
    int yMax = Math.min(newCuboid.getyMax(), c.getyMax());
    int zMin = Math.max(newCuboid.getzMin(), c.getzMin());
    int zMax = Math.min(newCuboid.getzMax(), c.getzMax());

   if (xMin > xMax || yMin > yMax || zMin > zMax) {
     return null;
   }

    return new Cuboid(xMin, xMax, yMin, yMax, zMin, zMax);
  }

  public static List<Cuboid> splitCuboid(Cuboid c, Cuboid intersection) {
    List<Cuboid> split = new ArrayList<>();

    if (c.getxMin() < intersection.getxMin()) {
      Cuboid newCuboid = new Cuboid(
          c.getxMin(), intersection.getxMin() - 1,
          c.getyMin(), c.getyMax(), c.getzMin(), c.getzMax()
      );
      split.add(newCuboid);
    }

    if (c.getxMax() > intersection.getxMax()) {
      Cuboid newCuboid = new Cuboid(
          intersection.getxMax() + 1, c.getxMax(),
          c.getyMin(), c.getyMax(), c.getzMin(), c.getzMax()
      );
      split.add(newCuboid);
    }

    if (c.getyMin() < intersection.getyMin()) {
      Cuboid newCuboid = new Cuboid(
          intersection.getxMin(), intersection.getxMax(),
          c.getyMin(), intersection.getyMin() - 1,
          c.getzMin(), c.getzMax()
      );
      split.add(newCuboid);
    }

    if (c.getyMax() > intersection.getyMax()) {
      Cuboid newCuboid = new Cuboid(
          intersection.getxMin(), intersection.getxMax(),
          intersection.getyMax() + 1, c.getyMax(),
          c.getzMin(), c.getzMax()
      );
      split.add(newCuboid);
    }

    if (c.getzMin() < intersection.getzMin()) {
      Cuboid newCuboid = new Cuboid(
          intersection.getxMin(), intersection.getxMax(),
          intersection.getyMin(), intersection.getyMax(),
          c.getzMin(), intersection.getzMin() - 1
      );
      split.add(newCuboid);
    }

    if (c.getzMax() > intersection.getzMax()) {
      Cuboid newCuboid = new Cuboid(
          intersection.getxMin(), intersection.getxMax(),
          intersection.getyMin(), intersection.getyMax(),
          intersection.getzMax() + 1, c.getzMax()
      );
      split.add(newCuboid);
    }

    return split;
  }

  public static long solvePart2(List<Integer[]> input) {
    List<Cuboid> cuboids = new ArrayList<>();

    for (Integer[] instruction : input) {
      int xMin = instruction[1];
      int xMax = instruction[2];
      int yMin = instruction[3];
      int yMax = instruction[4];
      int zMin = instruction[5];
      int zMax = instruction[6];

      Cuboid newCuboid = new Cuboid(xMin, xMax, yMin, yMax, zMin, zMax);

      List<Cuboid> newCuboids = new ArrayList<>();

      for (Cuboid c : cuboids) {
        Cuboid intersection = getIntersection(newCuboid, c);
        if (intersection == null) {
          newCuboids.add(c);
        } else {
          List<Cuboid> split = splitCuboid(c, intersection);
          newCuboids.addAll(split);
        }
      }

      if (instruction[0] == 1) {
        newCuboids.add(newCuboid);
      }

      cuboids = newCuboids;
    }
    long v = 0;
    for (Cuboid c : cuboids) {
      v += c.getVolume();
    }

    return v;
  }
}
