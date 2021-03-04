package com.company.Kassir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchTicket extends JPanel {
    KassirFrame kassirFrame;
    JButton next;
    JButton back;
    JComboBox available_tickets;
    JLabel available_ticketsl;
    public SearchTicket(KassirFrame kassirFrame){
        this.kassirFrame=kassirFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(Color.gray);
        back = new JButton("BACK");
        back.setBackground(Color.pink);
        back.setBounds(150,400,200,50);
        add(back);
        available_tickets = new JComboBox();
        available_tickets.setSelectedItem(null);
        available_tickets.setBackground(Color.pink);
        available_tickets.setBounds(100,100,300,30);
        add(available_tickets);
        available_ticketsl = new JLabel("TICKETS MATCHING YOUR SETTINGS");
        available_ticketsl.setBounds(100,50,300,30);
        add(available_ticketsl);
        next = new JButton("NEXT");
        next.setBounds(100,300,300,50);
        next.setBackground(Color.pink);
        add(next);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getBuyTicket().setVisible(true);
                kassirFrame.getSearchTicket().setVisible(false);
                available_tickets.removeAllItems();
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                for(int i =0; i<kassirFrame.sendListT("tickets").size();i++){
                    if((kassirFrame.sendListT("tickets").get(i).flight_id)==((Integer) kassirFrame.getSearchTicket().available_tickets.getSelectedItem())){
                        kassirFrame.getBuySelectedTicket().selected_ticket = kassirFrame.sendListT("tickets").get(i);
                    }
                }
                for(int i =0; i<kassirFrame.sendListF("flights").size();i++){
                    if(kassirFrame.sendListF("flights").get(i).id == kassirFrame.getBuySelectedTicket().selected_ticket.flight_id){
                        kassirFrame.getBuySelectedTicket().selected_flight = kassirFrame.sendListF("flights").get(i);
                    }
                }
                for(int i=0;i<kassirFrame.sendList("aircrafts").size();i++){
                    if (kassirFrame.sendList("aircrafts").get(i).id ==kassirFrame.getBuySelectedTicket().selected_flight.aircraftid){
                        kassirFrame.getBuySelectedTicket().selected_aircraft = kassirFrame.sendList("aircrafts").get(i);
                    }
                }
                if(kassirFrame.getBuySelectedTicket().selected_ticket.ticket_type.equals("BusinessClass")){
                    kassirFrame.getBuySelectedTicket().Cost.setText("THE PRICE OF THIS TICKET "+kassirFrame.getBuySelectedTicket().selected_flight.businessprice+" KZT");
                }if(kassirFrame.getBuySelectedTicket().selected_ticket.ticket_type.equals("EconomyClass")){
                    kassirFrame.getBuySelectedTicket().Cost.setText("THE PRICE OT THIS TICKET "+kassirFrame.getBuySelectedTicket().selected_flight.economprice+" KZT");
                }
                kassirFrame.getSearchTicket().setVisible(false);
                kassirFrame.getBuySelectedTicket().setVisible(true);
                kassirFrame.getBuySelectedTicket().setSize(520,500);
            }
        });
    }
}
