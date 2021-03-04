package com.company.Kassir;

import java.io.Serializable;

public class TicketPackage implements Serializable {
    String operationType;
    Ticket ticket;

    public TicketPackage(String operationType, Ticket ticket) {
        this.operationType = operationType;
        this.ticket = ticket;
    }
}
