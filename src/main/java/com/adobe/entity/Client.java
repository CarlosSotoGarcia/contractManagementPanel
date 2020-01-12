package com.adobe.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.clientName = :name ")
})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String clientBillingCity;

    @Column(nullable = true)
    private String clientBillingPostalCode;

    @Column(nullable = true)
    private String clientBillingState;

    @Column(nullable = true)
    private String clientBillingStreet;

    @Column(nullable = false)
    private String clientName;

    @OneToMany(mappedBy = "client")
    private List<Project> projects;



    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientBillingCity() {
        return clientBillingCity;
    }

    public void setClientBillingCity(String clientBillingCity) {
        this.clientBillingCity = clientBillingCity;
    }

    public String getClientBillingPostalCode() {
        return clientBillingPostalCode;
    }

    public void setClientBillingPostalCode(String clientBillingPostalCode) {
        this.clientBillingPostalCode = clientBillingPostalCode;
    }

    public String getClientBillingState() {
        return clientBillingState;
    }

    public void setClientBillingState(String clientBillingState) {
        this.clientBillingState = clientBillingState;
    }

    public String getClientBillingStreet() {
        return clientBillingStreet;
    }

    public void setClientBillingStreet(String clientBillingStreet) {
        this.clientBillingStreet = clientBillingStreet;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
