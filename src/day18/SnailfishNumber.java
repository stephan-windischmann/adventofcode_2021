package day18;

public class SnailfishNumber {
  private int value;

  public SnailfishNumber left;
  public SnailfishNumber right;

  public SnailfishNumber leftVal;
  public SnailfishNumber rightVal;

  public SnailfishNumber() {
    this.left = null;
    this.right = null;
    this.leftVal = null;
    this.rightVal = null;
  }

  public SnailfishNumber(int value) {
    this.value = value;

    this.left = null;
    this.right = null;
    this.leftVal = null;
    this.rightVal = null;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public String toString() {
    if (this.left == null && this.right == null) {
      return String.valueOf(this.value);
    }

    StringBuilder n = new StringBuilder();

    n.append("[");
    n.append(this.left);
    n.append(",");
    n.append(this.right);
    n.append("]");

    return n.toString();
  }

  public int getMagnitude() {
    if (this.right == null && this.left == null) {
      return this.value;
    }
    return 3 * this.left.getMagnitude() + 2 * this.right.getMagnitude();
  }
}
