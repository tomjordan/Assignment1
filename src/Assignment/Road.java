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
    private boolean trafficLightStart = false;
    private boolean trafficLightend = false;
    private TrafficLight startLight;
    private TrafficLight endLight;

    Vehicle turning_vehicle;
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Vehicle> vehicles_off_road = new ArrayList<Vehicle>();


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

    public void addCar(int speed) {
        if (direction == "North") {
            vehicles.add(new Car("North", speed, xwest + width / 2, ysouth));
        } else if (direction == "South") {
            vehicles.add(new Car("South", speed, xwest + width / 2, ynorth));
        } else if (direction == "East") {
            vehicles.add(new Car("East", speed, xwest, ysouth + width / 2));
        } else if (direction == "West") {
            vehicles.add(new Car("West", speed, xeast, ysouth + width / 2));
        }
        vehicles.get(vehicle_ref).intiDir();
        vehicle_ref = vehicles.size();
        vehicles_on_road++;
    }

    public void addMotorbike(int speed) {
        if (direction == "North") {
            vehicles.add(new Motorbike("North", speed, xwest + width / 2, ysouth));
        } else if (direction == "South") {
            vehicles.add(new Motorbike("South", speed, xwest + width / 2, ynorth));
        } else if (direction == "East") {
            vehicles.add(new Motorbike("East", speed, xwest, ysouth + width / 2));
        } else if (direction == "West") {
            vehicles.add(new Motorbike("West", speed, xeast, ysouth + width / 2));
        }
        vehicles.get(vehicle_ref).intiDir();
        vehicle_ref = vehicles.size();
        vehicles_on_road++;
    }

    public void addBus(int speed) {
        if (direction == "North") {
            vehicles.add(new Bus("North", speed, xwest + width / 2, ysouth));
        } else if (direction == "South") {
            vehicles.add(new Bus("South", speed, xwest + width / 2, ynorth));
        } else if (direction == "East") {
            vehicles.add(new Bus("East", speed, xwest, ysouth + width / 2));
        } else if (direction == "West") {
            vehicles.add(new Bus("West", speed, xeast, ysouth + width / 2));
        }
        vehicles.get(vehicle_ref).intiDir();
        vehicle_ref = vehicles.size();
        vehicles_on_road++;
    }

    public void addTrafficLight(String which_end) {
        if (which_end == "Start") {
            this.trafficLightStart = true;
            tot_TrafficLights++;
        } else if (which_end == "End") {
            this.trafficLightend = true;
            tot_TrafficLights++;
        }
    }

    public void moveVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            if (checkCollision(i)) {
                vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                vehicles.get(i).setPos(vehicles.get(i - 1).getYrear() - 1);
            } else if (checkMovement(i)) {
                if (trafficLightend) {
                    if (endLight.isGreen()) {
                        isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);
                    }
                } else vehicles.get(i).setPos(getRoadEnd());
            } else vehicles.get(i).moveVehicle();

        }
    }




    public boolean checkMovement(int i) {
        boolean status = false;

        if (vehicles.get(i).getDirection() == "North") {
            if (vehicles.get(i).getYpos() + vehicles.get(i).getSpeed() > ynorth)
                status = true;
        } else if (vehicles.get(i).getDirection() == "South") {
            if (vehicles.get(i).getYpos() - vehicles.get(i).getSpeed() < ysouth) {
                status = true;
            }

        } else if (vehicles.get(i).getDirection() == "West") {
            if (vehicles.get(i).getXpos() - vehicles.get(i).getSpeed() < xwest) {
                status = true;
            }

        } else if (vehicles.get(i).getDirection() == "East") {
            if (vehicles.get(i).getXpos() + vehicles.get(i).getSpeed() > xeast) {
                status = true;
            }

        }
        return status;
    }


    public int getRoadEnd() {
        int max = 0;
        if (direction == "North") {
            max = ynorth;
        }
        if (direction == "South") {
            max = ysouth;
        }
        if (direction == "East") {
            max = xeast;
        }
        if (direction == "West") {
            max = xwest;
        }
        return max;


    }

    public Vehicle getVehicleOnRoad(int ref_num) {
        return vehicles.get(ref_num);

    }


    public void isOffRoad(int i, int rd_ref) {
        vehicles_off_road.add(vehicles.get(i));
        vehicles_off_road.get(i).setRoad_ref(rd_ref);
    }



    public boolean checkCollision(int vRef) {
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

    public void setVehicles_off_road() {
        this.vehicles_off_road = new ArrayList<Vehicle>();
    }

    public void reset_offRoad() {
        vehicles_off_road.clear();
    }

    public TrafficLight getEndLight() {
        return endLight;
    }

    public TrafficLight getStartLight() {
        return startLight;
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

    public void setVehicles_on_road(int vehicles_on_road) {
        this.vehicles_on_road = vehicles_on_road;
    }

    public void setVehicle_ref(int vehicle_ref) {
        this.vehicle_ref = vehicle_ref;
    }


    public int getXeast() {
        return xeast;
    }

    public int getXwest() {
        return xwest;
    }

    public int getWidth() {
        return width;
    }

    public int getYnorth() {
        return ynorth;
    }

    public int getYsouth() {
        return ysouth;
    }

}


/*

    public void addTrafficLight(String which_end) {
        if (which_end == "Start") {
            if (direction == "North") {
                trafficLights.add(new TrafficLight(xwest, ysouth, "NS", "Start"));
            } else if (direction == "South") {
                trafficLights.add(new TrafficLight(xeast, ynorth, "NS", "Start"));
            } else if (direction == "East") {
                trafficLights.add(new TrafficLight(xwest, ynorth, "EW", "Start"));
            } else if (direction == "West") {
                trafficLights.add(new TrafficLight(xeast, ysouth, "EW", "Start"));
            }
        } else if (which_end == "End") {
            if (direction == "North") {
                trafficLights.add(new TrafficLight(xwest, ynorth, "NS", "End"));

            } else if (direction == "South") {
                trafficLights.add(new TrafficLight(xeast, ysouth, "NS", "End"));

            } else if (direction == "East") {
                trafficLights.add(new TrafficLight(xeast, ynorth, "EW", "End"));

            } else if (direction == "West") {
                trafficLights.add(new TrafficLight(xwest, ysouth, "EW", "End"));
            }
        }
        tot_TrafficLights++;

    }*/




 /*   public void moveVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {

            if (vehicles.get(i).getDirection() == "North") {
                if (checkCollision(i)) {
                    vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                    vehicles.get(i).setPos(vehicles.get(i - 1).getYrear() - 1);
                } else if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        if (trafficLights.get(light_ref).isEnd()) {
                            isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);
                        }
                    } else vehicles.get(i).setPos(trafficLights.get(light_ref).getYpos() - 1);

                } else if (vehicles.get(i).getYpos() + vehicles.get(i).getSpeed() > ynorth) {
                    isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);

                } else vehicles.get(i).moveVehicle();

            } else if (vehicles.get(i).getDirection() == "South") {
                if (checkCollision(i)) {
                    vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                    vehicles.get(i).setPos(vehicles.get(i - 1).getYrear() + 1);
                } else if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        if (trafficLights.get(light_ref).isEnd()) {
                            isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);
                        }
                    } else vehicles.get(i).setPos(trafficLights.get(light_ref).getYpos() - 1);

                } else if (vehicles.get(i).getYpos() - vehicles.get(i).getSpeed() < ysouth) {
                    isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);

                } else vehicles.get(i).moveVehicle();

            } else if (vehicles.get(i).getDirection() == "East") {
                if (checkCollision(i)) {
                    vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                    vehicles.get(i).setPos(vehicles.get(i - 1).getXrear() - 1);
                } else if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        if (trafficLights.get(light_ref).isEnd()) {
                            isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);
                        }
                    } else vehicles.get(i).setPos(trafficLights.get(light_ref).getXpos() - 1);

                } else if (vehicles.get(i).getXpos() + vehicles.get(i).getSpeed() > xeast) {
                    isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);
                } else vehicles.get(i).moveVehicle();

            } else if (vehicles.get(i).getDirection() == "West") {
                if (checkCollision(i)) {
                    vehicles.get(i).setSpeed(vehicles.get(i - 1).getSpeed());
                    vehicles.get(i).setPos(vehicles.get(i - 1).getXrear() + 1);
                } else if (checkTrafficLights(i)) {
                    if (trafficLights.get(light_ref).isGreen()) {
                        if (trafficLights.get(light_ref).isEnd()) {
                            isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);
                        } else vehicles.get(i).moveVehicle();
                    } else vehicles.get(i).setPos(trafficLights.get(light_ref).getXpos() - 1);

                } else if (vehicles.get(i).getXpos() - vehicles.get(i).getSpeed() < xwest) {
                    isOffRoad(i, vehicles.get(i).getRoad_ref() + 1);
                } else vehicles.get(i).moveVehicle();

            }

        }
    }*/