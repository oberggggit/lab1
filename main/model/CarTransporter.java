package main.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public abstract class CarTransporter extends Truck{ //maybe not abstract

    //private main.model.BedComponent bed // this is in main.model.Truck now
    private LoadComponent<Car> loadComponent;

    public CarTransporter(int nrDoors, double enginePower, Color color, String modelName, int loadCapacity, int regNum){
        super(nrDoors, enginePower, color, modelName, regNum, new BedComponent());
        this.loadComponent = new LoadComponent<>(loadCapacity); //felixjons
    }

    @Override
    public boolean isBedUp(){
        return this.bed.isBedUp();
    }

    @Override
    public boolean isBedDown(){
        return this.bed.isBedDown();
    }

    @Override
    public void raiseBed(){
        this.bed.raiseBed(getCurrentSpeed());
    }

    @Override
    public void lowerBed(){
        this.bed.lowerBed(getCurrentSpeed());
    }

    public int getLoadCapacity(){
        return this.loadComponent.getLoadCapacity();
    }

    @Override
    public void move() {
        if (isBedUp()) {
            super.move();
            ArrayList<Car> carList = new ArrayList<>(loadComponent.getCarStack()); //Changed from ArrayList<main.model.Vehicle> to ArrayList<main.model.Car>, reducing a usage dependency from main.model.CarTransporter to main.model.Vehicle.
            for (int i = 0; i < carList.size(); i++) {
                carList.get(i).setPosition(this.getPosition()); //the carTransporters position should already be changed from super.move()
            }
        }
        else {
            throw new IllegalArgumentException("main.model.CarTransporter cannot move if bed is down.");
        }
    }

    public void load(Car car) {
        Point transporterPosition = getPosition();
        double distanceToCar = distanceToCar(car);

        if (isBedUp()) {
            throw new IllegalArgumentException("Can't load a car when bed is up");
        } else if (distanceToCar > 5) {
            throw new IllegalArgumentException("Distance to the car too big");
        } else if (car.getEnginePower() > 400) {
            throw new IllegalArgumentException("car is too big");
        } else {
            car.setPosition(transporterPosition);
            loadComponent.load(car);
        }
    }

    public Car unload() {
        boolean bedUp = isBedUp();

        if (!bedUp) {
            Car car = loadComponent.unload();

            Point newPosition = new Point(
                    (int) (getPosition().getX() + 2),
                    (int) (getPosition().getY())
            );
            car.setPosition(newPosition);
            return car;

        }
        else {
            throw new IllegalArgumentException("Can't unload a car when bed is up");
        }
    }

    public Car unload(int regNum) {
        boolean bedUp = isBedUp();

        if (!bedUp) {
            Car car = loadComponent.unload(regNum);

            Point newPosition = new Point(
                    (int) (getPosition().getX() + 2),
                    (int) (getPosition().getY())
            );
            car.setPosition(newPosition);
            return car;

        }
        else {
            throw new IllegalArgumentException("Can't unload a car when bed is up");
        }
    }

    public double distanceToCar(Vehicle car){
        Point currentPosition = this.getPosition();
        Point otherPosition = car.getPosition();

        return currentPosition.distance(otherPosition);
    }

    public Stack<Car> getCarStack(){
        return this.loadComponent.getCarStack();
    }

}
