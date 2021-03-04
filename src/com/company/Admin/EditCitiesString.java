package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class EditCitiesString extends JPanel {
    AdminFrame adminFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;

    public EditCitiesString(AdminFrame adminFrame) {
        this.adminFrame = adminFrame;
        setSize(520, 500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("ENTER STRING:");
        enterl.setBounds(100, 100, 300, 30);
        enterl.setForeground(Color.pink);
        add(enterl);
        enter = new JTextField();
        enter.setBounds(100, 150, 300, 30);
        add(enter);
        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        back.setBackground(Color.pink);
        back.setForeground(Color.white);
        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        edit.setBackground(Color.pink);
        edit.setForeground(Color.white);
        add(edit);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditCitiesParameter().setVisible(true);
                adminFrame.getEditCitiesString().setVisible(false);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminFrame.getEditCitiesParameter().parameter.getText().equals("name")){
                    String name  = "";
                    City city = null;
                    for(int i =0; i<adminFrame.sendListC("cities").size();i++){
                        if(adminFrame.sendListC("cities").get(i).id == Integer.parseInt(adminFrame.getEditCitiesParameter().id.getText())){
                            name = enter.getText();
                            city = adminFrame.sendListC("cities").get(i);
                        }
                    }
                    adminFrame.EditCitiesString("name",city,name);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }if(adminFrame.getEditCitiesParameter().parameter.getText().equals("country")){
                    String country  = "";
                    City city = null;
                    for(int i =0; i<adminFrame.sendListC("cities").size();i++){
                        if(adminFrame.sendListC("cities").get(i).id == Integer.parseInt(adminFrame.getEditCitiesParameter().id.getText())){
                            country = enter.getText();
                            city = adminFrame.sendListC("cities").get(i);
                        }
                    }
                    adminFrame.EditCitiesString("country",city,country);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }if(adminFrame.getEditCitiesParameter().parameter.getText().equals("short_name")){
                    String short_name  = "";
                    City city = null;
                    for(int i =0; i<adminFrame.sendListC("cities").size();i++){
                        if(adminFrame.sendListC("cities").get(i).id == Integer.parseInt(adminFrame.getEditCitiesParameter().id.getText())){
                            short_name = enter.getText();
                            city = adminFrame.sendListC("cities").get(i);
                        }
                    }
                    adminFrame.EditCitiesString("short_name",city,short_name);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }
            }

        });
    }


}
