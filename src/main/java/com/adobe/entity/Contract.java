package com.adobe.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Contract {

    @Id
//    @SequenceGenerator(name = "contract_seq", sequenceName = "contract_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_seq")
    private Long id;

    @Column(nullable = false)
    private String projectID;

    @Column(nullable = false)
    @NotEmpty
    private String projectName;

    @Column(nullable = false)
    @NotEmpty
    private String status;

    public Contract() {

    }

    public Contract(String projectID, @NotEmpty String projectName, @NotEmpty String status) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
