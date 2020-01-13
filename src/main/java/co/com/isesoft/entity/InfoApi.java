package co.com.isesoft.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "InfoApi.findById", query = "SELECT i FROM InfoApi i WHERE i.id = :id "),
        @NamedQuery(name = "InfoApi.findAll", query = "SELECT i FROM InfoApi i ")
})
public class InfoApi {

    @Id
    private String id;

    @Column(nullable = false)
    private String closeDate;

    @Column(nullable = true)
    private String createdDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isClosed;

    @Column(nullable = true)
    private String clientBillingCity;

    @Column(nullable = true)
    private String clientBillingCountry;

    @Column(nullable = true)
    private String clientBillingPostalCode;

    @Column(nullable = true)
    private String clientBillingState;

    @Column(nullable = true)
    private String clientBillingStreet;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private Boolean existClient;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
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

    public Boolean getExistClient() {
        return existClient;
    }

    public void setExistClient(Boolean existClient) {
        this.existClient = existClient;
    }

    public String getClientBillingCountry() {
        return clientBillingCountry;
    }

    public void setClientBillingCountry(String clientBillingCountry) {
        this.clientBillingCountry = clientBillingCountry;
    }
}
