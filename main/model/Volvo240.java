package main.model;

import main.view.CarPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4,100,Color.black, "main.model.Volvo240", 5643);
        try {
            this.setImage(ImageIO.read(new File("main/model/pics/Volvo240.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
