package Assignment;

public class Vehicle {
    private int carlength = 2;
    private int length;
    private int breadth;
    private String direction;
    private String type;
    private int xpos;
    private int ypos;
    private int xprev;
    private int yprev;
    private int xrear;
    private int yrear;
    private int speed;
    private int xinit;
    private int yinit;
    private int road_ref = 0;


    public Vehicle(String direction, int speed, int x, int y) {
        this.xinit = x;
        this.yinit = y;
        this.direction = direction;
        this.speed = speed;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCarlength() {
        return carlength;
    }

    public int getLength() {
        return length;
    }

    public void setCarlength(int carlength) {
        this.carlength = carlength;
    }

    public void intiDir() {
        if (getDirection() == "North") {
            ypos = yinit + this.getLength();
            yrear = yinit;
            xpos = xinit;
        } else if (getDirection() == "South") {
            ypos = yinit - this.getLength();
            yrear = yinit;
            xpos = xinit;
        } else if (getDirection() == "East") {
            xpos = xinit + this.getLength();
            xrear = xinit;
            ypos = yinit;
        } else if (getDirection() == "West") {
            xpos = xinit - this.getLength();
            xrear = xinit;
            ypos = yinit;
        }
    }

    public void moveVehicle() {

        if (direction == "North") {
            yprev = ypos;
            ypos = ypos + speed;
            yrear = yrear + speed;
        } else if (this.direction == "South") {
            yprev = ypos;
            ypos = ypos - speed;
            yrear = yrear - speed;
        } else if (this.direction == "East") {
            xprev = xpos;
            xpos = xpos + speed;
            xrear = xrear + speed;
        } else if (this.direction == "West") {
            xprev = xpos;
            xpos = xpos - speed;
            xrear = xrear - speed;
        }

    }

    public String getDirection() {
        return direction;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public int getXrear() {
        return xrear;
    }

    public int getYrear() {
        return yrear;
    }

    public void setSpeed(int newspeed) {
        this.speed = newspeed;
    }

    public void setPos(int newposition){
        if (getDirection() == "North") {
            ypos = newposition;
            yrear = newposition - this.getLength();
        } else if (getDirection() == "South") {
            ypos = newposition;
            yrear = newposition + this.getLength();
        } else if (getDirection() == "East") {
            xpos = newposition;
            xrear = newposition - this.getLength();
        } else if (getDirection() == "West") {
            xpos = newposition;
            xrear = newposition + this.getLength();
        }

    }
    public int getPos() {
        int position = 0;
        if (direction == "North" || direction == "South") {
            position = ypos;
        }else {
            position = xpos;
        }return position;
    }

    public int getRear(){
        int position = 0;
        if (direction == "North" || direction == "South") {
            position = yrear;
        }else {
            position = xrear;
        }return position;

    }


    int getSpeed() {
        return speed;
    }

    public int getRoad_ref(){
        return road_ref;

    }
    public void setRoad_ref(int num){
        this.road_ref = num;

    }



}








