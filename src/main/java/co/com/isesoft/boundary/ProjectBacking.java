package co.com.isesoft.boundary;

import co.com.isesoft.control.ClientManager;
import co.com.isesoft.control.ProjectManager;
import co.com.isesoft.entity.Client;
import co.com.isesoft.entity.Project;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ProjectBacking implements Serializable {
    private List<Project> projects;

    private Client client;

    @Inject
    private ProjectManager projectManager;

    @Inject
    private ClientManager clientManager;

    @PostConstruct
    public void init() {
        Long idClient;
        projects = new ArrayList<>();

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        if ( request.getParameterMap().containsKey("idItem")) {
            idClient = Long.valueOf(request.getParameter("idItem"));

            client = clientManager.findById(idClient);
            projects = projectManager.findByClient(client);
        } else {
            return;
        }
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
