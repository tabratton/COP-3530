package assignment.two;

public class IntData implements Sortable {
  private int data;

  public IntData(int data) {
    this.data = data;
  }

  public int compareTo(Object object) {
    IntData temp = (IntData) object;
    return (this.data - temp.getData());
  }

  public int getData() {
    return data;
  }

  public String toString() {
    return Integer.toString(data);
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof IntData && ((IntData) object).data == data;
  }

}
