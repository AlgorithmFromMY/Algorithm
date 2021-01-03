package p2536;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k;
    static int[] from, to;
    static Graph graph;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.valueOf(tokenizer.nextToken());
        m = Integer.valueOf(tokenizer.nextToken());
        k = Integer.valueOf(reader.readLine());

        Bus[] buses = new Bus[k];
        for(int i = 0; i < k; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int id = Integer.valueOf(tokenizer.nextToken()) - 1;
            int fromX = Integer.valueOf(tokenizer.nextToken());
            int fromY = Integer.valueOf(tokenizer.nextToken());
            int toX = Integer.valueOf(tokenizer.nextToken());
            int toY = Integer.valueOf(tokenizer.nextToken());

            Bus bus = new Bus(new int[]{fromY, fromX}, new int[]{toY, toX});
            buses[id] = bus;
        }

        graph = new Graph(k, buses);

        tokenizer = new StringTokenizer(reader.readLine());
        from = new int[2];
        to = new int[2];
        from[1] = Integer.valueOf(tokenizer.nextToken());
        from[0] = Integer.valueOf(tokenizer.nextToken());
        to[1] = Integer.valueOf(tokenizer.nextToken());
        to[0] = Integer.valueOf(tokenizer.nextToken());
    }

    private static void solve() {
        System.out.println(graph.minExchange(from, to));
    }
}
