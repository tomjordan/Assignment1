package Assignment;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RoadMain {
    int numRoads = 0;
    ArrayList<Road> roads = new ArrayList<Road>();
    private Random random = new Random();


/*

    public static void main(String[] args) {
        RoadMain roadMain = new RoadMain();
        roadMain.addnewRoad(30, 10, "North", 0, 0);
        roadMain.addConectingRoad(50, "West");
        roadMain.addConectingRoad(40, "North");
    }
*/

    public void change_roads(int road_ref) {

    }

    public void addnewRoad(int length, int width, String direction, int xinit, int yinit) {
        roads.add(new Road(length, width, direction, xinit, yinit));
        roads.get(numRoads).makeRoad();
        numRoads++;
    }

    public void addConectingRoad(int roadRef, int length, String direction) {

        String dir = roads.get(roadRef).getDirection();
        int north_end = roads.get(roadRef).getYnorth();
        int south_end = roads.get(roadRef).getYsouth();
        int east_end = roads.get(roadRef).getXeast();
        int west_end = roads.get(roadRef).getXwest();
        int width_new = roads.get(roadRef).getWidth();
        if (numRoads > 0) {
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
        roads.get(numRoads).makeRoad();
        roads.get(roadRef).setConnectedRoads(numRoads);

        numRoads++;
    }

    public Road getRoad(int road_ref) {
        return roads.get(road_ref);
    }


    public void addLight(int ref, String which_end) {
        roads.get(ref).addTrafficLight(which_end);
    }


    public void moveVehicles() {

        for (int i = roads.size() - 1; i >= 0; i--) {

            roads.get(i).moveVehicles();
            checkTurns();
        }
    }


    public void checkTurns() {
        Random r = new Random();
        for (int i = 0; i < roads.size(); i++) {
            if (roads.get(i).vehicles_off_road.size() > 0) {
                int ref;
                int speed = roads.get(i).vehicles_off_road.get(0).getSpeed();
                String type = roads.get(i).vehicles_off_road.get(0).getType();

                if (roads.get(i).connectedRoads.size() == 3) {
                    int j = r.nextInt(3);
                    if (isEmpty(roads.get(i).connectedRoads.get(j),
                            roads.get(i).vehicles_off_road.get(0).getLength())) {
                        ref = roads.get(i).connectedRoads.get(j);
                        addVehicle(type, speed, ref);
                        roads.get(i).vehicles.remove(0);
                        roads.get(i).reset_offRoad();

                    } else roads.get(i).vehicles.get(0).setPos(roads.get(i).getRoadEnd());

                } else if (roads.get(i).connectedRoads.size() == 2) {
                    int j = r.nextInt(2);
                    if (isEmpty(roads.get(i).connectedRoads.get(j),
                            roads.get(i).vehicles_off_road.get(0).getLength())) {
                        ref = roads.get(i).connectedRoads.get(j);
                        addVehicle(type, speed, ref);
                        //roads.get((roads.get(i).connectedRoads.get(j))).addVehicle(type, speed);
                        roads.get(i).vehicles.remove(0);
                        roads.get(i).reset_offRoad();
                    } else roads.get(i).vehicles.get(0).setPos(roads.get(i).getRoadEnd());

                } else if (roads.get(i).connectedRoads.size() == 1) {
                    if (isEmpty(roads.get(i).connectedRoads.get(0),
                            roads.get(i).vehicles_off_road.get(0).getLength())) {

                        ref = roads.get(i).connectedRoads.get(0);
                        addVehicle(type, speed, ref);
                        //roads.get((roads.get(i).connectedRoads.get(j))).addVehicle(type, speed);
                        roads.get(i).vehicles.remove(0);
                        roads.get(i).reset_offRoad();
                    } else roads.get(i).vehicles.get(0).setPos(roads.get(i).getRoadEnd());
                } else if (roads.get(i).connectedRoads.size() == 0) {
                    roads.get(i).vehicles.remove(0);
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


    public void addVehicle(String type, int speed, int roadRef) {
        if (type == "Car") {
            roads.get(roadRef).addCar(speed);
            roads.get(roadRef).vehicles.get(roads.get(roadRef).vehicles.size() - 1).setRoadRef(roadRef);
        } else if (type == "Bus") {
            roads.get(roadRef).addBus(speed);
            roads.get(roadRef).vehicles.get(roads.get(roadRef).vehicles.size() - 1).setRoadRef(roadRef);

        } else if (type == "Motorbike") {
            roads.get(roadRef).addMotorbike(speed);
            roads.get(roadRef).vehicles.get(roads.get(roadRef).vehicles.size()-1).setRoadRef(roadRef);

        }
    }

    public void printPos() {

        {
            for (int v = 0; v < roads.size(); v++) {
                for (int x = 0; x < roads.get(v).vehicles.size(); x++) {
                    System.out.println(roads.get(v).vehicles.get(x).getType());
                    System.out.println(roads.get(v).vehicles.get(x).getDirection());
                    System.out.println(roads.get(v).vehicles.get(x).getPos());
                    System.out.println(roads.get(v).vehicles.get(x).getRoadRef());
                }
            }
        }
    }
}


/*

 public void checkTurns() {
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
        }
*/



     /*   for (int n = 0; n < roads.get(i).vehicles_off_road.size(); n++) {

        int ref = roads.get(i).vehicles_off_road.get(n).getRoad_ref();
        int speed = roads.get(i).vehicles_off_road.get(n).getSpeed();
        int size = roads.get(i).vehicles_off_road.get(n).getLength();
        if (isEmpty(ref, size)) {
        roads.get(i).setVehicles_on_road(roads.get(i).getNum_vehicles() - 1);
        roads.get(i).vehicles.remove(i);
        roads.get(i).setVehicle_ref(roads.get(i).vehicles.size());
        roads.get(ref).addVehicle(type, speed);
        roads.get(ref).vehicles.get(roads.get(ref).vehicles.size() - 1).setRoad_ref(ref);
        roads.get(i).vehicles_off_road.remove(n);
        } else roads.get(i).vehicles.get(0).setPos(roads.get(i).getRoadEnd());
        roads.get(i).reset_offRoad();*/


    /*public void addIntersection(int roadRef, String intersectionType, int length) {
        String dir = roads.get(roadRef).getDirection();
        int north_end = roads.get(roadRef).getYnorth();
        int south_end = roads.get(roadRef).getYsouth();
        int east_end = roads.get(roadRef).getXeast();
        int west_end = roads.get(roadRef).getXwest();
        int width_new = roads.get(roadRef).getWidth();
        if (num_roads > 0) {
            if (dir == "North") {
                if (intersectionType == "+") {
                    roads.add(new Road(length, width_new,
                            "East", west_end, north_end));
                    roads.add(new Road(length, width_new,
                            "West", east_end, north_end));
                    roads.add(new Road(length, width_new,
                            "North", east_end, north_end));
                    roads.get(roadRef).setConnectedRoads(num_roads);
                    roads.get(roadRef).setConnectedRoads(num_roads + 1);
                    roads.get(roadRef).setConnectedRoads(num_roads + 2);
                    roads.get(num_roads).makeRoad();
                    roads.get(num_roads + 1).makeRoad();
                    roads.get(num_roads + 2).makeRoad();
                    num_roads += 3;

                } else if (intersectionType == "T") {
                    roads.add(new Road(length, width_new,
                            "East", west_end, north_end));
                    roads.add(new Road(length, width_new,
                            "West", east_end, north_end));
                    roads.get(roadRef).setConnectedRoads(num_roads);
                    roads.get(roadRef).setConnectedRoads(num_roads + 1);
                    roads.get(roadRef).setConnectedRoads(num_roads + 2);
                    roads.get(num_roads).makeRoad();
                    roads.get(num_roads + 1).makeRoad();
                    num_roads += 2;


                }
            }
            if (dir == "South") {
                if (intersectionType == "+") {
                    roads.add(new Road(length, width_new,
                            "East", west_end, south_end - width_new));
                    roads.add(new Road(length, width_new,
                            "West", west_end, south_end - width_new));
                    roads.add(new Road(length, width_new,
                            "South", east_end, south_end));
                    roads.get(roadRef).setConnectedRoads(num_roads);
                    roads.get(roadRef).setConnectedRoads(num_roads + 1);
                    roads.get(roadRef).setConnectedRoads(num_roads + 2);
                    roads.get(num_roads).makeRoad();
                    roads.get(num_roads + 1).makeRoad();
                    roads.get(num_roads + 2).makeRoad();
                    num_roads += 3;

                } else if (intersectionType == "T") {
                    roads.add(new Road(length, width_new,
                            "East", west_end, south_end - width_new));

                    roads.add(new Road(length, width_new,
                            "West", west_end, south_end - width_new));
                    roads.get(roadRef).setConnectedRoads(num_roads);
                    roads.get(roadRef).setConnectedRoads(num_roads + 1);
                    roads.get(roadRef).setConnectedRoads(num_roads + 2);
                    roads.get(num_roads).makeRoad();
                    roads.get(num_roads + 1).makeRoad();
                    num_roads += 2;
                }


                if (dir == "East") {

                    if (intersectionType == "+") {
                        roads.add(new Road(length, width_new,
                                "North", east_end, south_end));

                        roads.add(new Road(length, width_new,
                                "South", east_end, north_end));

                        roads.add(new Road(length, width_new,
                                "East", east_end, south_end));
                        roads.get(roadRef).setConnectedRoads(num_roads);
                        roads.get(roadRef).setConnectedRoads(num_roads + 1);
                        roads.get(roadRef).setConnectedRoads(num_roads + 2);
                        roads.get(num_roads).makeRoad();
                        roads.get(num_roads + 1).makeRoad();
                        roads.get(num_roads + 2).makeRoad();
                        num_roads += 3;
                    } else if (intersectionType == "T") {
                        roads.add(new Road(length, width_new,
                                "North", east_end, south_end));

                        roads.add(new Road(length, width_new,
                                "South", east_end, north_end));
                        roads.get(roadRef).setConnectedRoads(num_roads);
                        roads.get(roadRef).setConnectedRoads(num_roads + 1);
                        roads.get(roadRef).setConnectedRoads(num_roads + 2);
                        roads.get(num_roads).makeRoad();
                        roads.get(num_roads + 1).makeRoad();
                        num_roads += 2;
                    }
                }

                if (dir == "West") {

                    if (intersectionType == "+") {
                        roads.add(new Road(length, width_new,
                                "North", west_end - width_new, south_end));

                        roads.add(new Road(length, width_new,
                                "South", west_end - width_new, north_end));

                        roads.add(new Road(length, width_new,
                                "West", east_end, south_end));
                        roads.get(roadRef).setConnectedRoads(num_roads);
                        roads.get(roadRef).setConnectedRoads(num_roads + 1);
                        roads.get(roadRef).setConnectedRoads(num_roads + 2);
                        roads.get(num_roads).makeRoad();
                        roads.get(num_roads + 1).makeRoad();
                        roads.get(num_roads + 2).makeRoad();
                        num_roads += 3;
                    } else if (intersectionType == "T") {
                        roads.add(new Road(length, width_new,
                                "North", west_end - width_new, south_end));

                        roads.add(new Road(length, width_new,
                                "South", west_end - width_new, north_end));
                        roads.get(roadRef).setConnectedRoads(num_roads);
                        roads.get(roadRef).setConnectedRoads(num_roads + 1);
                        roads.get(roadRef).setConnectedRoads(num_roads + 2);
                        roads.get(num_roads).makeRoad();
                        roads.get(num_roads + 1).makeRoad();
                        num_roads += 2;
                    }
                }


            }
        }
    }*/


   /* public void addVehicle(String type, int speed) {
        roads.get(0).addVehicle(type, speed);
    }*/