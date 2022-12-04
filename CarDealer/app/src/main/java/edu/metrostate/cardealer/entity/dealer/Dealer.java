package edu.metrostate.cardealer.entity.dealer;

import java.util.ArrayList;
import java.util.List;

import edu.metrostate.cardealer.entity.vehicle.Vehicle;

public class Dealer {
    private boolean isAcceptingNewVehicles;
    private String dealerId;
    private String name;
    private final List<Vehicle> dealerVehicles = new ArrayList<>();

    public Dealer(String dealerId) {
        this.dealerId = dealerId;
    }

    public Dealer(String dealerId, String name) {
        this.dealerId = dealerId;
        this.name = name;
    }

    public Dealer newDealer(String dealerId, String name){
        return new Dealer(dealerId, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enableVehicleAcquisition() {
        this.isAcceptingNewVehicles = true;
    }

    public void disableVehicleAcquisition() {
        isAcceptingNewVehicles = false;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerId() {
        return this.dealerId;
    }

    public boolean acceptingNewVehicles(){
        return isAcceptingNewVehicles;
    }

    public List<Vehicle> getDealerVehicles(){
        return this.dealerVehicles;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "dealerId='" + dealerId + '\'' +
                ", isAcceptingNewVehicles=" + isAcceptingNewVehicles +
                ", name='" + name + '\'' +
                '}';
    }
}
