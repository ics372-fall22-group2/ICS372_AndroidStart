package edu.metrostate.cardealer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testVehicleShowsManufacturer(){
        Vehicle v = new Vehicle("testV", "Accord");

        v.setManufacturer("Honda");

//        assert
        String expected = "Honda";
        String result = v.getManufacturer();

        assertEquals(result, expected);
    }
}