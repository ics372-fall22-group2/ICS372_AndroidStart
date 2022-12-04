package edu.metrostate.cardealer.entity.vehicle;

public class SportsCar extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.SPORTS_CAR);

    public static SportsCar getInstance(String vehicleId) {
        return new SportsCar(vehicleId);
    }

    public SportsCar(String vehicleId){
        super();
        this.setVehicleId(vehicleId);
    }

    public SportsCar(String vehicleId, String manufacturer, String model, Long acquisitionDate, double price, String dealerId, boolean onLoan) {
        super(vehicleId, manufacturer, model, acquisitionDate, price, dealerId, onLoan) ;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }
}
