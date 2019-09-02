public class Road {
    int length;
    int width;
    int xinit;
    int yinit;
    int xend;
    int yend;
    String direction;


    public Road(int length, int width, String direction, int xinit, int yinit) {
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.xinit = xinit;
        this.yinit = yinit;
    }

    public void getEnds() {
        if (this.getDirection() == "North") {
            yend = yinit + length;
            xend = xinit + width;
        }
        else if (this.getDirection() == "South") {
            yend = yinit - length;
            xend = xinit + width;
        }
        else if (this.getDirection() == "East") {
            xend = xinit + length;
            yend = yinit + width;
        }
        else if (this.getDirection() == "West") {
            xend = xinit - length;
            yend = yinit + width;
            }
        }





    public int getLength() {
        return length;
    }

    public String getDirection() {
        return direction;
    }


}
