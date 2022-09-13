package day22;

import java.util.ArrayList;
import java.util.List;

public class Cuboid {
  private int xMin;
  private int xMax;
  private int yMin;
  private int yMax;
  private int zMin;
  private int zMax;

  private long volume;

  public Cuboid (int xMin, int xMax, int yMin, int yMax, int zMin, int zMax) {
    this.xMin = xMin;
    this.xMax = xMax;
    this.yMin = yMin;
    this.yMax = yMax;
    this.zMin = zMin;
    this.zMax = zMax;

    this.volume =
        Math.abs((long)xMax - (long)xMin + 1)
            * Math.abs((long)yMax - (long)yMin + 1)
            * Math.abs((long)zMax - (long)zMin + 1);
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

  public int getzMin() {
    return zMin;
  }

  public int getzMax() {
    return zMax;
  }

  public long getVolume() {
    return this.volume;
  }

  @Override
  public String toString() {
    return String.format("x: %d..%d y: %d..%d z: %d..%d volume: %d",
        xMin, xMax, yMin, yMax, zMin, zMax, volume);
  }
}
