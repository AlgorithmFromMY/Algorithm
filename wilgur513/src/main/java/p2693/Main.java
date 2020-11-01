package p2693;

import java.util.*;
import java.io.*;

class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        int n = Integer.valueOf(reader.readLine());

        for(int i = 0; i < n; i++)
            runSingleTestCase();
    }

    private static void runSingleTestCase() throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0; i < 10; i++){
            queue.add(Integer.parseInt(tokenizer.nextToken()));
        }
    }

    private static void solve() {
        queue.remove();
        queue.remove();
        System.out.println(queue.remove());
    }
}

