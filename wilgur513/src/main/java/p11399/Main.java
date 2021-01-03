package p11399;

import java.util.*;
import java.io.*;

class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] list;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        n = Integer.valueOf(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        list = new int[n];

        for(int i = 0; i < n; i++)
            list[i] = Integer.valueOf(tokenizer.nextToken());

        Arrays.sort(list);
    }

    private static void solve() {
        int result = 0;

        for(int i = n; i >= 1; i--)
            result += i * list[n - i];

        System.out.println(result);
    }
}
