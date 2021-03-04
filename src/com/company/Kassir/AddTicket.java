package com.company.Kassir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTicket extends JPanel {
    KassirFrame kassirFrame;
    JButton back;
    JButton add;
    JLabel flight_idl;
    JComboBox flight_id;
    JLabel idl;
    JTextField id;
    JLabel namel;
    JTextField name;
    JLabel surnamel;
    JTextField surname;
    JLabel passport_numberl;
    JTextField passport_number;
    JLabel ticket_typel;
    JComboBox ticket_type;
    String[] type = new String[2];
    String[] flight_ids;

    public AddTicket(KassirFrame kassirFrame){
        type[0]="EconomyClass";
        type[1]="BusinessClass";
        this.kassirFrame=kassirFrame;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);
        flight_ids = new String[kassirFrame.sendListF("flights").size()];
        for(int i =0;i <kassirFrame.sendListF("flights").size();i++){
            flight_ids[i] = String.valueOf(kassirFrame.sendListF("flights").get(i).id);
        }
        flight_id = new JComboBox(flight_ids);
        flight_id.setBounds(10,120,180,30);
        flight_id.setBackground(Color.pink);
        add(flight_id);
        flight_id.setSelectedItem(null);
        add = new JButton("ADD");
        add.setBounds(125,400,100,30);
        add.setBackground(Color.pink);
        add(add);
        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        back.setBackground(Color.pink);
        add(back);
        idl = new JLabel("ID");
        idl.setBounds(10,10,180,30);
        add(idl);
        id = new JTextField();
        id.setBounds(10,45,180,30);
        id.setBackground(Color.pink);
        add(id);
        flight_idl = new JLabel("FLIGHT");
        flight_idl.setBounds(10,85,180,30);

        add(flight_idl);
        namel = new JLabel("NAME");
        namel.setBounds(10,160,180,30);
        add(namel);
        name = new JTextField();
        name.setBounds(10,195,180,30);
        name.setBackground(Color.pink);
        add(name);
        surnamel = new JLabel("SURNAME");
        surnamel.setBounds(290,10,180,30);

        add(surnamel);
        surname = new JTextField();
        surname.setBounds(290,45,180,30);
        surname.setBackground(Color.pink);
        add(surname);
        passport_numberl = new JLabel("PASSPORT NUMBER");
        passport_numberl.setBounds(290,85,180,30);

        add(passport_numberl);
        passport_number = new JTextField();
        passport_number.setBounds(290,120,180,30);
        passport_number.setBackground(Color.pink);
        add(passport_number);
        ticket_type = new JComboBox(type);
        ticket_type.setBounds(290,195,180,30);
        ticket_type.setBackground(Color.pink);;
        add(ticket_type);
        ticket_type.setSelectedItem(null);
        ticket_typel = new JLabel("TICKET TYPE");
        ticket_typel.setBounds(290,160,180,30);

        add(ticket_typel);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getTicketMenu().setVisible(true);
                kassirFrame.getAddTicket().setVisible(false);
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ticket ticket = new Ticket(Integer.parseInt(id.getText()),kassirFrame.sendListF("flights").get(flight_id.getSelectedIndex()).id,name.getText(),surname.getText(),passport_number.getText(), type[ticket_type.getSelectedIndex()]);
                kassirFrame.sendTicket(ticket);
                id.setText("");
                flight_id.setSelectedItem(null);
                name.setText("");
                surname.setText("");
                passport_number.setText("");
                ticket_type.setSelectedItem(null);
            }
        });
    }
}
