import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Saab95 extends Car{
    private boolean turboOn;

    public Saab95(){
        super(2,125, Color.red, "Saab95", 4436); //nrDoors = 2; color = Color.red; enginePower = 125; modelName = "Saab95";
        turboOn = false;
        try {
            this.setImage(ImageIO.read(CarPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    protected void setTurboOn() {turboOn = true; }

    protected void setTurboOff(){
	    turboOn = false;
    }

    protected boolean getTurbo(){return turboOn;}
    
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(this.turboOn) turbo = 1.3; //If a saab has turboOn it has been fitted with 30% stronger brakes, lets say they get 30% better when turbo is on.
        return getEnginePower() * 0.01 * turbo;
    }


}

