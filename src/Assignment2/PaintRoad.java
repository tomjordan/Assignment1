package Assignment2;

import javax.swing.*;
import java.awt.*;

public class PaintRoad extends JPanel {
    String direction;
    int xinit;
    int yinit;
    int length;
    int width;


    public PaintRoad(int length, int width, String direction, int xinit, int yinit){
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.xinit = xinit;
        this.yinit = yinit;
        //repaint();
    }



    public void paint(Graphics g) {
        super.paint(g);
        switch (direction) {
            case "North":
                g.fillRect(xinit, yinit + length, width, length );
                break;
            case "South":
                g.fillRect(xinit, yinit, width, length );
                break;
            case "East":
                g.fillRect(xinit, yinit, length, width );
                break;
            case "West":
                g.fillRect(xinit - length, yinit, length, width );
                break;
        }
    }
}

