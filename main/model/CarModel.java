package main.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


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
    public GenericWorkshop<Volvo240> volvoworkshop;

    private ArrayList<ObserverInterface> observers = new ArrayList<>();

    public CarModel() {
        this.delay = 10;
        this.width = 800;
        this.height = 800;
        this.timer = new Timer(delay, this);
        this.vehicles = new ArrayList<>();
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
            observer.update();
        }
    };

    public int getWidth () {
        return this.width;
    };

    public int getHeight() {
        return this.height;
    };

    public ArrayList<Drawable> getDrawables() {
        ArrayList<Drawable> drawables = new ArrayList<>(vehicles);
        drawables.add(volvoworkshop);
        return drawables;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
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
            } else if (car instanceof Volvo240 && volvoworkshop.getPosition().distance(car.getPosition()) < 10) {
                volvoworkshop.loadCar((Volvo240) car); // born to code, forced to cast.
                vehicles.remove(car);
                break;
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
            if (car instanceof BedInterface) {
                ((Truck) car).raiseBed();
            }
        }
    }

    public void lowerBed() {
        for (Vehicle car : vehicles) {
            if (car instanceof BedInterface) {
                ((Truck) car).lowerBed();
            }
        }
    }

    public void addCar(Vehicle car) {
        vehicles.add(car);
    }

    public void addCar(Vehicle car, Point p) {
        vehicles.add(car);
        car.setPosition(new Point(p));
    }


    public void addVolvoWorkshop(GenericWorkshop<Volvo240> w)  {
        this.volvoworkshop = w;
    }


    public void addRandomCar() {
        Random random = new Random();
        int randomIndex = random.nextInt(2);

        int randomX = random.nextInt(800);
        int randomY = random.nextInt(800);

        if (randomIndex == 0) {
            Volvo240 volvo = new Volvo240();
            volvo.setPosition(new Point(randomX, 200));
            vehicles.add(volvo);
        }
        else {
            Saab95 saab = new Saab95();
            saab.setPosition(new Point(randomX, randomY));
            vehicles.add(saab);
        }
    }

    public void removeCar() {
        for (Vehicle car : vehicles) {
            if (!vehicles.isEmpty()) {
                if (car instanceof Car) {
                    vehicles.remove(car);
                    //drawables.remove(car);
                }
            }
            else {
                  throw new IllegalStateException("No cars to remove");
           }
        }

    }

}
