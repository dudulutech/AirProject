package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Flights extends JPanel {
    AdminFrame adminFrame;
    JButton add;
    JButton back;
    JComboBox aircraft_idcb	;
    JComboBox departure_city_idcb	;
    JComboBox arrival_city_idcb	;
    public Flights(AdminFrame adminFrame){
        this.adminFrame=adminFrame;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);
        String []id1 = new String[adminFrame.sendList("aircrafts").size()];
        for (int i=0;i<adminFrame.sendList("aircrafts").size();i++){
                id1[i]=String.valueOf((adminFrame.sendList("aircrafts").get(i).id));
        }
        String[]id2=new String[adminFrame.sendListC("cities").size()];
        for (int i=0;i<adminFrame.sendListC("cities").size();i++){
            id2[i]=String.valueOf((adminFrame.sendListC("cities").get(i).id));
        }

        JLabel idlabel = new JLabel("ID");
        idlabel.setBounds(50,20,150,40);
        add(idlabel);

        JTextField idtext = new JTextField();
        idtext.setBounds(200,20,200,40);
        add(idtext);

        JLabel aircraftidlabel = new JLabel("Aircraft ID");
        aircraftidlabel.setBounds(50,70,150,40);
        add(aircraftidlabel);
        aircraft_idcb = new JComboBox(id1);
        aircraft_idcb.setBounds(200,70,200,40);
        add(aircraft_idcb);

        JLabel departureidlabel = new JLabel("Departure city ID");
        departureidlabel.setBounds(50,120,150,40);
        add(departureidlabel);

        departure_city_idcb = new JComboBox(id2);
        departure_city_idcb.setBounds(200,120,200,40);
        add(departure_city_idcb);

        JLabel arrivalidlabel = new JLabel("Arrival city ID");
        arrivalidlabel.setBounds(50,170,150,40);
        add(arrivalidlabel);

        arrival_city_idcb = new JComboBox(id2);
        arrival_city_idcb.setBounds(200,170,200,40);
        add(arrival_city_idcb);

        JLabel departuretimelabel = new JLabel("Departure time");
        departuretimelabel.setBounds(50,220,150,40);
        add(departuretimelabel);

        JTextField departuretimetext = new JTextField();
        departuretimetext.setBounds(200,220,200,40);
        add(departuretimetext);

        JLabel economlabel = new JLabel("Economy place price");
        economlabel.setBounds(50,270,150,40);
        add(economlabel);

        JTextField economtext = new JTextField();
        economtext.setBounds(200,270,200,40);
        add(economtext);

        JLabel businesslabel = new JLabel("Business place price");
        businesslabel.setBounds(50,320,150,40);
        add(businesslabel);

        JTextField businesstext = new JTextField();
        businesstext.setBounds(200,320,200,40);
        add(businesstext);

        add=new JButton("ADD");
        add.setBounds(50,400,150,40);
        add.setBackground(Color.pink);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flight flight = new Flight(Integer.parseInt(idtext.getText()), (adminFrame.sendList("aircrafts").get((aircraft_idcb.getSelectedIndex())).id), (adminFrame.sendListC("cities").get((departure_city_idcb.getSelectedIndex())).id), (adminFrame.sendListC("cities").get((arrival_city_idcb.getSelectedIndex())).id),departuretimetext.getText(),Integer.parseInt(economtext.getText()),Integer.parseInt(businesstext.getText()));
                try {
                    adminFrame.sendFlight(flight);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                idtext.setText("");
                aircraft_idcb.setSelectedItem(null);
                departure_city_idcb.setSelectedItem(null);
                arrival_city_idcb.setSelectedItem(null);
                departuretimetext.setText("");
                economtext.setText("");
                businesstext.setText("");
            }
        });

        back = new JButton("BACK");
        back.setBounds(250,400,150,40);
        back.setBackground(Color.pink);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getAddPanel().setVisible(true);
                adminFrame.getFlights().setVisible(false);
            }
        });
    }
}
