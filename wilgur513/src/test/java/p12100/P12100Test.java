package p12100;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class P12100Test {
    @Test
    public void slideLeft() {
        Slider slider = new LeftSlider();
        long[][] map = {{0, 2, 2}, {2, 2, 4}, {0, 4, 8}};
        long[][] actual = slider.slide(map);

        assertThat(actual[0], is(new long[]{4, 0, 0}));
        assertThat(actual[1], is(new long[]{4, 4, 0}));
        assertThat(actual[2], is(new long[]{4, 8, 0}));
    }

    @Test
    public void slideUp() {
        Slider slider = new UpSlider();
        long[][] map = {{2, 2, 0}, {2, 4, 4}, {2, 8, 4}};
        long[][] actual = slider.slide(map);

        assertThat(actual[0], is(new long[]{4, 2, 8}));
        assertThat(actual[1], is(new long[]{2, 4, 0}));
        assertThat(actual[2], is(new long[]{0, 8, 0}));
    }

    @Test
    public void slideDown() {
        Slider slider = new DownSlider();
        long[][] map = {{2, 2, 2}, {2, 4, 8}, {2, 4, 16}};
        long[][] actual = slider.slide(map);

        assertThat(actual[0], is(new long[]{0, 0, 2}));
        assertThat(actual[1], is(new long[]{2, 2, 8}));
        assertThat(actual[2], is(new long[]{4, 8, 16}));
    }

    @Test
    public void slideRight() {
        Slider slider = new RightSlider();
        long[][] map = {{2, 2, 2}, {2, 4, 8}, {4, 4, 8}};
        long[][] actual = slider.slide(map);

        for(int i = 0; i < 3; i++)
            System.out.println(Arrays.toString(actual[i]));

        assertThat(actual[0], is(new long[]{0, 2, 4}));
        assertThat(actual[1], is(new long[]{2, 4, 8}));
        assertThat(actual[2], is(new long[]{0, 8, 8}));
    }

    @Test
    public void emptyMap() {
        Map map = new Map(new long[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        assertThat(map.getMaxValue(), is(0L));
    }

    @Test
    public void hasOneBlockMap() {
        Map map = new Map(new long[][] {{0, 0, 2}, {0, 0, 0}, {0, 0, 0}});
        assertThat(map.getMaxValue(), is(2L));

        map = new Map(new long[][] {{0, 0, 0}, {8, 0, 0}, {0, 0, 0}});
        assertThat(map.getMaxValue(), is(8L));
    }

    @Test
    public void hasMultipleBlockButCanNotCombine() {
        Map map = new Map(new long[][] {{0, 0, 2}, {0, 0, 8}, {16, 0, 0}});
        assertThat(map.getMaxValue(), is(16L));
    }

    @Test
    public void makeMaxValueBySlideToLeftOnce() {
        Map map = new Map(new long[][] {{4, 4, 0}, {0, 0, 0}, {2, 0, 0}});
        assertThat(map.getMaxValue(), is(8L));

        map = new Map(new long[][] {{4, 0, 4}, {0, 0, 0}, {2, 0, 0}});
        assertThat(map.getMaxValue(), is(8L));
    }

    @Test
    public void makeMaxValueBySlideToLeftMultiple() {
        Map map = new Map(new long[][]{{16, 16, 32}, {0, 0, 0}, {8, 0, 0}});
        assertThat(map.getMaxValue(), is(64L));
    }

    @Test
    public void makeMaxValueBySlideToUpMultiple() {
        Map map = new Map(new long[][]{{2, 0, 0}, {2, 0, 0}, {4, 0, 2}});
        assertThat(map.getMaxValue(), is(8L));
    }

    @Test
    public void makeMaxValueBySlideToMultipleWay() {
        Map map = new Map(new long[][]{{2, 2, 2, 2}, {8, 0, 0, 0}, {0, 0, 0, 0}, {16, 0, 0, 0}});
        assertThat(map.getMaxValue(), is(32L));

        map = new Map(new long[][]{{4, 4, 8}, {4, 4, 8}, {8, 8, 16}});
        assertThat(map.getMaxValue(), is(64L));

        map = new Map(new long[][]{{4, 8, 4}, {0, 0, 0}, {2, 0, 16}});
        assertThat(map.getMaxValue(), is(32L));
    }
}
