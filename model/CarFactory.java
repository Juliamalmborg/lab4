package model;

import java.util.Random;

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


    public static Vehicle createRandomCar() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                return createVolvo240();
            case 1:
                return createSaab95();
            case 2:
                return createScania();

    }
        return null;
    }}
