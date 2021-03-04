package com.company.Admin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

public class Aircrafts extends JPanel {
    AdminFrame adminFrame;
    JButton back;
    JButton add;
    public Aircrafts(AdminFrame adminFrame){
        this.adminFrame=adminFrame;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);


    JLabel idlabel = new JLabel("ID");
        idlabel.setBounds(100,50,100,40);
        add(idlabel);

    JTextField idtext = new JTextField();
        idtext.setBounds(200,50,200,40);
        add(idtext);

        JLabel namelabel = new JLabel("Name");
        namelabel.setBounds(100,100,100,40);
        add(namelabel);

        JTextField nametext = new JTextField();
        nametext.setBounds(200,100,200,40);
        add(nametext);

        JLabel modellabel = new JLabel("Model");
        modellabel.setBounds(100,150,100,40);

        add(modellabel);

        JTextField modeltext = new JTextField();
        modeltext.setBounds(200,150,200,40);
        add(modeltext);

        JLabel businesscapacity = new JLabel("Business class");
        businesscapacity.setBounds(100,200,100,40);

        add(businesscapacity);

        JTextField businesstext = new JTextField();
        businesstext.setBounds(200,200,200,40);
        add(businesstext);

        JLabel economcapacity = new JLabel("Economy class");
        economcapacity.setBounds(100,250,100,40);

        add(economcapacity);

        JTextField economtext = new JTextField();
        economtext.setBounds(200,250,200,40);
        add(economtext);

        add=new JButton("ADD");
        add.setBounds(150,300,200,40);
        add.setBackground(Color.pink);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aircraft aircraft = new Aircraft(Integer.parseInt(idtext.getText()),nametext.getText(),modeltext.getText(),Integer.parseInt(businesstext.getText()),Integer.parseInt(economtext.getText()));
                    adminFrame.sendAircraft(aircraft);
                    idtext.setText("");
                    nametext.setText("");
                    businesstext.setText("");
                    modeltext.setText("");
                    economtext.setText("");
                } catch (Exception s) {
                    s.printStackTrace();
                }
            }
        });

        back = new JButton("BACK");
        back.setBounds(150,400,200,40);
        back.setBackground(Color.pink);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getAddPanel().setVisible(true);
                adminFrame.getAircrafts().setVisible(false);
            }
        });
    }
        public void addaction(ObjectOutputStream ous){
            try {
                ous.close();
            }catch(Exception e){
                e.printStackTrace();
            }


}


}
