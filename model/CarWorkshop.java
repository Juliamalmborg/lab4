package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CarWorkshop<T extends Vehicle> implements Loadable<T>, Drawable { // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    private final FifoStorage<T> storageInWorkshop;
    private double xpos;
    private double ypos;
    BufferedImage volvoWorkshopImage;

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

    @Override
    public BufferedImage getImage(){
        try{
            volvoWorkshopImage = ImageIO.read(CarWorkshop.class.getResourceAsStream("../pics/VolvoBrand.jpg"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return volvoWorkshopImage;
    }
}
