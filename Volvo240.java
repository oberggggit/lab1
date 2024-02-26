import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4,100,Color.black, "Volvo240", 5643);
        try {
            this.setImage(ImageIO.read(CarPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
