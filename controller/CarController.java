package controller;

import model.*;
import main.CarView;


import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
 
    private CarModel model;

    private CarView cv;

    int gasAmount = 0;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars;

    public CarController(CarModel model, CarView cv) { //använder inte Carview
        this.cars = model.getVehicles();
        this.model = model;
        this.cv = cv;
        initComponents();
    }

    private void initComponents(){
        cv.gasSpinner.addChangeListener(GasSpinner());
        cv.gasButton.addActionListener(GasActionListener());
        cv.brakeButton.addActionListener(BrakeActionListener());
        cv.turboOnButton.addActionListener(TurboOnActionListener());
        cv.turboOffButton.addActionListener(TurboOffActionListener());
        cv.liftBedButton.addActionListener(LiftBedActionListener());
        cv.lowerBedButton.addActionListener(LowerBedActionListener());
        cv.startButton.addActionListener(StartActionListener());
        cv.stopButton.addActionListener(StopActionListener());

        cv.addCarButton.addActionListener(AddCarActionListener());
        cv.removeCarButton.addActionListener(RemoveCarActionListener());
    }
    //från början från CarView, skapar actionlisteners
    public ChangeListener GasSpinner() {
        return e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue();
    }

    public ActionListener GasActionListener() {
        return e -> this.model.gas(gasAmount);
    }

    public ActionListener BrakeActionListener() {
        return e -> this.model.brake(gasAmount);
    }

    public ActionListener TurboOnActionListener() {
        return e -> this.model.setTurboOn();
    }

    public ActionListener TurboOffActionListener() {
        return e -> this.model.setTurboOff();
    }

    public ActionListener LiftBedActionListener() {
        return e -> this.model.raiseRamp();
    }

    public ActionListener LowerBedActionListener() {
        return e -> this.model.lowerRamp();
    }

    public ActionListener StartActionListener() {
        return e -> this.model.startAllVehicles();
    }

    public ActionListener StopActionListener() {
        return e -> this.model.stopAllVehicles();
    }

    public ActionListener AddCarActionListener(){ return e -> this.model.addCar();}

    public ActionListener RemoveCarActionListener(){ return e -> this.model.removeCar();}


}


