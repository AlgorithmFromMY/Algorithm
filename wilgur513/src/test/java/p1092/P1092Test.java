package p1092;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class P1092Test {
    Cranes cranes;

    @Before
    public void setUp() throws Exception {
        cranes = new Cranes();
    }

    @Test
    public void craneCanTakeUnderCraneWeight(){
        Crane crane = new Crane(10);
        assertThat(crane.canTake(9), is(true));
    }

    @Test
    public void craneCanNotTakeOverCraneWeight(){
        Crane crane = new Crane(10);
        assertThat(crane.canTake(11), is(false));
    }

    @Test
    public void craneCompareTo(){
        Crane crane1 = new Crane(1);
        Crane crane2 = new Crane(3);
        Crane crane3 = new Crane(1);

        assertThat(crane1.compareTo(crane2), is(-1));
        assertThat(crane2.compareTo(crane1), is(1));
        assertThat(crane3.compareTo(crane1), is(0));
    }

    @Test
    public void craneTakeLuggage(){
        Crane crane = new Crane(10);
        crane.take();
        crane.take();

        assertThat(crane.requiredTime(),is(2));
    }

    @Test
    public void canNotTakeOverCraneWeightLuggage(){
        cranes.add(new Crane(10));

        assertThat(cranes.canTakeLuggage(11), is(false));
    }

    @Test
    public void canNotTakeOverAllCranesWeightLuggage(){
        cranes.add(new Crane(1));
        cranes.add(new Crane(2));
        cranes.add(new Crane(3));
        cranes.add(new Crane(2));

        assertThat(cranes.canTakeLuggage(4), is(false));
    }

    @Test
    public void canTakeUnderCraneWeightLuggage(){
        cranes.add(new Crane(10));

        assertThat(cranes.canTakeLuggage(9), is(true));
    }

    @Test
    public void takeOneUnderCraneWeightLuggageWithOneCrane(){
        cranes.add(new Crane(10));
        cranes.take(9);

        assertThat(cranes.requiredTime(), is(1));
    }

    @Test
    public void takeSomeUnderCraneWeightLuggageWithTwoCrane(){
        Cranes cranes = new Cranes();
        cranes.add(new Crane(10));
        cranes.add(new Crane(11));

        cranes.take(9);
        cranes.take(9);
        cranes.take(4);

        assertThat(cranes.requiredTime(), is(2));
    }

    @Test
    public void takeSomeUnderCraneWeightLuggageWithSomeCranes(){
        Cranes cranes = new Cranes();
        cranes.add(new Crane(6));
        cranes.add(new Crane(8));
        cranes.add(new Crane(9));

        cranes.take(2);
        cranes.take(5);
        cranes.take(2);
        cranes.take(4);
        cranes.take(7);

        assertThat(cranes.requiredTime(), is(2));
    }
}
