package edu.metrostate.cardealer.entity.vehicle;

public class SUV extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.SUV);

    public static SUV getInstance(String vehicleId) {
        return new SUV(vehicleId);
    }

    public SUV(String vehicleId){
        super();
        this.setVehicleId(vehicleId);
    }

    public SUV(String vehicleId, String manufacturer, String model, Long acquisitionDate, double price, String dealerId, boolean onLoan) {
        super(vehicleId, manufacturer, model, acquisitionDate, price, dealerId, onLoan) ;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }



}
