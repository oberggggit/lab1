import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Saab95 saab;
    private Volvo240 volvo; //en för saab och en för volvo

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.saab = new Saab95();
        this.volvo = new Volvo240();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assertEquals(2, saab.getNrDoors());
        assertEquals(4, volvo.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {
        assertEquals(125, saab.getEnginePower());
        assertEquals(100, volvo.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        assertEquals(0, saab.getCurrentSpeed());
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void getSaabColor() {
        assertEquals(Color.red, saab.getColor());
    }

    @org.junit.jupiter.api.Test
    void getVolvoColor() {
        assertEquals(Color.black, volvo.getColor());
    }

    @org.junit.jupiter.api.Test
    void setSaabColor() {
        saab.setColor(Color.pink);
        assertEquals(Color.pink, saab.getColor());
    }

    @org.junit.jupiter.api.Test
    void setVolvoColor() {
        volvo.setColor(Color.cyan);
        assertEquals(Color.cyan, volvo.getColor());
    }

    @org.junit.jupiter.api.Test
    void startSaabEngine() {
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void startVolvoEngine() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void stopSaabEngine() {
        saab.startEngine();
        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void stopVolvoEngine() {
        volvo.startEngine();
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void setPosition() {
        Point newSaabPosition = new Point(10, 15);
        Point newVolvoPosition = new Point(20, 25);
        saab.setPosition(newSaabPosition);
        volvo.setPosition(newVolvoPosition);

        assertEquals(newSaabPosition, saab.getPosition());
        assertEquals(newVolvoPosition, volvo.getPosition());
    }

    @org.junit.jupiter.api.Test
    void getPosition() {
        assertEquals(0, saab.getPosition().getX());
        assertEquals(0, saab.getPosition().getY());
        assertEquals(0, volvo.getPosition().getX());
        assertEquals(0, volvo.getPosition().getY());

    }

    @org.junit.jupiter.api.Test
    void setDirection() {
        saab.setDirection(180);
        volvo.setDirection(270);

        assertEquals(180, saab.getDirection());
        assertEquals(270, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void getDirection() {
        assertEquals(90, saab.getDirection());
        assertEquals(90, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void volvogas() {
        //currentspeed is defaulted to 0 here
        volvo.gas(0.5);
        assertEquals(0.625, volvo.getCurrentSpeed()); //0,01*1,25*100 is same as 0,01*125*1 (saab and volvo same when no turbo for saab)

    }

    @org.junit.jupiter.api.Test
    void saabgas() {
        //currentspeed is defaulted to 0 here

        saab.setTurboOff();
        saab.gas(0.5);
        assertEquals(0.625, saab.getCurrentSpeed());

        saab.stopEngine();

        saab.setTurboOn();
        saab.gas(0.5);
        assertEquals(0.8125, saab.getCurrentSpeed());

    }


    @org.junit.jupiter.api.Test
    void brakeSaab() {
        saab.gas(1);
        saab.brake(0.5);
        assertEquals(0.625, saab.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void brakeVolvo() {
        volvo.gas(1);
        volvo.brake(0.5);
        assertEquals(0.625, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void moveSaab() {
        saab.startEngine();
        saab.gas(1);
        Point saabStartPosition = saab.getPosition();
        saab.move();
        assertNotEquals(saabStartPosition, saab.getPosition());
    }

    @org.junit.jupiter.api.Test
    void moveVolvo() {
        volvo.startEngine();
        volvo.gas(1);
        Point volvoStartPosition = volvo.getPosition();
        volvo.move();
        assertNotEquals(volvoStartPosition, volvo.getPosition());
    }

    @org.junit.jupiter.api.Test
    void turnLeftSaab() {
        saab.turnLeft();
        assertEquals(0, saab.getDirection());
    }

    @org.junit.jupiter.api.Test
    void turnLeftVolvo() {
        volvo.turnLeft();
        assertEquals(0, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void turnRightSaab() {
        saab.turnRight();
        assertEquals(180, saab.getDirection());
    }

    @org.junit.jupiter.api.Test
    void turnRightVolvo() {
        volvo.turnRight();
        assertEquals(180, volvo.getDirection());
    }

    /*
    @org.junit.jupiter.api.Test
    void speedFactor() { //redundant
        saab.setTurboOff();
        assertEquals(false, saab.turboOn);
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() { //redundant
    }

    @org.junit.jupiter.api.Test //redundant
    void decrementSpeed() {
    }

     */
}