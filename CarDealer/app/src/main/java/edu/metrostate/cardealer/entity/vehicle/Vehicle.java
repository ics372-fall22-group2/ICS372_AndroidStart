package edu.metrostate.cardealer.entity.vehicle;

import org.nd4j.shade.jackson.annotation.JsonIgnore;
import org.nd4j.shade.jackson.annotation.JsonSubTypes;
import org.nd4j.shade.jackson.annotation.JsonTypeInfo;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

    //Using Json Type info to enable vehicle subtype creation from imported JSON files
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "vehicle_type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Sedan.class, name = "sedan"),
            @JsonSubTypes.Type(value = PickUp.class, name = "pickup"),
            @JsonSubTypes.Type(value = SUV.class, name = "suv"),
            @JsonSubTypes.Type(value = SportsCar.class, name = "sports car")
    })
public abstract class Vehicle {
    public enum VehicleType {SEDAN, SUV, SPORTS_CAR, PICK_UP}

    private String dealershipId;
    private String vehicleType;
    private String vehicleManufacturer;
    private String vehicleModel;
    private String vehicleId;
    private Double price;
    private Long acquisitionDate;
    @JsonIgnore private boolean isOnLoan = false;

    public Vehicle(){

    }
    /**Constructor
     *
     * @param dealershipId the dealerId
     * @param vehicleType the vehicle type: SUV, PickUP, SportsCar, Sedan
     * @param vehicleManufacturer the vehicleManufacturer
     * @param vehicleModel the vehicleModel
     * @param vehicleId the vehicle id
     * @param price the vehicle price
     * @param acquisitionDate the vehicle acquisition date in epochMill
//     * @param isOnLoan boolean true or false
     */
    public Vehicle(String dealershipId, String vehicleType, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        this.dealershipId = dealershipId;
        this.vehicleType = vehicleType;
        this.vehicleManufacturer = vehicleManufacturer;
        this.vehicleModel = vehicleModel;
        this.vehicleId = vehicleId;
        this.price = price;
        this.acquisitionDate = acquisitionDate;
        this.isOnLoan = false;
    }


    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getManufacturer() {
        return vehicleManufacturer;
    }

    public void setManufacturer(String vehicleManufacturer) {
        this.vehicleManufacturer = vehicleManufacturer;
    }

    public String getModel() {
        return vehicleModel;
    }

    public void setModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     *
     * @return a parse string date value
     */
    public String getAcquisitionDate(){
        return parseEpochMilliDate(acquisitionDate).toLocalDate().toString();
    }

    /**A helper method to convert epoch date to parsedDate
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
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getVehicleType(){
        return this.vehicleType;
    };

    protected void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }

    public void setDealershipId(String newDealerId){
        dealershipId = newDealerId;
    }

    public String getDealershipId(){
        return this.dealershipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getVehicleId().equals(vehicle.getVehicleId()) && Objects.equals(getManufacturer(), vehicle.getManufacturer()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getAcquisitionDate(), vehicle.getAcquisitionDate()) && Objects.equals(getVehicleType(), vehicle.getVehicleType());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleManufacturer='" + vehicleManufacturer + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", price=" + price +
                ", vehicleType=" + getVehicleType() +
                ", dealerId=" + dealershipId +
                '}';
    }

    boolean isVehicleOnLoan(){
        return isOnLoan;
    }

    /**
     * A method to set vehicles on Loan if they are not instances of SportsCar
     * @param onLoan
     */
    public void setOnLoan(boolean onLoan) {
        if (this instanceof SportsCar){
            return;
        }
        this.isOnLoan = onLoan;
    }

}
