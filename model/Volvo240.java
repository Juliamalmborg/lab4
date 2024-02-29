package model;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Volvo240 extends Vehicle {
    BufferedImage volvoImage;
    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


    @Override
    public BufferedImage getImage() {
        try{
            volvoImage = ImageIO.read(Volvo240.class.getResourceAsStream("../pics/Volvo240.jpg"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return volvoImage;
    }
}
