package Assignment;

import java.util.Random;
public class TrafficLight {

    int xpos;
    int ypos;
    String orientation;
    boolean status;


    public TrafficLight(int x, int y, String orientation, boolean status){
        this.xpos = x;
        this.ypos = y;
        this.orientation = orientation;
        this.status = status;
    }
    public boolean isGreen(){
        return status; //True = green  False = red
    /*public boolean isGreen(){
        Random status = new Random();
        return status.nextBoolean(); //True = green  False = red*/

    }
    public String getOrientation(){
        return orientation;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getXpos(){
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }
}
