package day20;

public class Day20 {
  private static int getIndex(boolean[] index) {
    int indexDecimal = 0;

    for (int i = 0; i < index.length; ++i) {
      if (index[i]) {
        indexDecimal |= 1 << index.length - 1 - i;
      }
    }

    return indexDecimal;
  }

  private static char applyForPixel(int i, int j, char[][] picture, String algorithm, boolean zeroVal) {
    boolean[] index = new boolean[9];
    if (i > 0 && j > 0) {
      index[0] = picture[i - 1][j - 1] == '#';
    } else {
      index[0] = zeroVal;
    }
    if (i > 0 && j >= 0 && j < picture[0].length) {
      index[1] = picture[i - 1][j] == '#';
    } else {
      index[1] = zeroVal;
    }
    if (i > 0 && j < picture[0].length - 1) {
      index[2] = picture[i - 1][j + 1] == '#';
    } else {
      index[2] = zeroVal;
    }
    if (i >= 0 && i < picture.length && j > 0) {
      index[3] = picture[i][j - 1] == '#';
    } else {
      index[3] = zeroVal;
    }
    if (i >= 0 && i < picture.length  && j >= 0  && j < picture[0].length) {
      index[4] = picture[i][j] == '#';
    } else {
      index[4] = zeroVal;
    }
    if (i >= 0 && i < picture.length && j < picture[0].length - 1) {
      index[5] = picture[i][j + 1] == '#';
    } else {
      index[5] = zeroVal;
    }
    if (i < picture.length - 1 && j > 0) {
      index[6] = picture[i + 1][j - 1] == '#';
    } else {
      index[6] = zeroVal;
    }
    if (i < picture.length - 1 && j >= 0 && j < picture[0].length) {
      index[7] = picture[i + 1][j] == '#';
    } else {
      index[7] = zeroVal;
    }
    if (i < picture.length - 1 && j < picture[0].length - 1) {
      index[8] = picture[i + 1][j + 1] == '#';
    } else {
      index[8] = zeroVal;
    }

    return algorithm.charAt(getIndex(index));
  }

  private static char[][] applyAlgorithm(char[][] picture, String algorithm, boolean zeroVal) {
    char[][] newPicture = new char[picture.length + 2][picture[0].length + 2];

    for (int i = 0; i < newPicture.length; ++i) {
      for (int j = 0; j < newPicture[0].length; ++j) {
        newPicture[i][j] = applyForPixel(i - 1, j - 1, picture, algorithm, zeroVal);
      }
    }

    return newPicture;
  }

  public static int enhanceImage(Input input, int n) {
    int r = 0;

    char[][] picture = input.getPicture();

    for (int i = 0; i < n; ++i) {
      // If first entry in algorithm is #, outside pixel toggle between on and off.
      boolean zeroVal = false;
      if (input.getAlgorithm().charAt(0) == '#') {
        zeroVal = i % 2 != 0;
      }

      picture = applyAlgorithm(picture, input.getAlgorithm(), zeroVal);
    }

    for (char[] line : picture) {
      for (char c : line) {
        if (c == '#') {
          ++r;
        }
      }
    }

    return r;
  }

  public static int solvePart1(Input input) {
    return enhanceImage(input, 2);
  }

  public static int solvePart2(Input input) {
    return enhanceImage(input, 50);
  }
}
