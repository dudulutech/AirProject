package com.company.Kassir;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTicketString extends JPanel {
    KassirFrame kassirFrame;
    JLabel enterl;
    JTextField enter;
    JButton back;
    JButton edit;

    public EditTicketString(KassirFrame kassirFrame) {
        this.kassirFrame=kassirFrame;
        setSize(520, 500);
        setLayout(null);
        setBackground(Color.gray);
        enterl = new JLabel("ENTER STRING:");
        enterl.setBounds(100, 100, 300, 30);
        enterl.setForeground(Color.pink);
        add(enterl);
        enter = new JTextField();
        enter.setBounds(100, 150, 300, 30);
        add(enter);
        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        back.setBackground(Color.pink);
        back.setForeground(Color.white);
        add(back);
        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        edit.setBackground(Color.pink);
        edit.setForeground(Color.white);
        add(edit);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               kassirFrame.getEditTicketParameter().setVisible(true);
               kassirFrame.getEditTicketString().setVisible(false);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kassirFrame.getEditTicketParameter().parameter.getText().equals("name")){
                    String name  = "";
                    Ticket ticket = null;
                    for(int i =0; i<kassirFrame.sendListT("tickets").size();i++){
                        if(kassirFrame.sendListT("tickets").get(i).id == Integer.parseInt(kassirFrame.getEditTicketParameter().id.getText())){
                            name = enter.getText();
                            ticket = kassirFrame.sendListT("tickets").get(i);
                        }
                    }
                    kassirFrame.EditTicketsString("name",ticket,name);
                    enter.setText("");
                    kassirFrame.getEditTicketParameter().parameter.setText("");
                    kassirFrame.getEditTicketParameter().id.setText("");
                }
                if (kassirFrame.getEditTicketParameter().parameter.getText().equals("surname")){
                    String surname  = "";
                    Ticket ticket=null;
                    for(int i =0; i<kassirFrame.sendListT("tickets").size();i++){
                        if(kassirFrame.sendListT("tickets").get(i).id == Integer.parseInt(kassirFrame.getEditTicketParameter().id.getText())){
                            surname = enter.getText();
                            ticket = kassirFrame.sendListT("tickets").get(i);
                        }
                    }
                    kassirFrame.EditTicketsString("surname",ticket,surname);
                    enter.setText("");
                    kassirFrame.getEditTicketParameter().parameter.setText("");
                    kassirFrame.getEditTicketParameter().id.setText("");
                }
                if (kassirFrame.getEditTicketParameter().parameter.getText().equals("passport_number")){
                    String passport  = "";
                    Ticket ticket = null;
                    for(int i =0; i<kassirFrame.sendListT("tickets").size();i++){
                        if(kassirFrame.sendListT("tickets").get(i).id == Integer.parseInt(kassirFrame.getEditTicketParameter().id.getText())){
                            passport = enter.getText();
                            ticket = kassirFrame.sendListT("tickets").get(i);
                        }
                    }
                    kassirFrame.EditTicketsString("passport_number",ticket,passport);
                    enter.setText("");
                    kassirFrame.getEditTicketParameter().parameter.setText("");
                    kassirFrame.getEditTicketParameter().id.setText("");
                }
                if (kassirFrame.getEditTicketParameter().parameter.getText().equals("ticket_type")){
                    String tickets  = "";
                    Ticket ticket = null;
                    for(int i =0; i<kassirFrame.sendListT("tickets").size();i++){
                        if(kassirFrame.sendListT("tickets").get(i).id == Integer.parseInt(kassirFrame.getEditTicketParameter().id.getText())){
                            tickets = enter.getText();
                            ticket = kassirFrame.sendListT("tickets").get(i);
                        }
                    }
                    kassirFrame.EditTicketsString("ticket_type",ticket,tickets);
                    enter.setText("");
                    kassirFrame.getEditTicketParameter().parameter.setText("");
                    kassirFrame.getEditTicketParameter().id.setText("");
                }
            }

        });
    }
}
