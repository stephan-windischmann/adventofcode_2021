package day16;

import java.util.BitSet;

public class Day16 {
  public static int parsePacket(int i, Packet p, BitSet input) {
    int v = 0;
    if (input.get(i)) {
      v |= (1 << 2);
    }
    if (input.get(i + 1)) {
      v |= (1 << 1);
    }
    if (input.get(i + 2)) {
      v |= 1;
    }
    p.setVersion(v);

    int t = 0;
    if (input.get(i + 3)) {
      t |= (1 << 2);
    }
    if (input.get(i + 4)) {
      t |= (1 << 1);
    }
    if (input.get(i + 5)) {
      t |= 1;
    }
    p.setType(t);

    if (t == Packet.LITERAL) {
      i = parseLiteral(i + 6, p, input);
    } else {
      if (input.get(i +  6)) {
        i = parseNumPackets(i +  7, p, input);
      } else {
        i = parseLenPackets(i + 7, p, input);
      }
    }

    return i;
  }

  public static int parseLenPackets(int i, Packet p, BitSet input) {
    int len = 0;
    for (int j = 0; j < 15; ++j) {
      if (input.get(i + j)) {
        len |= (1 << (14 - j));
      }
    }
    i += 15;
    int endPacket = i + len;
    while (i < endPacket) {
      Packet newPacket = new Packet();
      i = parsePacket(i, newPacket, input);
      p.addEmbeddedPackets(newPacket);
    }
    return i;
  }

  public static int parseNumPackets(int i, Packet p, BitSet input) {
    int num = 0;
    for (int j = 0; j < 11; ++j) {
      if (input.get(i + j)) {
        num |= (1 << (10 - j));
      }
    }
    i += 11;
    for (int j = 0; j < num; ++j) {
      Packet newPacket = new Packet();
      i = parsePacket(i, newPacket, input);
      p.addEmbeddedPackets(newPacket);
    }
    return i;
  }
  public static int parseLiteral(int i, Packet p, BitSet input) {
    long n = 0;
    while (true) {
      boolean f = input.get(i);
      if (input.get(i + 1)) {
        n |= (1 << 3);
      }
      if (input.get(i + 2)) {
        n |= (1 << 2);
      }
      if (input.get(i + 3)) {
        n |= (1 << 1);
      }
      if (input.get(i + 4)) {
        n |= 1;
      }
      i += 5;
      if (f) {
        n = n << 4;
      } else {
        break;
      }
    }
    p.setValue(n);
    return i;
  }

  public static int solvePart1(BitSet input) {
    Packet p = new Packet();
    parsePacket(0, p, input);

    return getVersionSum(p);
  }

  public static int getVersionSum(Packet p)  {
    int v = p.getVersion();

    for (Packet embedded : p.getEmbeddedPackets()) {
      v += getVersionSum(embedded);
    }

    return v;
  }

  public static long solvePart2(BitSet input) {
    Packet p = new Packet();
    parsePacket(0, p, input);

    return p.getValue();
  }
}
