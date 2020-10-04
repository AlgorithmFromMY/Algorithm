package p1837;

import java.math.BigInteger;

public class Password {
    private BigInteger p;
    private PrimeNumbers primeNumbers;

    public Password(String p, int k) {
        this.p = new BigInteger(p);
        primeNumbers = new PrimeNumbers(k);
    }

    public boolean isSafe() {
        return hasUnderKPrimeMeasure() ? false : true;
    }

    public int getUnsafeNumber(){
        for(int prime : primeNumbers.create())
            if(p.mod(new BigInteger(String.valueOf(prime))).equals(BigInteger.ZERO))
                return prime;

        throw new IllegalStateException();
    }

    private boolean hasUnderKPrimeMeasure(){
        for(int prime : primeNumbers.create()){
            if(p.mod(new BigInteger(String.valueOf(prime))).equals(BigInteger.ZERO))
                return true;
        }

        return false;
    }
}
