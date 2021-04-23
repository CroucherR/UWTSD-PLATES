package com.example.pinpointpersonalplates.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

//Creates a Customer Entity containing a generated customerid value, firstname,secondname, address and a one to many relationship with the Paltes entity.

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid;
    private String firstname;
    private String secondname;
    private String address;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Plates.class, mappedBy = "customer")
    private List<Plates> customer;

    public Customer()
    {

    }

    public Customer(String firstname, Customer customer, String secondname, String address)
    {
        this.firstname = firstname;
        this.address = address;
        this.secondname = secondname;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
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

    public List<Plates> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Plates> customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
