package com.company.Admin;

import java.io.Serializable;

public class EditCitiesPackage implements Serializable {
    String parameter;
    City city;
    int integer;
    String string;

    public EditCitiesPackage(String parameter, City city, String string) {
        this.parameter = parameter;
        this.city=city;
        this.string = string;
    }
    public EditCitiesPackage(String parameter, City city, int integer) {
        this.parameter = parameter;
        this.city=city;
        this.integer = integer;

    }
}
