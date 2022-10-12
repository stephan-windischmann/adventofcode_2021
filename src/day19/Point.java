package day19;

public class Point {
  private int x;
  private int y;
  private int z;

  public Point (int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
  }

  public double getDistanceTo(Point p) {
    return Math.sqrt(
        Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2) + Math.pow(p.getZ() - z, 2)
    );
  }

  public int getManhattanDistance(Point p) {
    return Math.abs(x - p.getX()) +  Math.abs(y - p.getY()) + Math.abs(z - p.getZ());
  }

  public void rotateX() {
    int oldY = y;
    y = -z;
    z = oldY;
  }

  public void rotateY() {
    int oldX = x;
    x = z;
    z = -oldX;
  }

  public void rotateZ() {
    int oldX = x;
    x = -y;
    y = oldX;
  }

  public void move(
      int xOffset, int yOffset, int zOffset) {
    x = xOffset + x;
    y = yOffset + y;
    z = zOffset + z;
  }

  @Override
  public String toString() {
    return String.format("x: %d y: %d z: %d", x, y, z);
  }
}
