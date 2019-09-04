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

    public Road getRoad(int road_ref) {
        return roads.get(road_ref);
    }

    /*public void checkCorners(){

        for (int i = 0; i < roads.size(); i++){
            if (roads.get(i).vehicles_off_road.size()>0){
                Vehicle newVeh = roads.get(i).vehicles_off_road.get(0);
                 int ref = newVeh.getRoad_ref();
                 roads.get(ref).addVehicle(newVeh.getType(), newVeh.getSpeed());
                roads.get(i).vehicles_off_road.remove(0);
                }
            }
        }*/

    public void addVehicle(String type, int speed) {
        roads.get(0).addVehicle(type, speed);
    }

    public void addLight(int ref, String which_end) {
        roads.get(ref).addTrafficLight(which_end);
    }


    public void moveVehicles() {

        for (int i = 0; i < roads.size(); i++) {

            roads.get(i).moveVehicles();
            checkTurns();
        }
    }


    public void checkTurns() {
        for (int i = 0; i < roads.size() - 1; i++) {
            if (roads.get(i).vehicles_off_road.size() > 0) {
                for (int n = 0; n < roads.get(i).vehicles_off_road.size(); n++) {
                    int ref = roads.get(i).vehicles_off_road.get(n).getRoad_ref();
                    int speed = roads.get(i).vehicles_off_road.get(n).getSpeed();
                    String type = roads.get(i).vehicles_off_road.get(n).getType();
                    int size = roads.get(i).vehicles_off_road.get(n).getLength();
                    if (isEmpty(ref, size)) {
                        roads.get(i).setVehicles_on_road(roads.get(i).getNum_vehicles() - 1);
                        roads.get(i).vehicles.remove(i);
                        roads.get(i).setVehicle_ref(roads.get(i).vehicles.size());
                        roads.get(ref).addVehicle(type, speed);
                        roads.get(ref).vehicles.get(roads.get(ref).vehicles.size() - 1).setRoad_ref(ref);
                        roads.get(i).vehicles_off_road.remove(n);
                    } else roads.get(i).vehicles.get(0).setPos(roads.get(i).getMax());
                    roads.get(i).reset_offRoad();

                }
            }
        }

    }

    public boolean isEmpty(int i, int size) {
        boolean status = false;
        if (roads.get(i).vehicles.size() == 0) {
            status = true;
        } else if (i == roads.size() - 1) {
            status = true;
        } else if (roads.get(i).vehicles.size() > 0) {
            if (roads.get(i).getDirection() == "North") {
                if (roads.get(i).getVehicleOnRoad(roads.get(i).vehicles.size() - 1).getYrear()
                        > roads.get(i).getYsouth() + size) {
                    status = true;
                }
            } else if (roads.get(i).getDirection() == "South") {
                if (roads.get(i).getVehicleOnRoad(roads.get(i).vehicles.size() - 1).getYrear()
                        > roads.get(i).getYnorth() - size) {
                    status = true;
                }
            } else if (roads.get(i).getDirection() == "East") {
                if (roads.get(i).getVehicleOnRoad(roads.get(i).vehicles.size() - 1).getYrear()
                        > roads.get(i).getXwest() + size) {
                    status = true;
                }
            } else if (roads.get(i).getDirection() == "North") {
                if (roads.get(i).getVehicleOnRoad(roads.get(i).vehicles.size() - 1).getYrear()
                        > roads.get(i).getXeast() - size) {
                    status = true;
                }
            }
        } else status = false;


        return status;
    }
}


   /* public void checkTurns() {
        for (int i = 0; i < roads.size(); i++) {
            if (i < roads.size() - 1) {
                if (roads.get(i).vehicles_off_road.size() > 0) {
                    int ref = roads.get(i).vehicles_off_road.get(0).getRoad_ref();
                    int speed = roads.get(i).vehicles_off_road.get(0).getSpeed();
                    String type = roads.get(i).vehicles_off_road.get(0).getType();
                    roads.get(ref).addVehicle(type, speed);
                    roads.get(ref).vehicles.get(roads.get(ref).vehicles.size() - 1).setRoad_ref(ref);
                    roads.get(i).reset_offRoad();
                }


            }
        }*/
