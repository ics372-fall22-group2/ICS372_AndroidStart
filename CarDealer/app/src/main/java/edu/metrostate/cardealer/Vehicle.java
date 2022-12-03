package edu.metrostate.cardealer;

public class Vehicle {

    private final String id;
    private final String model;
    private String manufacturer;

    /**
     *
     * @param id
     * @param model
     */
    Vehicle(String id, String model){
        this.id = id;
        this.model = model;
        this.manufacturer = null;

    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

}
