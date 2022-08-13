package day17;

public class Area {
  private final int xMin;
  private final int xMax;
  private final int yMin;
  private final int yMax;

  public Area(int xMin, int xMax, int yMin, int yMax) {
    this.xMin = xMin;
    this.xMax = xMax;
    this.yMin = yMin;
    this.yMax = yMax;
  }

  public int getxMin() {
    return xMin;
  }

  public int getxMax() {
    return xMax;
  }

  public int getyMin() {
    return yMin;
  }

  public int getyMax() {
    return yMax;
  }
}
