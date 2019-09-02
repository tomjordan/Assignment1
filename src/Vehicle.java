public class Vehicle {
    int length;
    int breadth;
    int position;

    public Vehicle(){
        int length = 0;
        int breadth = 0;
        int position = 0;
    }

    void moveVehicle(){
        position = position+length;
    }
}
