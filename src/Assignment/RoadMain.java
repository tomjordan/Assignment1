package Assignment;

import java.util.ArrayList;


public class RoadMain {
    int num_roads = 0;
    ArrayList<Road> roads = new ArrayList<Road>();

    public static void main(String[] args) {
        RoadMain roadMain = new RoadMain();
        roadMain.addnewRoad(30, 10, "North", 0, 0);
        roadMain.addConectingRoad(50, "West");
        roadMain.addConectingRoad(40, "North");
    }

    public void change_roads(int road_ref) {

    }

    public void addnewRoad(int length, int width, String direction, int xinit, int yinit) {
        roads.add(new Road(length, width, direction, xinit, yinit));
        roads.get(num_roads).makeRoad();
        num_roads++;
    }

    public void addConectingRoad(int length, String direction) {

        String dir = roads.get(num_roads - 1).getDirection();
        int north_end = roads.get(num_roads - 1).getYnorth();
        int south_end = roads.get(num_roads - 1).getYsouth();
        int east_end = roads.get(num_roads - 1).getXeast();
        int west_end = roads.get(num_roads - 1).getXwest();
        int width_new = roads.get(num_roads - 1).getWidth();
        if (num_roads > 0) {
            if (dir == "North") {
                if (direction != "South") {

                    if (direction == "East") {
                        roads.add(new Road(length, width_new,
                                direction, west_end, north_end));

                        num_roads++;
                    } else if (direction == "West") {
                        roads.add(new Road(length, width_new,
                                direction, east_end, north_end));
                    } else if (direction == "North") {
                        roads.add(new Road(length, width_new,
                                direction, east_end, north_end));

                    }

                }
            }
            if (dir == "South") {
                if (direction != "North") {

                    if (direction == "East") {
                        roads.add(new Road(length, width_new,
                                direction, west_end, south_end - width_new));
                    } else if (direction == "West") {
                        roads.add(new Road(length, width_new,
                                direction, west_end, south_end - width_new));
                    } else if (direction == "South") {
                        roads.add(new Road(length, width_new,
                                direction, east_end, south_end));

                    }

                }
            }
            if (dir == "East") {
                if (direction != "West") {

                    if (direction == "North") {
                        roads.add(new Road(length, width_new,
                                direction, east_end, south_end));
                    } else if (direction == "South") {
                        roads.add(new Road(length, width_new,
                                direction, east_end, north_end));
                    } else if (direction == "East") {
                        roads.add(new Road(length, width_new,
                                direction, east_end, south_end));

                    }

                }
            }
            if (dir == "West") {
                if (direction != "East") {

                    if (direction == "North") {
                        roads.add(new Road(length, width_new,
                                direction, west_end - width_new, south_end));
                    } else if (direction == "South") {
                        roads.add(new Road(length, width_new,
                                direction, west_end - width_new, north_end));
                    } else if (direction == "West") {
                        roads.add(new Road(length, width_new,
                                direction, east_end, south_end));

                    }

                }
            }
        }
        roads.get(num_roads).makeRoad();
        num_roads++;
    }

    public Road getRoad(int road_ref){
        return roads.get(road_ref);
    }

    public void checkCorners(){

        for (int i = 0; i < roads.size(); i++){
            if (roads.get(i).vehicles_off_road.size()>0){
                Vehicle newVeh = roads.get(i).vehicles_off_road.get(0);
                 int ref = newVeh.getRoad_ref();
                 roads.get(ref).addVehicle(newVeh.getType(), newVeh.getSpeed());
                roads.get(i).vehicles_off_road.remove(0);
                }
            }
        }


    public void addVehicle(String type, int speed){
        roads.get(0).addVehicle(type, speed);
    }
public void moveVehicles(){

        for (int i = 0; i < roads.size(); i++){
            roads.get(i).moveVehicles();
    }
}
    /*public boolean checkOnRoad(int ref) {
        int y = vehicles.get(ref).getYpos();
        int x = vehicles.get(ref).getXpos();
        int speed = vehicles.get(ref).getSpeed();
        if (x + speed > xeast || x - speed < xwest) {
            return false;
        } else if (y + speed > ynorth || y - speed < ysouth) {
            return false;
        } else return true;


    }*/
}

