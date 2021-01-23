package p2800;

import org.junit.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class P2800Test {
    RemovedExpressionsFinder finder;

    @Before
    public void setUp() throws Exception {
        finder = new RemovedExpressionsFinder();
    }

    @Test
    public void onlyOneParenthesis() {
        List<String> actual = finder.getExpressionList("(0)");
        assertThat(actual, is(Arrays.asList("0")));
    }

    @Test
    public void hasTwoParenthesisAndConsistedOneGroup() {
        List<String> actual = finder.getExpressionList("(0/(0))");
        assertThat(actual, is(Arrays.asList("(0/0)", "0/(0)", "0/0")));
    }

    @Test
    public void hasThreeParenthesisAndConsistedTwoGroup() {
        List<String> actual = finder.getExpressionList("(0/(0))+(1)");
        assertThat(actual, is(Arrays.asList("0/(0)+(1)", "0/0+(1)", "0/0+1", "(0/0)+(1)", "(0/0)+1", "(0/(0))+1", "0/(0)+1")
                .stream().sorted().collect(Collectors.toList())));
    }
}
