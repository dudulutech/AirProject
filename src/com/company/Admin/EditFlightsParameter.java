package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.gray;
import static java.awt.Color.pink;

public class EditFlightsParameter extends JPanel {
    AdminFrame adminFrame;
    JLabel idl;
    JButton back;
    JTextField id;
    JButton next;
    JLabel parameterl;
    JTextField parameter;
    int a=0;
    int b =0;
    int c = 0;
    public EditFlightsParameter(AdminFrame adminFrame){
        this.adminFrame = adminFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(gray);
        idl = new JLabel("ID");
        idl.setBounds(100,50,300,30);
        idl.setForeground(Color.pink);
        add(idl);
        id= new JTextField();
        id.setBounds(100,100,300,30);
        add(id);
        parameterl = new JLabel("PARAMETER");
        parameterl.setBounds(100,150,300,30);
        add(parameterl);
        parameter = new JTextField();
        parameter.setBounds(100,200,300,30);
        add(parameter);
        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        back.setBackground(pink);
        add(back);
        next = new JButton("NEXT");
        next.setBounds(125,400,100,30);
        next.setBackground(pink);
        add(next);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getEditFlightsParameter().setVisible(false);
                adminFrame.getEditPanel().setVisible(true);
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(parameter.getText().equals("id")||parameter.getText().equals("econom_place_price") || parameter.getText().equals("business_place_price")){
                    adminFrame.getEditFlightsParameter().setVisible(false);
                    adminFrame.getEditFligtsInt().setVisible(true);

                }
                if (parameter.getText().equals("departure_time") ){
                    adminFrame.getEditFlightsParameter().setVisible(false);
                    adminFrame.getEditFligtsString().setVisible(true);

                }
                if(parameter.getText().equals("departure_city_id")){
                    adminFrame.getEditFlightsParameter().setVisible(false);
                    adminFrame.getEditFlightsDepartureCItyID().setVisible(true);
                    String[] listen = new String[adminFrame.sendListC("cities").size()];
                    for (int i = 0; i < adminFrame.sendListC("cities").size(); i++) {
                        listen[i] = String.valueOf(adminFrame.sendListC("cities").get(i).id);
                    }
                    if (listen.length > adminFrame.getEditFlightsDepartureCItyID().enter.getItemCount()) {
                        adminFrame.getEditFlightsDepartureCItyID().enter.addItem(listen[listen.length - 1]);
                    }
                    if (listen.length < adminFrame.getEditFlightsDepartureCItyID().enter.getItemCount()) {
                        ArrayList<String> impostors = new ArrayList<>();
                        for (int i = 0; i < adminFrame.getEditFlightsDepartureCItyID().enter.getItemCount(); i++) {
                            int dursemes = 0;
                            for (int j = 0; j < listen.length; j++) {
                                if ( adminFrame.getEditFlightsDepartureCItyID().enter.getItemAt(i).equals( listen[j])) {
                                }else {
                                    dursemes++;
                                }
                            }
                            if (dursemes == listen.length) {
                                impostors.add((String) adminFrame.getEditFlightsDepartureCItyID().enter.getItemAt(i));
                            }
                        }
                        adminFrame.getEditFlightsDepartureCItyID().enter.removeItem(impostors.get(b));
                        b++;
                    }
                }if(parameter.getText().equals("arrival_city_id")){
                    adminFrame.getEditFlightsParameter().setVisible(false);
                    adminFrame.getEditFlightsArrivalCityID().setVisible(true);
                    String[] listen = new String[adminFrame.sendListC("cities").size()];
                    for (int i = 0; i < adminFrame.sendListC("cities").size(); i++) {
                        listen[i] = String.valueOf(adminFrame.sendListC("cities").get(i).id);
                    }
                    if (listen.length > adminFrame.getEditFlightsArrivalCityID().enter.getItemCount()) {
                        adminFrame.getEditFlightsArrivalCityID().enter.addItem(listen[listen.length - 1]);
                    }
                    if (listen.length < adminFrame.getEditFlightsArrivalCityID().enter.getItemCount()) {
                        ArrayList<String> impostors = new ArrayList<>();
                        for (int i = 0; i < adminFrame.getEditFlightsArrivalCityID().enter.getItemCount(); i++) {
                            int dursemes = 0;
                            for (int j = 0; j < listen.length; j++) {
                                if ( adminFrame.getEditFlightsArrivalCityID().enter.getItemAt(i).equals( listen[j])) {
                                }else {
                                    dursemes++;
                                }
                            }
                            if (dursemes == listen.length) {
                                impostors.add((String) adminFrame.getEditFlightsArrivalCityID().enter.getItemAt(i));
                            }
                        }
                        adminFrame.getEditFlightsArrivalCityID().enter.removeItem(impostors.get(c));
                        c++;
                    }
                }if(parameter.getText().equals("aircraft_id")) {
                    adminFrame.getEditFlightsParameter().setVisible(false);
                    adminFrame.getEditFlightAircraftID().setVisible(true);
                    String[] listen = new String[adminFrame.sendList("aircrafts").size()];
                    for (int i = 0; i < adminFrame.sendList("aircrafts").size(); i++) {
                        listen[i] = String.valueOf(adminFrame.sendList("aircrafts").get(i).id);
                    }
                    if (listen.length > adminFrame.getEditFlightAircraftID().enter.getItemCount()) {
                        adminFrame.getEditFlightAircraftID().enter.addItem(listen[listen.length - 1]);
                    }
                    if (listen.length < adminFrame.getEditFlightAircraftID().enter.getItemCount()) {
                        ArrayList<String> impostors = new ArrayList<>();
                        for (int i = 0; i < adminFrame.getEditFlightAircraftID().enter.getItemCount(); i++) {
                            int dursemes = 0;
                            for (int j = 0; j < listen.length; j++) {
                                if ( adminFrame.getEditFlightAircraftID().enter.getItemAt(i).equals( listen[j])) {
                                }else {
                                    dursemes++;
                                }
                            }
                            if (dursemes == listen.length) {
                                impostors.add((String) adminFrame.getEditFlightAircraftID().enter.getItemAt(i));
                            }
                        }
                        adminFrame.getEditFlightAircraftID().enter.removeItem(impostors.get(a));
                        a++;
                    }
                }
            }

        });
    }
}
