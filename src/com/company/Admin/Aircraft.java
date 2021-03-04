package com.company.Admin;

import java.io.Serializable;

public class Aircraft implements Serializable {
     public int id;
    public String name;
    public String model;
    public int business_class_capacity;
    public int econom_class_capacity;

    public Aircraft(int id, String name, String model, int business_class_capacity, int econom_class_capacity) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.business_class_capacity = business_class_capacity;
        this.econom_class_capacity = econom_class_capacity;
    }
}
