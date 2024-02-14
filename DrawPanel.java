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
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;
    // To keep track of a car's position
    ArrayList<Point> vehiclePoints = new ArrayList<>();

    ArrayList<BufferedImage> vehicleImage = new ArrayList<>();

    Point volvoWorkshopPoint = new Point(0,300);

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
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        vehicleImage.add(volvoImage);
        vehiclePoints.add(new Point(0,0));
        vehicleImage.add(saabImage);
        vehiclePoints.add(new Point(0, 100));
        vehicleImage.add(scaniaImage);
        vehiclePoints.add(new Point(0,200));
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
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

    //metod för att ta bort point och bild när en bil tas bort
    public void removeVehicle(int index) {
        if (index < vehicleImage.size() && index < vehiclePoints.size()) {
            vehicleImage.remove(index);
            vehiclePoints.remove(index);
        }
    }

}
