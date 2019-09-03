package Assignment;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    /*@Test
    void testMove() {
        Road road = new Road(24, 10, "East", 0, 0);
        road.makeRoad();
        assertEquals(24, road.getXeast());
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
        assertEquals(39, road.getYnorth());
        road.addVehicle("Motorbike", "North", 10, 0, 17);
        assertEquals(18, road.getyPosition(0));
        road.moveVehicles();
        road.moveVehicles();
        assertEquals(38, road.getyPosition(0));
        road.moveVehicles();
        assertEquals(0, road.getNum_vehicles());



    }



   *//*@Test
    void testonroad() {
        Road road = new Road(24, 10, "North", 0, 15);
        road.makeRoad();
        road.addVehicle("Motorbike", "North", 10, 0, 50);
        road.addTrafficLight(5, 200, "NS", true);
        road.addVehicle("Motorbike", "North", 10, 0, 25);

    }*/

    @Test
    void trafficLighttest() {
        Road road = new Road(30, 10, "North", 0, 0);
        road.makeRoad();
        road.addTrafficLight("End");
        road.addVehicle("Motorbike", 10);
        road.moveVehicles();
        road.moveVehicles();
        road.moveVehicles();
        road.moveVehicles();
        road.moveVehicles();
        assertEquals(30, road.getVehicleOnRoad(0).getYpos());
    }

    @Test
    void testaddtrafficlight() {
        Road road = new Road(25, 10, "North", 0, 0);
        road.makeRoad();
        road.addTrafficLight("End");
        assertEquals(25, road.getTrafficlight(0).getYpos());
        Road road2 = new Road(25, 10, "South", 0, 0);
        road2.makeRoad();
        road2.addTrafficLight("End");
        assertEquals(-25, road2.getTrafficlight(0).getYpos());
    }

    @Test
    void testcollisions() {
        Road road = new Road(25, 10, "North", 0, 0);
        road.makeRoad();
        road.addVehicle("Car", 4);
        road.moveVehicles();
        road.moveVehicles();
        assertEquals(8, road.getVehicleOnRoad(0).getYrear());
        road.addVehicle("Car", 15);
        road.moveVehicles();
        assertEquals(11, road.getVehicleOnRoad(1).getYpos());

        Road road2 = new Road(25, 10, "West", 0, 0);
        road2.makeRoad();
        road2.addVehicle("Car", 4);
        road2.moveVehicles();
        road2.moveVehicles();
        assertEquals(-8, road2.getVehicleOnRoad(0).getXrear());
        road2.addVehicle("Car", 15);
        road2.moveVehicles();
        assertEquals(-14, road2.getVehicleOnRoad(0).getXpos());
        assertEquals(-11, road2.getVehicleOnRoad(1).getXpos());


    }
}