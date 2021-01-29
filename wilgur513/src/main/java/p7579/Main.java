package p7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int NEG = -987654321;
    static int n, m;
    static int[] memory;
    static int[] cost;
    static int[][] cache;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.valueOf(tokenizer.nextToken());
        m = Integer.valueOf(tokenizer.nextToken());

        memory = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++)
            memory[i] = Integer.valueOf(tokenizer.nextToken());

        cost = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++)
            cost[i] = Short.valueOf(tokenizer.nextToken());

        cache = new int[n + 1][10001];
        for(int i = 0; i <= n; i++)
            Arrays.fill(cache[i], -1);
    }

    private static void solve() {
        int cost = 0;

        while(!isPossibleCost(cost)){
            cost++;
        }

        System.out.println(cost);
    }

    private static boolean isPossibleCost(int cost){
        return maxMemory(0, cost) >= m;
    }

    private static int maxMemory(int index, int c){
        if(isBaseCondition(index, c))
            return baseValue(c);

        if(cache[index][c] == -1){
            cache[index][c] = Math.max(maxMemoryInactiveCurrentApp(index, c),
                                        maxMemoryActiveCurrentApp(index, c));
        }

        return cache[index][c];
    }

    private static boolean isBaseCondition(int index, int c){
        return c == 0 || (index == n || c < 0);
    }

    private static int baseValue(int c){
        return c == 0 ? 0 : NEG;
    }

    private static int maxMemoryInactiveCurrentApp(int index, int c){
        int maxMemory = maxMemory(index + 1, c - cost[index]);
        return maxMemory == -1 ? NEG : maxMemory + memory[index];
    }

    private static int maxMemoryActiveCurrentApp(int index, int c){
        int maxMemory = maxMemory(index + 1, c);
        return maxMemory == - 1 ? NEG : maxMemory;
    }
}
