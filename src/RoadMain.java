import java.util.ArrayList;

public class RoadMain {
    int no_cars = 0;
/*    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList<Vechicle> mortorbikes = new ArrayList<Vechicle>();
    ArrayList<Vechicle> busses = new ArrayList<Vechicle>();*/

    public static void main(String args[]) {


        TopRoad topRoad = new TopRoad();

        topRoad.drawRoad();
        topRoad.addVehicle();
        topRoad.drawRoad();
        topRoad.move_vehicles();
        topRoad.move_vehicles();
        topRoad.move_vehicles();
        topRoad.move_vehicles();
        topRoad.drawRoad();
        topRoad.addVehicle();
        topRoad.drawRoad();
        topRoad.addVehicle();
        topRoad.drawRoad();
        topRoad.move_vehicles();
        topRoad.drawRoad();
        topRoad.move_vehicles();


    }

    public void movement() {

    }

}
