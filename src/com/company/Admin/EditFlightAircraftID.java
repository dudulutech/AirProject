package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlightAircraftID extends JPanel {
    AdminFrame adminFrame;
    JButton edit;
    JButton back;
    JLabel enterl;
    JComboBox enter;
    String[] aircrafts_ids;
    public EditFlightAircraftID(AdminFrame adminFrame){
        this.adminFrame = adminFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("AIRCRAFT ID");
        enterl.setBounds(100, 100, 300, 30);
        enterl.setForeground(Color.white);
        add(enterl);
        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        back.setBackground(Color.pink);
        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        edit.setBackground(Color.pink);
        add(edit);
        aircrafts_ids = new String[adminFrame.sendList("aircrafts").size()];
        for(int i =0;i<adminFrame.sendList("aircrafts").size();i++){
            aircrafts_ids[i]= String.valueOf(adminFrame.sendList("aircrafts").get(i).id);
        }
        enter = new JComboBox(aircrafts_ids);
        enter.setBounds(100,150,300,30);
        add(enter);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditFlightAircraftID().setVisible(false);
                adminFrame.getEditFlightsParameter().setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminFrame.getEditFlightsParameter().parameter.getText().equals("aircraft_id")){
                    int aircraft_id = 0;
                    Flight flight = null;
                    for(int i =0; i<adminFrame.sendListF("flights").size();i++){
                        if(adminFrame.sendListF("flights").get(i).id == Integer.parseInt(adminFrame.getEditFlightsParameter().id.getText())){
                            aircraft_id = Integer.parseInt((String) enter.getSelectedItem());
                            flight = adminFrame.sendListF("flights").get(i);
                        }
                    }
                    adminFrame.FlightEditInt("aircraft_id",flight,aircraft_id);
                    enter.setSelectedIndex(0);
                    adminFrame.getEditFlightsParameter().parameter.setText("");
                    adminFrame.getEditFlightsParameter().id.setText("");
                }
            }
        });
    }
}
