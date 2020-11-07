package p14726;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class P14726Test {
    private CardNumber number;

    @Before
    public void setUp() throws Exception {
        number = new CardNumber();
    }

    @Test
    public void twiceOddPositionIsZeroNumber(){
        String expected = number.twiceAndReduce("0102030405060708");
        assertThat(expected, is("0102030405060708"));
    }

    @Test
    public void twiceOddPositionIsUnderFour(){
        String expected = number.twiceAndReduce("1123364927093214");
        assertThat(expected, is("2143668947096224"));
    }

    @Test
    public void twiceAndReduceOddPositionIsOverFour(){
        String expected = number.twiceAndReduce("5166778899528677");
        assertThat(expected, is("1136577899127657"));
    }

    @Test
    public void reduceToSumZeroNumber(){
        int expected = number.reduceToSum("0000000000000000");
        assertThat(expected, is(0));
    }

    @Test
    public void reduceToSumOneNumber(){
        int expected = number.reduceToSum("1111111111111111");
        assertThat(expected, is(16));
    }

    @Test
    public void reduceToSumVaryNumber(){
        int expected = number.reduceToSum("1463246779010084");
        assertThat(expected, is(62));
    }
}
