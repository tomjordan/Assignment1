package Assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadMainTest {

    @Test
    void testnewRoads() {
        RoadMain roadMain = new RoadMain();

        roadMain.addnewRoad(20, 10, "North", 0, 0);
        roadMain.addConectingRoad(20, "West");
        roadMain.addConectingRoad(20, "South");
        Road a = roadMain.getRoad(0);
        Road b = roadMain.getRoad(1);
        Road c = roadMain.getRoad(2);
        System.out.println(a.getYnorth() + "   " + a.getYsouth() + "   " +
                a.getXeast() + "   " + a.getXwest());
        System.out.println(b.getYnorth() + "   " + b.getYsouth() + "   " +
                b.getXeast() + "   " + b.getXwest());
        System.out.println(c.getYnorth() + "   " + c.getYsouth() + "   " +
                c.getXeast() + "   " + c.getXwest());

    }

    /*@Test
    void testturning() {
        RoadMain roadMain = new RoadMain();
        roadMain.addnewRoad(20, 10, "East", 0, 0);
        roadMain.addConectingRoad(20, "North");
        roadMain.addConectingRoad(20, "West");
        roadMain.addLight(0, "End");
        roadMain.roads.get(0).getTrafficlight(0).setStatus(false);
        roadMain.addVehicle("Car", 5);
        roadMain.moveVehicles();
        assertEquals(7, roadMain.roads.get(0).vehicles.get(0).getXpos());
        roadMain.moveVehicles();
        roadMain.addVehicle("Motorbike", 4);
        roadMain.moveVehicles();
        roadMain.moveVehicles();
        assertEquals(19, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(9, roadMain.roads.get(0).vehicles.get(1).getXpos());
        roadMain.roads.get(0).getTrafficlight(0).setStatus(true);
        roadMain.moveVehicles();
        roadMain.moveVehicles();
        roadMain.moveVehicles();
        assertEquals(17, roadMain.roads.get(1).vehicles.get(0).getYpos());
        assertEquals(16, roadMain.roads.get(1).vehicles.get(0).getXpos());
      //  roadMain.roads.get(0).getTrafficlight(0).setStatus(true);
        roadMain.moveVehicles();
        assertEquals(7, roadMain.roads.get(1).vehicles.get(0).getzYpos());
        assertEquals(16, roadMain.roads.get(1).vehicles.get(1).getXpos());
        roadMain.moveVehicles();
        roadMain.moveVehicles();
        assertEquals(19, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(16, roadMain.roads.get(0).vehicles.get(1).getXpos());
        roadMain.roads.get(0).getTrafficlight(0).setStatus(true);



        assertEquals(2, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        roadMain.checkTurns();
        assertEquals(7, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        assertEquals(17, roadMain.roads.get(0).vehicles.get(0).getXpos());
        roadMain.checkTurns();
        assertEquals(12, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        roadMain.checkTurns();
        assertEquals(25, roadMain.roads.get(1).vehicles.get(1).getXpos());
        assertEquals(1, roadMain.roads.get(1).vehicles.get(1).getYpos());
        assertEquals(2, roadMain.roads.get(1).getNum_vehicles());
        assertEquals(17, roadMain.roads.get(1).vehicles.get(0).getYpos());
        assertEquals(1, roadMain.roads.get(1).vehicles.get(0).getRoad_ref());
        roadMain.moveVehicles();
        roadMain.checkTurns();
        assertEquals(1, roadMain.roads.get(1).getNum_vehicles());
        roadMain.moveVehicles();
        roadMain.checkTurns();
        assertEquals(25, roadMain.roads.get(2).vehicles.get(0).getYpos());
        assertEquals(23, roadMain.roads.get(2).vehicles.get(0).getXpos());

        roadMain.moveVehicles();
        roadMain.checkTurns();
        assertEquals(18, roadMain.roads.get(2).vehicles.get(0).getXpos());
        roadMain.moveVehicles();
        roadMain.checkTurns();
        roadMain.moveVehicles();
        roadMain.checkTurns();
        roadMain.moveVehicles();
        roadMain.checkTurns();
        roadMain.moveVehicles();
        roadMain.checkTurns();
        //assertEquals(18, roadMain.roads.get(2).vehicles.get(0).getXpos());

    }*/


    @Test
    void testEmpty(){
        RoadMain roadMain = new RoadMain();
        roadMain.addnewRoad(12, 10, "East", 0, 0);
        roadMain.addConectingRoad(12, "North");
        roadMain.addConectingRoad(12, "West");
        roadMain.addVehicle("Car", 10);
        roadMain.addLight(0, "End");
        roadMain.roads.get(0).getTrafficlight(0).setStatus(false);
        roadMain.moveVehicles();
        roadMain.moveVehicles();
        roadMain.moveVehicles();
        assertEquals(11, roadMain.roads.get(0).vehicles.get(0).getXpos());
        roadMain.addVehicle("Bus", 5);
        roadMain.roads.get(0).vehicles.get(0).setSpeed(1);
        roadMain.moveVehicles();
        assertEquals(8, roadMain.roads.get(0).vehicles.get(1).getXpos());
        assertEquals(11, roadMain.roads.get(0).vehicles.get(0).getXpos());
        roadMain.roads.get(0).getTrafficlight(0).setStatus(true);
        roadMain.moveVehicles();
        roadMain.roads.get(0).vehicles.get(0).setSpeed(5);
        roadMain.moveVehicles();
        assertEquals(4, roadMain.roads.get(1).vehicles.get(0).getYpos());
        assertEquals(false, roadMain.isEmpty(0, 6));

        assertEquals(12, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(4, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        assertEquals(12, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(5, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        assertEquals(12, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(6, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        assertEquals(12, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(7, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        assertEquals(12, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(8, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        assertEquals(12, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(9, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        assertEquals(17, roadMain.roads.get(1).vehicles.get(1).getXpos());
        assertEquals(10, roadMain.roads.get(1).vehicles.get(0).getYpos());
        roadMain.moveVehicles();
        roadMain.moveVehicles();
        roadMain.moveVehicles();


        assertEquals(19, roadMain.roads.get(2).vehicles.get(0).getXpos());
        assertEquals(7, roadMain.roads.get(1).vehicles.get(0).getYpos());


        /*assertEquals(9, roadMain.roads.get(0).vehicles.get(0).getXpos());
        assertEquals(9, roadMain.roads.get(0).vehicles.get(1).getXpos());
*/
    }
}