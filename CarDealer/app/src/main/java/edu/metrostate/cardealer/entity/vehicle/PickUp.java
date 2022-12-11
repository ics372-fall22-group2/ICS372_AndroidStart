package edu.metrostate.cardealer.entity.vehicle;

public class PickUp extends Vehicle {
    private static final String vehicleType =  String.valueOf(VehicleType.PICK_UP).replace("_", "\s"); //replace _ with space to get "SPORTS CAR" as type;

    public PickUp() {
        setVehicleType(vehicleType);
    }

    public static PickUp getInstance(String vehicleId) {
        return new PickUp(vehicleId);
    }

    public PickUp(String vehicleId){
        this();
        this.setVehicleId(vehicleId);
    }

    /**
     *
     * @param dealershipId dealershipId
     * @param vehicleManufacturer vehicle manufacturer
     * @param vehicleModel vehicle model
     * @param vehicleId vehicle id
     * @param price vehicle price
     * @param acquisitionDate acquisition date
     */
    public PickUp(String dealershipId, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        super(dealershipId, vehicleType, vehicleManufacturer, vehicleModel, vehicleId, price, acquisitionDate);
    }

}
