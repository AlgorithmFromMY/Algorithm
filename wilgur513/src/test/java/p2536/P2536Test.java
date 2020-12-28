package p2536;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class P2536Test {
    @Test
    public void busCanArrive() {
        Bus bus = new Bus(new int[]{5, 2}, new int[]{1, 2});
        assertThat(bus.canArrive(4, 2), is(true));
        assertThat(bus.canArrive(6, 2), is(false));
        assertThat(bus.canArrive(4, 1), is(false));

        bus = new Bus(new int[]{2, 5}, new int[]{2, 10});
        assertThat(bus.canArrive(2, 9), is(true));
        assertThat(bus.canArrive(2, 11), is(false));
        assertThat(bus.canArrive(2, 4), is(false));
        assertThat(bus.canArrive(1, 9), is(false));
    }

    @Test
    public void busCanVerticallyExchange() {
        Bus bus1 = new Bus(new int[]{5, 2}, new int[]{10, 2});
        Bus bus2 = new Bus(new int[]{6, 2}, new int[]{1, 2});
        assertThat(bus1.canExchange(bus2), is(true));
        assertThat(bus2.canExchange(bus1), is(true));

        Bus bus3 = new Bus(new int[]{0, 2}, new int[]{4, 2});
        assertThat(bus1.canExchange(bus3), is(false));
        assertThat(bus3.canExchange(bus1), is(false));

        Bus bus4 = new Bus(new int[]{20, 2}, new int[]{11, 2});
        assertThat(bus1.canExchange(bus4), is(false));
        assertThat(bus4.canExchange(bus1), is(false));
    }

    @Test
    public void busCanHorizontallyExchange() {
        Bus bus1 = new Bus(new int[]{2, 10}, new int[]{2, 5});
        Bus bus2 = new Bus(new int[]{2, 6}, new int[]{2, 1});
        assertThat(bus1.canExchange(bus2), is(true));
        assertThat(bus2.canExchange(bus1), is(true));

        Bus bus3 = new Bus(new int[]{2, 4}, new int[]{2, 0});
        assertThat(bus1.canExchange(bus3), is(false));
        assertThat(bus3.canExchange(bus1), is(false));

        Bus bus4 = new Bus(new int[]{2, 11}, new int[]{2, 20});
        assertThat(bus1.canExchange(bus4), is(false));
        assertThat(bus4.canExchange(bus1), is(false));
    }

    @Test
    public void busCanExchange() {
        Bus bus1 = new Bus(new int[]{4, 2}, new int[]{15, 2});
        Bus bus2 = new Bus(new int[]{10, 1}, new int[]{10, 3});
        assertThat(bus1.canExchange(bus2), is(true));
        assertThat(bus2.canExchange(bus1), is(true));

        Bus bus3 = new Bus(new int[]{3, 1}, new int[]{3, 10});
        assertThat(bus1.canExchange(bus3), is(false));
        assertThat(bus3.canExchange(bus1), is(false));

        Bus bus4 = new Bus(new int[]{16, 17}, new int[]{16, 1});
        assertThat(bus1.canExchange(bus4), is(false));
        assertThat(bus4.canExchange(bus1), is(false));

        Bus bus5 = new Bus(new int[]{6, 3}, new int[]{6, 20});
        assertThat(bus1.canExchange(bus5), is(false));
        assertThat(bus5.canExchange(bus1), is(false));
    }
}
