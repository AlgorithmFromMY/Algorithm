package p1562;

import java.util.Arrays;

public class Cache {
    private int[][][] cache;

    public Cache() {
        cache = new int[101][10][1 << 10];

        for(int i = 0; i < 101; i++)
            for(int j = 0; j < 10; j++)
                Arrays.fill(cache[i][j], -1);
    }

    public boolean hasValue(int n, int digit, int bit) {
        return cache[n][digit][bit] != -1;
    }

    public void put(int n, int digit, int bit, int value) {
        cache[n][digit][bit] = value;
    }

    public int get(int n, int digit, int bit) {
        return cache[n][digit][bit];
    }
}
