import java.util.ArrayList;

public class Road {
    int length;
    int width;
    int xinit;
    int yinit;
    int xend;
    int yend;
    String direction;
    int vehicle_ref = 0;
    int vehicles_on_road;
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();


    public Road(int length, int width, String direction, int xinit, int yinit) {
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.xinit = xinit;
        this.yinit = yinit;
    }

    public void makeRoad() {
        if (this.getDirection() == "North") {
            yend = yinit + length;
            xend = xinit + width;
        } else if (this.getDirection() == "South") {
            yend = yinit - length;
            xend = xinit + width;
        } else if (this.getDirection() == "East") {
            xend = xinit + length;
            yend = yinit + width;
        } else if (this.getDirection() == "West") {
            xend = xinit - length;
            yend = yinit + width;
        }
    }

    public void addVehicle(String type, String direction, int speed, int x, int y) {
        vehicles.add(new Vehicle(type, direction, speed, x, y));
        vehicles.get(vehicle_ref).intiDir();
        vehicle_ref++;
        vehicles_on_road++;
    }


    public int getLength() {
        return length;
    }

    public String getDirection() {
        return direction;
    }

    public int getNum_vehicles() {
        return vehicles_on_road;
    }

    public void moveVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).xpos + vehicles.get(i).speed > xend) {
                vehicles_on_road -= 1;
                //vehicles.remove(i);
                vehicles.remove(i);
                i -=1;
            } else vehicles.get(i).moveVehicle();
        }
    }

    public int getxPosition(int ref_num) {
        return vehicles.get(ref_num).xpos;


    }

    public int getyPosition(int ref_num) {
        return vehicles.get(ref_num).ypos;

    /*public void checkonroad(){
        for (int i = 0; i < num_vehicles; i++) {
            vehicles.get(i).moveVehicle();
            if(vehicles.get(i).xpos + vehicles.get(i).speed > xend ){
            }*/

    }
}




