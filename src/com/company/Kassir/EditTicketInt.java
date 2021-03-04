package com.company.Kassir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTicketInt extends JPanel {
    KassirFrame kassirFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;

    public EditTicketInt(KassirFrame kassirFrame){
        this.kassirFrame=kassirFrame;
        setSize(520,500);
        setBackground(Color.gray);
        setLayout(null);

        enterl = new JLabel("ENTER INT");
        enterl.setBounds(100,100,300,30);
        enterl.setForeground(Color.pink);
        add(enterl);
        enter = new JTextField();
        enter.setBounds(100,150,300,30);
        add(enter);
        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        back.setBackground(Color.pink);
        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125,400,100,30);
        edit.setBackground(Color.pink);
        add(edit);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getEditTicketParameter().setVisible(false);
                kassirFrame.getEditTicketInt().setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kassirFrame.getEditTicketParameter().parameter.getText().equals("id")){
                    int id = 0;
                    Ticket ticket = null;
                    for(int i =0; i<kassirFrame.sendListT("tickets").size();i++){
                        if(kassirFrame.sendListT("tickets").get(i).id == Integer.parseInt(kassirFrame.getEditTicketParameter().id.getText())){
                            id = Integer.parseInt(enter.getText());
                            ticket = kassirFrame.sendListT("tickets").get(i);
                        }
                    }
                   kassirFrame.EditTicketsInt("id",ticket,id);
                    enter.setText("");
                    kassirFrame.getEditTicketParameter().parameter.setText("");
                    kassirFrame.getEditTicketParameter().id.setText("");
                }
                if(kassirFrame.getEditTicketParameter().parameter.getText().equals("flight_id")){
                    int id = 0;
                    Ticket ticket = null;
                    for(int i =0; i<kassirFrame.sendListT("tickets").size();i++){
                        if(kassirFrame.sendListT("tickets").get(i).id == Integer.parseInt(kassirFrame.getEditTicketParameter().id.getText())){
                            id = Integer.parseInt(enter.getText());
                            ticket = kassirFrame.sendListT("tickets").get(i);
                        }
                    }
                    kassirFrame.EditTicketsInt("flight_id",ticket,id);
                    enter.setText("");
                    kassirFrame.getEditTicketParameter().parameter.setText("");
                    kassirFrame.getEditTicketParameter().id.setText("");
                }
            }
        });
    }
}
