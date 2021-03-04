package com.company.Admin;

import java.io.Serializable;

public class FlightsPackage implements Serializable {
    String operationType;

    com.company.Admin.Flight flight;

    public FlightsPackage(String operationType, Flight flight) {
        this.operationType = operationType;
        this.flight = flight;
    }
}
