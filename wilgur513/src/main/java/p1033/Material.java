package p1033;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Material {
    private long[] factors;

    public Material() {
        factors = new long[10];
    }

    public void multiple(long factor) {
        List<Integer> factorList = Factorization.execute(factor);
        for(int f : factorList)
            factors[f]++;
    }

    public List<Integer> factors() {
        List<Integer> result = new ArrayList<>();
        int[] primeMeasure = {2, 3, 5, 7};

        for(int factor : primeMeasure)
            for(long i = 0; i < factors[factor]; i++)
                result.add(factor);

        return result;
    }

    public void divide(int factor) {
        Factorization.execute(factor).stream().filter(f -> factors[f] > 0).forEach(f -> factors[f]--);
    }

    public int minMeasure() {
        return IntStream.range(2, 10).filter(factor -> factors[factor] > 0).findFirst().orElse(1);
    }

    public long quantity() {
        long result = 1L;

        for(int factor = 2; factor < 10; factor++)
            for(int i = 0; i < factors[factor]; i++)
                result *= factor;

        return result;
    }
}
