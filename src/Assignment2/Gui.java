package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Assignment.*;


public class Gui extends JFrame implements ActionListener {

    private JComboBox<String> direction;
    private JTextField newRoadLength;
    private JComboBox<Integer> existingRoads;
    private int roadCount = 0;
    RoadMain roadMain = new RoadMain();
    //int[] roadList = new int[roadCount];

    public static void main(String[] args) {
        new Gui().setVisible(true);


    }

    private Gui() {
        super("Traffic Simulator");
        setSize(1400, 1000);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());


        ////////Create gui layout here////////


        ///Create Elements here///
        JPanel controlPanel = new JPanel();
        JPanel newRoadInputs = new JPanel();
        JPanel modeSelection = new JPanel();
        JButton simulatorMode = new JButton("Simulator Mode");
        JButton buildMode = new JButton("Build Mode");
        direction = new JComboBox<>(new String[]{"North", "South", "East", "West"});
        newRoadLength = new JTextField("Road Length");
        existingRoads = new JComboBox<>(new Integer[roadCount]);
        JButton addToMap = new JButton("Add Road");


        ///Give actions///
        controlPanel.setLayout(new GridLayout(2, 1));
        modeSelection.setLayout(new GridLayout(2, 1));
        newRoadInputs.setLayout(new GridLayout(4, 1));
        simulatorMode.addActionListener(this);
        buildMode.addActionListener(this);
        addToMap.addActionListener(this);


        ///Add to GUI///
        add(controlPanel, BorderLayout.EAST);
        modeSelection.add(simulatorMode);
        modeSelection.add(buildMode);

        newRoadInputs.add(direction);
        newRoadInputs.add(newRoadLength);
        newRoadInputs.add(existingRoads);
        newRoadInputs.add(addToMap);

        controlPanel.add(modeSelection);
        controlPanel.add(newRoadInputs);
    }

    private String getDirection() {
        return direction.getItemAt(direction.getSelectedIndex());
    }

    private int getNewRoadLength() {
        int length = Integer.parseInt(newRoadLength.getText());
        return length;
    }

    private boolean isLengthInt() {
        String input = newRoadLength.getText();
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
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


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = actionEvent.getActionCommand();

        if (name.equals("Simulator Mode")) {
            System.out.println("Simulator Mode pressed");
            try {
                roadMain.runSim();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (name.equals("Build Mode")) {
            // roadMain = new RoadMain();
            System.out.println("Build Mode pressed");


        } else if (name.equals("Add Road")) {
            if (!isLengthInt()) {
                System.out.println("Enter a valid integer length");

            } else {
                if (roadCount == 0) {
                    roadMain.addnewRoad(getNewRoadLength(), 10, getDirection(), 0, 0);
                    System.out.println("New road added! Direction: " + getDirection() + "  Length: " + getNewRoadLength());

                } else {
                    roadMain.addConectingRoad(getConnectedRoad(), getNewRoadLength(), getDirection());
                    System.out.println("New road added! Direction: " + getDirection() + "  Length: " + getNewRoadLength() + " On the end of road: " + getConnectedRoad());
                }
                existingRoads.addItem(roadCount);
                roadCount++;

            }
        }
    }
}
