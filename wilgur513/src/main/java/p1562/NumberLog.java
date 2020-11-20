package p1562;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberLog {
    private int[] count;

    public NumberLog() {
        count = new int[10];
        Arrays.fill(count, 0);
    }

    public void log(int value) {
        count[value]++;
    }

    public void removeLog(int value) {
        count[value]--;
    }

    public boolean hasLogged(int value) {
        return count[value] > 0;
    }

    public boolean hasLoggedAll() {
        return IntStream.range(0, 10).allMatch(this::hasLogged);
    }

    public int bitMask() {
        return IntStream.range(0, 10)
                .filter(a -> hasLogged(a))
                .reduce(0, (a, b) -> a | (1 << b));
    }
}
