package p1033;

import org.junit.*;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CockTailTest {
    @Test
    public void cockTailBOJExample1(){
        CockTail cockTail = new CockTail(5);
        cockTail.addRatio(4, 0, 1, 1);
        cockTail.addRatio(4, 1, 3, 1);
        cockTail.addRatio(4, 2, 5, 1);
        cockTail.addRatio(4, 3, 7, 1);
        assertThat(cockTail.getQuantities(), is(Arrays.asList(105L, 35L, 21L, 15L, 105L)));
    }

    @Test
    public void cockTailBOJExample2(){
        CockTail cockTail = new CockTail(10);
        cockTail.addRatio(4, 0, 1, 1);
        cockTail.addRatio(4, 1, 3, 1);
        cockTail.addRatio(4, 2, 5, 1);
        cockTail.addRatio(4, 3, 7, 1);
        cockTail.addRatio(3, 5, 1, 9);
        cockTail.addRatio(3, 6, 8, 2);
        cockTail.addRatio(5, 7, 2, 1);
        cockTail.addRatio(7, 8, 5, 8);
        cockTail.addRatio(5, 9, 1, 6);

        assertThat(cockTail.getQuantities(), is(Arrays.asList(420L, 140L, 84L, 60L, 420L, 540L, 15L, 270L, 432L, 3240L)));
    }

    @Test
    public void cockTailBOJExample3(){
        CockTail cockTail = new CockTail(7);
        cockTail.addRatio(0, 1, 1, 1);
        cockTail.addRatio(0, 5, 1, 1);
        cockTail.addRatio(2, 3, 1, 1);
        cockTail.addRatio(3, 4, 1, 1);
        cockTail.addRatio(4, 5, 1, 1);
        cockTail.addRatio(5, 6, 1, 1);

        assertThat(cockTail.getQuantities(), is(Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 1L)));
    }

    @Test
    public void cockTailUseOnlyOneRatioAndSortedOrder(){
        CockTail cockTail = new CockTail(5);
        cockTail.addRatio(4, 0, 1, 1);
        cockTail.addRatio(4, 1, 1, 1);
        cockTail.addRatio(4, 2, 1, 1);
        cockTail.addRatio(4, 3, 1, 1);
        assertThat(cockTail.getQuantities(), is(Arrays.asList(1L, 1L, 1L, 1L, 1L)));
    }

    @Test
    public void cockTailOneToOneRatioAndSortedOrder(){
        CockTail cockTail = new CockTail(5);
        cockTail.addRatio(4, 0, 6, 6);
        cockTail.addRatio(4, 1, 7, 7);
        cockTail.addRatio(4, 2, 9, 9);
        cockTail.addRatio(4, 3, 9, 9);
        assertThat(cockTail.getQuantities(), is(Arrays.asList(1L, 1L, 1L, 1L, 1L)));
    }

    @Test
    public void cockTailOneToOneRatioAndUnsortedOrder(){
        CockTail cockTail = new CockTail(5);
        cockTail.addRatio(4, 0, 6, 6);
        cockTail.addRatio(0, 1, 7, 7);
        cockTail.addRatio(1, 2, 9, 9);
        cockTail.addRatio(1, 3, 9, 9);
        assertThat(cockTail.getQuantities(), is(Arrays.asList(1L, 1L, 1L, 1L, 1L)));
    }

    @Test
    public void cockTailVaryPrimeRatioAndUnsortedOrder(){
        CockTail cockTail = new CockTail(5);
        cockTail.addRatio(0, 1, 9, 8);
        cockTail.addRatio(3, 2, 4, 3);
        cockTail.addRatio(4, 3, 3, 1);
        cockTail.addRatio(1, 4, 5, 6);

        assertThat(cockTail.getQuantities(), is(Arrays.asList(45L, 40L, 12L, 16L, 48L)));
    }

    @Test
    public void cockTailVaryNonPrimeRatioAndUnsortedOrder(){
        CockTail cockTail = new CockTail(5);
        cockTail.addRatio(0, 1, 9, 3);
        cockTail.addRatio(3, 2, 4, 8);
        cockTail.addRatio(4, 3, 2, 8);
        cockTail.addRatio(1, 4, 4, 2);

        assertThat(cockTail.getQuantities(), is(Arrays.asList(6L, 2L, 8L, 4L, 1L)));
    }

    @Test
    public void cockTailUseThreeGroup(){
        CockTail cockTail = new CockTail(6);
        cockTail.addRatio(0, 1, 2, 3);
        cockTail.addRatio(3, 2, 4, 8);
        cockTail.addRatio(0, 3, 2, 8);
        cockTail.addRatio(5, 4, 5, 7);
        cockTail.addRatio(2, 5, 6, 7);

        assertThat(cockTail.getQuantities(), is(Arrays.asList(30L, 45L, 240L, 120L, 8*49L, 8*35L)));
    }

    @Test
    public void cockTailOnlyOneMaterial(){
        CockTail cockTail = new CockTail(1);
        assertThat(cockTail.getQuantities(), is(Arrays.asList(1L)));
    }

    @Test
    public void cockTailAddSelfRatioAndDepartGroup(){
        CockTail cockTail = new CockTail(3);
        cockTail.addRatio(0, 0, 1, 1);
        cockTail.addRatio(0, 1, 2, 3);
        cockTail.addRatio(0, 2, 3, 4);

        assertThat(cockTail.getQuantities(), is(Arrays.asList(6L, 9L, 8L)));
    }
}
