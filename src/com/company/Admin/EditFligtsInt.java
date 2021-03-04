package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFligtsInt extends JPanel {
    AdminFrame adminFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;
    public EditFligtsInt(AdminFrame adminFrame) {
        this.adminFrame = adminFrame;
        setSize(520, 500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("ENTER INT");
        enterl.setBounds(100, 100, 300, 30);
        add(enterl);
        enter = new JTextField();
        enter.setBounds(100, 150, 300, 30);
        add(enter);
        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        back.setBackground(Color.pink);
        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        edit.setBackground(Color.pink);
        add(edit);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditFligtsInt().setVisible(false);
                adminFrame.getEditFlightsParameter().setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminFrame.getEditFlightsParameter().parameter.getText().equals("id")){
                    int id = 0;
                    Flight flight = null;
                    for(int i =0; i<adminFrame.sendListF("flights").size();i++){
                        if(adminFrame.sendListF("flights").get(i).id == Integer.parseInt(adminFrame.getEditFlightsParameter().id.getText())){
                            id = Integer.parseInt(enter.getText());
                            flight = adminFrame.sendListF("flights").get(i);
                        }
                    }
                    adminFrame.FlightEditInt("id",flight,id);
                    enter.setText("");
                    adminFrame.getEditFlightsParameter().parameter.setText("");
                    adminFrame.getEditFlightsParameter().id.setText("");
                }if(adminFrame.getEditFlightsParameter().parameter.getText().equals("econom_place_price")){
                    int eco=0;
                    Flight flight = null;
                    for(int i = 0; i<adminFrame.sendListF("flights").size();i++){
                        if(adminFrame.sendListF("flights").get(i).id == Integer.parseInt(adminFrame.getEditFlightsParameter().id.getText())){
                            eco = Integer.parseInt(enter.getText());
                            flight = adminFrame.sendListF("flights").get(i);
                        }
                    }
                    adminFrame.FlightEditInt("econom_place_price",flight,eco);
                    enter.setText("");
                    adminFrame.getEditFlightsParameter().parameter.setText("");
                    adminFrame.getEditFlightsParameter().id.setText("");
                }
                if(adminFrame.getEditFlightsParameter().parameter.getText().equals("business_place_price")){
                    int bus=0;
                    Flight flight = null;
                    for(int i = 0; i<adminFrame.sendListF("flights").size();i++){
                        if(adminFrame.sendListF("flights").get(i).id == Integer.parseInt(adminFrame.getEditFlightsParameter().id.getText())){
                            bus = Integer.parseInt(enter.getText());
                            flight = adminFrame.sendListF("flights").get(i);
                        }
                    }
                    adminFrame.FlightEditInt("business_place_price",flight,bus);
                    enter.setText("");
                    adminFrame.getEditFlightsParameter().parameter.setText("");
                    adminFrame.getEditFlightsParameter().id.setText("");
                }
            }
        });
    }
}
