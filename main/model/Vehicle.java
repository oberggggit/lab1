package main.model;

import java.awt.*;
import java.awt.image.BufferedImage;
public abstract class Vehicle implements Movable, Drawable{

    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;
    private int regNum;

    private double currentSpeed;
    private Point pt;
    private double direction;
    private BufferedImage image;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, int regNum){ //Konstruktor
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.regNum = regNum;

        this.currentSpeed = 0;
        this.pt = new Point(0,0); //start = 0,0
        this.direction = 0; // Riktning i grader (0-360)
    }

    public int getNrDoors(){return nrDoors;}

    public BufferedImage getImage(){return image;}

    public void setImage(BufferedImage img){image = img;}

    protected String getModelName(){return modelName;}

    public int getRegNum(){return regNum;}

    public double getEnginePower(){
        return enginePower;
    }

    public double setEnginePower(double newEnginePower){ return enginePower = newEnginePower;} ////Goes against access/modifier principle stuff (forgot name of principle, whatever)

    public double getCurrentSpeed(){return currentSpeed;}

    public Color getColor(){return color;}

    public void setColor(Color clr){ color = clr; }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public Point getPosition(){
        return pt.getLocation();
    }

    public double getDirection(){
        return direction;
    }

    public void setPosition(Point newPt) {
        this.pt = newPt.getLocation();
    }

    public void setDirection(double newDir) {
        this.direction = newDir;
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Gas amount not in correct interval");
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Brake amount not in correct interval");
        }

    }


    @Override
    public void move() {
        double deltaX = getCurrentSpeed() * Math.cos(Math.toRadians(getDirection()));
        double deltaY = getCurrentSpeed() * Math.sin(Math.toRadians(getDirection()));

        Point newPosition = new Point(
                (int) (getPosition().getX() + deltaX),
                (int) (getPosition().getY() + deltaY)
        );

        setPosition(newPosition);
    }

    @Override
    public void turnLeft() {
        // Turn the car left by decreasing its direction angle
        direction -= 90;
        direction = direction % 360;
    }

    @Override
    public void turnRight() {
        // Turn the car right by increasing its direction angle
        direction += 90;
        direction = direction % 360;
    }
    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        if (speedFactor() * amount >= 0){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }
        else {
            throw new IllegalArgumentException("Increment speed not positive");
        }

    }
    protected void decrementSpeed(double amount){
        if (speedFactor() * amount >= 0){
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        }
        else {
            throw new IllegalArgumentException("Decrement speed not negative");
        }

    }

}
