package p1644;

public class Value {
    private int value;

    public Value(int value) {
        this.value = value;
    }

    public boolean isSameAndUnder(int num) {
        return isSame(num) || isUnder(num);
    }

    public boolean isSame(int num) {
        return num == value;
    }

    public boolean isUnder(int num) {
        return value < num;
    }

    public boolean isOver(int num) {
        return num < value;
    }

    public void plus(int value) {
        this.value += value;
    }

    public void minus(int value) {
        this.value -= value;
    }
}
