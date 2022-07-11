package day8;

import java.util.List;

public class InputLine {
  private List<String> left;
  private List<String> right;

  public InputLine(List<String> left, List<String> right) {
    this.left = left;
    this.right = right;
  }

  public List<String> getLeft() {
    return this.left;
  }

  public List<String> getRight() {
    return this.right;
  }
}
