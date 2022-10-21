package day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
  private final char[][] map;
  private int energy;

  private final Map<Character, Integer> energyPerStep;

  public Room(char[][] map) {
    this(map, 0);
  }

  public Room(char[][] map, int energy) {
    this.map = map;
    this.energy = energy;

    energyPerStep = new HashMap<>();
    energyPerStep.put('A', 1);
    energyPerStep.put('B', 10);
    energyPerStep.put('C', 100);
    energyPerStep.put('D', 1000);
  }

  public char[][] getMap() {
    return map;
  }



  public char[][] getCopyMap() {
    char[][] newMap = new char[map.length][map[0].length];

    for (int i = 0; i < map.length; ++i) {
      for (int j = 0; j < map[0].length; ++j) {
        newMap[i][j] = map[i][j];
      }
    }

    return newMap;
  }

  public int getEnergy() {
    return energy;
  }

  public void addEnergy(int steps, char amphipod) {
    energy += (steps * energyPerStep.get(amphipod));
  }

  public boolean isOrganized() {
    /* Organized map:
      #############
      #...........#
      ###A#B#C#D###
        #A#B#C#D#
        #########
     */

    if (map[2][3] != 'A') {
      return false;
    }
    if (map[3][3] != 'A') {
      return false;
    }
    if (map[2][5] != 'B') {
      return false;
    }
    if (map[3][5] != 'B') {
      return false;
    }
    if (map[2][7] != 'C') {
      return false;
    }
    if (map[3][7] != 'C') {
      return false;
    }
    if (map[2][9] != 'D') {
      return false;
    }
    if (map[3][9] != 'D') {
      return false;
    }

    return true;
  }

  public List<Room> getNextMoves() {
    List<Room> nextMoves = new ArrayList<>();

    // First check the rooms
    nextMoves.addAll(checkRoom(2, 3));
    nextMoves.addAll(checkRoom(2, 5));
    nextMoves.addAll(checkRoom(2, 7));
    nextMoves.addAll(checkRoom(2, 9));
    nextMoves.addAll(checkRoom(3, 3));
    nextMoves.addAll(checkRoom(3, 5));
    nextMoves.addAll(checkRoom(3, 7));
    nextMoves.addAll(checkRoom(3, 9));

    // Now check the hallway
    nextMoves.addAll(checkHallway());

    return nextMoves;
  }

  private List<Room> checkRoom(int y, int x) {
    List<Room> nextMoves = new ArrayList<>();

    if (map[y][x] == '.') {
      return nextMoves;
    }

    if ((y == 3 && isCorrectRoom(y, x)) || (y == 3 && map[2][x] != '.')) {
      return nextMoves;
    }

    char c = map[y][x];

    for (int i = x - 1; i > 0; --i) {
      if(map[1][i] != '.') {
        break;
      }
      if (i == 3 || i == 5 || i == 7 || i == 9) {
        continue;
      }
      char[][] newMap = getCopyMap();
      newMap[y][x] = '.';
      newMap[1][i] = c;
      Room newRoom = new Room(newMap, energy);
      newRoom.addEnergy((y - 1 + x - i), c);
      nextMoves.add(newRoom);
    }

    for (int i = x + 1; i < map[1].length - 1; ++i) {
      if(map[1][i] != '.') {
        break;
      }
      if (i == 3 || i == 5 || i == 7 || i == 9) {
        continue;
      }
      char[][] newMap = getCopyMap();
      newMap[y][x] = '.';
      newMap[1][i] = c;
      Room newRoom = new Room(newMap, energy);
      newRoom.addEnergy((y - 1 + i - x), c);
      nextMoves.add(newRoom);
    }

    return nextMoves;
  }

  private List<Room> checkHallway() {
    List<Room> nextMoves = new ArrayList<>();

    for (int i = 1; i < map[1].length - 1; ++i) {
      if (map[1][i] == '.') {
        continue;
      }
      char c = map[1][i];
      int targetRoom = getTargetRoom(c);
      if (!wayToRoomFree(i, targetRoom)) {
        continue;
      }

      if (map[2][targetRoom] == '.' && map[3][targetRoom] == '.') {
        char[][] newMap = getCopyMap();
        newMap[1][i] = '.';
        newMap[3][targetRoom] = c;
        Room newRoom = new Room(newMap, energy);
        newRoom.addEnergy(Math.abs(targetRoom - i) + 2, c);
        nextMoves.add(newRoom);
      } else if (map[2][targetRoom] == '.' && map[3][targetRoom] == c) {
        char[][] newMap = getCopyMap();
        newMap[1][i] = '.';
        newMap[2][targetRoom] = c;
        Room newRoom = new Room(newMap, energy);
        newRoom.addEnergy(Math.abs(targetRoom - i) + 1, c);
        nextMoves.add(newRoom);
      }
    }

    return nextMoves;
  }

  private boolean wayToRoomFree(int pos, int targetRoom) {
    while (pos != targetRoom) {
      if (pos < targetRoom) {
        ++pos;
      } else {
        --pos;
      }
      if (map[1][pos] != '.') {
        return false;
      }
    }

    return true;
  }

  private int getTargetRoom(char c) {
    return switch(c) {
      case 'A' -> 3;
      case 'B' -> 5;
      case 'C' -> 7;
      case 'D' -> 9;
      default -> -1;
    };
  }

  private boolean isCorrectRoom(int y, int x) {
    if (y !=2 && y != 3) {
      return false;
    }

    char c = map[y][x];

    return switch (x) {
      case 3 -> c == 'A';
      case 5 -> c == 'B';
      case 7 -> c == 'C';
      case 9 -> c == 'D';
      default -> false;
    };
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();

    for (char[] l : map) {
      output.append(l);
      output.append("\n");
    }

    return output.toString();
  }
}
