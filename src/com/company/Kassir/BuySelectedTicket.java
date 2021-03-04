package com.company.Kassir;


import com.company.Admin.Aircraft;
import com.company.Admin.Flight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BuySelectedTicket extends JPanel {
    KassirFrame kassaFrame;
    Ticket selected_ticket;
    Flight selected_flight;
    Aircraft selected_aircraft;
    JLabel Cost;
    JButton back;
    JButton buy;
    public BuySelectedTicket(KassirFrame kassaFrame){
        this.kassaFrame = kassaFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(Color.gray);
        Cost = new JLabel();
        Cost.setBounds(100,100,300,30);
        add(Cost);
        back = new JButton("BACK");
        back.setBounds(150,400,200,50);
        back.setBackground(Color.pink);
        add(back);
        buy = new JButton("BUY");
        buy.setBounds(150,300,200,50);
        buy.setBackground(Color.pink);
        add(buy);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassaFrame.getBuySelectedTicket().setVisible(false);
                kassaFrame.getSearchTicket().setVisible(true);
            }
        });
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selected_ticket.ticket_type.equals("EconomyClass")) {
                    try {
                        kassaFrame.DeleteAircraft(selected_aircraft);
                        kassaFrame.sendAircraft(new Aircraft(selected_aircraft.id, selected_aircraft.name, selected_aircraft.model, selected_aircraft.business_class_capacity, selected_aircraft.econom_class_capacity - 1));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }if (selected_ticket.ticket_type.equals("BusinessClass")){
                    try {
                        kassaFrame.DeleteAircraft(selected_aircraft);
                        kassaFrame.sendAircraft(new Aircraft(selected_aircraft.id, selected_aircraft.name, selected_aircraft.model, selected_aircraft.business_class_capacity-1, selected_aircraft.econom_class_capacity));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }
}
