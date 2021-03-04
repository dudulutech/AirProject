package com.company.Admin;

import java.io.Serializable;

public class City implements Serializable {
    public int id;
    String country;
    String name;
    String shortname;

    public City(int id, String name,String country,  String shortname) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.shortname = shortname;
    }
}
