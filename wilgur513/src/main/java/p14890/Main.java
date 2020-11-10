package p14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static RoadParser parser;
    private static RoadAnalysis analysis;
    private static RoadCounter counter;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.valueOf(tokenizer.nextToken());
        int l = Integer.valueOf(tokenizer.nextToken());

        initRoadAnalysis(l);
        initRoadParser(n);
        initRoadCounter();
    }

    private static void initRoadAnalysis(int l){
        analysis = new RoadAnalysis(l);
    }

    private static void initRoadParser(int n) throws IOException {
        parser = new RoadParser(inputRoad(n));
    }

    private static void initRoadCounter() {
        counter = new RoadCounter(parser, analysis);
    }

    private static String[] inputRoad(int n) throws IOException {
        String[] road = new String[n];

        for(int i = 0; i < n; i++)
            road[i] = reader.readLine().replaceAll(" ", "");

        return road;
    }

    private static void solve() {
        System.out.println(counter.count());
    }
}
