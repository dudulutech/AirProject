package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePanel extends JPanel {
    AdminFrame main;
    JButton aircrafts;
    JButton cities;
    JButton flights;
    JButton back;
    public DeletePanel(AdminFrame main){
        this.main=main;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);

        aircrafts=new JButton("AIRCRAFTS");
        aircrafts.setBounds(30,100,120,70);
        aircrafts.setBackground(Color.pink);
        add(aircrafts);
        aircrafts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getMainMenu().setVisible(false);
                main.getDeletePanel().setVisible(false);
                main.getAircraftsdelete().setVisible(true);
            }
        });



        cities=new JButton("CITIES");
        cities.setBounds(180,100,120,70);
        cities.setBackground(Color.pink);
        add(cities);
        cities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getMainMenu().setVisible(false);
                main.getDeletePanel().setVisible(false);
                main.getCitiesdelete().setVisible(true);
            }
        });

        flights=new JButton("FLIGHTS");
        flights.setBounds(330,100,120,70);
        flights.setBackground(Color.pink);
        add(flights);
        flights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getMainMenu().setVisible(false);
                main.getDeletePanel().setVisible(false);
                main.getFlightsdelete().setVisible(true);
            }
        });

        back=new JButton("BACK");
        back.setBounds(180,300,120,50);
        back.setBackground(Color.pink);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getMainMenu().setVisible(true);
                main.getDeletePanel().setVisible(false);
            }
        });

    }
}
