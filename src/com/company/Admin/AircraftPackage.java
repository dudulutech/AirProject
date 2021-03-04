package com.company.Admin;

import java.io.Serializable;

public class AircraftPackage implements Serializable {
     public String operationType;
   public Aircraft airCraft;

    public AircraftPackage(String operationType, Aircraft airCraft) {
        this.operationType = operationType;
        this.airCraft = airCraft;
    }
}
