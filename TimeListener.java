
import controller.CarController;
import model.CarList;
import model.Vehicle;
import model.Volvo240;
import view.CarView;
import view.DrawPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimeListener implements ActionListener{
    CarController cc;
    CarList cars;

    public TimerListener(CarController cc, CarList cars){
        this.cars = cars;
        this.cc = cc;
    }
    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : cars.getVehicles()) {
            car.move();
            int x = (int) Math.round(car.getXpos());
            int y = (int) Math.round(car.getYpos());
            if (collisionFrame(x, y)) {
                car.invertDirection(); //en metod för invertDirection byta riktning
            }
            if (workshopCollision(x, y) && car instanceof Volvo240) {
                Volvo240 volvo = (Volvo240) car;
                volvo.stopEngine();
                volvoWorkshop.load(volvo);
                cars.removeVehicle(car);
                frame.drawPanel.removeVehicle(frame.drawPanel.vehicleImage.indexOf(frame.drawPanel.volvoImage));
                continue;
            }
            frame.drawPanel.moveit(x, y, cars.indexOf(car));
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }
    // This method checks so that the object is with in the panel
    public boolean collisionFrame(int x, int y) {
        int panelWidth = frame.drawPanel.getWidth() ;
        int panelHeight = frame.drawPanel.getHeight() ;
        int ImageWidth = frame.drawPanel.vehicleImage.getFirst().getWidth();
        int ImageHeight = frame.drawPanel.vehicleImage.getFirst().getHeight();
        return x < 0 || x > panelWidth - ImageWidth || y > panelHeight - ImageHeight || y < 0;

    }
    public boolean workshopCollision(int x, int y) {
        double workshopWidth = volvoWorkshop.getXpos();
        double workshopHeight = volvoWorkshop.getYpos();
        double threshold = 10; //
        return Math.abs(x - workshopWidth) <= threshold && Math.abs(y - workshopHeight) <= threshold;
    }
}
