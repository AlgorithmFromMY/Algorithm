package p1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Cranes cranes;
    private static Integer[] luggage;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        initCranes();
        initLuggage();
    }

    private static void initCranes() throws IOException {
        int n = Integer.valueOf(reader.readLine());
        cranes = new Cranes();

        for(int weight : inputIntegerArray(n))
            cranes.add(new Crane(weight));
    }

    private static void initLuggage() throws IOException {
        int m = Integer.valueOf(reader.readLine());
        luggage = inputIntegerArray(m);
        Arrays.sort(luggage, Collections.reverseOrder());
    }

    private static Integer[] inputIntegerArray(int size) throws IOException {
        Integer[] result = new Integer[size];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0; i < size; i++)
            result[i] = Integer.valueOf(tokenizer.nextToken());

        return result;
    }

    private static void solve() {
        System.out.println(requiredTime());
    }

    private static int requiredTime(){
        if(!cranes.canTakeLuggage(luggage[0]))
            return -1;

        for(int w : luggage)
            cranes.take(w);

        return cranes.requiredTime();
    }
}
