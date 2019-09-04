package Assignment;

import java.util.Random;

public class TrafficLight {

    private int xpos;
    private int ypos;
    private String orientation;
    private boolean status = true;
    String which_end;


    public TrafficLight(int x, int y, String orientation, String which_end) {

        this.xpos = x;
        this.ypos = y;
        this.orientation = orientation;
        this.which_end = which_end;
    }

    public boolean isGreen() {
        return status; //True = green  False = red
    /*public boolean isGreen(){
        Random status = new Random();
        return status.nextBoolean(); //True = green  False = red*/

    }

    public boolean isEnd() {
        boolean status = false;

        if (which_end == "End") {
            status = true;
        }return status;
    }


        public String getOrientation () {
            return orientation;
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

