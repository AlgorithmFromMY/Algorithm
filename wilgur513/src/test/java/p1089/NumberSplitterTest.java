package p1089;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class NumberSplitterTest {
    @Test
    public void splitEmptyNumberString(){
        NumberSplitter splitter = new NumberSplitter(new String[]{"", "", "", "", ""});
        assertThat(splitter.hasNext(), is(false));
    }

    @Test
    public void splitOneNumberString(){
        NumberSplitter splitter = new NumberSplitter(new String[]{"###", "#.#", "###", "#.#", "#.#"});
        assertThat(splitter.hasNext(), is(true));
        assertThat(splitter.next(), is(new String[]{"###", "#.#", "###", "#.#", "#.#"}));
    }

    @Test
    public void splitMoreNumberString(){
        NumberSplitter splitter = new NumberSplitter(new String[]{"###.###.#.#", "#.#...#.#.#", "###.###.###", "#.#.....#.#",
                                                                  "#.#.#...#.."});
        assertThat(splitter.hasNext(), is(true));
        assertThat(splitter.next(), is(new String[]{"###", "#.#", "###", "#.#", "#.#"}));

        assertThat(splitter.hasNext(), is(true));
        assertThat(splitter.next(), is(new String[]{"###", "..#", "###", "...", "#.."}));

        assertThat(splitter.hasNext(), is(true));
        assertThat(splitter.next(), is(new String[]{"#.#", "#.#", "###", "#.#", "#.."}));

        assertThat(splitter.hasNext(), is(false));
    }
}
