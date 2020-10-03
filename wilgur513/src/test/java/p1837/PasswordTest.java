package p1837;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PasswordTest {
    @Test
    public void bojExample1(){
        Password password = new Password(String.valueOf(11*13), 10);
        assertThat(password.isSafe(), is(true));
    }

    @Test
    public void bojExample2(){
        Password password = new Password(String.valueOf(7*11), 12);
        assertThat(password.isSafe(), is(false));
        assertThat(password.getUnsafeNumber(), is(7));
    }

    @Test
    public void primeNumbersUnderTen(){
        assertThat(new PrimeNumbers(10).create(), is(Arrays.asList(2, 3, 5, 7)));
    }
}
