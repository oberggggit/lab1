import main.model.Volvo240;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    private Volvo240 volvo;

    @BeforeEach
    void setUp() {
        this.volvo = new Volvo240();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void speedFactor() {
        assertEquals(1.25,volvo.speedFactor()) ;
    }

    @Test
    void testBrakeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.brake(1.2); // Provide an invalid value
        });
    }

    @Test
    void testGasThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.gas(1.2); // Provide an invalid value
        });
    }
}