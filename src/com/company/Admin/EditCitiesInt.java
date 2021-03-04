package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class EditCitiesInt extends JPanel {
    AdminFrame adminFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;

    public EditCitiesInt(AdminFrame adminFrame){
        this.adminFrame=adminFrame;
        setSize(520,500);
        setBackground(Color.gray);
        setLayout(null);

        enterl = new JLabel("ENTER INT");
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
                adminFrame.getEditCitiesInt().setVisible(false);
                adminFrame.getEditCitiesParameter().setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminFrame.getEditCitiesParameter().parameter.getText().equals("id")){
                    int id = 0;
                    City city = null;
                    for(int i =0; i<adminFrame.sendListC("cities").size();i++){
                        if(adminFrame.sendListC("cities").get(i).id == Integer.parseInt(adminFrame.getEditCitiesParameter().id.getText())){
                            System.out.println("id found");
                            id = Integer.parseInt(enter.getText());
                            city = adminFrame.sendListC("cities").get(i);
                        }
                    }
                    adminFrame.EditCitiesInt("id",city,id);
                    enter.setText("");
                    adminFrame.getEditAircraftParameter().parameter.setText("");
                    adminFrame.getEditAircraftParameter().id.setText("");
                }
            }
    });
}


}

