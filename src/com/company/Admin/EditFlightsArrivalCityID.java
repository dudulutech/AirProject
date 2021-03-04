package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlightsArrivalCityID extends JPanel {
    AdminFrame adminFrame;
    JButton edit;
    JButton back;
    JLabel enterl;
    JComboBox enter;
    String[] arrival_city_ids;
    public EditFlightsArrivalCityID(AdminFrame adminFrame) {
        this.adminFrame = adminFrame;
        setSize(520, 500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("ARRIVAL_CITY_ID");
        enterl.setBounds(100, 100, 300, 30);
        add(enterl);
        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        back.setBackground(Color.pink);
        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        edit.setBackground(Color.pink);
        add(edit);
        arrival_city_ids = new String[adminFrame.sendListC("cities").size()];
        for (int i = 0; i < adminFrame.sendListC("cities").size(); i++) {
            arrival_city_ids[i] = String.valueOf(adminFrame.sendListC("cities").get(i).id);
        }
        enter = new JComboBox(arrival_city_ids);
        enter.setBounds(100, 150, 300, 30);
        add(enter);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditFlightsArrivalCityID().setVisible(false);
                adminFrame.getEditFlightsParameter().setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (adminFrame.getEditFlightsParameter().parameter.getText().equals("arrival_city_id")) {
                    int arrival_city_id = 0;
                    Flight flight = null;
                    for (int i = 0; i < adminFrame.sendListF("flights").size(); i++) {
                        if (adminFrame.sendListF("flights").get(i).id == Integer.parseInt(adminFrame.getEditFlightsParameter().id.getText())) {
                            arrival_city_id = Integer.parseInt((String) enter.getSelectedItem());
                            flight = adminFrame.sendListF("flights").get(i);
                        }
                    }
                    adminFrame.FlightEditInt("arrival_city_id", flight, arrival_city_id);
                    enter.setSelectedIndex(0);
                    adminFrame.getEditFlightsParameter().parameter.setText("");
                    adminFrame.getEditFlightsParameter().id.setText("");
                }
            }
        });
    }
}
