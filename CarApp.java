import model.*;
import view.CarView;
import controller.CarController;



public class CarApp {

    public static void main(String[] args) {

        CarModel cars = initModel();
        CarView cv = initViewForModel(cars);
        initUIForView(cv);
        //CarView cv = new CarView("CarSim 1.0", cars);
        CarController cc = new CarController(cars, cv);

        CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(1, 0, 300);

        cc.timer.start();
}

    private static void initUIForView(CarView cv) {


    }

    private static CarView initViewForModel(CarModel cars) {
        CarView cv = new CarView("CarSim 1.0", cars);
        // mer här
        return cv;
    }


    public static CarModel initModel() {
        CarModel cm = new CarModel();

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
        return cm;
    }


}
