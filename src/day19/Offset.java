package day19;

public class Offset {
  private int x, y, z;

  public Offset(int x, int y, int z) {
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

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setZ(int z) {
    this.z = z;
  }

  @Override
  public String toString() {
    return String.format("x: %d y: %d z: %d\n", x, y, z);
  }
}
