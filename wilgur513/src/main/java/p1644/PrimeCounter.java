package p1644;

public class PrimeCounter {
    private final PrimeSum primeSum;
    private final int num;
    private int count;

    public PrimeCounter(int num, PrimeGenerator generator) {
        this.primeSum = new PrimeSum(generator.getPrimeList());
        this.num = num;
        count = primeSum.isSameWithSum(num) ? 1 : 0;
        count();
    }

    private void count() {
        while(primeSum.hasNextSum(num)){
            handleNextSum(num);
        }
    }

    private void handleNextSum(int num) {
        primeSum.makeNextSum(num);

        if(primeSum.isSameWithSum(num))
            count++;
    }

    public int getCount() {
        return count;
    }

    public static PrimeCounter create(int num) {
        return new PrimeCounter(num, new PrimeGenerator(num));
    }
}
