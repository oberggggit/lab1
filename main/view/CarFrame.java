package main.view;

import main.model.CarModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CarFrame extends JFrame {

    CarModel cm;
    CarPanel cv;

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    public JSpinner gasSpinner;
    public int gasAmount = 0; //ev controller
    JLabel gasLabel = new JLabel("Amount of gas");

    public JButton gasButton = new JButton("GaZz!");
    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = new JButton("Turbo on");
    public JButton turboOffButton = new JButton("Turbo off");
    public JButton liftBedButton = new JButton("Lift Bed");
    public JButton lowerBedButton = new JButton("Lower Bed");

    public JButton startButton = new JButton("Start all cars");
    public JButton stopButton = new JButton("Stop all cars");

    public CarFrame(CarModel cm, CarPanel cp) {
        this.cm = cm;
        this.cv = cp;
        initComponents("NutSim 1.3");
    }

    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(cm.getWidth(), cm.getHeight()));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(cv);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(100, //initial value
                        0, //min
                        100, //max
                        2);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCarButton, 7);

        controlPanel.setPreferredSize(new Dimension((cm.getWidth() / 2) + 4, 100));
        controlPanel.setBackground(Color.WHITE);
        this.add(controlPanel);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(cm.getWidth() / 5 - 15, 100));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(cm.getWidth() / 5 - 15, 100));
        this.add(stopButton);

        this.add(cv);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
