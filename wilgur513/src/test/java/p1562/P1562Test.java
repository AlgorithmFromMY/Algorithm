package p1562;

import org.junit.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class P1562Test {
    private NumberLog log;
    private Cache cache;

    @Before
    public void setUp() throws Exception {
        log = new NumberLog();
        cache = new Cache();
    }

    @Test
    public void hasLoggedWithNothingLogged(){
        hasLoggedEachNumber(new int[]{});
    }

    @Test
    public void hasLoggedWithLoggedSomething(){
        log.log(2);
        log.log(9);

        hasLoggedEachNumber(new int[]{2, 9});
    }

    @Test
    public void hasLoggedWithDuplicateLog(){
        log.log(2);
        log.log(2);
        hasLoggedEachNumber(new int[]{2});

        log.log(3);
        hasLoggedEachNumber(new int[]{2, 3});

        log.log(3);
        hasLoggedEachNumber(new int[]{2, 3});
    }

    @Test
    public void hasLoggedAll(){
        for(int value = 0; value < 10; value++)
            log.log(value);

        hasLoggedEachNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertThat(log.hasLoggedAll(), is(true));
    }

    @Test
    public void removeLog(){
        log.log(2);
        log.log(3);
        log.log(5);

        log.removeLog(5);
        hasLoggedEachNumber(new int[]{2, 3});

        log.removeLog(2);
        hasLoggedEachNumber(new int[]{3});
    }

    @Test
    public void removeDuplicateLog(){
        log.log(2);
        log.log(3);
        log.log(3);
        log.log(5);

        log.removeLog(3);
        hasLoggedEachNumber(new int[]{2, 3, 5});

        log.removeLog(3);
        hasLoggedEachNumber(new int[]{2, 5});
    }
    @Test
    public void bitMask(){
        assertThat(log.bitMask(), is(0));

        log.log(3);
        log.log(9);

        assertThat(log.bitMask(), is(0b1000001000));

        log.log(2);

        assertThat(log.bitMask(), is(0b1000001100));
    }

    @Test
    public void hasAnyValueNotAddedCache(){
        assertThat(cache.hasValue(3, 5, 0b0000000001), is(false));
        assertThat(cache.hasValue(2, 4, 0b0011000001), is(false));
        assertThat(cache.hasValue(1, 0, 0b0011010001), is(false));
        assertThat(cache.hasValue(6, 2, 0b0010000101), is(false));
    }

    @Test
    public void hasValueAddedCache(){
        cache.put(100, 5, 0b0000000000, 10);
        assertThat(cache.hasValue(100, 5, 0b0000000000), is(true));

        cache.put(1, 5, 0b1111000000, 23232);
        assertThat(cache.hasValue(1, 5, 0b1111000000), is(true));

        cache.put(100, 0, 0b1111111111, 999999999);
        assertThat(cache.hasValue(100, 0, 0b1111111111), is(true));
    }

    @Test
    public void getValue(){
        cache.put(100, 5, 0b0000000000, 10);
        assertThat(cache.get(100, 5, 0b0000000000), is(10));

        cache.put(1, 5, 0b1111000000, 23232);
        assertThat(cache.get(1, 5, 0b1111000000), is(23232));

        cache.put(100, 0, 0b1111111111, 999999999);
        assertThat(cache.get(100, 0, 0b1111111111), is(999999999));
    }

    private void hasLoggedEachNumber(int[] include){
        IntStream.range(0, 10).forEach(
                a -> assertThat(log.hasLogged(a), is(actualValue(a, include)))
        );
    }

    private boolean actualValue(int value, int[] include) {
        return include(value, include) ? true : false;
    }

    private boolean include(int value, int[] include) {
        return Arrays.stream(include).anyMatch(a -> a == value);
    }
}
