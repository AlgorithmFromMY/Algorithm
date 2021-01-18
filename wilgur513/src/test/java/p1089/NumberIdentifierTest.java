package p1089;

import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class NumberIdentifierTest {
    private Convertor convertor;
    private NumberIdentifier identifier;

    @Before
    public void setUp() throws Exception {
        convertor = new Convertor();
        identifier = new NumberIdentifier();
    }

    @Test
    public void convertToZeroBit(){
        int expected = convertor.convert(new String[]{"...", "...", "...", "...", "..."});
        assertThat(expected, is(0b000_000_000_000_000));
    }

    @Test
    public void convertToComplicateBit(){
        int expected = convertor.convert(new String[]{".#.", "##.", "...", ".#.", "##."});
        assertThat(expected, is(0b010_110_000_010_110));
    }

    @Test
    public void identifyNoNumberLamp(){
        List<Integer> expected = identifier.identify(convertor.convert(new String[]{"...", ".#.", "...", "...", "..."}));
        assertThat(expected, is(Arrays.asList()));
    }

    @Test
    public void identifyByZeroNumberLamp(){
        List<Integer> expected = identifier.identify(convertor.convert(new String[]{"###", "#.#", "#.#", "#.#", "###"}));
        assertThat(expected, is(Arrays.asList(0, 8)));
    }

    @Test
    public void identifyByEmptyLamp(){
        List<Integer> expected = identifier.identify(convertor.convert(new String[]{"...", "...", "...", "...", "..."}));
        assertThat(expected, is(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @Test
    public void answersArithmeticMeanOfTwoNumbers(){
        // Arrange
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // Act
        int actualResult = collection.arithmeticMean();

        // Assert
        assertThat(actualResult, is(6));
    }

    private class ScoreCollection {
        public void add(Supplier o) {
        }

        public int arithmeticMean() {
            return 0;
        }
    }
}
