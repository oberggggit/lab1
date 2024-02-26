import main.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericWorkshopTest {
    private GenericWorkshop<Volvo240> volvoWorkshop;
    private GenericWorkshop<Saab95> saabWorkshop;
    private GenericWorkshop<Vehicle> vehicleWorkshop;

    private Volvo240 volvo;
    private Saab95 saab;
    private Scania scania;

    @BeforeEach
    void setUp() {
        this.volvo = new Volvo240();
        this.saab = new Saab95();
        this.scania = new Scania();
        this.volvoWorkshop = new GenericWorkshop<Volvo240>(5);
        this.saabWorkshop = new GenericWorkshop<Saab95>(5);
        this.vehicleWorkshop = new GenericWorkshop<Vehicle>(5);
    }

    @Test
    void loadCarVehicleWorkshop() {
        vehicleWorkshop.loadCar(volvo);
        vehicleWorkshop.loadCar(saab);
        vehicleWorkshop.loadCar(scania);
    }

    @Test
    void loadCarVolvoWorkshop() {
        volvoWorkshop.loadCar(volvo);
        //assertThrows(IllegalArgumentException.class, () -> volvoWorkshop.loadCar(saab));
    }

    @Test
    void unloadCarVehicleWorkshop() {
        vehicleWorkshop.loadCar(volvo);
        vehicleWorkshop.loadCar(saab);
        vehicleWorkshop.loadCar(scania);
        assertEquals(scania, vehicleWorkshop.unloadCar());
        assertEquals(saab, vehicleWorkshop.unloadCar());
        assertEquals(volvo, vehicleWorkshop.unloadCar());
    }

    @Test
    void unloadCarVehicleWorkshopWithRegNum() {
        vehicleWorkshop.loadCar(volvo);
        vehicleWorkshop.loadCar(saab);
        vehicleWorkshop.loadCar(scania);
        assertEquals(volvo, vehicleWorkshop.unloadCar(5643));

    }
}