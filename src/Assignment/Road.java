package Assignment;

import java.util.ArrayList;

public class Road {
    private int length;
    private int width;
    private int xinit;
    private int yinit;
    private int xeast;
    private int xwest;
    private int ynorth;
    private int ysouth;
    private String direction;
    private int vehicle_ref = 0;
    private int vehicles_on_road;
    private int tot_TrafficLights = 0;
    private int light_ref = 0;
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Vehicle> vehicles_off_road = new ArrayList<Vehicle>();
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

    public void addVehicle(String type, int speed) {
        if (direction == "North") {
            vehicles.add(new Vehicle(type, "North", speed, xwest + width / 2, ysouth));
        } else if (direction == "South") {
            vehicles.add(new Vehicle(type, "South", speed, xwest + width / 2, ynorth));
        } else if (direction == "East") {
            vehicles.add(new Vehicle(type, "East", speed, xwest, ysouth + width / 2));
        } else if (direction == "West") {
            vehicles.add(new Vehicle(type, "West", speed, xeast, ysouth + width / 2));
        }
        vehicles.get(vehicle_ref).intiDir();
        vehicle_ref = vehicles.size();
        vehicles_on_road++;
    }

    public void addTrafficLight(String which_end) {
        if (which_end == "Start") {
            if (direction == "North") {
                trafficLights.add(new TrafficLight(xwest, ysouth, "NS"));
            } else if (direction == "South") {
                trafficLights.add(new TrafficLight(xeast, ynorth, "NS"));
            } else if (direction == "East") {
                trafficLights.add(new TrafficLight(xwest, ynorth, "EW"));
            } else if (direction == "West") {
                trafficLights.add(new TrafficLight(xeast, ysouth, "EW"));
            }
        } else if (which_end == "End") {
            if (direction == "North") {
                trafficLights.add(new TrafficLight(xwest, ynorth, "NS"));

            } else if (direction == "South") {
                trafficLights.add(new TrafficLight(xeast, ysouth, "NS"));

            } else if (direction == "East") {
                trafficLights.add(new TrafficLight(xeast, ynorth, "EW"));

            } else if (direction == "West") {
                trafficLights.add(new TrafficLight(xwest, ysouth, "EW"));
            }
        }
        tot_TrafficLights++;

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
            if (checkCollision(i)) {
                vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                vehicles.get(i).setPos(vehicles.get(i - 1).getYrear() - 1);
            } else if (checkTrafficLights(i)) {
                if (trafficLights.get(light_ref).isGreen()) {
                    vehicles.get(i).moveVehicle();
                } else vehicles.get(i).setPos(trafficLights.get(light_ref).getYpos()-1);

            } else if (vehicles.get(i).getYpos() + vehicles.get(i).getSpeed() > ynorth) {
                vehicles.get(i).setRoad_ref();
                vehicles_off_road.add(vehicles.get(i));
                vehicles_on_road -= 1;
                vehicles.remove(i);
                vehicle_ref = vehicles.size();
                i -= 1;
            } else vehicles.get(i).moveVehicle();

        } else if (vehicles.get(i).getDirection() == "South") {
            if (checkCollision(i)) {
                vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                vehicles.get(i).setPos(vehicles.get(i - 1).getYrear() + 1);
            } else if (checkTrafficLights(i)) {
                if (trafficLights.get(light_ref).isGreen()) {
                    vehicles.get(i).moveVehicle();
                } else vehicles.get(i).setPos(trafficLights.get(light_ref).getYpos()-1);

            } else if (vehicles.get(i).getYpos() - vehicles.get(i).getSpeed() < ysouth) {
                vehicles.get(i).setRoad_ref();
                vehicles_off_road.add(vehicles.get(i));
                vehicles_on_road -= 1;
                vehicles.remove(i);
                vehicle_ref = vehicles.size();
                i -= 1;
            } else vehicles.get(i).moveVehicle();

        } else if (vehicles.get(i).getDirection() == "East") {
            if (checkCollision(i)) {
                vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                vehicles.get(i).setPos(vehicles.get(i - 1).getXrear() - 1);
            } else if (checkTrafficLights(i)) {
                if (trafficLights.get(light_ref).isGreen()) {
                    vehicles.get(i).moveVehicle();
                } else vehicles.get(i).setPos(trafficLights.get(light_ref).getXpos()-1);

            } else if (vehicles.get(i).getXpos() + vehicles.get(i).getSpeed() > xeast) {
                vehicles.get(i).setRoad_ref();
                vehicles_off_road.add(vehicles.get(i));
                vehicles_on_road -= 1;
                vehicles.remove(i);
                vehicle_ref = vehicles.size();
                i -= 1;
            } else vehicles.get(i).moveVehicle();

        } else if (vehicles.get(i).getDirection() == "West") {
            if (checkCollision(i)) {
                vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                vehicles.get(i).setPos(vehicles.get(i - 1).getXrear() + 1);
            } else if (checkTrafficLights(i)) {
                if (trafficLights.get(light_ref).isGreen()) {
                    vehicles.get(i).moveVehicle();
                } else vehicles.get(i).setPos(trafficLights.get(light_ref).getXpos()-1);

            } else if (vehicles.get(i).getXpos() - vehicles.get(i).getSpeed() < xwest) {
                vehicles.get(i).setRoad_ref();
                vehicles_off_road.add(vehicles.get(i));
                vehicles_on_road -= 1;
                vehicles.remove(i);
                vehicle_ref = vehicles.size();
                i -= 1;
            } else vehicles.get(i).moveVehicle();

        }

    }
}


    public Vehicle getVehicleOnRoad(int ref_num) {
        return vehicles.get(ref_num);

    }

    public boolean checkOnRoad(int i) {

        boolean status = false;
        if (direction == "East" ) {
            if (vehicles.get(i).getXpos() + vehicles.get(i).getSpeed() > xeast) {
                status = true;
            }
        }else if (direction == "West" ) {
            if (vehicles.get(i).getXpos() - vehicles.get(i).getSpeed() < xwest) {
                status = true;
            }
        }else if (direction == "North" ) {
            if (vehicles.get(i).getYpos() + vehicles.get(i).getSpeed() > ynorth) {
                status = true;
            }
        }else if (direction == "South" ) {
            if (vehicles.get(i).getYpos() - vehicles.get(i).getSpeed() < ysouth) {
                status = true;
            }
        }
        return status;
    }

        public boolean checkTrafficLights ( int ref){
            int speed = vehicles.get(ref).getSpeed();
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

        public int getXeast () {
            return xeast;
        }

        public int getXwest () {
            return xwest;
        }

        public int getWidth () {
            return width;
        }

        public int getYnorth () {
            return ynorth;
        }

        public int getYsouth () {
            return ysouth;
        }

        public TrafficLight getTrafficlight ( int ref){

            return trafficLights.get(ref);

        }

        public boolean checkCollision ( int vRef){
            boolean status = false;
            if (vehicles.size() == 1) {
                status = false;
            } else if (vRef == 0) {
                status = false;
            } else {
                if (direction == "North") {
                    if (vehicles.get(vRef).getYpos() + vehicles.get(vRef).getSpeed() >=
                            vehicles.get(vRef - 1).getYrear()) {
                        status = true;
                    } else status = false;

                } else if (direction == "East") {
                    if (vehicles.get(vRef).getXpos() + vehicles.get(vRef).getSpeed() >=
                            vehicles.get(vRef - 1).getXrear()) {
                        status = true;
                    } else status = false;

                } else if (direction == "West") {
                    if (vehicles.get(vRef).getXpos() - vehicles.get(vRef).getSpeed() <=
                            vehicles.get(vRef - 1).getXrear()) {
                        status = true;
                    } else status = false;

                } else if (direction == "South") {
                    if (vehicles.get(vRef).getYpos() - vehicles.get(vRef).getSpeed() <=
                            vehicles.get(vRef - 1).getYrear()) {
                        status = true;
                    } else status = false;

                }

            }
            return status;
        }

    public ArrayList<Vehicle> getVehicles_off_road() {
        return vehicles_off_road;
    }
}





