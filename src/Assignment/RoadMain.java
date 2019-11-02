package Assignment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Assignment.Gui.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RoadMain {
    /*Roadmain is used to change coordiantes of traffic */
    private int numRoads = 0;
    ArrayList<Road> roads = new ArrayList<Road>();
    private Random random = new Random();
    ArrayList<TrafficLight> trafficLights = new ArrayList<TrafficLight>();


    public static void main(String[] args) {


    }
     /*     Basic simulator with 5 roads and one traffic light at the end of road 0.
        New vehicles are added at random with random attributes. The traffic light changes status at random.
        More raods and traffic lights can be added by using addTrafficLight and
        addConnectingRoad methods*//*

        // Add roads and traffic lights here///////////////////////////////////////////
        RoadMain roadMain = new RoadMain();
        roadMain.addnewRoad(25, 10, "North", 0, 0);
        roadMain.addConectingRoad(0, 25, "East");
        roadMain.addConectingRoad(0, 25, "North");
        roadMain.addConectingRoad(0, 25, "West");
        roadMain.addConectingRoad(1, 25, "South");
        roadMain.addConectingRoad(1, 25, "North");

        ///////Traffic Lights
        roadMain.roads.get(0).addTrafficLight("End");
        roadMain.roads.get(1).addTrafficLight("End");

        roadMain.runSim();

        ////////////////////////////////////////////////////////////////////////////////////////

       for (; ; ) {
            TimeUnit.SECONDS.sleep(1);
            Random r = new Random();
            int j = r.nextInt(7);
            int speed = r.nextInt(6) + 3;
            if (j == 0) {
                if (roadMain.isEmpty(0, 2)) {
                    roadMain.addVehicle("Car", speed, 0);
                }
            } else if (j == 1) {
                if (roadMain.isEmpty(0, 1)) {
                    roadMain.addVehicle("Motorbike", speed, 0);
                }
            } else if (j == 2) {
                if (roadMain.isEmpty(0, 6)) {

                    roadMain.addVehicle("Bus", speed, 0);
                }
            }

            
            roadMain.printPos();
            roadMain.moveVehicles();



            for (Road road : roadMain.roads) {
                if (road.lightAtEnd()) {
                    int i = r.nextInt(5);
                    if (i == 0 || i == 2 || i == 3) {
                        road.setEndLight(true);
                    } else if (i == 1 || i == 4) {
                        road.setEndLight(false);
                    }
                } else if (road.lightAtStart()) {
                    int i = r.nextInt(5);
                    if (i == 0 || i == 2 || i == 3) {
                        road.setStartLight(true);
                    } else if (i == 1 || i == 4) {
                        road.setStartLight(false);
                    }


                }


            }
        }

    }
*/


    public void addnewRoad(int length, int width, String direction, int xinit, int yinit) {
        /*Adds a road which is no connected to any existing road */
        roads.add(new Road(length, width, direction, xinit, yinit));
        roads.get(numRoads).makeRoad();
        numRoads++;
    }

    public void addConectingRoad(int roadRef, int length, String direction) {
        /*Adds a new road onto the end of an existing road. To add an intersection, add multiple roads to the end of the same road  */
        //  if (length > 12 && length < 30) {
        String dir = roads.get(roadRef).getDirection();
        int north_end = roads.get(roadRef).getYnorth();
        int south_end = roads.get(roadRef).getYsouth();
        int east_end = roads.get(roadRef).getXeast();
        int west_end = roads.get(roadRef).getXwest();
        int width_new = roads.get(roadRef).getWidth();
        if (numRoads > 0) {
            if (dir.equals("North")) {
                if (!direction.equals("South")) {

                    switch (direction) {
                        case "East":
                            roads.add(new Road(length, width_new,
                                    direction, east_end, north_end));

                            break;
                        case "West":
                            roads.add(new Road(length, width_new,
                                    direction, west_end, north_end));
                            break;
                        case "North":
                            roads.add(new Road(length, width_new,
                                    direction, west_end, north_end + width_new));

                            break;
                    }

                }
            }
            if (dir.equals("South")) {
                if (!direction.equals("North")) {

                    switch (direction) {
                        case "East":
                            roads.add(new Road(length, width_new,
                                    direction, east_end, south_end - width_new));
                            break;
                        case "West":
                            roads.add(new Road(length, width_new,
                                    direction, west_end, south_end - width_new));
                            break;
                        case "South":
                            roads.add(new Road(length, width_new,
                                    direction, west_end, south_end - width_new));

                            break;
                    }

                }
            }
            if (dir.equals("East")) {
                if (!direction.equals("West")) {

                    switch (direction) {
                        case "North":
                            roads.add(new Road(length, width_new,
                                    direction, east_end, north_end));
                            break;
                        case "South":
                            roads.add(new Road(length, width_new,
                                    direction, east_end, south_end));
                            break;
                        case "East":
                            roads.add(new Road(length, width_new,
                                    direction, east_end + width_new, south_end));

                            break;
                    }

                }
            }
            if (dir.equals("West")) {
                if (!direction.equals("East")) {

                    switch (direction) {
                        case "North":
                            roads.add(new Road(length, width_new,
                                    direction, west_end - width_new, north_end));
                            break;
                        case "South":
                            roads.add(new Road(length, width_new,
                                    direction, west_end - width_new, south_end));
                            break;
                        case "West":
                            roads.add(new Road(length, width_new,
                                    direction, west_end - width_new, south_end));

                            break;
                    }

                }
            }
            roads.get(numRoads).makeRoad();
            roads.get(roadRef).setConnectedRoads(numRoads);

            numRoads++;
        }
    }

    public void addTrafficLight(int roadRef, String whichEnd) {
        /*Adds a traffic light to specified road */
        roads.get(roadRef - 1).addTrafficLight(whichEnd);
    }

    public Road getRoad(int road_ref) {
        return roads.get(road_ref);
    }


    void moveVehicles() {

        /*Moves vehicles on all roads  */
        for (int i = roads.size() - 1; i >= 0; i--) {
            roads.get(i).moveVehicles();
            checkTurns(i);


        }

    }


    private void checkTurns(int i) {
        /*Checks if a vehicle has moved off its current road. If it has and there are connected roads, the vehicle will turn (be added to next road
         * if there are multiple connected roads (intersection) the vehicles turn randomly to one of the new roads   */
        Random r = new Random();
        Road road = roads.get(i);
        if (road.vehiclesOffRoad.size() > 0) {
            for (int n = 0; n < road.vehiclesOffRoad.size(); n++) {
                int ref;
                int speed = road.vehiclesOffRoad.get(n).getSpeed();
                String type = road.vehiclesOffRoad.get(n).getType();

                if (road.connectedRoads.size() == 3) {
                    int j = r.nextInt(3);
                    if (isEmpty(road.connectedRoads.get(j),
                            road.vehiclesOffRoad.get(n).getLength())) {
                        ref = road.connectedRoads.get(j);
                        addVehicle(type, speed, ref);
                        road.vehicles.remove(n);

                    } else road.vehicles.get(n).setPos(road.getRoadEnd());

                } else if (road.connectedRoads.size() == 2) {
                    int j = r.nextInt(2);
                    if (isEmpty(road.connectedRoads.get(j),
                            road.vehiclesOffRoad.get(n).getLength())) {
                        ref = road.connectedRoads.get(j);
                        addVehicle(type, speed, ref);
                        road.vehicles.remove(n);
                    } else road.vehicles.get(0).setPos(road.getRoadEnd());

                } else if (road.connectedRoads.size() == 1) {
                    if (isEmpty(road.connectedRoads.get(0),
                            road.vehiclesOffRoad.get(n).getLength())) {

                        ref = road.connectedRoads.get(n);
                        addVehicle(type, speed, ref);
                        road.vehicles.remove(n);
                    } else road.vehicles.get(0).setPos(road.getRoadEnd());
                } else if (road.connectedRoads.size() == 0) {
                    road.vehicles.remove(n);
                    road.reset_offRoad();
                }


            }
        }
        road.reset_offRoad();

    }
    //}


    public boolean isEmpty(int i, int size) {
        /*Returns true if there is enough room at the beginning of a new road to add a new vehicle to it. Used when
         * turning vehicles  */
        boolean status = false;
        if (roads.get(i).vehicles.size() == 0) {
            status = true;
        } else if (i == roads.size() - 1) {
            status = true;
        } else if (roads.get(i).vehicles.size() > 0) {
            if (roads.get(i).vehicles.get(roads.get(i).vehicles.size() - 1).getDistanceTraveled()
                    > size + 15)
                status = true;
        }


        return status;
    }


    void addVehicle(String type, int speed, int roadRef) {
        /*Adds a new vehicle to the road specified. Used to allow vehicles to turn  */
        if (type.equals("Car")) {
            roads.get(roadRef).addCar(speed);
            roads.get(roadRef).vehicles.get(roads.get(roadRef).vehicles.size() - 1).setRoadRef(roadRef);


        } else if (type.equals("Bus")) {
            roads.get(roadRef).addBus(speed);
            roads.get(roadRef).vehicles.get(roads.get(roadRef).vehicles.size() - 1).setRoadRef(roadRef);

        } else if (type.equals("Motorbike")) {
            roads.get(roadRef).addMotorbike(speed);
            roads.get(roadRef).vehicles.get(roads.get(roadRef).vehicles.size() - 1).setRoadRef(roadRef);


        }
    }

    void printPos() {
        /*Prints the road number, vehicle types and vehicle positions on all roads  */

        System.out.println("\nMoving vehicles....\n");
        for (int v = 0; v < roads.size(); v++) {
            System.out.println("\n__________________ Vehicles on Road: " + v + "______________________________");
            if (roads.get(v).lightAtStart()) {
                if (roads.get(v).getStartLight().isGreen()) {
                    System.out.println("|Start light is green|\n");
                } else System.out.println("|Start light red|\n");

            } else if (roads.get(v).lightAtEnd()) {
                if (roads.get(v).getEndLight().isGreen()) {
                    System.out.println("|End light green|\n");
                } else System.out.println("|End light red|\n");
            }

            if (roads.get(v).vehicles.size() == 0) {
                System.out.println("No vehicles are currently on this road...");
            }
            for (int x = 0; x < roads.get(v).vehicles.size(); x++) {
                if (roads.get(v).vehicles.get(x).getType().equals("Motorbike")) {
                    System.out.println("Type:  " + roads.get(v).vehicles.get(x).getType() + "    |Direction:  " +
                            roads.get(v).vehicles.get(x).getDirection()
                            + "    |X Position:  " + roads.get(v).vehicles.get(x).getXpos() + "    |Y Position:  "
                            + roads.get(v).vehicles.get(x).getYpos() + "    |Speed: " + roads.get(v).vehicles.get(x).getSpeed());


                } else {

                    System.out.println("Type:  " + roads.get(v).vehicles.get(x).getType() + "          |Direction:  " +
                            roads.get(v).vehicles.get(x).getDirection()
                            + "    |X Position:  " + roads.get(v).vehicles.get(x).getXpos() + "    |Y Position:  "
                            + roads.get(v).vehicles.get(x).getYpos() + "    |Speed: " + roads.get(v).vehicles.get(x).getSpeed());
                }
            }

        }
    }

    public void runSim() {
        Random r = new Random();
        if (roads.get(0).vehicles.size() < 3) {

            int j = r.nextInt(100);
            int speed = r.nextInt(6) + 3;
            if (j == 0) {
                if (isEmpty(0, 20)) {
                    addVehicle("Car", speed, 0);

                }
            } else if (j == 1) {
                if (isEmpty(0, 10)) {
                    addVehicle("Motorbike", speed, 0);
                }
            } else if (j == 2) {
                if (isEmpty(0, 60)) {

                    addVehicle("Bus", speed, 0);
                }
            }
        }

        // printPos();
        moveVehicles();


        for (Road road : roads) {
            if (road.lightAtEnd()) {
                int i = r.nextInt(150);
                if (i > 147) {
                    road.setEndLight(true);
                } else if (i < 3) {
                    road.setEndLight(false);
                }
            } else if (road.lightAtStart()) {
                int i = r.nextInt(5);
                if (i == 0 || i == 2 || i == 3) {
                    road.setStartLight(true);
                } else if (i == 1 || i == 4) {
                    road.setStartLight(false);
                }


            }


        }
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

}
