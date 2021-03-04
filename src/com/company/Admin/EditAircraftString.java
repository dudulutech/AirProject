package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAircraftString extends JPanel {
    AdminFrame adminFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;
    public EditAircraftString(AdminFrame adminFrame){
        this.adminFrame = adminFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("ENTER STRING:");
        enterl.setBounds(100,100,300,30);
        enterl.setForeground(Color.pink);
        add(enterl);
        enter = new JTextField();
        enter.setBounds(100,150,300,30);
        add(enter);
        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        back.setBackground(Color.pink);
        back.setForeground(Color.white);
        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125,400,100,30);
        edit.setBackground(Color.pink);
        edit.setForeground(Color.white);
        add(edit);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditAircraftParameter().setVisible(true);
                adminFrame.getEditAircraftString().setVisible(false);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminFrame.getEditAircraftParameter().parameter.getText().equals("name")){
                    String name = "";
                    Aircraft airCraft = null;
                    for(int i =0; i<adminFrame.sendList("aircrafts").size();i++){
                        if(adminFrame.sendList("aircrafts").get(i).id == Integer.parseInt(adminFrame.getEditAircraftParameter().id.getText())){
                            name = (enter.getText());
                            airCraft = adminFrame.sendList("aircrafts").get(i);
                        }
                    }
                    adminFrame.EditAircraftString("name",airCraft,name);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }
                if(adminFrame.getEditAircraftParameter().parameter.getText().equals("model")){
                    String model = "";
                    Aircraft airCraft = null;
                    for(int i =0; i<adminFrame.sendList("aircrafts").size();i++){
                        if(adminFrame.sendList("aircrafts").get(i).id == Integer.parseInt(adminFrame.getEditAircraftParameter().id.getText())){
                            model = (enter.getText());
                            airCraft = adminFrame.sendList("aircrafts").get(i);
                        }
                    }
                    adminFrame.EditAircraftString("model",airCraft,model);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }
            }
        });
    }
}
