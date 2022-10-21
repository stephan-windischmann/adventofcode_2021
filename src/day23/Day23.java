package day23;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Day23 {
  public static int solvePart1(Room room) {
    Comparator<Room> energyComparator = new Comparator<>() {
      @Override
      public int compare(Room o1, Room o2) {
        return o1.getEnergy() - o2.getEnergy();
      }
    };

    Set<String> s = new HashSet<>();

    PriorityQueue<Room> q = new PriorityQueue<>(energyComparator);

    q.add(room);
    while (!q.isEmpty()) {
      Room r = q.poll();
      if (s.contains(r.toString())) {
        continue;
      }

      if (r.isOrganized()) {
        return r.getEnergy();
      }

      q.addAll(r.getNextMoves());
      s.add(r.toString());
    }

    return -1;
  }

  public static int solvePart2(RoomPart2 room) {
    Comparator<RoomPart2> energyComparator = new Comparator<>() {
      @Override
      public int compare(RoomPart2 o1, RoomPart2 o2) {
        return o1.getEnergy() - o2.getEnergy();
      }
    };

    Set<String> s = new HashSet<>();

    PriorityQueue<RoomPart2> q = new PriorityQueue<>(energyComparator);

    q.add(room);
    while (!q.isEmpty()) {
      RoomPart2 r = q.poll();
      if (s.contains(r.toString())) {
        continue;
      }

      if (r.isOrganized()) {
        return r.getEnergy();
      }

      q.addAll(r.getNextMoves());
      s.add(r.toString());
    }

    return -1;
  }
}
