package com.company.Admin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Aircraftsdelete extends JPanel {
    AdminFrame main;
    JButton addButton;
    JButton back;

    public Aircraftsdelete(AdminFrame main) {
        this.main = main;
        setSize(500, 500);
        setBackground(Color.gray);
        setLayout(null);

        JLabel nameLabel = new JLabel("ID");
        nameLabel.setSize(100, 40);
        nameLabel.setLocation(150, 150);
        add(nameLabel);

        JTextField id = new JTextField();
        id.setBounds(200, 150, 200, 40);
        add(id);

        addButton = new JButton("DELETE");
        addButton.setSize(300, 40);
        addButton.setLocation(100, 200);
        addButton.setBackground(Color.pink);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Aircraft aircraft = new Aircraft(Integer.parseInt(id.getText()),null,null,0,0);
                    main.DeleteAircraft(aircraft);
                    id.setText("");

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        back = new JButton("BACK");
        back.setSize(300, 30);
        back.setLocation(100, 250);
        back.setBackground(Color.pink);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getDeletePanel().setVisible(true);
                main.getAircraftsdelete().setVisible(false);
            }
        });
    }

    public void deleteaction(Socket socket, ObjectOutputStream ous) {
        try {
            ous.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
