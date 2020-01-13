package co.com.isesoft.boundary;

import co.com.isesoft.control.ClientManager;
import co.com.isesoft.control.InfoApiManagement;
import co.com.isesoft.control.ProjectManager;
import co.com.isesoft.entity.Client;
import co.com.isesoft.entity.InfoApi;
import co.com.isesoft.entity.Project;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named
@ViewScoped
public class ClientAddBacking implements Serializable {

    @Inject
    private InfoApiManagement infoApiManagement;

    @Inject
    private ClientManager clientManager;

    @Inject
    private ProjectManager projectManager;

    private InfoApi infoApi;

    private Client client;

    private Project project;

    private String contractId;
    private String poNumber;
    private String wONumber;


    @PostConstruct
    public void init() {
        String idInfoApi;
        client = new Client();

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        if ( request.getParameterMap().containsKey("idInfoApi")) {
            idInfoApi = String.valueOf(request.getParameter("idInfoApi"));
            infoApi = infoApiManagement.findById(idInfoApi);
            client.setClientBillingCity(infoApi.getClientBillingCity());
            client.setClientBillingPostalCode(infoApi.getClientBillingPostalCode());
            client.setClientBillingState(infoApi.getClientBillingState());
            client.setClientBillingStreet(infoApi.getClientBillingStreet());
            client.setClientName(infoApi.getClientName());
            client.setClientBillingCountry(infoApi.getClientBillingCountry());
        }
    }



    public void add() {
        client = this.clientManager.save(this.client);

        project = new Project();
        project.setId(infoApi.getId());
        project.setClosed(infoApi.getClosed());
        project.setCloseDate(infoApi.getCloseDate());
        project.setClient(client);
        project.setDescription(infoApi.getDescription());
        project.setCreatedDate(infoApi.getCreatedDate());
        project.setContractId(contractId);
        project.setPoNumber(poNumber);
        project.setWoNumber(wONumber);

        projectManager.save(project);

        infoApi.setValidate(Boolean.TRUE);
        infoApiManagement.save(infoApi);

        infoApiManagement.reValidateByClientName(client.getClientName());

        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "panel");
    }

    public void backToList() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "panel");
    }

    public InfoApi getInfoApi() {
        return infoApi;
    }

    public void setInfoApi(InfoApi infoApi) {
        this.infoApi = infoApi;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public InfoApiManagement getInfoApiManagement() {
        return infoApiManagement;
    }

    public void setInfoApiManagement(InfoApiManagement infoApiManagement) {
        this.infoApiManagement = infoApiManagement;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getwONumber() {
        return wONumber;
    }

    public void setwONumber(String wONumber) {
        this.wONumber = wONumber;
    }
}
