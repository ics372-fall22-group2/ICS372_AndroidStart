package edu.metrostate.cardealer.entity.vehicle;

public class Sedan extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.SEDAN);

    public Vehicle getInstance(String vehicleId) {
        return new Sedan(vehicleId);
    }

    public Sedan(String vehicleId){
        super();
        this.setVehicleId(vehicleId);
    }

    public Sedan(String vehicleId, String manufacturer, String model, Long acquisitionDate, double price, String dealerId, boolean onLoan) {
        super(vehicleId, manufacturer, model, acquisitionDate, price, dealerId, onLoan) ;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }
}
