public class CarApp {

    public static void main(String[] args) {
    // Instance of this class
    CarController cc = new CarController();
    CarView cw = new CarView("CarSim 1.0", cc);

    Volvo240 volvo = new Volvo240();
    volvo.setXpos(0);
    volvo.setYpos(0);

    Saab95 saab = new Saab95();
    saab.setXpos(0);
    saab.setYpos(100);

    Scania scania = new Scania();
    scania.setXpos(0);
    scania.setYpos(200);

    //CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<Volvo240>(1, 0, 300);

    cc.cars.add(volvo);
    cc.cars.add(saab);
    cc.cars.add(scania);

    // Start a new view and send a reference of self
    cc.frame = new CarView("CarSim 1.0", cc); // denna skapar new frame/view i cc??
    cc.startTimer();
    // Start the timer
}

}
