package com.company.Admin;

import java.net.Socket;


public class Admin {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",1465);
            AdminFrame main = new AdminFrame(socket);
            main.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}