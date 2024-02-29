package main.model;

import java.awt.*;

abstract class Truck extends Vehicle{ // A truck is a main.model.Vehicle with a bed and a bedAngle

    public BedInterface bed;

    /*
    public static GenerateTruck () \{

    }
     */

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int regNum, BedInterface bed){
        super(nrDoors, enginePower, color, modelName, regNum);
        this.bed = bed;
    }

    public boolean isBedUp(){
        return this.bed.isBedUp();
    }

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
        //this error seem to impact the movement of the other cars. If we stop and lower the bed, we can only move one car.
//        else {
//            throw new IllegalArgumentException("main.model.Truck cannot move if Bed is down.");
//       }
    }

}
