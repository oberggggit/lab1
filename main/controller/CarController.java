package main.controller;

import main.model.CarModel;
import main.view.CarFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarController { //JFrame extension removed

    private CarModel cm;
    private CarFrame cf;


    // Constructor
    public CarController(CarModel cm, CarFrame cf){
        this.cm = cm;
        this.cf = cf;
        initButtons();
    }
    private void initButtons() {
        cf.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.gas(cf.gasAmount);
            }
        });

        cf.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { cm.brake(cf.gasAmount);
            }
        });

        cf.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.startAllCars();
            }
        });

        cf.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.stopAllCars();
            }
        });

        cf.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.turboOn();
            }
        });

        cf.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.turboOff();
            }
        });

        cf.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.liftBed();
            }
        });

        cf.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.lowerBed();
            }
        });

        cf.gasSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cf.gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
        cf.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.addCar();
            }
        });
        cf.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.removeCar();
            }
        });

    }

}