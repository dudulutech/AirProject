package com.company.Kassir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketMenu extends JPanel {
    KassirFrame kassirFrame;
    JButton add;
    JButton edit;
    JButton delete;
    JButton back;
    String [] listen;
    ArrayList<String> impostorss = new ArrayList<>();
    public TicketMenu(KassirFrame kassirFrame){
        this.kassirFrame = kassirFrame;
        setSize(500,500);
        setLayout(null);
        setBackground(Color.gray);

        add = new JButton("ADD");
        add.setBounds(150,70,200,50);
        add.setBackground(Color.pink);
        add(add);

        edit = new JButton("EDIT");
        edit.setBounds(150,140,200,50);
        edit.setBackground(Color.pink);
        add(edit);

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getEditTicketParameter().setVisible(true);
                kassirFrame.getTicketMenu().setVisible(false);
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(150,210,200,50);
        delete.setBackground(Color.pink);
        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getTicketMenu().setVisible(false);
                kassirFrame.getDeleteTicket().setVisible(true);

            }
        });
        back = new JButton("BACK");
        back.setBounds(150,280,200,50);
        back.setBackground(Color.pink);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getTicketMenu().setVisible(false);
                kassirFrame.getMenuKassa().setVisible(true);
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kassirFrame.getTicketMenu().setVisible(false);
                kassirFrame.getAddTicket().setVisible(true);

                listen = new String[kassirFrame.sendListF("flights").size()];
                for(int i =0;i <kassirFrame.sendListF("flights").size();i++){
                    listen[i] = String.valueOf(kassirFrame.sendListF("flights").get(i).id);
                }


                if(listen.length<kassirFrame.getAddTicket().flight_id.getItemCount()) {
                    ArrayList<String> impostors = new ArrayList<>();

                    for(int i = 0;i<kassirFrame.getAddTicket().flight_id.getItemCount();i++){
                        int dursemes =0;
                        for(int j =0; j<listen.length;j++){
                            if(Integer.parseInt((String) kassirFrame.getAddTicket().flight_id.getItemAt(i))!=Integer.parseInt(listen[j])){
                                dursemes++;
                            }
                        }
                        if(dursemes==listen.length){
                            impostors.add((String) kassirFrame.getAddTicket().flight_id.getItemAt(i));
                        }


                    }
                    for (int i = 0; i < (kassirFrame.getAddTicket().flight_id.getItemCount() - listen.length); i++) {
                        kassirFrame.getAddTicket().flight_id.removeItem(impostors.get(i));
                    }
                }
                if(listen.length>kassirFrame.getAddTicket().flight_id.getItemCount()) {

                    for(int i =0;i<(listen.length-kassirFrame.getAddTicket().flight_id.getItemCount());i++){
                        impostorss.add(listen[listen.length-1-i]);
                    }
                    for(int i =0;i<(listen.length-kassirFrame.getAddTicket().flight_id.getItemCount());i++){
                        kassirFrame.getAddTicket().flight_id.addItem(impostorss.get(i));
                    }
                }
            }
        });
    }
}