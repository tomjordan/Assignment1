package Assignment.Gui;

import java.awt.*;

public class VehicleImage {
    /*This class is used to draw vehicles on the map*/

    String type;
    int xinit;
    int yinit;
    int length;
    int width;


    public VehicleImage(int xinit, int yinit, int length, int width, String type) {
        this.type = type;
        this.xinit = xinit;
        this.yinit = yinit;
        this.length = length;
        this.width = width;
    }

    public void drawTraffic(Graphics g) {
        switch (type) {
            case "Car":
                g.setColor(Color.RED);
                g.fillRect(xinit, yinit, length, width);
                break;

            case "Bus":
                g.setColor(Color.YELLOW);
                g.fillRect(xinit, yinit, length, width);
                break;
            case "Motorbike":
                g.setColor(Color.BLUE);
                g.fillRect(xinit, yinit, length, width);
                break;
        }
    }
}








