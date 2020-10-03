package p1837;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbers {
    private int size;
    private boolean[] isPrime;

    public PrimeNumbers(int size){
        this.size = size;
        initIsPrime();
        findPrime();
    }

    public List<Integer> create() {
        List<Integer> result = new ArrayList<>();

        for(int value = 0; value < size; value++)
            if(isPrime[value])
                result.add(value);

        return result;
    }

    private void findPrime() {
        for(int value = 2; value < size; value++){
            for(int factor = 2; value * factor < size; factor++){
                isPrime[value * factor] = false;
            }
        }
    }

    private void initIsPrime(){
        isPrime = new boolean[size];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
    }
}
