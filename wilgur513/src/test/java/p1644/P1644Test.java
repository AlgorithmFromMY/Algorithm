package p1644;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class P1644Test {
    @Test
    public void primeNumberListUnderInputNumberThatIsNotPrime() {
        PrimeGenerator generator = new PrimeGenerator(12);
        assertThat(generator.getPrimeList(), is(new PrimeList(Arrays.asList(2, 3, 5, 7, 11))));
    }

    @Test
    public void primeNumberListUnderInputNumberThatIsPrime() {
        PrimeGenerator generator = new PrimeGenerator(23);
        assertThat(generator.getPrimeList(), is(new PrimeList(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23))));
    }

    @Test
    public void numberThatCanNotMadeByPrimeNumber() {
        assertThat(result(4), is(0));
        assertThat(result(20), is(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void primeNumberThatIsMinimalNumber() {
        assertThat(result(1), is(0));
    }

    @Test
    public void primeNumberThatHasOnlyItselfNumber() {
        assertThat(result(3), is(1));
        assertThat(result(11), is(1));
    }

    @Test
    public void primeNumberThatHasMoreCase() {
        assertThat(result(41), is(3));
        assertThat(result(53), is(2));
    }

    private int result(int num){
        return PrimeCounter.create(num).getCount();
    }
}
