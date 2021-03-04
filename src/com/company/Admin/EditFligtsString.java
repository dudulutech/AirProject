package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFligtsString extends JPanel {
    AdminFrame adminFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;

    public EditFligtsString(AdminFrame adminFrame) {
        this.adminFrame = adminFrame;
        setSize(520, 500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("ENTER STRING");
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
                adminFrame.getEditFligtsString().setVisible(false);
                adminFrame.getEditFlightsParameter().setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (adminFrame.getEditFlightsParameter().parameter.getText().equals("departure_time")) {
                    String departure_time = "";
                    Flight flight = null;
                    for (int i = 0; i < adminFrame.sendListF("flights").size(); i++) {
                        if (adminFrame.sendListF("flights").get(i).id == Integer.parseInt(adminFrame.getEditFlightsParameter().id.getText())) {
                            departure_time = enter.getText();
                            flight = adminFrame.sendListF("flights").get(i);
                        }
                    }
                    adminFrame.FlightEditString("departure_time", flight, departure_time);
                    enter.setText("");
                    adminFrame.getEditFlightsParameter().parameter.setText("");
                    adminFrame.getEditFlightsParameter().id.setText("");
                }
            }
        });

    }
}
