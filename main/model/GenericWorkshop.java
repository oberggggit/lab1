package main.model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GenericWorkshop <V extends Vehicle> implements Drawable {

    private LoadComponent<V> loadComponent;
    private Point position;
    private BufferedImage image;

    public GenericWorkshop(int maxCapacity) {
        this.loadComponent = new LoadComponent<>(maxCapacity);
    }

    public void loadCar(V car) {
        loadComponent.load(car);
    }

    public V unloadCar() { //Shouldn't be car, should be unloadVehicle but whatever
        V unloadedCar = this.loadComponent.unload();
        return unloadedCar;
    }

    public V unloadCar(int regNum) { //Shouldn't be car, should be unloadVehicle but whatever
        V unloadedCar = this.loadComponent.unload(regNum);
        return unloadedCar;
    }


    public BufferedImage getImage() {
        return this.image;
    }

    public Point getPosition() {
        return this.position;
    }


    public void setPosition(Point position) {
        this.position = position;
    }


    public void setImage(BufferedImage image) {
        this.image = image;
    }
}


