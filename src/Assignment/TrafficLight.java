package Assignment;

import java.util.Random;

public class TrafficLight {
    /*Traffic light is used to stop traffic at the beginning or end of roads  */
    private boolean status = true;
    String whichEnd;


    public TrafficLight(String where) {
        this.whichEnd = where;
    }

    public boolean isGreen() {
        /*Returns true if light is green, false if red  */
        return status; // True = green  False = red

    }

    void setStatus(boolean status) {
        /*Sets the status of the traffic light. True = green, False = red  */

        this.status = status;
    }

}

