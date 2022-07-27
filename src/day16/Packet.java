package day16;

import java.util.ArrayList;
import java.util.List;

public class Packet {
  final static int LITERAL = 4;
  final static int SUM = 0;
  final static int PRODUCT = 1;
  final static int MIN = 2;
  final static int MAX = 3;
  final static int GT = 5;
  final static int LT = 6;
  final static int EQUAL = 7;

  int version;
  int type;

  long value;

  private List<Packet> embedded;

  public Packet() {
    embedded = new ArrayList<>();
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public int getVersion() {
    return version;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }

  public void setValue(long value) {
    this.value = value;
  }

  public long getValue() {
    switch (type) {
      case Packet.LITERAL:
        return value;
      case Packet.SUM:
        long sum = 0;
        for (Packet p : embedded) {
          sum += p.getValue();
        }
        return sum;
      case Packet.PRODUCT:
        long product = embedded.get(0).getValue();
        for (int i = 1; i < embedded.size(); ++i) {
          product *= embedded.get(i).getValue();
        }
        return product;
      case Packet.MIN:
        long min = embedded.get(0).getValue();
        for (int i = 1; i < embedded.size(); ++i) {
          min = Math.min(embedded.get(i).getValue(), min);
        }
        return min;
      case Packet.MAX:
        long max = embedded.get(0).getValue();
        for (int i = 1; i < embedded.size(); ++i) {
          max = Math.max(embedded.get(i).getValue(), max);
        }
        return max;
      case Packet.GT:
        return embedded.get(0).getValue() > embedded.get(1).getValue() ? 1 : 0;
      case Packet.LT:
        return embedded.get(0).getValue() < embedded.get(1).getValue() ? 1 : 0;
      case Packet.EQUAL:
        return embedded.get(0).getValue() == embedded.get(1).getValue() ? 1 : 0;
    }
    return 0;
  }

  public void addEmbeddedPackets(Packet p) {
    embedded.add(p);
  }

  public List<Packet> getEmbeddedPackets() {
    return embedded;
  }
}
