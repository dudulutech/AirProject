package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flightsdelete extends JPanel {
    AdminFrame main;
    JButton addButton;
    JButton back;
    public Flightsdelete(AdminFrame main){
        this.main = main;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);

        JLabel nameLabel=new JLabel("ID");
        nameLabel.setSize(100,40);
        nameLabel.setLocation(150,150);
        add(nameLabel);

        JTextField nameLong=new JTextField();
        nameLong.setBounds(200, 150,200,40);
        add(nameLong);

        addButton = new JButton("DELETE");
        addButton.setSize(300,40);
        addButton.setLocation(100,200);
        addButton.setBackground(Color.pink);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flight flight = new Flight(Integer.parseInt(nameLong.getText()),0,0,0,null,0,0);
                main.deleteFlight(flight);
                nameLong.setText("");
            }
        });


        back = new JButton("BACK");
        back.setSize(300,30);
        back.setLocation(100,250);
        back.setBackground(Color.pink);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getDeletePanel().setVisible(true);
                main.getFlightsdelete().setVisible(false);
            }
        });
    }
}
