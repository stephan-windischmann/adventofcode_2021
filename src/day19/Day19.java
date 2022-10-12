package day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day19 {
  private static boolean matches(List<Point> a, List<Point> b) {
    Set<Double> aSet = new HashSet<>();
    Set<Double> bSet = new HashSet<>();

    for (int i = 0; i < a.size(); ++i) {
      for (int j = i + 1; j < a.size(); ++j) {
        Point aPoint = a.get(i);
        Point bPoint = a.get(j);
        aSet.add(aPoint.getDistanceTo(bPoint));
      }
    }

    for (int i = 0; i < b.size(); ++i) {
      for (int j = i + 1; j < b.size(); ++j) {
        Point aPoint = b.get(i);
        Point bPoint = b.get(j);
        bSet.add(aPoint.getDistanceTo(bPoint));
      }
    }

    aSet.retainAll(bSet);
    return aSet.size() >= 66;
  }

  public static boolean rotationsMatch(List<Point> a, List<Point> b, Offset offset) {
    Map<Double, Integer> distances = new HashMap<>();

    for (Point p1 : a) {
      for (Point p2 : b) {
        double d = p1.getDistanceTo(p2);
        distances.put(d, distances.getOrDefault(d, 0) + 1);
        if (distances.get(d) >= 12) {
          offset.setX(p1.getX() - p2.getX());
          offset.setY(p1.getY() - p2.getY());
          offset.setZ(p1.getZ() - p2.getZ());
          return true;
        }
      }
    }
    return false;
  }

  public static void mergeScanners(List<Point> a, List<Point> b, List<Point> scannersPos) {
    /*
     * Rotation algorithm taken from https://uk.mathworks.com/matlabcentral/answers/123763-how-to-rotate-entire-3d-data-with-x-y-z-values-along-a-particular-axis-say-x-axis
     *
     * Around X-axis:
     * x = x;
     * y = y*cos(theta) - z*sin(theta);
     * z = y*sin(theta) + z*cos(theta);
     *
     * Around Y-axis:
     * x = x*cos(theta) + z*sin(theta);
     * y = y;
     * z = z*cos(theta) - x*sin(theta);
     *
     * Around Z-axis:
     * x = x*cos(theta) - y*sin(theta);
     * y = x*sin(theta) + y*cos(theta);
     * z = z;
     */

    for (int x = 0; x < 4; ++x) {
      for (Point p : b) {
        p.rotateX();
      }
      for (int y = 0; y < 4; ++y) {
        for (Point p : b) {
          p.rotateY();
        }
        for (int z = 0; z < 4; ++z) {
          for (Point p : b) {
            p.rotateZ();
          }
          Offset offset = new Offset(0, 0, 0);
          if (rotationsMatch(a, b, offset)) {
            Point scanner = new Point(offset.getX(), offset.getY(), offset.getZ());
            scannersPos.add(scanner);
            for (Point p : b) {
              p.move(offset.getX(), offset.getY(), offset.getZ());
              if (!contains(p, a)) {
                a.add(p);
              }
            }
            return;
          }
        }

      }
    }
  }

  public static boolean contains(Point point, List<Point> l) {
    for (Point p : l) {
      if (p.getX() == point.getX() && p.getY() == point.getY() && p.getZ() == point.getZ()) {
        return true;
      }
    }

    return false;
  }

  public static List<Point> mergeAllScanners(List<List<Point>> scanners, List<Point> scannersPos) {
    List<Point> a = scanners.remove(0);
    scannersPos.add(new Point(0, 0, 0));
    while (!scanners.isEmpty()) {
      for (int i = scanners.size() - 1; i >= 0; --i) {
        List<Point> b = scanners.remove(i);
        if (matches(a, b)) {
          mergeScanners(a, b, scannersPos);
        } else {
          scanners.add(b);
        }
      }
    }

    return a;
  }

  public static int solvePart1(List<List<Point>> scanners) {
    List<Point> scannersPos = new ArrayList<>();
    return mergeAllScanners(scanners, scannersPos).size();
  }

  public static int solvePart2(List<List<Point>> scanners) {
    List<Point> scannersPos = new ArrayList<>();
    mergeAllScanners(scanners, scannersPos);

    int max = 0;
    for (int i = 0; i < scannersPos.size(); ++i) {
      for (int j = i + 1; j < scannersPos.size(); ++j) {
        max = Math.max(max, scannersPos.get(i).getManhattanDistance(scannersPos.get(j)));
      }
    }

    return max;
  }
}

