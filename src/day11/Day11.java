package day11;

import java.util.List;

public class Day11 {
  public static void increaseEnergy(char[][] data) {
    for (int i = 0; i < data[0].length; ++i) {
      for (int j = 0; j < data.length; ++j) {
        incrementByOne(data, j, i);
      }
    }
  }

  public static void incrementByOne(char[][] data, int x, int y) {
    if (x < 0 || y < 0 || x >= data[0].length || y >= data.length) {
      return;
    }

    if (data[y][x] == '9') {
      data[y][x] = 'x';
    } else if (data[y][x] >= '0' && data[y][x] <= '9') {
      data[y][x] += 1;
    }
  }

  public static int flash(char[][] data) {
    int flashes = 0;

    for (int i = 0; i < data.length; ++i) {
      for (int j = 0; j < data[0].length; ++j) {
        if (data[i][j] == 'x') {
          data[i][j] = 'X';
          ++flashes;
          incrementByOne(data, j - 1, i);
          incrementByOne(data, j, i - 1);
          incrementByOne(data, j - 1, i - 1);
          incrementByOne(data, j + 1, i);
          incrementByOne(data, j, i + 1);
          incrementByOne(data, j + 1, i + 1);
          incrementByOne(data, j + 1, i - 1);
          incrementByOne(data, j - 1, i + 1);
        }
      }
    }

    return flashes;
  }

  public static int solvePart1(char[][] input, int count) {
    int result = 0;

    int w = input[0].length;
    int h = input.length;

    for (int s = 0; s < count; ++s) {
      Day11.increaseEnergy(input);
      int c = flash(input);
      result += c;
      while (c > 0) {
        c = flash(input);
        result += c;
      }
      for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
          if (input[i][j] == 'X') {
            input[i][j] = '0';
          }
        }
      }
    }

    return result;
  }

  public static int solvePart2(char[][] input) {
    int w = input[0].length;
    int h = input.length;

    int s = 0;
    while (true) {
      ++s;
      Day11.increaseEnergy(input);
      int flashes = 0;
      int c = flash(input);
      flashes += c;
      while (c > 0) {
        c = flash(input);
        flashes += c;
      }
      if (flashes == w * h) {
        return s;
      }

      for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
          if (input[i][j] == 'X') {
            input[i][j] = '0';
          }
        }
      }
    }
  }
}