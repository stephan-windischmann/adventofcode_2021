package day23;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
  public static Room loadInput(String filename) {
    Path p = Path.of(filename);

    try {
      List<String> data = Files.readAllLines(p);

      char[][] map = new char[data.size()][data.get(0).length()];

      for (int i = 0; i < data.size(); ++i) {
        for (int j = 0; j < data.get(i).length(); ++j) {
          map[i][j] = data.get(i).charAt(j);
        }
      }

      return new Room(map);
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return new Room(new char[0][0]);
  }

  public static RoomPart2 loadInputPart2(String filename) {
    Path p = Path.of(filename);

    try {
      List<String> data = Files.readAllLines(p);

      char[][] map = new char[data.size()][data.get(0).length()];

      for (int i = 0; i < data.size(); ++i) {
        for (int j = 0; j < data.get(i).length(); ++j) {
          map[i][j] = data.get(i).charAt(j);
        }
      }

      return new RoomPart2(map);
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return new RoomPart2(new char[0][0]);
  }

  public static void main(String[] args) {
    Room room = Main.loadInput("./input/day23/input");

    int r1 = Day23.solvePart1(room);
    System.out.printf("Day 23 part 1 solution: %d\n", r1);

    RoomPart2 roomPart2 = Main.loadInputPart2("./input/day23/input_part2");

    int r2 = Day23.solvePart2(roomPart2);
    System.out.printf("Day 23 part 2 solution: %d\n", r2);
  }
}
