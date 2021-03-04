package com.company.Kassir;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Kassir {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",1466);
            KassirFrame main= new KassirFrame(socket);
            main.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
