package day6;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Day6 {
  // 'Dumb' solution
  public static int solvePart1(List<Lanternfish> data, int days) {
    for (int day = 0; day < days; ++day) {
      int len = data.size();

      ListIterator<Lanternfish> iter = data.listIterator();
      List<Lanternfish> newFishes = new LinkedList<>();
      for (int i = 0; i < len; ++i) {
        Lanternfish fish = iter.next();
        if (fish.getCurAge() == 0) {
          fish.setCurAge(fish.getMaxAge());
          Lanternfish newFish = new Lanternfish(6, 8);
          newFishes.add(newFish);
        } else {
          fish.setCurAge(fish.getCurAge() - 1);
        }
        iter.set(fish);
      }
      data.addAll(newFishes);
    }

    return data.size();
  }

  // More efficient solution than the brute force method from part 1.
  public static long solvePart2(List<Lanternfish> data, int days) {
    //HashMap<Integer, BigInteger> fishes = new HashMap<>();

    long[] fishes = new long[9];
    for (Lanternfish fish : data) {
      fishes[fish.getCurAge()] += 1;
    }

    for (int day = 0; day < days; ++day) {
      long spawn = fishes[0];
      for (int i = 0; i < 8; ++i) {
        fishes[i] = fishes[i + 1];
      }
      fishes[6] += spawn;
      fishes[8] = spawn;
    }

    long r = 0;
    for (long c : fishes) {
      r += c;
    }
    return r;
  }
}
