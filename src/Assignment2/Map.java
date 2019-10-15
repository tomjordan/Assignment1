package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map extends JPanel {

    ArrayList<RoadShape> roads = new ArrayList<>();

    public Map(int length, int width) {
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(length, width));
    }

    public void paintRoads() {
        repaint();
    }

    public void addRoad(int length, int width, String direction, int xinit, int yinit) {
        this.roads.add(new RoadShape(length, width, direction, xinit, yinit));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (RoadShape road : roads) {
            g.setColor(Color.WHITE);
            road.draw(g);
        }
    }
}


/*
package Assignment2;

        import javax.swing.*;
        import java.awt.*;
        import java.util.ArrayList;

public class PaintRoad extends JPanel {
    String direction;
    int xinit;
    int yinit;
    int length;
    int width;
    private ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();


    public PaintRoad(int length, int width, String direction, int xinit, int yinit){
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.xinit = xinit;
        this.yinit = yinit;

        setupListeners();





        //repaint();
    }
    void setupListeners(){
        switch (direction) {
            case "North":
                rectangleList.add(new Rectangle(xinit, yinit + length, width, length ));
                break;
            case "South":
                rectangleList.add(new Rectangle(xinit, yinit, width, length ));
                break;
            case "East":
                rectangleList.add(new Rectangle(xinit, yinit, length, width ));
                break;
            case "West":
                rectangleList.add(new Rectangle(xinit - length, yinit, length, width ));
                break;
        }

        public void paint(Graphics g) {
            super.paint(g);
            for (Rectangle rect : rectangleList){
                rectangleList.add(g.f)
                Graphics2D g = (Graphics2D) g;
            }
        }
    }
}

*/
