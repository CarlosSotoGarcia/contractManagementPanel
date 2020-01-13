package co.com.isesoft.boundary;

import co.com.isesoft.control.ClientManager;
import co.com.isesoft.control.InfoApiManagement;
import co.com.isesoft.entity.Client;
import co.com.isesoft.entity.InfoApi;

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

    private InfoApi infoApi;

    private Client client;

    @Inject
    private InfoApiManagement infoApiManagement;

    @Inject
    private ClientManager clientManager;

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
        this.clientManager.save(this.client);
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
}
