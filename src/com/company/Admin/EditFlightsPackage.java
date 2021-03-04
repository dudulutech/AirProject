package com.company.Admin;

import java.io.Serializable;

public class EditFlightsPackage implements Serializable {
    String parameter;
    Flight flight;
    int integer;
    String string;

    public EditFlightsPackage(String parameter, Flight flight, int integer) {
        this.parameter = parameter;
        this.flight = flight;
        this.integer = integer;
    }
    public EditFlightsPackage(String parameter,Flight flight,String string){
        this.parameter=parameter;
        this.flight=flight;
        this.string=string;
    }
}
