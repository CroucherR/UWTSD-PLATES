package com.example.pinpointpersonalplates.model;
import javax.persistence.*;

//Creates a plate entity which stores the generated plateid value, registration plate and the dependencies from the other entities.

@Entity
public class Plates implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int plateid;
    private String registrationplate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment", referencedColumnName = "id")
    private Payment payment;

    public Plates()
    {

    }

    public Plates(String registrationplate, Customer customer, Payment payment)
    {
        this.registrationplate = registrationplate;
        this.payment = payment;
        this.setCustomer(customer);
    }


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


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
