package Assignment2;

import java.awt.*;

public class RoadShape {

    String direction;
    int xinit;
    int yinit;
    int length;
    int width;


    public RoadShape(int length, int width, String direction, int xinit, int yinit) {
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.xinit = xinit;
        this.yinit = yinit;

    }


    //@Override
    public void draw(Graphics g) {
      //  g.fillRect(xinit, yinit, length, width);
        //super.paint(g);
        switch (direction) {
            case "North":
                g.fillRect(xinit, yinit, width, length);
                break;
            case "South":
                g.fillRect(xinit, yinit, width, length);
                break;
            case "East":
                g.fillRect(xinit, yinit, length, width);
                break;
            case "West":
                g.fillRect(xinit, yinit, length, width);
                break;
        }
    }
}



