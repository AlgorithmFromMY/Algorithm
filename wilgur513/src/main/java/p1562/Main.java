package p1562;

import java.util.Scanner;

public class Main {
    private static final int MOD = 1_000_000_000;
    private static Cache cache = new Cache();
    private static NumberLog log = new NumberLog();
    private static int n;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        n = new Scanner(System.in).nextInt();
    }

    private static void solve() {
        int result = 0;

        for (int digit = 1; digit < 10; digit++) {
            log.log(digit);
            result = (result + numberOfStairNumbers(n, digit, log)) % MOD;
            log.removeLog(digit);
        }

        System.out.println(result);
    }

    private static int numberOfStairNumbers(int n, int digit, NumberLog log) {
        if(n == 1)
            return log.hasLoggedAll() ? 1 : 0;

        if(!cache.hasValue(n, digit, log.bitMask())){
            int result = 0;

            if(digit != 9) {
                log.log(digit + 1);
                result = numberOfStairNumbers(n - 1, digit + 1, log);
                log.removeLog(digit + 1);
            }

            if(digit != 0) {
                log.log(digit - 1);
                result = (result + numberOfStairNumbers(n - 1, digit - 1, log)) % MOD;
                log.removeLog(digit - 1);
            }

            cache.put(n, digit, log.bitMask(), result);
        }

        return cache.get(n, digit, log.bitMask());
    }
}
