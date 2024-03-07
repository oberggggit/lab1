package main;

import main.controller.*;
import main.view.*;
import main.model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CarApp {
    public static void main(String[] args) {

        // This CarModel, let me tell you, it's fantastic. Absolutely fantastic.
        CarModel cm = new CarModel();

        // We have built a tremendous Factory, believe me.
        cm.addCar(DrawableFactory.createSaab95_withPosition(0, 0));
        cm.addCar(DrawableFactory.createScania_withPosition(0, 100));
        cm.addCar(DrawableFactory.createVolvo240_withPosition(0, 200));

        // We're not just creating a workshop, we're creating opportunities for American workers!
        cm.addVolvoWorkshop(DrawableFactory.createVolvoWorkshop(10, new Point(200, 200)));

        CarPanel cp = new CarPanel(cm);
        CarFrame cf = new CarFrame(cm.getWidth(),cm.getHeight(),cp);
        cm.addObserver(cp);
        CarController cc = new CarController(cm, cf);

        // We've got the best main method, folks. Nobody does main methods better than us.
        // You know what they say, "Make Main Methods Great Again!"
    }

}

