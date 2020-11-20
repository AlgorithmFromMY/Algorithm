package p1092;

public class Crane implements Comparable<Crane>{
    private int weight;
    private int time;

    public Crane(int weight) {
        this.weight = weight;
    }

    public boolean canTake(int luggage) {
        return weight >= luggage;
    }

    public void take() {
        time++;
    }

    public int requiredTime() {
        return time;
    }

    @Override
    public int compareTo(Crane o) {
        return Integer.compare(weight, o.weight);
    }
}
