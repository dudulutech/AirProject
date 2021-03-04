package com.company.Kassir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KassirMenu extends JPanel {
    KassirFrame kassirFrame;
    JButton buy;
    JButton exit;
    JButton edit;
    JButton delete;
    public KassirMenu(KassirFrame kassirFrame){
        this.kassirFrame=kassirFrame;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);

        buy=new JButton("BUY TICKETS");
        buy.setBounds(150,100,200,40);
        buy.setBackground(Color.pink);
        add(buy);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getMenuKassa().setVisible(false);
                kassirFrame.getBuyTicket().setVisible(true);


            }
        });

        edit=new JButton("EDIT TICKETS");
        edit.setBounds(150,170,200,40);
        edit.setBackground(Color.pink);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getMenuKassa().setVisible(false);
                kassirFrame.getTicketMenu().setVisible(true);

            }
        });

        exit=new JButton("EXIT");
        exit.setBounds(150,240,200,40);
        exit.setBackground(Color.pink);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
