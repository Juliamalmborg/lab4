package model;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CarTransport extends Truck implements Loadable<Vehicle>{

    private final LifoStorage<Vehicle> storage;

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        storage = new LifoStorage<Vehicle> (4);
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public void load(Vehicle car) {
        if (car instanceof Truck) { //Truck innefattar CarTransport och scania
            throw new IllegalArgumentException("Cannot load another Truck.");
        }
        else if (!inProximity(car)) {
            throw new IllegalArgumentException("Car is to far away, can not be loaded.");
        }
        else if (getIsRampOn()) {
            storage.load(car);
            car.setXpos(this.getXpos());
            car.setYpos(this.getYpos());
        }
    }
    @Override
    public Vehicle unload() {
        if (getIsRampOn()) {
             Vehicle unloadedCar = storage.unload();
             unloadedCar.setXpos(this.getXpos()-1);
             return unloadedCar;
        } else {
            throw new IllegalStateException("No cars to unload or the ramp is not down.");
        }
    }

    public boolean getIsRampOn() {
        return ramp.getIsRampOn();
    }

    public int getnrCarsOnRamp(){
        return storage.getsize();
    }


    public boolean inProximity(Vehicle car) {
        return Math.abs(this.getXpos() - car.getXpos()) < 2 && Math.abs(this.getYpos() - car.getYpos()) < 2;
    }

    }



