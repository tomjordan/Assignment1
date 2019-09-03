package Assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadMainTest {

    @Test
    void testnewRoads(){
        RoadMain roadMain = new RoadMain();

        roadMain.addnewRoad(20, 10, "North", 0, 0);
        roadMain.addConectingRoad(20, "West");
        roadMain.addConectingRoad(20, "South");
        Road a = roadMain.getRoad(0);
        Road b = roadMain.getRoad(1);
        Road c = roadMain.getRoad(2);
        System.out.println(a.getYnorth() + "   " + a.getYsouth() +"   " +
                a.getXeast() +"   " + a.getXwest());
        System.out.println(b.getYnorth() + "   " + b.getYsouth() +"   " +
                b.getXeast() +"   " + b.getXwest());
        System.out.println(c.getYnorth() + "   " + c.getYsouth() +"   " +
                c.getXeast() +"   " + c.getXwest());

    }

}