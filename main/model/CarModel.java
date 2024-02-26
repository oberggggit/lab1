package main.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class CarModel implements SubjectInterface, ActionListener {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    private int width;
    private int height;

    // The frame that represents this instance View of the MVC pattern

    public ArrayList<Vehicle> vehicles;
    public ArrayList<Drawable> drawables;
    private GenericWorkshop<Volvo240> volvoworkshop;

    private boolean imageRenderingLimiter = false;
    private BufferedImage volvoworkshopImage;

    private ArrayList<ObserverInterface> observers = new ArrayList<>();

    public CarModel() {
        this.delay = 10;
        this.width = 800;
        this.height = 800;
        this.timer = new Timer(delay, this);
        this.vehicles = new ArrayList<>();
        this.drawables = new ArrayList<>();
        this.timer.start();

    };

    public void addObserver(ObserverInterface observer){
        observers.add(observer);
    };

    public void removeObserver(ObserverInterface observer){
        observers.remove(observer);
    };

    public void notifyObservers(){
        for (ObserverInterface observer : observers) {
            observer.update(); //TODO: Choose what to send as argument
        }
    };

    public int getWidth () {
        return this.width;
    };

    public int getHeight() {
        return this.height;
    };


    @Override
    public void actionPerformed(ActionEvent e) { //Should not be exactly like this though should be a func that is called in Controller.
        for (Vehicle car : vehicles) {
            car.move();

            double carX = car.getPosition().getX();
            double carY = car.getPosition().getY();

            if (carX + car.getImage().getWidth() > width || carX < 0) {
                car.stopEngine();
                car.turnLeft();
                car.turnLeft();
                car.startEngine();

            } else if (carY + car.getImage().getHeight() > height-140 || carY < 0) { // the -140 is because of the buttons
                car.stopEngine();
                car.turnLeft();
                car.turnLeft();
                car.startEngine();
            } else if (car instanceof Volvo240 && volvoworkshop.getPosition().distance(car.getPosition()) < 5) {
                volvoworkshop.loadCar((Volvo240) car); // born to code, forced to cast.
                drawables.remove(car);
            }

            if (!imageRenderingLimiter) { // only add images in first frame.
                drawables.add(car);
            }
        }
        notifyObservers();
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles
                ) {
            car.gas(gas);
        }
    }

    // Calls the gas method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles
        ) {
            car.brake(brake);
        }
    }

    public void startAllCars() {
        for (Vehicle car : vehicles
        ) {
            car.startEngine();
        }
    }

    public void stopAllCars() {
        for (Vehicle car : vehicles
        ) {
            car.stopEngine();
        }
    }

    public void turboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Truck) {
                ((Truck) car).raiseBed();
            }
        }
    }

    public void lowerBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof Truck) {
                ((Truck) car).lowerBed();
            }
        }
    }
}
