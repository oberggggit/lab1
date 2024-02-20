import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTransporterTest {
    private HanomagCarTransport hanomag;
    private HanomagCarTransport hanomag2;
    private Saab95 saab;
    private Volvo240 volvo;


    @BeforeEach
    void setUp() {
        this.hanomag = new HanomagCarTransport();
        this.hanomag2 = new HanomagCarTransport();
        this.volvo = new Volvo240();
        this.saab = new Saab95();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void speedFactor() { //flytta till Hanomags test?
    }

    @Test
    void isBedUp() { //checking deafault bed state
        assertTrue(hanomag.isBedUp());

    }

    @Test
    void setBedState() { //checking the bed setter
        hanomag.lowerBed();
        assertFalse(hanomag.isBedUp());
    }

    @Test
    void getLoadCapacity() {
        assertEquals(5, hanomag.getLoadCapacity());
    }

    @Test
    void move() {
        hanomag.gas(1);
        Point hanomagStartPosition = hanomag.getPosition();
        hanomag.move();
        assertNotEquals(hanomagStartPosition, hanomag.getPosition());
    }

    @Test
    void load() { //checking that we can load when bed is down
        hanomag.lowerBed();
        hanomag.load(volvo);
        hanomag.load(saab);
        assertEquals(2, hanomag.getCarStack().size());

    }

    @Test
    void loadWithBedUp() { //checking that we can't load when bed is up
        assertThrows(IllegalArgumentException.class, () -> {
            hanomag.load(volvo);
        });

    }

//    @Test
//    void loadCarTransporter() { //checking that we can't load another CarTransporter
//        hanomag.lowerBed();
//        assertThrows(IllegalArgumentException.class, () -> {
//            hanomag.load(hanomag2);
//        });
//    }

    @Test
    void loadCarFarAway() { //checking that we can't load a car that is too far away
        hanomag.lowerBed();
        volvo.setPosition(new Point(10, 10));
        assertThrows(IllegalArgumentException.class, () -> {
            hanomag.load(volvo);
        });
    }

    @Test
    void loadCarTooBig() { //checking that we can't load a car that is too big
        hanomag.lowerBed();
        volvo.setEnginePower(1500);
        assertThrows(IllegalArgumentException.class, () -> {
            hanomag.load(volvo);
        });
    }

    @Test
    void unload() { //checking that we can unload cars when bed is down
        hanomag.lowerBed();
        hanomag.load(volvo);
        hanomag.load(saab);
        hanomag.unload();
        assertEquals(1, hanomag.getCarStack().size());
    }

    @Test
    void unloadCorrectCar() {
        hanomag.lowerBed();
        hanomag.load(volvo);
        hanomag.load(saab);
        Vehicle unloadedCar = hanomag.unload();
        assertEquals(saab, unloadedCar);
        Vehicle unloadedCar1 = hanomag.unload();
        assertEquals(volvo, unloadedCar1);
    }

    @Test
    void unloadCarPosition() {
        hanomag.lowerBed();
        hanomag.load(volvo);
        Vehicle unloadedCar = hanomag.unload();
        assertNotEquals(unloadedCar.getPosition(), hanomag.getPosition());

    }

    @Test
    void unloadCarBedisUp() {
        hanomag.lowerBed();
        hanomag.load(volvo);
        hanomag.raiseBed();
        assertThrows(IllegalArgumentException.class, () -> {
            hanomag.unload();
        });
    }

    @Test
    void unloadCarWhenEmpty() {
        hanomag.lowerBed();
        assertThrows(IllegalArgumentException.class, () -> {
            hanomag.unload();
        });
    }

    @Test
    void distanceToCar() {
        hanomag.setPosition(new Point(0, 0));
        volvo.setPosition(new Point(0, 5));
        assertEquals(5, hanomag.distanceToCar(volvo));
    }
}