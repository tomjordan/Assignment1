import java.util.ArrayList;

public class Road {
    int length;
    int width;
    int xinit;
    int yinit;
    int xeast;
    int xwest;
    int ynorth;
    int ysouth;
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
            ynorth = yinit + length;
            ysouth = yinit;
            xwest = xinit + width;
            xeast = xinit;
        } else if (this.getDirection() == "South") {
            ysouth = yinit - length;
            ynorth = yinit;
            xeast = xinit;
            xwest = xinit + width;
        } else if (this.getDirection() == "East") {
            xeast = xinit + length;
            xwest = xinit;
            ynorth = yinit + width;
            ysouth = yinit;
        } else if (this.getDirection() == "West") {
            xwest = xinit - length;
            xeast = xinit;
            ynorth = yinit + width;
            ysouth = yinit;
        }
    }

    public void addVehicle(String type, String direction, int speed, int x, int y) {
        vehicles.add(new Vehicle(type, direction, speed, x, y));
        vehicles.get(vehicle_ref).intiDir();
        vehicle_ref = vehicles.size();
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

            if (vehicles.get(i).getDirection() == "North"){
                if (vehicles.get(i).ypos + vehicles.get(i).speed > ynorth) {
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -=1;
                } else vehicles.get(i).moveVehicle();

            }
            else if (vehicles.get(i).getDirection() == "South"){
                if (vehicles.get(i).ypos - vehicles.get(i).speed < ysouth) {
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -=1;
                } else vehicles.get(i).moveVehicle();

            }
            else if (vehicles.get(i).getDirection() == "East"){
                if (vehicles.get(i).xpos + vehicles.get(i).speed > xeast){
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -=1;
                } else vehicles.get(i).moveVehicle();

            }
            else if (vehicles.get(i).getDirection() == "West"){
                if (vehicles.get(i).ypos - vehicles.get(i).speed < xwest) {
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -=1;
                } else vehicles.get(i).moveVehicle();

            }

        }
    }

    public int getxPosition(int ref_num) {
        return vehicles.get(ref_num).xpos;


    }

    public int getyPosition(int ref_num) {
        return vehicles.get(ref_num).ypos;

    }
}




