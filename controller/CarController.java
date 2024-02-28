package controller;

import model.CarModel;
import model.TimerListener;
import model.Vehicle;
import view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    private CarView frame;

    private CarModel model;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();


    //KONSTRUKTOR
    public CarController(CarModel cm, CarView frame) {
        this.frame = frame;


        JPanel controlPanel = new JPanel();

        JPanel gasPanel = new JPanel();
        JSpinner gasSpinner = new JSpinner();
        int gasAmount = 0;
        JLabel gasLabel = new JLabel("Amount of gas");

        JButton gasButton = new JButton("Gas");
        JButton brakeButton = new JButton("Brake");
        JButton turboOnButton = new JButton("Saab Turbo on");
        JButton turboOffButton = new JButton("Saab Turbo off");
        JButton liftBedButton = new JButton("Scania Lift Bed");
        JButton lowerBedButton = new JButton("Lower Lift Bed");

        JButton startButton = new JButton("Start all cars");
        JButton stopButton = new JButton("Stop all cars");
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        this.frame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.brake(gasAmount);
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.setTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.setTurboOff();
            }
        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.raiseRamp();
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.lowerRamp();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.startAllVehicles();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.stopAllVehicles();
            }
        });

    }

}
    //methods:


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    // Calls the gas method for each car once
