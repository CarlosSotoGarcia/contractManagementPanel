package co.com.isesoft.control;

import co.com.isesoft.entity.Client;
import co.com.isesoft.entity.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

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

    public List<Project> findByClient(Client client) {
        TypedQuery<Project> query = this.entityManager.createNamedQuery("Project.findByClient", Project.class);
        query.setParameter("idClient", client.getId());

        try {
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Project save(Project project) {
        return entityManager.merge(project);
    }
}
