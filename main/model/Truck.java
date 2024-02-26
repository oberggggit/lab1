package main.model;

import java.awt.*;

abstract class Truck extends Vehicle{ // A truck is a main.model.Vehicle with a bed and a bedAngle

    public BedInterface bed;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int regNum, BedInterface bed){
        super(nrDoors, enginePower, color, modelName, regNum);
        this.bed = bed;
    }

    public boolean isBedUp(){
        return this.bed.isBedUp();
    } //TODO Maybe change to protected for these 4 methods.

    public boolean isBedDown(){
        return this.bed.isBedDown();
    }

    public void raiseBed(){
        this.bed.raiseBed(getCurrentSpeed());
    }

    public void lowerBed(){
        this.bed.lowerBed(getCurrentSpeed());
    }

    protected double speedFactor(){
        return 8;
    }


    @Override
    public void gas(double amount) {
        if (isBedUp()) {
            super.gas(amount);
        }
        else {
            throw new IllegalArgumentException("main.model.Truck cannot move if Bed is down.");
        }
    }


    //TODO Override gas and check if bed is up - has to do this on carTransporter as well -> Might want to restructure our code because of this, schematically

}
