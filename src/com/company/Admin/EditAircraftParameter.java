package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAircraftParameter extends JPanel {
    AdminFrame adminFrame;
    JLabel idl;
    JButton back;
    JTextField id;
    JButton next;
    JLabel parameterl;
    JTextField parameter;

    public EditAircraftParameter(AdminFrame adminFrame){
        this.adminFrame = adminFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(Color.gray);
        idl = new JLabel("ID");
        idl.setBounds(100,50,300,30);
        idl.setForeground(Color.pink);
        add(idl);
        id= new JTextField();
        id.setBounds(100,100,300,30);
        add(id);
        parameterl = new JLabel("PARAMETER");
        parameterl.setBounds(100,150,300,30);
        parameterl.setForeground(Color.pink);
        add(parameterl);
        parameter = new JTextField();
        parameter.setBounds(100,200,300,30);
        add(parameter);
        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        back.setBackground(Color.pink);
        add(back);
        next = new JButton("NEXT");
        next.setBounds(125,400,100,30);
        next.setBackground(Color.pink);
        add(next);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditPanel().setVisible(true);
                adminFrame.getEditAircraftParameter().setVisible(false);
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(parameter.getText().equals("name") || parameter.getText().equals("model")){
                    adminFrame.getEditAircraftParameter().setVisible(false);
                    adminFrame.getEditAircraftString().setVisible(true);
                    if(adminFrame.getEditAircraftParameter().parameter.equals("name")){
                        adminFrame.getEditAircraftString().enterl.setText("ENTER NAME");
                    }if(adminFrame.getEditAircraftParameter().parameter.equals("model")){
                        adminFrame.getEditAircraftString().enterl.setText("ENTER MODEL");
                    }
                }
                if(parameter.getText().equals("id") || parameter.getText().equals("business_class_capacity") || parameter.getText().equals("econom_class_capacity")){
                    adminFrame.getEditAircraftParameter().setVisible(false);
                    adminFrame.getEditAircraftInt().setVisible(true);
                    if(adminFrame.getEditAircraftParameter().parameter.equals("id")){
                        adminFrame.getEditAircraftInt().enterl.setText("ENTER ID");
                    }if(adminFrame.getEditAircraftParameter().parameter.equals("business_class_capacity")){
                        adminFrame.getEditAircraftInt().enterl.setText("ENTER BUSINESS CLASS CAPACITY");
                    }if(adminFrame.getEditAircraftParameter().parameter.equals("econom_class_capacity")){
                        adminFrame.getEditAircraftInt().enterl.setText("ENTER ECONOM CLASS CAPACITY");
                    }
                }
            }
        });
    }
}
