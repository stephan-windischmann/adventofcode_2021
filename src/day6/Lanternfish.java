package day6;

public class Lanternfish {
  private int maxAge;
  private int curAge;

  public Lanternfish(int age) {
    this.maxAge = age;
    this.curAge = age;
  }

  public Lanternfish(int maxAge, int curAge) {
    this.maxAge = maxAge;
    this.curAge = curAge;
  }

  public int getMaxAge() {
    return maxAge;
  }

  public void setMaxAge(int maxAge) {
    this.maxAge = maxAge;
  }

  public int getCurAge() {
    return curAge;
  }

  public void setCurAge(int curAge) {
    this.curAge = curAge;
  }
}
