package edu.metrostate.cardealer.utils;

import java.util.List;
import java.util.Optional;

import edu.metrostate.cardealer.entity.dealer.Dealer;
import edu.metrostate.cardealer.entity.vehicle.Vehicle;

public interface IFileHandler {

    public Optional<List<Vehicle>> importDealerVehiclesFromFile(String filePath);

    public String exportDealerVehiclesToFile(Dealer dealer);
}
