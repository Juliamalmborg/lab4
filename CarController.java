import javax.swing.*;
import java.awt.*;
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

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(2, 0, 300);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        volvo.setXpos(0);
        volvo.setYpos(0);

        Saab95 saab = new Saab95();
        saab.setXpos(0);
        saab.setYpos(100);

        Scania scania = new Scania();
        scania.setXpos(0);
        scania.setYpos(200);

        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.timer.start();
        // Start the timer
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getXpos());
                int y = (int) Math.round(car.getYpos());
                if (collisionFrame(x, y)) {
                    car.invertDirection();//en metod för invertDirection byta riktning
                }
                else if (workshopCollision(x,y) && car instanceof Volvo240) {
                    volvoWorkshop.load((Volvo240) car);
                    car.stopEngine();
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
            return x < 0 || x > panelWidth || y > panelHeight || y < 0; //just nu åker den lite ut ur rutan

        }
        public boolean workshopCollision(int x, int y) {
            return x == (int) volvoWorkshop.getXpos() && y == (int) volvoWorkshop.getYpos();
        }
    }
    // Calls the gas method for each car once
    void gas(int amount) {
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

    void turnLeft(){
        for (Vehicle car : cars) {
            car.turnLeft();
    }}
    void turnRight(){
        for (Vehicle car : cars) {
            car.turnRight();
        }}
}
