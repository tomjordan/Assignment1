package Assignment;

import java.util.Random;

public class TrafficLight {

    private int xpos;
    private int ypos;
    private boolean status = true;
    String which_end;


    public TrafficLight(String where) {
        this.which_end = where;
    }

    public boolean isGreen() {
        return status; //True = green  False = red

    }

    public void setStatus ( boolean status){
        this.status = status;
    }

    public int getXpos () {
        return xpos;
    }

    public int getYpos () {
        return ypos;
    }

    public void setXpos ( int xpos){
        this.xpos = xpos;
    }

    public void setYpos ( int ypos){
        this.ypos = ypos;
    }
}

