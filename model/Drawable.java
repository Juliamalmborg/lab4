package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface Drawable {
    double getXpos();

    double getYpos();

    BufferedImage getImage();
}
