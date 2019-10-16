package Assignment2;

import java.awt.*;

public class RoadShape {

    String direction;
    int xinit;
    int yinit;
    int length;
    int width;
    int count;


    public RoadShape(int length, int width, String direction, int xinit, int yinit, int roadnum) {
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.xinit = xinit;
        this.yinit = yinit;
        this.count = roadnum;
    }

    int getXinit(){
        return xinit;
    }

    int getYinit(){
        return yinit;
    }

    //@Override
    public void draw(Graphics g) {
      //  g.fillRect(xinit, yinit, length, width);
        //super.draw(g);
        switch (direction) {
            case "North":
                g.fillRect(xinit, yinit, width, length);
                g.setColor(Color.BLACK);
                g.drawString("Road: "+this.count, xinit, yinit+40);
                g.fillRect(xinit, yinit - width, width, width);
                break;
            case "South":
                g.fillRect(xinit, yinit, width, length);
                g.setColor(Color.BLACK);
                g.drawString("Road: "+this.count, xinit, yinit+40);
                g.fillRect(xinit, yinit + length, width, width);
                break;
            case "East":
                g.fillRect(xinit, yinit, length, width);
                g.setColor(Color.BLACK);
                g.drawString("Road: "+this.count, xinit, yinit+40);
                g.fillRect(xinit+length, yinit , width, width);
                break;
            case "West":
                g.fillRect(xinit, yinit, length, width);
                g.setColor(Color.BLACK);
                g.drawString("Road: "+this.count, xinit, yinit+40);
                g.fillRect(xinit-width, yinit , width, width);
                break;
        }
    }
}



