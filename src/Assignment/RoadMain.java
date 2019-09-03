package Assignment;

import java.util.ArrayList;


public class RoadMain {
    int num_roads = 0;
    ArrayList<Road> roads = new ArrayList<Road>();

    public void main(String args[]) {
        addnewRoad(20, 10, "North", 0, 0);
        addConectingRoad(20, "East");
        addConectingRoad(20, "North");

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

}
