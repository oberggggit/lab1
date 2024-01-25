import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4,100,Color.black, "Volvo240");
    }
    
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
