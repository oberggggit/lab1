package main.view;

import main.model.CarModel;
import main.model.Drawable;
import main.model.ObserverInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

// This panel represents the animated part of the view with the car images.

public class CarPanel extends JPanel implements ObserverInterface { //maybe add extends JFrame


    List<Point> positions = new ArrayList<>();
    List<BufferedImage> images = new ArrayList<>();

    private final int X;
    private final int Y;

    CarModel cm;


    // Initializes the panel and reads the images
    public CarPanel(int x, int y, CarModel cm) {
        this.X = x;
        this.Y = y-140; //buttons take up 140 pixels
        this.cm = cm;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(X, Y));
        this.setBackground(Color.white);
    }




    public void update() {

        this.positions.clear();
        this.images.clear();

        for (Drawable drawable : cm.drawables) {
            this.positions.add(drawable.getPosition());
            this.images.add(drawable.getImage());
        }

        repaint();

    }

    // This method is called each time the panel updates/refreshes/repaints itself


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable: cm.drawables) {
            g.drawImage(drawable.getImage(), (int) drawable.getPosition().getX(), (int) drawable.getPosition().getY(), null);
        }
    }


}