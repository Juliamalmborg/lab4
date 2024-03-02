package model;

import java.util.ArrayList;

public class CarList {
    private ArrayList<Vehicle> cars = new ArrayList<>();

    protected void addVehicle(Vehicle vehicle) {
        cars.add(vehicle);
    }

    protected void removeVehicle(Vehicle vehicle){
        cars.remove(vehicle);
    }

    protected ArrayList<Vehicle> getVehicles(){
        return cars;
    }
}
