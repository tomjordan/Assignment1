import jdk.jfr.Timespan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void testMove() {
        Road road = new Road(24, 10, "East", 0, 0);
        road.makeRoad();
        assertEquals(24, road.xeast);
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

    @Test
    void teststuff() {
        Road road = new Road(24, 10, "North", 0, 15);
        road.makeRoad();
        assertEquals(39, road.ynorth);
        road.addVehicle("Motorbike", "North", 10, 0, 17);
        assertEquals(18, road.getyPosition(0));
        road.moveVehicles();
        road.moveVehicles();
        assertEquals(38, road.getyPosition(0));
        road.moveVehicles();
        assertEquals(0, road.getNum_vehicles());



    }

    @Test
    void testonroad() {
        Road road = new Road(24, 10, "North", 0, 15);
        road.makeRoad();
        road.addVehicle("Motorbike", "North", 10, 0, 50);
        road.addTrafficLight(5, 200, "NS", true);
        road.addVehicle("Motorbike", "North", 10, 0, 25);

    }

    @Test
    void trafficLighttest() {
        Road road = new Road(30, 10, "North", 0, 0);
        road.makeRoad();
        road.addTrafficLight(5, 15, "NS", false);
        road.addVehicle("Motorbike", "North", 7 , 0, 0);
        road.moveVehicles();
        road.moveVehicles();
        road.moveVehicles();
        road.moveVehicles();
        assertEquals(15, road.getyPosition(0));
    }

}