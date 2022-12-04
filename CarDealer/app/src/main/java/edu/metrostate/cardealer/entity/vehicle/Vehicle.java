package edu.metrostate.cardealer.entity.vehicle;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public abstract class Vehicle {
    public enum VehicleType {SEDAN, SUV, SPORTS_CAR, PICK_UP}

    private String VehicleId;
    private String manufacturer;
    private String model;
    private Long acquisitionDate;
    private BigDecimal price;
    protected String vehicleType;
    private String dealerId;
    private boolean isOnLoan;

    public Vehicle(){

    }

    /**Constructor
     *
     * @param vehicleId the vehicle id
     * @param manufacturer the manufacturer
     * @param model the model
     * @param acquisitionDate the vehicle acquisition date in epochMill
     * @param price the vehicle price
//     * @param vehicleType the vehicle type: SUV, PickUP, SportsCar, Sedan
     * @param dealerId the dealerId
     * @param isOnLoan boolean true or false
     */
    public Vehicle(String vehicleId, String manufacturer, String model, Long acquisitionDate, Number price, String dealerId, boolean isOnLoan) {
        VehicleId = vehicleId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.dealerId = dealerId;
        this.acquisitionDate = acquisitionDate;
        setPrice((Double) price);
//        this.vehicleType = vehicleType;
        this.isOnLoan = isOnLoan;
    }


    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return a parse string date value
     */
    public String getAcquisitionDate(){
        return parseEpochMilliDate(acquisitionDate).toLocalDate().toString();
    }

    /**
     *
     * @param epochDate the epochDate
     * @return parsed date from epochDate
     */
    private ZonedDateTime parseEpochMilliDate(Long epochDate) {
        Instant parsedDateInstant = Instant.ofEpochMilli(epochDate);
        return parsedDateInstant.atZone(ZoneId.of("America/Chicago"));
    }

    public void setAcquisitionDate(Long acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public double getPrice() {
        return price.doubleValue();
    }

    public void setPrice(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    public abstract String getVehicleType();

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setDealerId(String newDealerId){
        dealerId = newDealerId;
    }

    public String getDealerId(){
        return this.dealerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getVehicleId().equals(vehicle.getVehicleId()) && Objects.equals(getManufacturer(), vehicle.getManufacturer()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getAcquisitionDate(), vehicle.getAcquisitionDate()) && Objects.equals(getVehicleType(), vehicle.getVehicleType());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VehicleId=" + VehicleId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", price=" + price +
                ", vehicleType=" + vehicleType +
                ", dealerId=" + dealerId +
                '}';
    }

    /**
     *
     * @return true if vehicle is onLoan
     */
    boolean isVehicleOnLoan(){
        return isOnLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.isOnLoan = onLoan;
    }

}
