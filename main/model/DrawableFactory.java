package main.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DrawableFactory {

    public static Saab95 createSaab95_withPosition(int x, int y) {
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(x, y));
        return saab;
    }

    public static Scania createScania_withPosition(int x, int y) {
        Scania scania = new Scania();
        scania.setPosition(new Point(x, y));
        return scania;
    }

    public static Volvo240 createVolvo240_withPosition(int x, int y) {
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(new Point(x, y));
        return volvo;
    }

    public static GenericWorkshop<Volvo240> createVolvoWorkshop(int capacity, Point position) {
        GenericWorkshop<Volvo240> w = new GenericWorkshop<>(capacity);
        w.setPosition(new Point(position));
        try {
            w.setImage(ImageIO.read(new File("main/model/pics/VolvoBrand.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return w;
    }

    public static GenericWorkshop<Volvo240> createVolvoWorkshop(int capacity) {
        GenericWorkshop<Volvo240> w = new GenericWorkshop<>(capacity);
        try {
            w.setImage(ImageIO.read(new File("main/model/pics/VolvoBrand.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return w;
    }

}
