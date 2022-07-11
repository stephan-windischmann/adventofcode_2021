package day9;

import java.util.ArrayList;
import java.util.List;

public class Cave {
  private List<List<Integer>> cave;

  public Cave() {
    this.cave = new ArrayList<>();
  }

  public void addRow(String row) {
    List<Integer> newRow = new ArrayList<>();

    for (Character c : row.toCharArray()) {
      newRow.add(Integer.parseInt(String.valueOf(c)));
    }

    this.cave.add(newRow);
  }

  public int getDepth(int x, int y) {
    return this.cave.get(y).get(x);
  }

  public int getHeight() {
    return this.cave.size();
  }

  public int getWidth() {
    return this.cave.get(0).size();
  }

  public boolean isLowPoint(int x, int y) {
    int curPoint = this.getDepth(x, y);
    if (x > 0) {
      if (this.cave.get(y).get(x - 1) <= curPoint) {
        return false;
      }
    }
    if (x < this.getWidth() - 1) {
      if (this.cave.get(y).get(x + 1) <= curPoint) {
        return false;
      }
    }
    if (y > 0) {
      if (this.cave.get(y - 1).get(x) <= curPoint) {
        return false;
      }
    }
    if (y < this.getHeight() - 1) {
      if (this.cave.get(y + 1).get(x) <= curPoint) {
        return false;
      }
    }

    return true;
  }

  public int getBasinSize(int x, int y) {
    int curDepth = this.getDepth(x, y);

    if (curDepth == 9 || curDepth == -1) {
      return 0;
    }

    int s = 1;
    s += this.getBasinSizeHelper(x - 1, y, curDepth);
    s += this.getBasinSizeHelper(x + 1, y, curDepth);
    s += this.getBasinSizeHelper(x, y - 1, curDepth);
    s += this.getBasinSizeHelper(x, y + 1, curDepth);

    return s;
  }

  private int getBasinSizeHelper(int x, int y, int d) {
    if (x < 0 || y < 0 || x == this.getWidth() || y == this.getHeight()) {
      return 0;
    }

    int curDepth = this.getDepth(x, y);

    if (curDepth == 9 || curDepth == -1 || curDepth <= d) {
      return 0;
    }

    this.cave.get(y).set(x, -1);

    int s = 1;
    s += this.getBasinSizeHelper(x - 1, y, curDepth);
    s += this.getBasinSizeHelper(x + 1, y, curDepth);
    s += this.getBasinSizeHelper(x, y - 1, curDepth);
    s += this.getBasinSizeHelper(x, y + 1, curDepth);

    return s;
  }
}
