package co.com.isesoft.entity;

import java.io.Serializable;

public class InfoDTO implements Serializable {

    private static final long serialVersionUID = 2111590973619351083L;

    private String clientBillingCity;
    private String clientBillingPostalCode;
    private String clientBillingState;
    private String clientBillingStreet;
    private String clientBillingCountry;
    private String clientName;
    private String closeDate;
    private String createdDate;
    private String description;
    private String id;
    private Boolean isClosed;
    private Boolean validate;

    public InfoApi toInfoApi() {
        InfoApi infoApi = new InfoApi();
        infoApi.setClosed(isClosed);
        infoApi.setCloseDate(closeDate);
        infoApi.setDescription(description);
        infoApi.setId(id);
        infoApi.setClientBillingCountry(clientBillingCountry);
        infoApi.setClientBillingCity(clientBillingCity);
        infoApi.setClientBillingPostalCode(clientBillingPostalCode);
        infoApi.setClientBillingState(clientBillingState);
        infoApi.setClientBillingStreet(clientBillingStreet);
        infoApi.setClientName(clientName);
        infoApi.setExistClient(Boolean.FALSE);
        infoApi.setValidate(Boolean.FALSE);
        return infoApi;
    }

    public Project toProject() {
        Project project = new Project();
        project.setClosed(isClosed);
        project.setCloseDate(closeDate);
        project.setDescription(description);
        project.setId(id);
        return project;
    }

    public InfoDTO() {
    }

    public Client toClient() {
        Client client = new Client();
        client.setClientBillingCity(clientBillingCity);
        client.setClientBillingPostalCode(clientBillingPostalCode);
        client.setClientBillingState(clientBillingState);
        client.setClientBillingStreet(clientBillingStreet);
        client.setClientName(clientName);
        return client;
    }

    @Override
    public String toString() {
        return "InfoDTO{" +
                "clientBillingCity='" + clientBillingCity + '\'' +
                ", clientBillingPostalCode='" + clientBillingPostalCode + '\'' +
                ", clientBillingState='" + clientBillingState + '\'' +
                ", clientBillingStreet='" + clientBillingStreet + '\'' +
                ", clientBillingCountry='" + clientBillingCountry + '\'' +
                ", clientName='" + clientName + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", isClosed=" + isClosed +
                '}';
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public String getClientBillingCountry() {
        return clientBillingCountry;
    }

    public void setClientBillingCountry(String clientBillingCountry) {
        this.clientBillingCountry = clientBillingCountry;
    }

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }
}
