package day25;

import java.util.Arrays;

public class Day25 {
  public static int solvePart1(char[][] data) {
    /*for (char[] l : data) {
      for (char c : l) {
        System.out.print(c);
      }
      System.out.println();
    }*/
    int steps = 0;

    while (true) {
      ++steps;

      int moves = 0;
      char[][] newData = new char[data.length][data[0].length];
      for (char[] line : newData) {
        Arrays.fill(line, '.');
      }

      // First the east-facing (>) cucumbers move
      for (int i = 0; i < data.length; ++i) {
        for (int j = 0; j < data[0].length; ++j) {
          if (data[i][j] == '.') {
            continue;
          }
          if (data[i][j] == 'v') {
            newData[i][j] = 'v';
            continue;
          }
          if (j < data[0].length - 1) {
            if (data[i][j + 1] == '.') {
              ++moves;
              newData[i][j + 1] = '>';
            } else {
              newData[i][j] = '>';
            }
          } else {
            if (data[i][0] == '.') {
              ++moves;
              newData[i][0] = '>';
            } else {
              newData[i][j] = '>';
            }
          }
        }
      }
      data = newData;
      newData = new char[data.length][data[0].length];
      for (char[] line : newData) {
        Arrays.fill(line, '.');
      }

      // Then the south-facing (v) cucumbers move
      for (int i = 0; i < data.length; ++i) {
        for (int j = 0; j < data[0].length; ++j) {
          if (data[i][j] == '.') {
            continue;
          }
          if (data[i][j] == '>') {
            newData[i][j] = '>';
            continue;
          }
          if (i < data.length - 1) {
            if (data[i + 1][j] == '.') {
              ++moves;
              newData[i + 1][j] = 'v';
            } else {
              newData[i][j] = 'v';
            }
          } else {
            if (data[0][j] == '.') {
              ++moves;
              newData[0][j] = 'v';
            } else {
              newData[i][j] = 'v';
            }
          }
        }
      }
      data = newData;

      if (moves == 0) {
        break;
      }
    }


    return steps;
  }
}
