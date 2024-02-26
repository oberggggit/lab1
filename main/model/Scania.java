package main.model;

import main.view.CarPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Scania extends Truck{

    //private main.model.BedWithAngleComponent bed; /This is handled in main.model.Truck

    public Scania(){
        super(2,500, Color.CYAN, "ScaniaTruck", 1234, new BedWithAngleComponent());

        try {
            this.setImage(ImageIO.read(new File("main/model/pics/Scania.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}
