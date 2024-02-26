import main.model.Saab95;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    private Saab95 saab;

    @BeforeEach
    void setUp() {
        this.saab = new Saab95();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.getTurbo());
    }

    @Test
    void setTurboOff() {
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.getTurbo());
    }

    @Test
    void speedFactor() {
        assertEquals(1.25,saab.speedFactor()) ;
    }

    @Test
    void testBrakeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(1.2); // Provide an invalid value
        });
    }

    @Test
    void testGasThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(1.2); // Provide an invalid value
        });
    }
}