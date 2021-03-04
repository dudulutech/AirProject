package com.company.Kassir;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class KassirThread extends Thread {
    ServerSocket socket;
    Connection connection;

    public KassirThread(ServerSocket socket,Connection connection){
        this.socket=socket;
        this.connection=connection;
    }

    @Override
    public void run() {
        while (socket.isBound()) {
            try{
                Socket socket1= socket.accept();
                System.out.println("KASSIR CONNECTED");
                KassirThreadKabyldau k1 = new KassirThreadKabyldau(socket1,connection);
                k1.start();
            }catch (IOException e){
                e.printStackTrace();
            }



        }
    }
}
