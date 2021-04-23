package com.example.pinpointpersonalplates.model;

// Plates Data transfer object(DTO) used as a design pattern to transfer data from the plate entity into a new platesDTO entity/

public class PlatesDTO
{
    private int plateid;
    private String registrationplate;
    private String firstname;
    private String secondname;
    private String cost;

    public int getPlateid() {
        return plateid;
    }

    public void setPlateid(int plateid) {
        this.plateid = plateid;
    }

    public String getRegistrationplate() {
        return registrationplate;
    }

    public void setRegistrationplate(String registrationplate) {
        this.registrationplate = registrationplate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
