package main.model;

import java.awt.*;

public abstract class Car extends Vehicle{

    public Car (int nrDoors, double enginePower, Color color, String modelName, int regNum) {
        super(nrDoors, enginePower, color, modelName, regNum);
    }
}
