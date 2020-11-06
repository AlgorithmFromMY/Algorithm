package p2502;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Solution solution;
    private static TransformFibonacci alpha = new TransformFibonacci(1, 0);
    private static TransformFibonacci beta = new TransformFibonacci(0, 1);
    private static int d, k;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        d = scanner.nextInt();
        k = scanner.nextInt();
        solution = new Solution(k);
    }

    private static void solve() {
        solution.solve(alpha.apply(d - 1), beta.apply(d - 1));
        System.out.println(solution.getA());
        System.out.println(solution.getB());
    }
}
