package com.company.Admin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

public class Cities extends JPanel {
    AdminFrame adminFrame;
    JButton add;
    JButton back;
    public Cities(AdminFrame adminFrame){
        this.adminFrame=adminFrame;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);

        JLabel idlabel = new JLabel("ID");
        idlabel.setBounds(100,100,100,40);
        add(idlabel);

        JTextField idtext = new JTextField();
        idtext.setBounds(200,100,200,40);
        add(idtext);

        JLabel namelabel = new JLabel("Name");
        namelabel.setBounds(100,150,100,40);
        add(namelabel);

        JTextField nametext = new JTextField();
        nametext.setBounds(200,150,200,40);
        add(nametext);

        JLabel countrylabel = new JLabel("Country");
        countrylabel.setBounds(100,200,100,40);
        add(countrylabel);

        JTextField countrytext = new JTextField();
        countrytext.setBounds(200,200,200,40);
        add(countrytext);

        JLabel shortlabel = new JLabel("Short name");
        shortlabel.setBounds(100,250,100,40);
        add(shortlabel);

        JTextField shorttext = new JTextField();
        shorttext.setBounds(200,250,200,40);
        add(shorttext);

        add=new JButton("ADD");
        add.setBounds(150,300,200,40);
        add.setBackground(Color.pink);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    City cities = new City(Integer.parseInt(idtext.getText()),nametext.getText(),countrytext.getText(),shorttext.getText());
                    adminFrame.sendCities(cities);
                    idtext.setText("");
                    nametext.setText("");
                    countrytext.setText("");
                    shorttext.setText("");

                }catch (Exception e1){
                    e1.printStackTrace();
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
                adminFrame.getCities().setVisible(false);
            }
        });
    }

    public  void addaction(ObjectOutputStream oos){
        try{
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
