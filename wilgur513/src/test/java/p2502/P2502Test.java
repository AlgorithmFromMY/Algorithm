package p2502;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class P2502Test {
    @Test
    public void transformFibZeroArg(){
        TransformFibonacci fib = new TransformFibonacci(0, 1);
        int expected = fib.apply(0);
        assertThat(expected, is(0));

        fib = new TransformFibonacci(1, 0);
        expected = fib.apply(0);
        assertThat(expected, is(1));
    }

    @Test
    public void transformFibOneArg(){
        TransformFibonacci fib = new TransformFibonacci(0, 1);
        int expected = fib.apply(1);
        assertThat(expected, is(1));

        fib = new TransformFibonacci(2, 3);
        expected = fib.apply(1);
        assertThat(expected, is(3));
    }

    @Test
    public void transformFibNArg(){
        TransformFibonacci fib = new TransformFibonacci(1, 1);
        int expected = fib.apply(5);
        assertThat(expected, is(8));

        fib = new TransformFibonacci(2, 3);
        expected = fib.apply(4);
        assertThat(expected, is(13));
    }

    @Test
    public void calculateCake(){
        int alpha = 3;
        int beta = 5;

        Solution solution = new Solution(41);
        solution.solve(alpha, beta);
        int expectedA = solution.getA();
        int expectedB = solution.getB();

        assertThat(expectedA, is(2));
        assertThat(expectedB, is(7));
    }
}
