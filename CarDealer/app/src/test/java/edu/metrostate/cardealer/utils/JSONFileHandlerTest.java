package edu.metrostate.cardealer.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import edu.metrostate.cardealer.entity.dealer.Dealer;

class JSONFileHandlerTest {
    String jsonTestDataFilePath = "C:\\Users\\msjal\\source\\repos\\ics372\\testAndroid\\ICS372_AndroidStart\\CarDealer\\app\\src\\main\\java\\edu\\metrostate\\cardealer\\data\\test_json_vehicle_inventory_data.json";
    IFileHandler fileHandler;
    @BeforeEach
    void setUp() {
        fileHandler = new JSONFileHandler();
    }

    @Test
    void importDataFromFile() {
        fileHandler.importDealerVehiclesFromFile(jsonTestDataFilePath);
    }

    @Test
    void exportDataToFile() {
        Dealer d = new Dealer("d001", "TestDealer");
        var vehicleList = fileHandler.importDealerVehiclesFromFile(jsonTestDataFilePath);
        vehicleList.get().forEach(vehicle -> d.addVehicle(vehicle));

        var dealerVehicles = d.getDealerVehicles();
        assertEquals(4, dealerVehicles.size());

        String exportFile = fileHandler.exportDealerVehiclesToFile(d);
        File file = new File(exportFile);

        assertTrue(file.exists());

    }
}