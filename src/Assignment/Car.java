package Assignment;

public class Car extends Vehicle {

    public Car(String direction, int speed, int x, int y) {
        super(direction, speed, x, y);
        setLength(getCarlength());
    }
    public String getType(){
        return "Car";
    }
}
