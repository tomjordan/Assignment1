import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void testMove() {
        Road road = new Road(24, 10,"East",0,0);
        road.makeRoad();
        assertEquals(24, road.xend);
        road.addVehicle("Bus", "East", 4, 0, 0);
        road.moveVehicles();
        road.addVehicle("Car", "East", 3, 0, 0);

        assertEquals(10, road.getxPosition(0));
        assertEquals(2, road.getxPosition(1));

        road.moveVehicles();
        road.moveVehicles();

        assertEquals(18, road.getxPosition(0));
        assertEquals(8, road.getxPosition(1));
        road.moveVehicles();
        road.moveVehicles();
        road.moveVehicles();
        assertEquals(17, road.getxPosition(0));
        assertEquals(1, road.getNum_vehicles());
        road.moveVehicles();
        assertEquals(20, road.getxPosition(0));


    }
}