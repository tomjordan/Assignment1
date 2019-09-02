import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest2 {

    @Test
    void testgets() {
        Vehicle vehicle = new Vehicle("Car", "North", 20, 1, 1);
        vehicle.intiDir();
        assertEquals("Car", vehicle.getType());
        assertEquals("North", vehicle.getDirection());
        assertEquals(20, vehicle.getSpeed());
        assertEquals(1, vehicle.getXpos());
        assertEquals(3, vehicle.getYpos());
    }
   @Test
   void testmovement() {
       Vehicle vehicle = new Vehicle("Car", "North", 20, 1, 1);
       vehicle.intiDir();
       vehicle.moveVehicle();

    }

    @Test
    void testtypes() {
        Vehicle bus = new Vehicle("Bus", "West", 4, 0, 0);
        bus.intiDir();
        bus.moveVehicle();
        assertEquals("Bus", bus.getType());
        assertEquals("West", bus.getDirection());
        assertEquals(4, bus.getSpeed());
        assertEquals(-10, bus.getXpos());

        Vehicle moto = new Vehicle("Motorbike", "east", 25, 0, 0);
        moto.intiDir();
        moto.moveVehicle();
        assertEquals("Motorbike", bus.getType());
        assertEquals("East", bus.getDirection());
        assertEquals(25, bus.getSpeed());
        assertEquals(26, bus.getXpos());
    }
}