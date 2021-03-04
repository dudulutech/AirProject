package com.company;
import com.company.Admin.AdminThread;
import com.company.Kassir.KassirThread;
import java.net.ServerSocket;
import java.sql.*;
import java.util.Scanner;

public class Server {
    static Connection connection;
    Scanner in = new Scanner(System.in);
    static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:5432/air?useUnicode=true&serverTimezone=UTC", "postgres", "25399");
        } catch (Exception e) {


            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            ServerSocket admin = new ServerSocket(1465);
            ServerSocket kassir= new ServerSocket(1466);
            connect();
            KassirThread kt = new KassirThread(kassir,connection);
            AdminThread at = new AdminThread(admin,connection);
            kt.start();
            at.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
