package edu.metrostate.cardealer.entity.vehicle;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SUVTest{
    Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        vehicle = new SUV("T01", "Honda", "Accord", 1670102205108L, 34500.00, "dealer001", false );
    }

    @Test
    public void returnsSUVType(){
        String manufacturer = "Honda";
        assertEquals(manufacturer, vehicle.getManufacturer());
    }
}