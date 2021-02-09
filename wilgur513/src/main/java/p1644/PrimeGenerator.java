package p1644;

import java.util.*;

public class PrimeGenerator {
    private final int upper;
    private final boolean[] isPrime;
    private final List<Integer> primes;

    public PrimeGenerator(int upper) {
        this.upper = upper;
        isPrime = new boolean[upper + 1];
        primes = new ArrayList<>();
        findPrimes();
    }

    private void findPrimes() {
        prepareIsPrimeFlags();
        checkIsPrime();
        addFoundPrimeToList();
    }

    private void prepareIsPrimeFlags() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
    }

    private void checkIsPrime() {
        for(int value = 2; value <= upper; value++){
            for(int mul = 2; mul * value <= upper; mul++){
                if(isPrime[mul * value]){
                    isPrime[mul * value] = false;
                }
            }
        }
    }

    private void addFoundPrimeToList() {
        for(int value = 2; value <= upper; value++){
            if(isPrime[value]) {
                primes.add(value);
            }
        }
    }

    public PrimeList getPrimeList() {
        return new PrimeList(primes);
    }
}
