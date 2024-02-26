package main.model;

import main.view.CarPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Saab95 extends Car{
    private boolean turboOn;

    public Saab95(){
        super(2,125, Color.red, "main.model.Saab95", 4436); //nrDoors = 2; color = Color.red; enginePower = 125; modelName = "main.model.Saab95";
        turboOn = false;
        try {
            this.setImage(ImageIO.read(new File("main/model/pics/Saab95.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setTurboOn() {turboOn = true; }

    public void setTurboOff(){
	    turboOn = false;
    }

    public boolean getTurbo(){return turboOn;}
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(this.turboOn) turbo = 1.3; //If a saab has turboOn it has been fitted with 30% stronger brakes, lets say they get 30% better when turbo is on.
        return getEnginePower() * 0.01 * turbo;
    }


}

