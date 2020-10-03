package p1033;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class FactorizationTest {
    @Test
    public void factorizationOne(){
        List<Integer> expected = Factorization.execute(1);
        List<Integer> actual = Arrays.asList();
        assertThat(expected, is(actual));
    }

    @Test
    public void factorizationTwo(){
        List<Integer> expected = Factorization.execute(2);
        List<Integer> actual = Arrays.asList(2);
        assertThat(expected, is(actual));
    }

    @Test
    public void factorizationNonPrimeNumber(){
        List<Integer> expected = Factorization.execute(16);
        List<Integer> actual = Arrays.asList(2, 2, 2, 2);
        assertThat(expected, is(actual));
    }

    @Test
    public void factorizationComplicateNumber(){
        List<Integer> expected = Factorization.execute(2*2*3*4*9);
        List<Integer> actual = Arrays.asList(2, 2, 2, 2, 3, 3, 3);
        assertThat(expected, is(actual));
    }
}
