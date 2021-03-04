package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAircraftInt extends JPanel {
    AdminFrame adminFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;
    public EditAircraftInt(AdminFrame adminFrame){
        this.adminFrame = adminFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("ENTER INT:");
        enterl.setBounds(100,100,300,30);
        enterl.setForeground(Color.pink);
        add(enterl);
        enter = new JTextField();
        enter.setBounds(100,150,300,30);
        add(enter);
        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        back.setBackground(Color.pink);

        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125,400,100,30);
        edit.setBackground(Color.pink);

        add(edit);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditAircraftInt().setVisible(false);
                adminFrame.getEditAircraftParameter().setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminFrame.getEditAircraftParameter().parameter.getText().equals("id")){
                    int id = 0;
                    Aircraft airCraft = null;
                    for(int i =0; i<adminFrame.sendList("aircrafts").size();i++){
                        if(adminFrame.sendList("aircrafts").get(i).id == Integer.parseInt(adminFrame.getEditAircraftParameter().id.getText())){
                            System.out.println("id found");
                            id = Integer.parseInt(enter.getText());
                            airCraft = adminFrame.sendList("aircrafts").get(i);
                        }
                    }
                    adminFrame.EditAircraftInt("id",airCraft,id);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }if(adminFrame.getEditAircraftParameter().parameter.getText().equals("business_class_capacity")){
                    int business_class_capacity=0;
                    Aircraft airCraft = null;
                    for(int i = 0; i<adminFrame.sendList("aircrafts").size();i++){
                        if(adminFrame.sendList("aircrafts").get(i).id == Integer.parseInt(adminFrame.getEditAircraftParameter().id.getText())){
                            business_class_capacity = Integer.parseInt(enter.getText());
                            airCraft = adminFrame.sendList("aircrafts").get(i);
                        }
                    }
                    adminFrame.EditAircraftInt("business_class_capacity",airCraft,business_class_capacity);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }if(adminFrame.getEditAircraftParameter().parameter.getText().equals("econom_class_capacity")){
                    int econom_class_capacity=0;
                    Aircraft airCraft = null;
                    for(int i = 0; i<adminFrame.sendList("aircrafts").size();i++){
                        if(adminFrame.sendList("aircrafts").get(i).id == Integer.parseInt(adminFrame.getEditAircraftParameter().id.getText())){
                            econom_class_capacity = Integer.parseInt(enter.getText());
                            airCraft = adminFrame.sendList("aircrafts").get(i);
                        }
                    }
                    adminFrame.EditAircraftInt("econom_class_capacity",airCraft,econom_class_capacity);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }
            }
        });
    }
}
