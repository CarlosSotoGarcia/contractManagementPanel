package com.adobe.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Project.findByClientAndDescription", query = "SELECT c FROM Project c WHERE c.client.id = :idClient and c.description = :description ")
})
public class Project {

    @Id
    private String id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="client")
    private Client client;

    @Column(nullable = false)
    private String closeDate;

    @Column(nullable = true)
    private String createdDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isClosed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
}
