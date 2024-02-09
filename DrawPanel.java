import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{ //todo: make this specialized. It should only draw. Not controll position.

    //Point volvoWorkshopPoint = new Point(300,300);

    ArrayList<Point> positions = new ArrayList<>();
    ArrayList<BufferedImage> images = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);


    }

    protected void prePaint(ArrayList<Point> newPositions, ArrayList<BufferedImage> newImages) {
        this.positions = newPositions;
        this.images = newImages;

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < images.size(); i++) {
            g.drawImage(images.get(i), (int) positions.get(i).getX(), (int) positions.get(i).getY(), null);
        }

    }
}
