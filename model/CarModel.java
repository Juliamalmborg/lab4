package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class CarModel implements ModelUpdateListener {
    private final int delay = 50;
    public Timer timer = new Timer(delay, new TimerListener());
    private CarList carList;


    ArrayList<CarWorkshop> carWorkshops = new ArrayList<>();
    //CarWorkshop<Volvo240> volvoWorkshop; //vi har tänkt

    ArrayList<Drawable> DrawableObjects = new ArrayList<>();
    //Storlek på fönster
    private static final int X = 800;
    private static final int Y = 800;

    public CarModel() {
        this.carList = new CarList();
    }
    //methods:
    //interface: drawable objects
    public void addVehicle(Vehicle vehicle) {
        carList.addVehicle(vehicle);

        DrawableObjects.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle) {
        carList.removeVehicle(vehicle);
        DrawableObjects.remove(vehicle);
    }

    public void addWorkshop(CarWorkshop workshop) {
        carWorkshops.add(workshop);
        DrawableObjects.add(workshop);
    }


    public ArrayList<Vehicle> getVehicles(){return carList.getVehicles();
    }

    //Listeners
    private final List<ModelUpdateListener> listeners = new ArrayList<>();
    // gå igenom denna . anropa actonupdate på listam
    public void addListener(ModelUpdateListener l){
        listeners.add(l);
    }
    protected void notifyListeners(){
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate(DrawableObjects);
    }

    protected void addDrawableObjects(){


    }


    @Override
    public void actOnModelUpdate(ArrayList<Drawable> drawables) {
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate(drawables);
    }

    public int getWidth() {
        return X;
    }


    public int getHeight() {
        return Y;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                for (Vehicle car : carList.getVehicles()) {
                    car.move();
                    int x = (int) Math.round(car.getXpos());
                    int y = (int) Math.round(car.getYpos());
                    if (collisionFrame(car, x, y)) {
                        car.invertDirection();
                    }
                    if (workshopCollision(x, y) && car instanceof Volvo240) {
                        Volvo240 volvo = (Volvo240) car;
                        volvo.stopEngine();
                        carWorkshops.get(0).load(volvo);
                        removeVehicle(volvo);
                    }
                    notifyListeners();
                }
            }catch (Exception es){
                es.printStackTrace();
            }
        }

        public boolean collisionFrame(Vehicle car, int x, int y) {
            int ImageWidth = car.getImage().getWidth();
            int ImageHeight = car.getImage().getHeight();
            return x < 0 || x > getWidth() - ImageWidth || y > (getHeight()-240) - ImageHeight || y < 0;


        }
        public boolean workshopCollision(int x, int y) {
            double workshopWidth = carWorkshops.get(0).getXpos();
            double workshopHeight = carWorkshops.get(0).getYpos();
            double threshold = 10; //
            return Math.abs(x - workshopWidth) <= threshold && Math.abs(y - workshopHeight) <= threshold;
        }
        private void handleWorkshopCollision(Vehicle vehicle) {
            Volvo240 volvo = (Volvo240) vehicle;
            volvo.stopEngine();
            carWorkshops.get(0).load(volvo);
            removeVehicle(volvo); // Remove from the list in the model
        }

    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : this.carList.getVehicles()
        ) {
            car.gas(gas);
        }
    }

    public void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle car : this.carList.getVehicles()
        ){
            car.brake(brake);
        }
    }

    public void setTurboOn(){
        for (Vehicle car : this.carList.getVehicles()){
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    public void setTurboOff(){
        for (Vehicle car : this.carList.getVehicles()){
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    public void raiseRamp() {
        for (Vehicle car : this.carList.getVehicles()) {
            if (car instanceof Scania) {
                ((Scania) car).raiseRamp();
            }
        }
    }
    public void lowerRamp() {
        for (Vehicle car : this.carList.getVehicles()) {
            if (car instanceof Scania) {
                ((Scania) car).lowerRamp();
            }
        }
    }
    public void startAllVehicles() {
        for (Vehicle car : this.carList.getVehicles()) {
            car.startEngine();
        }
    }

    public void stopAllVehicles() {
        for (Vehicle car : this.carList.getVehicles()) {
            car.stopEngine();
        }
    }

    private static final int MaxCars = 10;
    public void addCar(){
        if (carList.getVehicles().size() < MaxCars) {
            Vehicle newCar = CarFactory.createRandomCar();
            addVehicle(newCar);
        }
    }

    public void removeCar(){
        if (!carList.getVehicles().isEmpty()) {
            carList.getVehicles().removeFirst();
        }
    }
}
