package com.adobe.control;

import com.adobe.entity.Client;
import com.adobe.entity.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ProjectManager {

    @PersistenceContext
    private EntityManager entityManager;

    public Project findByClientAndDescription(Client client, String description) {
        TypedQuery<Project> query = this.entityManager.createNamedQuery("Project.findByClientAndDescription", Project.class);
        query.setParameter("idClient", client.getId());
        query.setParameter("description", description);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Project save(Project project) {
        return entityManager.merge(project);
    }
}
