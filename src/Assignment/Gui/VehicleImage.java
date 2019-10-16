package Assignment.Gui;

import java.awt.*;

public class VehicleImage {


    String type;
    String direction;
    int distanceTraveled;
    int roadNum;
    int xinit;
    int yinit;


    public VehicleImage(int distanceTraveled, String type, int xinit, int yinit, String direction) {
        this.type = type;
        this.distanceTraveled = distanceTraveled*10;
        this.xinit = xinit;
        this.yinit = yinit;
        this.direction = direction;
    }

    public void update(int xinit, int yinit, int distanceTraveled){
        this.xinit = xinit;
        this.yinit = yinit;
        this.distanceTraveled = distanceTraveled*10;
    }

/*
    public void drawTraffic(Graphics g){
        switch (direction) {
            case "North":
                if (type.equals("Car")) {
                    g.setColor(Color.RED);
                    g.fillRect(xinit+25, yinit-distanceTraveled, 30, 20);}
                else if (type.equals("Bus")){
                    g.setColor(Color.YELLOW);
                    g.fillRect(xinit+25, yinit-distanceTraveled, 30, 60);}
            else if (type.equals("Motorbike")){
                    g.setColor(Color.GREEN);
                    g.fillRect(xinit+25, yinit-distanceTraveled, 30, 10);}
                    break;
            case "South":
                if (type.equals("Car")) {
                    g.setColor(Color.RED);
                    g.fillRect(xinit+25, yinit+distanceTraveled, 30, 20);}
                else if (type.equals("Bus")){
                    g.setColor(Color.YELLOW);
                    g.fillRect(xinit+25, yinit+distanceTraveled, 30, 60);}
                else if (type.equals("Motorbike")){
                    g.setColor(Color.GREEN);
                    g.fillRect(xinit+25, yinit+distanceTraveled, 30, 10);}

                break;
            case "East":
                if (type.equals("Car")) {
                    g.setColor(Color.RED);
                    g.fillRect(xinit+distanceTraveled, yinit-25, 30, 20);}
                else if (type.equals("Bus")){
                    g.setColor(Color.YELLOW);
                    g.fillRect(xinit+distanceTraveled, yinit-25, 30, 60);}
                else if (type.equals("Motorbike")){
                    g.setColor(Color.GREEN);
                    g.fillRect(xinit+distanceTraveled, yinit-25, 30, 10);}

                break;
            case "West":
                if (type.equals("Car")) {
                    g.setColor(Color.RED);
                    g.fillRect(xinit-distanceTraveled, yinit-25, 30, 20);}
                else if (type.equals("Bus")){
                    g.setColor(Color.YELLOW);
                    g.fillRect(xinit-distanceTraveled, yinit-25, 30, 60);}
                else if (type.equals("Motorbike")){
                    g.setColor(Color.GREEN);
                    g.fillRect(xinit-distanceTraveled, yinit-25, 30, 10);}

                break;
        }
    }*/



    }


