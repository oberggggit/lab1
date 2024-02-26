package main.model;

public class BedWithAngleComponent implements BedInterface {

    private double bedAngle;

    public BedWithAngleComponent() {
        this.bedAngle = 0;
    } //konstruktor

    public boolean isBedUp(){
        return bedAngle == 0;
    }

    public boolean isBedDown(){
        return bedAngle == 70;
    }

    public void raiseBed(double currentSpeed){
        if (currentSpeed != 0){
            throw new IllegalArgumentException("Please stop to raise bed");
        }
        else if (bedAngle == 0){
            throw new IllegalArgumentException("Bed is already up");
        }
        else {
            this.bedAngle = 0;
        }
    }

    public void lowerBed(double currentSpeed){
        if (currentSpeed != 0){
            throw new IllegalArgumentException("Please stop to lower bed");
        }
        else if (bedAngle == 70){
            throw new IllegalArgumentException("Bed is already down");
        }
        else {
            this.bedAngle = 70;
        }
    }
}
