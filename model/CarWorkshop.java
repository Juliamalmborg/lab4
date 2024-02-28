package model;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Vehicle> implements Loadable<T>, Positionable{ // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    private final FifoStorage<T> storageInWorkshop;
    private double xpos;
    private double ypos;

    public CarWorkshop(int maxCapacity, double x, double y) {

        storageInWorkshop = new FifoStorage<>(maxCapacity);
        this.xpos = x;
        this.ypos = y;
    }
    @Override
    public void load(T car) {
        storageInWorkshop.load(car);
        car.setXpos(this.getXpos());
        car.setYpos(this.getYpos());
        }
        @Override
    public T unload() {
            return storageInWorkshop.unload();
    }


    @Override
    public double getXpos() {
        return xpos;
    }

    @Override
    public double getYpos() {
        return ypos;
    }
}
