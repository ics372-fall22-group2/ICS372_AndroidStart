package edu.metrostate.cardealer.entity.vehicle;

public class SUV extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.SUV);

    public static SUV getInstance(String vehicleId) {
        return new SUV(vehicleId);
    }

    public SUV() {
        setVehicleType(vehicleType);
    }

    public SUV(String vehicleId){
        this();
        this.setVehicleId(vehicleId);
    }

    /** Constructor
     *
     * @param dealershipId dealershipId
     * @param vehicleManufacturer vehicle manufacturer
     * @param vehicleModel vehicle model
     * @param vehicleId vehicle id
     * @param price vehicle price
     * @param acquisitionDate acquisition date
     */
    public SUV(String dealershipId, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        super(dealershipId, vehicleType, vehicleManufacturer, vehicleModel, vehicleId, price, acquisitionDate);
    }
}
