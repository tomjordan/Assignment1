public class Vehicle {
    int carlength = 2;
    int length;
    int breadth;
    String direction;
    String type;
    int xpos;
    int ypos;
    int speed;
    int reference = 0;
    int xinit;
    int yinit;


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
            length = carlength*3;
        } else if (this.type == "Motorbike") {
            length = carlength/2;
        }
       return length;
        }



    public void intiDir(){
        if (getDirection() == "North"){
            ypos = yinit + this.getLength();
            xpos = xinit;
        }
        else if(getDirection() == "South"){
            ypos = yinit - this.getLength();
            xpos = xinit;
        }
        else if(getDirection() == "East"){
            xpos = xinit + this.getLength();
            ypos = yinit;
        }
        else if(getDirection() == "West"){
            xpos = xinit - this.getLength();
            ypos = yinit;
        }
    }

    public void moveVehicle(){

        if (direction == "North"){
            ypos = ypos + speed;
        }
        else if(this.direction == "South"){
            ypos = ypos - speed;
        }
        else if(this.direction == "East"){
            xpos = xpos + speed;
        }
        else if(this.direction == "West"){
            xpos = xpos - speed;
        }

    }

    public String getDirection(){
        return direction;
    }
    public int getXpos(){
        return xpos;
    }
    public int getYpos(){
        return ypos;
    }
    int getSpeed(){
        return speed;
    }
    String getType(){
        return type;
    }
}








