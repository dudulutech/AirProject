package com.company.Admin;

import java.io.Serializable;

public class CitiesPackage implements Serializable {
    String operationType;
    City cities;

    public CitiesPackage(String operationType, City cities) {
        this.operationType = operationType;
        this.cities = cities;
    }
}
