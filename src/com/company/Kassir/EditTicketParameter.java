package com.company.Kassir;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTicketParameter extends JPanel {
    KassirFrame kassirFrame;
    JLabel idl;
    JButton back;
    JTextField id;
    JButton next;
    JLabel parameterl;
    JTextField parameter;
    public EditTicketParameter(KassirFrame kassirFrame){
        this.kassirFrame=kassirFrame;
        setSize(520,500);
        setLayout(null);
        setBackground(Color.gray);
        idl = new JLabel("ID");
        idl.setBounds(100,50,300,30);
        idl.setForeground(Color.pink);
        add(idl);
        id= new JTextField();
        id.setBounds(100,100,300,30);
        add(id);
        parameterl = new JLabel("PARAMETER");
        parameterl.setBounds(100,150,300,30);
        parameterl.setForeground(Color.pink);
        add(parameterl);
        parameter = new JTextField();
        parameter.setBounds(100,200,300,30);
        add(parameter);
        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        back.setBackground(Color.pink);
        add(back);
        next = new JButton("NEXT");
        next.setBounds(125,400,100,30);
        next.setBackground(Color.pink);
        add(next);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               kassirFrame.getTicketMenu().setVisible(true);
               kassirFrame.getEditTicketParameter().setVisible(false);
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(parameter.getText().equals("name") || parameter.getText().equals("surname") || parameter.getText().equals("passport_number")||parameter.getText().equals("ticket_type")){
                    kassirFrame.getEditTicketParameter().setVisible(false);
                    kassirFrame.getEditTicketString().setVisible(true);
                }
                if(parameter.getText().equals("id")||parameter.getText().equals("flight_id")) {
                    kassirFrame.getEditTicketParameter().setVisible(false);
                    kassirFrame.getEditTicketInt().setVisible(true);
                }
            }
        });
    }
}
