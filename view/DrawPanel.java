package view;

import model.*;
import model.ModelUpdateListener;


import java.awt.*;

import java.util.ArrayList;

import javax.swing.*;




// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ModelUpdateListener {
    ArrayList<Drawable> drawables;
    // Initializes the panel and reads the images

    public DrawPanel(int width, int height) {
        this.drawables = new ArrayList<>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height-240));
        this.setBackground(Color.cyan);
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Drawable drawable: drawables){
            g.drawImage(drawable.getImage(), (int) Math.round(drawable.getXpos()), (int) Math.round(drawable.getYpos()), null);
    }
    }

    @Override
    public void actOnModelUpdate(ArrayList<Drawable> d) {
        drawables.clear();
        for (Drawable draw : d){
            drawables.add(draw);
        }
        this.repaint();
    }
}
