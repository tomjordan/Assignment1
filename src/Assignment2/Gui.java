package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    private JComboBox<String> direction;
    private JTextField newRoadLength;


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
        JButton simulatorMode = new JButton("Simulator Mode");
        JButton buildMode = new JButton("Build Mode");
        direction = new JComboBox<>(new String[]{"North", "South", "East", "West"});
        newRoadLength = new JTextField("Road Length");
        JButton addToMap = new JButton("Add Road");


        ///Give actions///
        controlPanel.setLayout(new GridLayout(5, 1));
        simulatorMode.addActionListener(this);
        buildMode.addActionListener(this);
        addToMap.addActionListener(this);


        ///Add to GUI///
        add(controlPanel, BorderLayout.EAST);
        controlPanel.add(simulatorMode);
        controlPanel.add(buildMode);
        controlPanel.add(direction);
        controlPanel.add(newRoadLength);
        controlPanel.add(addToMap);
    }

    private String getDirection() {
        return direction.getItemAt(direction.getSelectedIndex());
    }

    private int getNewRoadLength() {
        int length = Integer.parseInt(newRoadLength.getText());
        return length;
    }

    public boolean isLengthInt() {
        String input = newRoadLength.getText();
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = actionEvent.getActionCommand();

        if (name.equals("Simulator Mode")) {
            System.out.println("Simulator Mode pressed");
        } else if (name.equals("Build Mode")) {
            System.out.println("Build Mode pressed");
        } else if (name.equals("Add Road")) {
            if (!isLengthInt()) { System.out.println("Enter a valid integer length");

            } else { System.out.println(getDirection() + "    " + getNewRoadLength());

            }

        }
    }
}
