package model;
import view.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Saab95 extends Vehicle{
    BufferedImage saabImage;

    private boolean turboOn;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
	    turboOn = false;
    }
    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public BufferedImage getImage(){
        try{
            saabImage = ImageIO.read(Saab95.class.getResourceAsStream("../pics/Saab95.jpg"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return saabImage;
    }
}
