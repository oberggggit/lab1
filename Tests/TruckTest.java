import main.model.Scania;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    private Scania scania;

    @BeforeEach
    void setUp() {
        this.scania = new Scania();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setBedAngle() {
        scania.lowerBed();
        assertTrue(scania.isBedDown());
    }

    @Test
    void move() {
        scania.gas(1);
        Point scaniaStartPosition = scania.getPosition();
        scania.move();
        assertNotEquals(scaniaStartPosition, scania.getPosition());
    }

    @Test
    void move1() {
        assertThrows(IllegalArgumentException.class, () -> {
            scania.lowerBed();
            scania.gas(1);
        });

    }

    @Test
    void move2() {
        assertThrows(IllegalArgumentException.class, () -> {
            scania.gas(1);
            scania.lowerBed();
        });

    }

}
