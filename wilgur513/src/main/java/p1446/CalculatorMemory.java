package p1446;

import java.util.Arrays;

class CalculatorMemory {
    private int[] cache;

    public CalculatorMemory() {
        cache = new int[10001];
        Arrays.fill(cache, -1);
    }

    public void store(int a, int value) {
        cache[a] = value;
    }

    public int get(int a) {
        return cache[a];
    }

    public boolean hasValue(int a) {
        return cache[a] != -1;
    }
}
