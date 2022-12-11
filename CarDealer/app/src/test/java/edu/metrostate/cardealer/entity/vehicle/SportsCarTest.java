package edu.metrostate.cardealer.entity.vehicle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class SportsCarTest {
    static final Logger LOGGER = Logger.getLogger(SportsCarTest.class.getName());

    Vehicle testSportsCar;

    @BeforeEach
    void setUp() {
        testSportsCar = VehicleFactory.createVehicle("Sports Car", "v0002");
        testSportsCar.setManufacturer("Ferrari");
        testSportsCar.setModel("812 GTS");
        LOGGER.info(testSportsCar.toString());
    }

    @Test
    void sportsCarCannotBeLoanedOut(){
//        act
        testSportsCar.setOnLoan(true);

//        assert
        assertEquals(false, testSportsCar.isVehicleOnLoan());
    }

}