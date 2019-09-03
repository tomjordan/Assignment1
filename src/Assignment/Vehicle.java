package Assignment;

public class Vehicle {
    private int carlength = 2;
    private int length;
    private int breadth;
    private String direction;
    private String type;
    private int xpos;
    private int ypos;
    private int xrear;
    private int yrear;
    private int speed;
    private int reference = 0;
    private int xinit;
    private int yinit;


    public Vehicle(String type, String direction, int speed, int x, int y) {
        this.type = type;
        this.xinit = x;
        this.yinit = y;
        this.direction = direction;
        this.speed = speed;
    }

    public int getLength() {
        if (this.type == "Car") {
            length = carlength;
        } else if (this.type == "Bus") {
            length = carlength * 3;
        } else if (this.type == "Motorbike") {
            length = carlength / 2;
        }
        return length;
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
            ypos = ypos + speed;
            yrear = yrear + speed;
        } else if (this.direction == "South") {
            ypos = ypos - speed;
            yrear = yrear - speed;
        } else if (this.direction == "East") {
            xpos = xpos + speed;
            xrear = xrear + speed;
        } else if (this.direction == "West") {
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
            xpos = xinit - this.getLength();
            xpos = newposition;
            xrear = newposition + this.getLength();
        }

    }

    int getSpeed() {
        return speed;
    }

    String getType() {
        return type;
    }

    public void setXpos(int x) {
        this.xpos = x;
    }

    public void setYpos(int y) {
        this.ypos = y;
    }

}








