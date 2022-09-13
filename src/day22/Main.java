package day22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<Integer[]> loadInput(String filename) {
    List<Integer[]> input = new ArrayList<>();

    Path p = Path.of(filename);

    try {
      for (String line : Files.readAllLines(p)) {
        Integer[] instruction = new Integer[7];
        if (line.startsWith("on")) {
          instruction[0] = 1;
        } else {
          instruction[0] = -1;
        }

        String x = line.split(",")[0].split("x=")[1];
        String y = line.split(",")[1].split("y=")[1];
        String z = line.split(",")[2].split("z=")[1];

        instruction[1] = Integer.parseInt(x.split("\\.\\.")[0]);
        instruction[2] = Integer.parseInt(x.split("\\.\\.")[1]);
        instruction[3] = Integer.parseInt(y.split("\\.\\.")[0]);
        instruction[4] = Integer.parseInt(y.split("\\.\\.")[1]);
        instruction[5] = Integer.parseInt(z.split("\\.\\.")[0]);
        instruction[6] = Integer.parseInt(z.split("\\.\\.")[1]);

        input.add(instruction);
      }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return input;
  }

  public static void main(String[] args) {
    List<Integer[]> input = Main.loadInput("./input/day22/input");
    int r1 = Day22.solvePart1(input);

    System.out.printf("Day 22 part 1 solution: %d\n", r1);

    long r2 = Day22.solvePart2(input);

    System.out.printf("Day 22 part 2 solution: %d\n", r2);
  }
}
