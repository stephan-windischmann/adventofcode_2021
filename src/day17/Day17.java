package day17;

public class Day17 {
  public static int solvePart1(Area area) {
    int n = (-1) * area.getyMin() - 1;

    return (n * (n + 1)) / 2;
  }

  public static int solvePart2(Area area) {
    int r = 0;

    // Brute force
    for (int x = 0; x <= area.getxMax(); ++x) {
      for (int y = area.getyMin(); y <= -1 * area.getyMin(); ++y) {
        if (shoot(x, y, area)) {
          ++r;
        }
      }
    }

    return r;
  }

  private static boolean shoot(int xVel, int yVel, Area area) {
    int x = 0, y = 0;

    while (x <= area.getxMax() && y >=area.getyMin()) {
      x += xVel;
      y += yVel;
      if (xVel > 0) {
        --xVel;
      }
      --yVel;
      if ((x >= area.getxMin() && x <= area.getxMax()) &&
          (y >= area.getyMin() && y <= area.getyMax())) {
        return true;
      }
    }
    return false;
  }
}
