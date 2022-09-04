package day18;

import java.util.ArrayList;
import java.util.List;

public class Day18 {
  private static boolean canExplode(SnailfishNumber number) {
    return canExplodeHelper(number, 0);
  }

  private static boolean canExplodeHelper(SnailfishNumber number, int depth) {
    if (depth == 4 && number.left != null && number.right != null) {
      return true;
    }

    if (number.left == null && number.right == null) {
      return false;
    }

    return canExplodeHelper(number.left, depth + 1) ||
        canExplodeHelper(number.right, depth + 1);
  }

  private static boolean canSplit(SnailfishNumber number) {
    if (number.left == null && number.right == null) {
      return (number.getValue() >= 10);
    }
    return canSplit(number.left) || canSplit(number.right);
  }

  private static void explodeNumber(SnailfishNumber number) {
    parseNeighbors(number);
    explodeNumberHelper(number, 0);
  }

  private static boolean explodeNumberHelper(
      SnailfishNumber number, int depth) {
    if (depth == 4 && number.left != null && number.right != null) {
      if (number.left.leftVal != null) {
        number.left.leftVal.setValue(number.left.leftVal.getValue() + number.left.getValue());
      }
      if (number.right.rightVal != null) {
        number.right.rightVal.setValue(
            number.right.rightVal.getValue() + number.right.getValue());
      }
      number.setValue(0);
      number.left = null;
      number.right = null;
      return true;
    }
    if (number.left != null && number.right != null) {
      if (explodeNumberHelper(number.left, depth + 1)) {
        return true;
      }
      if (explodeNumberHelper(number.right, depth + 1)) {
        return true;
      }
    }
    return false;
  }

  private static boolean splitNumber(SnailfishNumber split) {
    if (split.left != null && split.right != null) {
      if (splitNumber(split.left)) {
        return true;
      }
      if (splitNumber(split.right)) {
        return true;
      }
    } else {
      if (split.getValue() > 9) {
        int l = (int)Math.floor((double)split.getValue() / 2.0);
        int r = (int)Math.ceil((double)split.getValue() / 2.0);
        split.left = new SnailfishNumber(l);
        split.right = new SnailfishNumber(r);
        return true;
      }
    }
    return false;
  }

  private static SnailfishNumber reduceSnailfishNumber(SnailfishNumber number) {
    if (canExplode(number)) {
      explodeNumber(number);
      reduceSnailfishNumber(number);
    }
    if (canSplit(number)) {
      parseNeighbors(number);
      splitNumber(number);
      reduceSnailfishNumber(number);
    }
    return number;
  }

  private static SnailfishNumber addSnailfishNumbers(SnailfishNumber a, SnailfishNumber b) {
    SnailfishNumber result = new SnailfishNumber();
    result.left = a;
    result.right = b;
    return reduceSnailfishNumber(result);
  }

  private static SnailfishNumber addAllSnailfishNumbers(List<SnailfishNumber> numbers) {
    SnailfishNumber a = numbers.get(0);
    for (int i = 1; i < numbers.size(); ++i) {
      a = addSnailfishNumbers(a, numbers.get(i));
    }

    return a;
  }

  private static void parseNeighbors(SnailfishNumber num) {
    List<SnailfishNumber> inOrder = new ArrayList<>();

    parseNeighborsHelper(num, inOrder);

    for (int i = 0; i < inOrder.size(); ++i) {
      if (i > 0) {
        inOrder.get(i).leftVal = inOrder.get(i - 1);
      }
      if (i < inOrder.size() - 1) {
        inOrder.get(i).rightVal = inOrder.get(i + 1);
      }
    }
  }

  private static void parseNeighborsHelper(SnailfishNumber num, List<SnailfishNumber> l) {
    if (num.left != null) {
      parseNeighborsHelper(num.left, l);
      parseNeighborsHelper(num.right, l);
    } else {
      l.add(num);
    }
  }

  public static int solvePart1(List<SnailfishNumber> input) {
    return addAllSnailfishNumbers(input).getMagnitude();
  }

  private static SnailfishNumber deepCopySnailfishNumber(SnailfishNumber n) {
    SnailfishNumber a = new SnailfishNumber();

    if (n.left == null && n.right == null) {
      a.setValue(n.getValue());
      return a;
    }

    a.left = deepCopySnailfishNumber(n.left);
    a.right = deepCopySnailfishNumber(n.right);

    return a;
  }

  public static int solvePart2(List<SnailfishNumber> input) {
    int maxMagnitude = 0;

    // Brute force it
    for (int i = 0; i < input.size(); ++i) {
      for (int j = 0; j < input.size(); ++j) {
        if (i == j) {
          continue;
        }
        SnailfishNumber a = deepCopySnailfishNumber(input.get(i));
        SnailfishNumber b = deepCopySnailfishNumber(input.get(j));
        maxMagnitude = Math.max(
            maxMagnitude, addSnailfishNumbers(a, b).getMagnitude());
      }
    }

    return maxMagnitude;
  }
}
