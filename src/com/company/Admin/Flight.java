package com.company.Admin;

import java.io.Serializable;

public class Flight implements Serializable {
    public int id;
    public int aircraftid;
    public int departureid;
    public int arrivalid;
    public String departuretime;
    public int businessprice;
    public int economprice;

    public Flight(int id, int aircraftid, int departureid, int arrivalid, String departuretime, int businessprice, int economprice) {
        this.id = id;
        this.aircraftid = aircraftid;
        this.departureid = departureid;
        this.arrivalid = arrivalid;
        this.departuretime = departuretime;
        this.businessprice = businessprice;
        this.economprice = economprice;
    }
}
