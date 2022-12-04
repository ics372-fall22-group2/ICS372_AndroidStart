package edu.metrostate.cardealer.entity.vehicle;

public class PickUp extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.PICK_UP);

    public static PickUp getInstance(String vehicleId) {
        return new PickUp(vehicleId);
    }

    public PickUp(String vehicleId){
        super();
        this.setVehicleId(vehicleId);
    }

    public PickUp(String vehicleId, String manufacturer, String model, Long acquisitionDate, double price, String dealerId, boolean onLoan) {
        super(vehicleId, manufacturer, model, acquisitionDate, price, dealerId, onLoan) ;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }
}
