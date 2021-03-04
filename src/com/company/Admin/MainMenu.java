package com.company.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    AdminFrame adminFrame;
    JButton add;
    JButton delete;
    JButton exit;
    JButton edit;
    public MainMenu(AdminFrame adminFrame){
        this.adminFrame=adminFrame;
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);

        add = new JButton("ADD");
        add.setBounds(150,50,200,50);
        add.setBackground(Color.pink);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getMainMenu().setVisible(false);
                adminFrame.getAddPanel().setVisible(true);
            }
        });

        edit=new JButton("EDIT");
        edit.setBounds(150,120,200,50);
        edit.setBackground(Color.pink);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getMainMenu().setVisible(false);
                adminFrame.getEditPanel().setVisible(true);
            }
        });

        delete=new JButton("DELETE");
        delete.setBounds(150,190,200,50);
        delete.setBackground(Color.pink);
        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.getMainMenu().setVisible(false);
                adminFrame.getDeletePanel().setVisible(true);
            }
        });

         exit=new JButton("EXIT");
        exit.setBounds(150,260,200,50);
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
