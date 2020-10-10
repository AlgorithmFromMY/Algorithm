package p2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static SNS sns;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        int n = Integer.valueOf(reader.readLine());
        initSNS(n);
    }

    private static void initSNS(int n) throws IOException {
        sns = new SNS(n);

        for(int i = 0; i < n - 1; i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            sns.relate(Integer.valueOf(tokenizer.nextToken()) - 1, Integer.valueOf(tokenizer.nextToken()) - 1);
        }
    }

    private static void solve() {
        System.out.println(sns.getMinEarlyAdapter());
    }
}
