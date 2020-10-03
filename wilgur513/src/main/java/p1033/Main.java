package p1033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static CockTail cockTail;

    public static void main(String[] args) throws IOException {
        initData();
        solve();
    }

    private static void initData() throws IOException {
        initCocktail();
        addMaterialRatio();
    }

    private static void initCocktail() throws IOException {
        n = Integer.valueOf(reader.readLine());
        cockTail = new CockTail(n);
    }

    private static void addMaterialRatio() throws IOException {
        for(int i = 0; i < n - 1; i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.valueOf(tokenizer.nextToken());
            int b = Integer.valueOf(tokenizer.nextToken());
            int p = Integer.valueOf(tokenizer.nextToken());
            int q = Integer.valueOf(tokenizer.nextToken());
            cockTail.addRatio(a, b, p, q);
        }
    }

    private static void solve() {
        for(long quantity : cockTail.getQuantities())
            System.out.print(quantity + " ");
    }
}
