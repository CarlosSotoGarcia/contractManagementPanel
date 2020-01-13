package co.com.isesoft.boundary;

import co.com.isesoft.control.ClientManager;
import co.com.isesoft.entity.Client;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ClientBacking implements Serializable {
    private List<Client> clients;

    private Client client;

    @Inject
    private ClientManager clientManager;

    @PostConstruct
    public void init() {this.clients = clientManager.loadAll();}

    public void loadClients() {
        this.clientManager.loadClient();
        this.clients = clientManager.loadAll();
    }

    public void deleteClients() {
        this.clientManager.deleteClients(this.clients);
        this.clientManager.loadClient();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
