package com.company.Admin;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class AdminThread extends Thread {

    ServerSocket socket;
    Connection connection;

    public AdminThread(ServerSocket socket,Connection connection){
        this.socket=socket;
        this.connection=connection;
    }

    @Override
    public void run() {

        while (socket.isBound()) {
            try{
                Socket socket2 = socket.accept();
                System.out.println("ADMIN CONNECTED");
                AdminThreadKabyldau a1 = new AdminThreadKabyldau(socket2,connection);
                a1.start();
            }catch (Exception e){
                e.printStackTrace();
            }



        }
    }
}
