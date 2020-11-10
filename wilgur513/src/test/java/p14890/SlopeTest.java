package p14890;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class SlopeTest {
    private RoadAnalysis roadAnalysis;

    @Before
    public void setUp() throws Exception {
        roadAnalysis = new RoadAnalysis();
    }

    @Test
    public void boj1Example(){
        roadAnalysis.setSlopeLength(2);

        assertThat(roadAnalysis.canThroughRoad("333333"), is(true));
        assertThat(roadAnalysis.canThroughRoad("233333"), is(false));
        assertThat(roadAnalysis.canThroughRoad("222323"), is(false));
        assertThat(roadAnalysis.canThroughRoad("111222"), is(true));
        assertThat(roadAnalysis.canThroughRoad("111331"), is(false));
        assertThat(roadAnalysis.canThroughRoad("112332"), is(false));
        assertThat(roadAnalysis.canThroughRoad("322111"), is(true));
        assertThat(roadAnalysis.canThroughRoad("332111"), is(false));
        assertThat(roadAnalysis.canThroughRoad("332112"), is(false));
        assertThat(roadAnalysis.canThroughRoad("333233"), is(false));
        assertThat(roadAnalysis.canThroughRoad("332233"), is(false));
        assertThat(roadAnalysis.canThroughRoad("333212"), is(false));
    }

    @Test
    public void boj2Example(){
        roadAnalysis.setSlopeLength(2);

        assertThat(roadAnalysis.canThroughRoad("321123"), is(false));
        assertThat(roadAnalysis.canThroughRoad("322123"), is(false));
        assertThat(roadAnalysis.canThroughRoad("322233"), is(false));
        assertThat(roadAnalysis.canThroughRoad("333333"), is(true));
        assertThat(roadAnalysis.canThroughRoad("333322"), is(true));
        assertThat(roadAnalysis.canThroughRoad("333333"), is(true));
        assertThat(roadAnalysis.canThroughRoad("222333"), is(true));
        assertThat(roadAnalysis.canThroughRoad("122333"), is(false));
        assertThat(roadAnalysis.canThroughRoad("112333"), is(false));
        assertThat(roadAnalysis.canThroughRoad("223322"), is(true));
        assertThat(roadAnalysis.canThroughRoad("333322"), is(true));
    }

    @Test
    public void sameNumberRoad() {
        roadAnalysis.setSlopeLength(1);

        boolean expected = roadAnalysis.canThroughRoad("11111");
        assertThat(expected, is(true));
    }

    @Test
    public void diffOverTwoHeightUpHillRoad(){
        roadAnalysis.setSlopeLength(1);

        boolean expected = roadAnalysis.canThroughRoad("133333");
        assertThat(expected, is(false));

        expected = roadAnalysis.canThroughRoad("12388888");
        assertThat(expected, is(false));
    }

    @Test
    public void diffOverTwoHeightDownHillRoad(){
        roadAnalysis.setSlopeLength(1);

        boolean expected = roadAnalysis.canThroughRoad("511111");
        assertThat(expected, is(false));

        expected = roadAnalysis.canThroughRoad("754321");
        assertThat(expected, is(false));
    }

    @Test
    public void diffOverTwoHeightUpAndDownHillRoad(){
        roadAnalysis.setSlopeLength(1);

        boolean expected = roadAnalysis.canThroughRoad("12323457");
        assertThat(expected, is(false));

        expected = roadAnalysis.canThroughRoad("12345673");
        assertThat(expected, is(false));
    }

    @Test
    public void canSetSlopeUpHillRoad(){
        roadAnalysis.setSlopeLength(2);

        boolean expected = roadAnalysis.canThroughRoad("112222");
        assertThat(expected, is(true));
    }

    @Test
    public void canNotSetSlopeUpHillRoad(){
        roadAnalysis.setSlopeLength(3);

        boolean expected = roadAnalysis.canThroughRoad("11222");
        assertThat(expected, is(false));
    }

    @Test
    public void canSetSlopeDownHillRoad(){
        roadAnalysis.setSlopeLength(2);

        boolean expected = roadAnalysis.canThroughRoad("333222");
        assertThat(expected, is(true));
    }

    @Test
    public void canNotSetSlopeDownHillRoad(){
        roadAnalysis.setSlopeLength(3);

        boolean expected = roadAnalysis.canThroughRoad("22211");
        assertThat(expected, is(false));
    }

    @Test
    public void canSetSlopeUpAndDownHillRoad(){
        roadAnalysis.setSlopeLength(2);

        boolean expected = roadAnalysis.canThroughRoad("2221111222");
        assertThat(expected, is(true));

        expected = roadAnalysis.canThroughRoad("222111112222");
        assertThat(expected, is(true));
    }

    @Test
    public void canNotSetSlopeUpAndDownHillRoad(){
        roadAnalysis.setSlopeLength(3);

        boolean expected = roadAnalysis.canThroughRoad("2221112222");
        assertThat(expected, is(false));

        roadAnalysis.setSlopeLength(2);

        expected = roadAnalysis.canThroughRoad("2221112222");
        assertThat(expected, is(false));

        expected = roadAnalysis.canThroughRoad("2221111112212321");
        assertThat(expected, is(false));
    }

    @Test
    public void roadParser(){
        String[] input = {"1234", "3572", "9863", "4567"};
        RoadParser parser = new RoadParser(input);
        String[] actual = {"1234", "3572", "9863", "4567", "1394", "2585", "3766", "4237"};

        for(int i = 0; i < 8; i++){
            assertThat(parser.hasNext(), is(true));
            assertThat(parser.next(), is(actual[i]));
        }

        assertThat(parser.hasNext(), is(false));
    }

    @Test
    public void countCanThroughAllRoad(){
        RoadParser parser = Mockito.mock(RoadParser.class);
        Mockito.when(parser.hasNext())
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(parser.next())
                .thenReturn("11")
                .thenReturn("22")
                .thenReturn("12")
                .thenReturn("12");

        RoadAnalysis analysis = Mockito.mock(RoadAnalysis.class);
        Mockito.when(analysis.canThroughRoad(Mockito.anyString()))
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true);

        RoadCounter counter = new RoadCounter(parser, analysis);
        assertThat(counter.count(), is(4));
    }

    @Test
    public void countCanThroughSomeRoad(){
        RoadParser parser = Mockito.mock(RoadParser.class);
        Mockito.when(parser.hasNext())
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(parser.next())
                .thenReturn("11")
                .thenReturn("33")
                .thenReturn("13")
                .thenReturn("13");

        RoadAnalysis analysis = Mockito.mock(RoadAnalysis.class);
        Mockito.when(analysis.canThroughRoad(Mockito.anyString()))
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(false);

        RoadCounter counter = new RoadCounter(parser, analysis);
        assertThat(counter.count(), is(2));
    }

    @Test
    public void mockitoTest(){
        RoadParser parser = Mockito.mock(RoadParser.class);
        Mockito.when(parser.hasNext())
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(parser.next())
                .thenReturn("11")
                .thenReturn("22")
                .thenReturn("12")
                .thenReturn("12");

        RoadAnalysis analysis = Mockito.mock(RoadAnalysis.class);
        Mockito.when(analysis.canThroughRoad(Mockito.anyString()))
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(false);

        String[] values = {"11", "22", "12", "12"};
        for(int i = 0; i < 4; i++) {
            assertThat(parser.hasNext(), is(true));
            assertThat(parser.next(), is(values[i]));
        }
        assertThat(parser.hasNext(), is(false));

        boolean[] flags = {true, true, false, false};
        for(int i = 0; i < 4; i++)
            assertThat(analysis.canThroughRoad(values[i]), is(flags[i]));
    }
}
