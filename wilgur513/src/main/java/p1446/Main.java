package p1446;

import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int n, d;
    private static DistanceCalculator calculator;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        initializeData();
        initializeCalculator(getShortCutData());
    }

    private static void initializeData() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.valueOf(tokenizer.nextToken());
        d = Integer.valueOf(tokenizer.nextToken());
    }

    private static List<ShortCut> getShortCutData() throws IOException {
        List<ShortCut> result = new ArrayList<>();

        for(int id = 0; id < n; id++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.valueOf(tokenizer.nextToken());
            int to = Integer.valueOf(tokenizer.nextToken());
            int distance = Integer.valueOf(tokenizer.nextToken());
            result.add(new ShortCut(id, from, to, distance));
        }

        return result;
    }

    private static void initializeCalculator(List<ShortCut> shortCuts) {
        calculator = new DistanceCalculator(d, shortCuts);
    }

    private static void solve() {
        System.out.println(calculator.getMinDistance(0));
    }
}
