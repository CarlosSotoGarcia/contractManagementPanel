package co.com.isesoft.control;

import co.com.isesoft.entity.Client;
import co.com.isesoft.entity.InfoDTO;
import co.com.isesoft.entity.Project;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ClientManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private ProjectManager projectManager;

    public List<Client> loadAll() {
        return this.entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public Client save(Client client) {
        return this.entityManager.merge(client);
    }

    public Client findById(Long id) {
        TypedQuery<Client> query = entityManager.createNamedQuery("Client.findById", Client.class);

        query.setParameter("id", id);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return  null;
        }
    }

    public Client findByName(String name) {
        TypedQuery<Client> query = this.entityManager.createNamedQuery("Client.findByName", Client.class);
        query.setParameter("name", name);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    public void deleteClients(List<Client> clients) {
        for (Client client: clients) {
            this.entityManager.remove(client);
            this.entityManager.flush();
        }
    }


}
