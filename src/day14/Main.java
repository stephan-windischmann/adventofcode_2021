package day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static String loadInput(String filename, Map<String, String> rules) {
    String template = "";
    Path p = Path.of(filename);

    try  {
      List<String> input = Files.readAllLines(p);

     template = input.get(0);

     for (int i = 2; i < input.size(); ++i) {
       String pair = input.get(i).split("->")[0].strip();
       String insert = input.get(i).split("->")[1].strip();

       rules.put(pair, insert);
     }
    } catch (IOException e) {
      System.out.println("Exception: " + e);
      System.exit(-1);
    }

    return template;
  }

  public static void main(String[] args) {
    Map<String, String> rules = new HashMap<>();
    String template  = Main.loadInput("./input/day14/input", rules);

    int r1 = Day14.solvePart1(template, rules, 10);
    System.out.printf("Day 14 part 1 solution: %d\n", r1);

    long r2 = Day14.solvePart2(template, rules, 40);
    System.out.printf("Day 14 part 2 solution: %d\n", r2);
  }
}
