package p1033;

import org.junit.*;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class MaterialTest {
    Material material;

    @Before
    public void setUp() throws Exception {
        material = new Material();
    }

    @Test
    public void materialFactorizeWithPrime(){
        material.multiple(3);
        assertThat(material.factors(), is(Arrays.asList(3)));
    }

    @Test
    public void materialFactorizeWithNonPrime(){
        material.multiple(2*2*2);
        assertThat(material.factors(), is(Arrays.asList(2, 2, 2)));
    }

    @Test
    public void materialFactorizeWithMultipleTwice(){
        material.multiple(2*2);
        material.multiple(3*5);
        assertThat(material.factors(), is(Arrays.asList(2, 2, 3, 5)));
    }

    @Test
    public void materialDivideWithPrime(){
        material.multiple(2*3*5);
        material.divide(2);
        assertThat(material.factors(), is(Arrays.asList(3, 5)));
    }

    @Test
    public void materialDivideWithNonPrime(){
        material.multiple(2*2*2*2);
        material.divide(2*2*2);
        assertThat(material.factors(), is(Arrays.asList(2)));
    }

    @Test
    public void materialManyDivide(){
        material.multiple(2*3*5);
        material.divide(2);
        material.divide(3);
        assertThat(material.factors(), is(Arrays.asList(5)));
    }

    @Test
    public void materialMinMeasureWithQuantityOne(){
        assertThat(material.minMeasure(), is(1));
    }

    @Test
    public void materialMinMeasureWithHasQuantity(){
        material.multiple(5*7*9*8);
        assertThat(material.minMeasure(), is(2));
    }

    @Test
    public void materialQuantity(){
        material.multiple(2*2*3*3*5);
        assertThat(material.quantity(), is(2*2*3*3*5L));
    }

    @Test
    public void materialManyMultipleQuantity(){
        material.multiple(2*2*3*5);
        material.multiple(2*7);
        material.multiple(8*9);
        assertThat(material.quantity(), is(2*2*2*2*2*2*3*3*3*5*7L));
    }

    @Test
    public void materialQuantityWithNonMultiple(){
        assertThat(material.quantity(), is(1L));
    }
}


