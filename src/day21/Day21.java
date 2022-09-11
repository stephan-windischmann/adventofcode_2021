package day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day21 {
  private static int die = 0;

  private static int rollDeterministicDice() {
    Day21.die++;
    if (Day21.die > 100) {
      Day21.die = 1;
    }
    return Day21.die;
  }

  private static int getPos(int startPos, int roll) {
    int pos = startPos + roll;
    while (pos > 10) {
      pos -= 10;
    }

    return pos;
  }

  public static int solvePart1(List<Integer> startPos) {
    int p1Score = 0;
    int p2Score = 0;

    int p1Pos = startPos.get(0);
    int p2Pos = startPos.get(1);

    int dieRolls = 0;

    while (true) {
      int roll = Day21.rollDeterministicDice();
      roll += Day21.rollDeterministicDice();
      roll += Day21.rollDeterministicDice();
      dieRolls += 3;
      p1Pos = getPos(p1Pos, roll);
      p1Score += p1Pos;
      if (p1Score >= 1000) {
        break;
      }

      roll = Day21.rollDeterministicDice();
      roll += Day21.rollDeterministicDice();
      roll += Day21.rollDeterministicDice();
      dieRolls += 3;
      p2Pos = getPos(p2Pos, roll);
      p2Score += p2Pos;
      if (p2Score >= 1000) {
        break;
      }
    }

    return Math.min(p1Score, p2Score) * dieRolls;
  }

  private static List<List<Integer>> getNewGameStates(List<Integer> gameState, int p) {
    List<List<Integer>> states = new ArrayList<>();

    for (int i = 1; i < 4; ++i) {
      for (int j = 1; j < 4; ++j) {
        for (int k = 1; k < 4;++k) {
          int roll = i + j + k;
          int newPos = getPos(gameState.get(p + 2), roll);
          List<Integer> newState = new ArrayList<>(gameState);
          newState.set(p + 2, newPos);
          newState.set(p, newState.get(p) + newPos);
          newState.set(4, p);
          states.add(newState);
        }
      }
    }

    return states;
  }

  private static long[] playGame(
      List<Integer> gameState, HashMap<List<Integer>, long[]> memo, int p) {
    if (memo.containsKey(gameState)) {
      return memo.get(gameState);
    }

    long[] r = new long[3];

    if (gameState.get(0) >= 21) {
      r[0] = 1;
      r[2] = 1;
    } else if (gameState.get(1) >= 21) {
      r[1] = 1;
      r[2] = 1;
    } else {
      int newPlayer = p == 0 ? 1 : 0;
      for (List<Integer> gs : getNewGameStates(gameState, p)) {
        long[] games = playGame(gs, memo, newPlayer);
        r[0] += games[0];
        r[1] += games[1];
        r[2] += games[2];
      }
    }

    memo.put(gameState, r);

    return r;
  }

  public static long solvePart2(List<Integer> startPos) {
    List<Integer> gameState = new ArrayList<>();
    gameState.add(0);
    gameState.add(0);
    gameState.add(startPos.get(0));
    gameState.add(startPos.get(1));
    gameState.add(0);
    HashMap<List<Integer>, long[]> memo = new HashMap<>();

    long[] games = playGame(gameState, memo, 0);

    return Math.max(games[0], games[1]);
  }
}
