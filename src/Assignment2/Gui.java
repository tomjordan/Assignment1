package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Gui().setVisible(true);



    }

    private Gui(){
        super ("Traffic Simulator");
        setSize(1400, 1000);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());


        ////////Create gui layout here////////


        ///Create Elements here///
        JPanel controlPanel = new JPanel();
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");


        ///Give actions///
        button1.addActionListener(this);
        button2.addActionListener(this);



        ///Add to GUI///
        add(controlPanel, BorderLayout.EAST);
        controlPanel.add(button1);
        controlPanel.add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = actionEvent.getActionCommand();

        if (name.equals("Button 1")){
            System.out.println("Button 1 pressed");
        }
        else if (name.equals("Button 2")){
            System.out.println("Button 2 pressed");
        }
    }
}
