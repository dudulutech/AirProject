package com.company.Kassir;


import com.company.Admin.Aircraft;
import com.company.Admin.AircraftPackage;
import com.company.Admin.City;
import com.company.Admin.Flight;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class KassirFrame extends JFrame {
    KassirMenu menuKassa;
    Socket socket;
    ObjectOutputStream ous;
    com.company.Kassir.TicketMenu ticketMenu;
    AddTicket addTicket;
    DeleteTicket deleteTicket;
    BuyTicket buyTicket;
    SearchTicket searchTicket;
    BuySelectedTicket buySelectedTicket;
    EditTicketParameter editTicketParameter;
    EditTicketsPackage editTicketsPackage;
    EditTicketInt editTicketInt;
    EditTicketString editTicketString;
    public KassirFrame(Socket socket){
        try{
            this.socket=socket;
            ous=new ObjectOutputStream(socket.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("KASSIR");
        setSize(500,500);
        setBackground(Color.gray);
        setLayout(null);

        menuKassa=new KassirMenu(this);
        menuKassa.setVisible(true);
        add(menuKassa);

        ticketMenu=new TicketMenu(this);
        ticketMenu.setVisible(false);
        add(ticketMenu);

        addTicket=new AddTicket(this);
        addTicket.setVisible(false);
        add(addTicket);

        deleteTicket=new DeleteTicket(this);
        deleteTicket.setVisible(false);
        add(deleteTicket);

        buyTicket=new BuyTicket(this);
        buyTicket.setVisible(false);
        add(buyTicket);

        editTicketParameter=new EditTicketParameter(this);
        editTicketParameter.setVisible(false);
        add(editTicketParameter);

        editTicketInt=new EditTicketInt(this);
        editTicketInt.setVisible(false);
        add(editTicketInt);

        editTicketString=new EditTicketString(this);
        editTicketString.setVisible(false);
        add(editTicketString);

        buySelectedTicket=new BuySelectedTicket(this);
        buySelectedTicket.setVisible(false);
        add(buySelectedTicket);

        searchTicket = new SearchTicket(this);
        searchTicket.setVisible(false);
        add(searchTicket);



    }

    public KassirMenu getMenuKassa() {
        return menuKassa;
    }

    public BuyTicket getBuyTicket() {
        return buyTicket;
    }

    public EditTicketParameter getEditTicketParameter() {
        return editTicketParameter;
    }

    public EditTicketsPackage getEditTicketsPackage() {
        return editTicketsPackage;
    }

    public EditTicketInt getEditTicketInt() {
        return editTicketInt;
    }

    public EditTicketString getEditTicketString() {
        return editTicketString;
    }

    public TicketMenu getTicketMenu() {
        return ticketMenu;
    }

    public AddTicket getAddTicket() {
        return addTicket;
    }

    public SearchTicket getSearchTicket() {
        return searchTicket;
    }

    public BuySelectedTicket getBuySelectedTicket() {
        return buySelectedTicket;
    }

    public DeleteTicket getDeleteTicket() {
        return deleteTicket;
    }

    public ArrayList<Flight> sendListF(String string){
        ArrayList<Flight> flights = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            flights = (ArrayList<Flight>) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return flights;
    }
    public void sendTicket(Ticket ticket){
        try {
            TicketPackage tp = new TicketPackage("ADD",ticket);
            ous.writeObject(tp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteTicket(Ticket ticket) {
        try {
            TicketPackage fp = new TicketPackage("DELETE", ticket);
            ous.writeObject(fp);
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    public ArrayList<Aircraft> sendList(String string){
        ArrayList<Aircraft> aircrafts = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            aircrafts = (ArrayList<Aircraft>) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return aircrafts;
    }
    public ArrayList<City> sendListC(String string){
        ArrayList<City> cities = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            cities = (ArrayList<City>) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cities;
    }public ArrayList<Ticket> sendListT(String string){
        ArrayList<Ticket> tickets = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            tickets = (ArrayList<Ticket>) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tickets;
    }
    public void sendAircraft(Aircraft airCraft) throws IOException {
        try{
            AircraftPackage ap = new AircraftPackage("ADD", airCraft);
            ous.writeObject(ap);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void DeleteAircraft(Aircraft airCraft) {
        try {
            AircraftPackage ap = new AircraftPackage("DELETE", airCraft);
            ous.writeObject(ap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void EditTicketsInt(String parameter, Ticket ticket, int idi) {
        try {
            EditTicketsPackage ep =new EditTicketsPackage(parameter,ticket,idi);
            ous.writeObject(ep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void EditTicketsString(String parameter, Ticket ticket, String string) {
        try {
            EditTicketsPackage ep =new EditTicketsPackage(parameter,ticket,string);
            ous.writeObject(ep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
