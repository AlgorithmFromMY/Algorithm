package p12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[][] map;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new long[n][n];

        for(int y = 0; y < n; y++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            for(int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    private static void solve() {
        Map m = new Map(map);
        System.out.println(m.getMaxValue());
    }
}
