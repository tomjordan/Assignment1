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
    int tot_TrafficLights = 0;
    int light_ref = 0;
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<TrafficLight> trafficLights = new ArrayList<TrafficLight>();


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
            xeast = xinit + width;
            xwest = xinit;
        } else if (this.getDirection() == "South") {
            ysouth = yinit - length;
            ynorth = yinit;
            xeast = xinit + width;
            xwest = xinit;
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
        if (checkOnRoad(x, y)) {
            vehicles.add(new Vehicle(type, direction, speed, x, y));
            vehicles.get(vehicle_ref).intiDir();
            vehicle_ref = vehicles.size();
            vehicles_on_road++;
        } else System.out.println("The vehicle you tried to add isnt on the road!");
    }

    public void addTrafficLight(int xpos, int ypos, String ori, boolean status) {
         if (checkOnRoad(xpos, ypos)) {
        trafficLights.add(new TrafficLight(xpos, ypos, ori, status));
        tot_TrafficLights++;
        } else System.out.println("The traffic light you tried to add isnt on the road!");

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

            if (vehicles.get(i).getDirection() == "North") {
                if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        vehicles.get(i).moveVehicle();
                    } else vehicles.get(i).setYpos(trafficLights.get(light_ref).ypos);

                } else if (vehicles.get(i).ypos + vehicles.get(i).speed > ynorth) {
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -= 1;
                } else vehicles.get(i).moveVehicle();

            } else if (vehicles.get(i).getDirection() == "South") {
                if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        vehicles.get(i).moveVehicle();
                    } else vehicles.get(i).setYpos(trafficLights.get(light_ref).ypos);

                } else if (vehicles.get(i).ypos - vehicles.get(i).speed < ysouth) {
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -= 1;
                } else vehicles.get(i).moveVehicle();

            } else if (vehicles.get(i).getDirection() == "East") {
                if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        vehicles.get(i).moveVehicle();
                    } else vehicles.get(i).setXpos(trafficLights.get(light_ref).xpos);

                } else if (vehicles.get(i).xpos + vehicles.get(i).speed > xeast) {
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -= 1;
                } else vehicles.get(i).moveVehicle();

            } else if (vehicles.get(i).getDirection() == "West") {
                if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        vehicles.get(i).moveVehicle();
                    } else vehicles.get(i).setXpos(trafficLights.get(light_ref).xpos);

                }
                if (vehicles.get(i).ypos - vehicles.get(i).speed < xwest) {
                    vehicles_on_road -= 1;
                    vehicles.remove(i);
                    vehicle_ref = vehicles.size();
                    i -= 1;
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

    public boolean checkOnRoad(int x, int y) {
        if (x > xeast || x < xwest) {
            return false;
        } else if (y > ynorth || y < ysouth) {
            return false;
        } else return true;

    }

    public boolean checkTrafficLights(int ref) {
        int speed = vehicles.get(ref).speed;
        int x = vehicles.get(ref).getXpos();
        int y = vehicles.get(ref).getYpos();
        String ori = vehicles.get(ref).getDirection();
        boolean status = false;
        for (int i = 0; i < trafficLights.size(); i++) {
            if (ori == "North") {
                if (trafficLights.get(i).getOrientation().equals("NS")) {
                    if (y + speed >= trafficLights.get(i).getYpos()) {
                        status = true;
                        light_ref = i;
                    }
                }
            } else if (ori == "South") {
                if (trafficLights.get(i).getOrientation().equals("NS")) {
                    if (y - speed <= trafficLights.get(i).getYpos()) {
                        status = true;
                        light_ref = i;
                    }
                }
            } else if (ori == "East") {
                if (trafficLights.get(i).getOrientation().equals("EW")) {
                    if (x + speed <= trafficLights.get(i).getXpos()) {
                        status = true;
                        light_ref = i;
                    }
                }
            } else if (ori == "West") {
                if (trafficLights.get(i).getOrientation().equals("EW")) {
                    if (x - speed <= trafficLights.get(i).getXpos()) {
                        status = true;
                        light_ref = i;
                    }
                }
            } else status = false;
        }
        return status;
    }
}



            
    





