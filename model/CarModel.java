package model;

import view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarModel implements ModelUpdateListener {
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    private CarList carList;
    // A list of cars, modify if needed

    // Flyttat denna till CarList
    ArrayList<Vehicle> cars = new ArrayList<>();
    CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(1, 0, 300); //ska tas bort härifrån

    public CarModel() {
        this.carList = new CarList();

    }
    //methods:
    public void addVehicle(Vehicle vehicle) {
        carList.addVehicle(vehicle);
        actOnVehicleAdded(vehicle);
    }

    //update vehicles?

    public CarWorkshop getVolvoServiceShop(){return volvoWorkshop;}

    private final List<ModelUpdateListener> listeners = new ArrayList<>();
    public void addListener(ModelUpdateListener l){
        listeners.add(l);
    }
    @Override
    public void actOnModelUpdate() {
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate();
    }

    @Override
    public void actOnVehicleAdded(Vehicle vehicle) {
        for (ModelUpdateListener l : listeners)
            l.actOnVehicleAdded(vehicle);
    }


    // get för listan, metod?



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */


    public void startTimer() {
        timer.start();
    }
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ){
            car.brake(brake);
        }
    }
    //Till knapparna
    void setTurboOn(){
        for (Vehicle car : cars){
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void setTurboOff(){
        for (Vehicle car : cars){
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void raiseRamp() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseRamp();
            }
        }
    }
    void lowerRamp() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerRamp();
            }
        }
    }
    void startAllVehicles() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopAllVehicles() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
}
