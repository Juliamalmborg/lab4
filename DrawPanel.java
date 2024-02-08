import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    //BufferedImage saabImage;

    BufferedImage volvoWorkshopImage;
    // To keep track of a single car's position

    ArrayList<Point> vehiclePoints = new ArrayList<>();

    ArrayList<BufferedImage> vehicleImage = new ArrayList<>();


    //Point volvoPoint = new Point();

    //Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int x, int y, int index) {
        vehiclePoints.get(index).x = x;
        vehiclePoints.get(index).y = y;

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.gray);

        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            vehicleImage.add(volvoImage);
            vehiclePoints.add(new Point(300,300));
            //saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            //vehicleImage.add(saabImage);
            //vehiclePoints.add(new Point(200, 0));
            //volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            //vehicleImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            //vehicleImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <vehicleImage.size(); i++) {
            g.drawImage(vehicleImage.get(i), vehiclePoints.get(i).x, vehiclePoints.get(i).y, null);
        }
        // see javadoc for more info on the parameters
        //g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

}
