package model;

import controller.CarController;
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

    private final CarList carList;
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
        //listener?
    }

    //notiffy function

    //update vehicles?

    public CarWorkshop getVolvoServiceShop(){return volvoWorkshop;}

    private final List<ModelUpdateListener> listeners = new ArrayList<>();
    // gå igenom denna . anropa actonupdate på listam
    public void addListener(ModelUpdateListener l){
        listeners.add(l);
    }
    @Override
    public void actOnModelUpdate() {
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate();
    }


    // get för listan, metod?



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

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
    private class TimerListener implements ActionListener{
        CarController cc;
        CarList cars;
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars.getVehicles()) {
                car.move();
                int x = (int) Math.round(car.getXpos());
                int y = (int) Math.round(car.getYpos());
                if (collisionFrame(x, y)) {
                    car.invertDirection(); //en metod för invertDirection byta riktning
                }
                if (workshopCollision(x, y) && car instanceof Volvo240) {
                    Volvo240 volvo = (Volvo240) car;
                    volvo.stopEngine();
                    volvoWorkshop.load(volvo);
                    cars.removeVehicle(car);
                    frame.drawPanel.removeVehicle(frame.drawPanel.vehicleImage.indexOf(frame.drawPanel.volvoImage));
                    continue;
                }
                frame.drawPanel.moveit(x, y, cars.indexOf(car));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
        // This method checks so that the object is with in the panel
        public boolean collisionFrame(int x, int y) {
            int panelWidth = frame.drawPanel.getWidth() ;
            int panelHeight = frame.drawPanel.getHeight() ;
            int ImageWidth = frame.drawPanel.vehicleImage.getFirst().getWidth();
            int ImageHeight = frame.drawPanel.vehicleImage.getFirst().getHeight();
            return x < 0 || x > panelWidth - ImageWidth || y > panelHeight - ImageHeight || y < 0;

        }
        public boolean workshopCollision(int x, int y) {
            double workshopWidth = volvoWorkshop.getXpos();
            double workshopHeight = volvoWorkshop.getYpos();
            double threshold = 10; //
            return Math.abs(x - workshopWidth) <= threshold && Math.abs(y - workshopHeight) <= threshold;
        }
    }
}
