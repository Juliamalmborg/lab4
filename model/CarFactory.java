package model;
public class CarFactory {

    //Ska man även skicka in ex nrDoors osv?
    public static Vehicle createVolvo240() {
        return new Volvo240();
    }
    public static Vehicle createSaab95() {
        return new Saab95();
    }

    public static Vehicle createScania() {
        return new Scania();
    }

}
