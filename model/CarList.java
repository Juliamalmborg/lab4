package model;

import java.util.ArrayList;

public class CarList {
    private ArrayList<Vehicle> cars = new ArrayList<>();
    public void addVehicle(Vehicle vehicle) {
        cars.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        cars.remove(vehicle);
    }

    public ArrayList<Vehicle> getVehicles(){
        return cars;
    }

}
