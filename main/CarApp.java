package main;

import model.*;
import controller.CarController;
import view.DrawPanel;


public class CarApp {

    public static void main(String[] args) {
        // create model
        CarModel cars = initModel();
        //create drawPanel
        DrawPanel drawPanel = new DrawPanel(cars.getWidth(), cars.getHeight());

        CarView cv = new CarView("CarSim 1.0", drawPanel, cars.getWidth(), cars.getHeight());

        CarController cc = new CarController(cars, cv);

        cars.addListener(drawPanel);
        cars.timer.start();
}

    public static CarModel initModel() {
        CarModel cm = new CarModel();

        CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(1, 0, 300);

        Vehicle volvo = CarFactory.createVolvo240();
        volvo.setXpos(0);
        volvo.setYpos(0);

        Vehicle saab = CarFactory.createSaab95();
        saab.setXpos(0);
        saab.setYpos(100);

        Vehicle scania = CarFactory.createScania();
        scania.setXpos(0);
        scania.setYpos(200);

        cm.addVehicle(volvo);
        cm.addVehicle(saab);
        cm.addVehicle(scania);
        cm.addWorkshop(volvoWorkshop);
        return cm;
    }


}
