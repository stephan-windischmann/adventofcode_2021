package day2;

import java.util.List;

public class Day2 {
  public static int solvePart1(List<String> data) {
    int x = 0, y = 0;

    for (String line : data) {
      String command = line.split(" ")[0];
      int distance = Integer.parseInt(line.split(" ")[1]);
      switch (command) {
        case "forward" -> x += distance;
        case "up" -> y -= distance;
        case "down" -> y += distance;
      }
    }

    return x * y;
  }

  public static int solvePart2(List<String> data) {
    int x = 0, y = 0, aim = 0;

    for (String line : data) {
      String command = line.split(" ")[0];
      int distance = Integer.parseInt(line.split(" ")[1]);
      switch (command) {
        case "forward" -> {
          x += distance;
          y += (distance * aim);
        }
        case "up" -> aim -= distance;
        case "down" -> aim += distance;
      }
    }

    return x * y;
  }
}
