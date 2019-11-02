package Assignment.Gui;

import Assignment.Road;
import Assignment.RoadMain;
import Assignment.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JFrame implements ActionListener {
    /*This class is used as to create the gui, interactively add roads to the map and then simulate the traffic
    based off what is happening in the roadMain class*/
    private JComboBox<String> direction;
    private JComboBox<Integer> newRoadLength;
    private JComboBox<Integer> existingRoads;
    private int roadCount = 0;
    private JComboBox<String> addTrafficLight;
    Map map;
    RoadMain roadMain = new RoadMain();
    Timer timer;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to my traffic simulator!\nTo add roads to the map manually select a direction, length and a road to connect too\n" +
                "To auto generate the default map press make default\nTo reset the map press build mode\nEnjoy!");
        new Gui().setVisible(true);


    }

    public Gui() {
        super("Traffic Simulator");
        //setVisible(true);
        setSize(1400, 1000);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());


        ////////Create gui layout here////////


        ///Create Elements///
        JPanel controlPanel = new JPanel();
        JPanel newRoadInputs = new JPanel();
        JPanel modeSelection = new JPanel();
        JButton simulatorMode = new JButton("Simulator Mode");
        JButton buildMode = new JButton("Build Mode");
        JButton makeDefault = new JButton("Make Default");
        direction = new JComboBox<>(new String[]{"North", "South", "East", "West"});
        newRoadLength = new JComboBox<>(new Integer[]{200, 300, 400});
        existingRoads = new JComboBox<>(new Integer[roadCount]);
        addTrafficLight = new JComboBox<>(new String[]{"Add Traffic Light?", "Yes", "No"});
        JLabel lengthLabel = new JLabel("Select a road length:");
        JPanel lengthSelection = new JPanel();

        JButton addToMap = new JButton("Add Road");
        map = new Map();

        ///Give actions///

        simulatorMode.addActionListener(this);
        buildMode.addActionListener(this);
        addToMap.addActionListener(this);
        makeDefault.addActionListener(this);


        ///Layout///
        controlPanel.setLayout(new GridLayout(2, 1));
        modeSelection.setLayout(new GridLayout(3, 1));
        newRoadInputs.setLayout(new GridLayout(5, 1));
        lengthSelection.setLayout((new GridLayout(2, 1)));

        add(controlPanel, BorderLayout.EAST);


        add(map, BorderLayout.CENTER);
        modeSelection.add(simulatorMode);
        modeSelection.add(buildMode);
        modeSelection.add(makeDefault);

        newRoadInputs.add(direction);
        newRoadInputs.add(addTrafficLight);
        newRoadInputs.add(lengthSelection);
        lengthSelection.add(lengthLabel);
        lengthSelection.add(newRoadLength);
        newRoadInputs.add(existingRoads);
        newRoadInputs.add(addToMap);

        controlPanel.add(modeSelection);
        controlPanel.add(newRoadInputs);
        addInitialRoad();
    }

    String getDirection() {
        return direction.getItemAt(direction.getSelectedIndex());
    }

    String getTrafficLight() {
        return addTrafficLight.getItemAt(addTrafficLight.getSelectedIndex());
    }

    int getNewRoadLength() {
        //int length = Integer.parseInt(newRoadLength.getText());
        return newRoadLength.getItemAt(newRoadLength.getSelectedIndex());
        //return length;
    }

    private int getConnectedRoad() {
        int roadNum;
        if (roadCount == 0) {
            roadNum = 0;
        } else {
            roadNum = existingRoads.getItemAt(existingRoads.getSelectedIndex());
        }
        return roadNum;

    }


    void confirmReset() {
        int input = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to reset the map?", "Select an Option...", JOptionPane.YES_NO_OPTION);
        System.out.println(input);
        if (input == 0) {
            this.dispose();
            new Gui().setVisible(true);


        }


    }

    void addInitialRoad() {
        roadMain.addnewRoad(200, 60, "South", 500, 0);
        addCount();
        map.addRoad(roadMain.getRoad(0).getLength(), 60,
                "South", roadMain.getRoad(0).getXwest(), -roadMain.getRoad(0).getYnorth(), 0);
        // map.paintRoads();
        //addCount();
    }

    void addNewRoad(int ref, int length, String direction) {
        roadMain.addConectingRoad(ref, length, direction);
        addCount();
        map.addRoad(length, 60,
                direction, roadMain.getRoad(roadCount - 1).getXwest(), -roadMain.getRoad(roadCount - 1).getYnorth(), roadCount - 1);

    }

    public void addCount() {
        existingRoads.addItem(roadCount);
        roadCount++;
    }


    public void updateImages() {
        map.vehicleImages.clear();
        map.trafficLightImages.clear();
        for (Road road : roadMain.getRoads()) {
            if (road.lightAtEnd()) {
                boolean status = road.getEndLight().isGreen();
                map.addTrafficLight(road.getTrafficLightWest(), road.getTrafficLightNorth(), status);
            }
            for (Vehicle vehicle : road.getVehicles()) {
                map.addVehicle(vehicle.getType(), -vehicle.getYnorth(), vehicle.getXwest(), vehicle.getLength(), road.getDirection());

            }

        }
        map.repaint();
    }


    void animate() {

        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(1000 / 60, e -> {

            roadMain.runSim();
            updateImages();

        });
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = actionEvent.getActionCommand();

        if (name.equals("Simulator Mode")) {
            System.out.println("Simulator Mode pressed");
            animate();

        } else if (name.equals("Build Mode")) {
            confirmReset();

        } else if (name.equals("Make Default")) {

            addNewRoad(0, 250, "East"); //1
            addNewRoad(0, 250, "West");//2
            addNewRoad(0, 250, "South");//3
            addNewRoad(1, 250, "East");//4
            addNewRoad(2, 250, "South");//5
            addNewRoad(5, 250, "East");//6
            addNewRoad(5, 250, "West");//7
            roadMain.addTrafficLight(1, "End");
            roadMain.addTrafficLight(6, "End");

            System.out.println("Make Default");

        } else if (name.equals("Add Road")) {

            if (getTrafficLight().equals("Add Traffic Light?")) {
                JOptionPane.showMessageDialog(null, "Please select whether or not you want a traffic light.");

            } else if (getTrafficLight().equals("Yes")) {
                addNewRoad(getConnectedRoad(), getNewRoadLength(), getDirection());
                roadMain.addTrafficLight(roadCount, "End");
                System.out.println("New road added! Direction: " + getDirection() + "  Length: " + getNewRoadLength() + " On the end of road: " + getConnectedRoad() + "  With a traffic light at its end");


            } else {
                addNewRoad(getConnectedRoad(), getNewRoadLength(), getDirection());
                System.out.println("New road added! Direction: " + getDirection() + "  Length: " + getNewRoadLength() + " On the end of road: " + getConnectedRoad());

            }
        }


    }
}

