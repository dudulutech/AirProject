package com.company.Kassir;

import java.io.Serializable;

public class EditTicketsPackage implements Serializable {
    String parameter;
    int integer;
    String string;
    Ticket ticket;

    public EditTicketsPackage(String parameter, Ticket ticket, String string) {
        this.parameter = parameter;
       this.ticket=ticket;
        this.string = string;
    }

    public EditTicketsPackage(String parameter, Ticket ticket,int integer ) {
        this.parameter = parameter;
        this.integer = integer;
        this.ticket=ticket;
    }
}
