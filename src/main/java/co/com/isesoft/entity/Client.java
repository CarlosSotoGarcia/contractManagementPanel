package co.com.isesoft.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.clientName = :name "),
        @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id ")
})
public class Client {

    @Id
    private String id;

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

    @Column(nullable = false)
    private String clientBillingCountry;

    @Column(nullable = false)
    private String wnueve;

    @Column(nullable = false)
    private String taxCertificate;

    @OneToMany(mappedBy = "client")
    private List<Project> projects;



    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getClientBillingCountry() {
        return clientBillingCountry;
    }

    public void setClientBillingCountry(String clientBillingCountry) {
        this.clientBillingCountry = clientBillingCountry;
    }

    public String getWnueve() {
        return wnueve;
    }

    public void setWnueve(String wnueve) {
        this.wnueve = wnueve;
    }

    public String getTaxCertificate() {
        return taxCertificate;
    }

    public void setTaxCertificate(String taxCertificate) {
        this.taxCertificate = taxCertificate;
    }
}
