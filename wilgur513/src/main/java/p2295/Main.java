package p2295;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] list;
    static int[] sum;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        list = new int[n];
        sum = new int[n * n];

        for(int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }

        int index = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                sum[index++] = list[i] + list[j];

        Arrays.sort(sum);
    }

    private static void solve() {
        int result = 0;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                if(Arrays.binarySearch(sum, list[i] - list[j]) >= 0)
                    result = Math.max(result, list[i]);
            }

        System.out.println(result);
    }
}
