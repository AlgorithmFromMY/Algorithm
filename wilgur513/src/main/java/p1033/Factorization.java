package p1033;

import java.util.*;

public class Factorization {
    public static List<Integer> execute(long arg) {
        List<Integer> result = new ArrayList<>();

        long value = arg;
        int measure = minMeasure(value);

        while(measure != 1){
            result.add(measure);
            value /= measure;
            measure = minMeasure(value);
        }

        return result;
    }

    private static int minMeasure(long value){
        int[] primeMeasure = {2, 3, 5, 7};

        return (int)Arrays.stream(primeMeasure)
                    .mapToLong(Long::valueOf).filter(measure -> value % measure == 0).findFirst().orElse(value);
    }
}
