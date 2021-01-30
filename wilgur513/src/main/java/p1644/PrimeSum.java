package p1644;

public class PrimeSum {
    private final PrimeList list;
    private final Value sum;

    public PrimeSum(PrimeList list) {
        this.list = list;
        sum = new Value(list.getSuffix());
    }

    public boolean hasNextSum(int num) {
        if(sum.isSameAndUnder(num) && list.isNoMoreSuffixElement())
            return false;

        if(sum.isOver(num) && list.isPrefixAndSuffixSame())
            return false;

        return true;
    }

    public void makeNextSum(int num) {
        if(sum.isSameAndUnder(num) && !list.isNoMoreSuffixElement()) {
            addSuffixToSum();
        }

        if(sum.isOver(num) && !list.isPrefixAndSuffixSame()){
            removePrefixFromSum();
        }
    }

    private void addSuffixToSum() {
        sum.plus(list.popSuffix());
    }

    private void removePrefixFromSum() {
        sum.minus(list.popPrefix());
    }

    public boolean isSameWithSum(int num) {
        return sum.isSame(num);
    }
}
