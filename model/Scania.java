package model;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends Truck {
    BufferedImage scaniaImage;
    private final double maxAngle = 70;
    private RampWithAngle ramp;

    public Scania(){
        super(2, Color.blue, 200, "Scania");
        this.ramp = new RampWithAngle(maxAngle);
    }

    public void raiseRamp(double angle) {
        if (getCurrentSpeed() == 0){
            ramp.raiseRamp(angle);
        }
        else
            throw new IllegalArgumentException("cannot raise ramp while moving");
    }


    public void lowerRamp(double angle) {
        if (getCurrentSpeed() == 0){
            ramp.lowerRamp(angle);
        }
        else
            throw new IllegalArgumentException("cannot lower ramp while moving");
    }


    public boolean getIsRampOn() {
        return ramp.getIsRampOn();
    }

    public double getRampAngle() {
        return ramp.getRampAngle();
    }

    public double getMaxAngle(){
        return ramp.getMaxAngle();
    }

    @Override
    public BufferedImage getImage() {
        try{
            scaniaImage = ImageIO.read(Scania.class.getResourceAsStream("../pics/Scania.jpg"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return scaniaImage;
    }
}

