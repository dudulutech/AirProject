package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Citiesdelete extends JPanel {
    AdminFrame main;
    JButton addButton;
    JButton back;
    public Citiesdelete(AdminFrame main){
        this.main=main;
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
                City cities = new City(Integer.parseInt(nameLong.getText()),null,null,null);
                main.deleteCities(cities);
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
                main.getCitiesdelete().setVisible(false);
                main.getDeletePanel().setVisible(true);
            }
        });
    }
    public void deleteaction(Socket socket, ObjectOutputStream ous) {
        try {
            ous.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
