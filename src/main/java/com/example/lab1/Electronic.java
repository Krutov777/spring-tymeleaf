package com.example.lab1;

public class Electronic {
    private String nameModel;
    private String nameCompany;
    private Double cost;

    public Electronic() {
        this.nameModel = "nameModel";
        this.nameCompany = "nameCompany";
        this.cost = 7.0;
    }

    public Electronic(String nameModel, String nameCompany, Double cost) {
        this.nameModel = nameModel;
        this.nameCompany = nameCompany;
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getNameModel() {
        return nameModel;
    }
}
