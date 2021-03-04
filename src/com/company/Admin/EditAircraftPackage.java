package com.company.Admin;

import java.io.Serializable;

public class EditAircraftPackage implements Serializable {
    String parameter;
    Aircraft airCraft;
    int integer;
    String string;

    public EditAircraftPackage(String parameter,Aircraft airCraft, int integer) {
        this.parameter =parameter;
        this.airCraft = airCraft;
        this.integer = integer;
    }

    public EditAircraftPackage(String parameter, Aircraft airCraft, String string) {
        this.parameter = parameter;
        this.airCraft = airCraft;
        this.string = string;
    }
}
