package com.company.Kassir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuyTicket extends JPanel {
    KassirFrame kassirFrame;
    JButton back;
    JComboBox aircraft_id;
    JLabel aircraft_idl;
    JComboBox departure_city;
    JLabel departure_cityl;
    JComboBox arrival_city;
    JLabel arrival_cityl;
    JButton search;
    ArrayList<Integer> available_flight_ids;
    JLabel error;
    ArrayList<Integer> available_tickets_id;
    public BuyTicket(KassirFrame kassirFrame){
        this.kassirFrame = kassirFrame;
        setSize(520,520);
        setLayout(null);
        setBackground(Color.gray);
        back = new JButton("BACK");
        back.setBounds(275,400,200,50);
        back.setBackground(Color.pink);
        add(back);
        search = new JButton("SEARCH FOR TICKET");
        search.setBounds(25,400,200,50);
        search.setBackground(Color.pink);
        add(search);
        aircraft_idl = new JLabel("AIRCRAFT");
        aircraft_idl.setBounds(100,20,300,30);
        add(aircraft_idl);
        error = new JLabel("NO TICKETS WITH YOUR SETTINGS");
        error.setBounds(100,300,300,30);
        add(error);
        error.setVisible(false);
        String[] aircraft_ids = new String[kassirFrame.sendList("aircrafts").size()];
        for(int i=0;i<kassirFrame.sendList("aircrafts").size();i++){
            aircraft_ids[i]= (String.valueOf(kassirFrame.sendList("aircrafts").get(i).id));
        }
        aircraft_id = new JComboBox(aircraft_ids);
        aircraft_id.setBounds(100,50,300,30);
        aircraft_id.setSelectedItem(null);
        aircraft_id.setBackground(Color.pink);
        add(aircraft_id);
        String[] aircraft_idss = new String[kassirFrame.sendListC("cities").size()];
        for(int i=0;i<kassirFrame.sendListC("cities").size();i++) {
            aircraft_idss[i] = (String.valueOf(kassirFrame.sendListC("cities").get(i).id));
        }
        departure_cityl = new JLabel("DEPARTURE CITY ID");
        departure_cityl.setBounds(100,100,300,30);
        add(departure_cityl);
        departure_city = new JComboBox(aircraft_idss);
        departure_city.setSelectedItem(null);
        departure_city.setBounds(100,150,300,30);
        departure_city.setBackground(Color.pink);
        add(departure_city);
        arrival_cityl = new JLabel("ARRIVAL CITY ID");
        arrival_cityl.setBounds(100,200,300,30);
        add(arrival_cityl);
        arrival_city = new JComboBox(aircraft_idss);
        arrival_city.setSelectedItem(null);
        arrival_city.setBounds(100,250,300,30);
        arrival_city.setBackground(Color.pink);
        add(arrival_city);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getBuyTicket().setVisible(false);
                kassirFrame.getMenuKassa().setVisible(true);
            }
        });
        aircraft_id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });
        departure_city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });
        arrival_city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                available_flight_ids = new ArrayList<>();
                available_tickets_id=new ArrayList<>();
                int z=0;
                for(int i=0;i<kassirFrame.sendListF("flights").size();i++){
                    if(kassirFrame.sendListF("flights").get(i).aircraftid == Integer.parseInt((String) aircraft_id.getSelectedItem()) && kassirFrame.sendListF("flights").get(i).departureid ==Integer.parseInt((String) departure_city.getSelectedItem()) && kassirFrame.sendListF("flights").get(i).arrivalid == Integer.parseInt((String)arrival_city.getSelectedItem())){
                        available_flight_ids.add(kassirFrame.sendListF("flights").get(i).id);

                    }
                }
                for(int i =0;i<available_flight_ids.size();i++){
                    for(int j=0;j<kassirFrame.sendListT("tickets").size();j++){
                        if(available_flight_ids.get(i).equals(kassirFrame.sendListT("tickets").get(j).flight_id)){
                            available_tickets_id.add(kassirFrame.sendListT("tickets").get(j).flight_id);
                            z=1;
                        }
                    }
                }
                if(z==0){
                    error.setVisible(true);
                }if(z==1){
                    kassirFrame.getBuyTicket().setVisible(false);
                    kassirFrame.getSearchTicket().setVisible(true);
                }
                for(int i=0;i<available_tickets_id.size();i++){
                    kassirFrame.getSearchTicket().available_tickets.addItem(available_tickets_id.get(i));
                }

            }
        });
    }
}
