package com.example.pinpointpersonalplates.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


//creates a payment entity to store a generated paymentid, cost and payment method

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int paymentid;
    private String cost;
    private String method;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plates", referencedColumnName = "id")
    private Plates plates;

    public Payment()
    {

    }

    public Payment(String cost, String method, Plates plates)
    {
        this.cost = cost;
        this.method = method;
        this.plates = plates;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Plates getPlates() {
        return plates;
    }

    public void setPlates(Plates plates) {
        this.plates = plates;
    }
}
