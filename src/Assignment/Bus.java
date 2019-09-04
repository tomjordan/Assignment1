package Assignment;

public class Bus extends Vehicle {

    public Bus(String direction, int speed, int x, int y) {
        super(direction, speed, x, y);
        setLength(getCarlength()*3);
    }
    public String getType(){
        return "Bus";
    }
}