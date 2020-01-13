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

    public void loadClient() {
        loadClientsApi();

    }
    private void loadClientsApi() {
        List<InfoDTO> clientDTOS = new ArrayList<>();
        String output = null;
        try {
            URL url = new URL("http://localhost:8080/cmforceservice/resources/opportunity");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            output = br.readLine();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (output != null) {
            JSONArray jsonArray = new JSONArray(output);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = (JSONObject) jsonArray.get(i);
                InfoDTO dto = new InfoDTO();
                dto.setClientBillingCity(json.has("ClientBillingCity") ? json.getString("ClientBillingCity") : "");
                dto.setClientBillingPostalCode(json.has("ClientBillingPostalCode") ? json.getString("ClientBillingPostalCode") : null);
                dto.setClientBillingState(json.has("ClientBillingState") ? json.getString("ClientBillingState") : null);
                dto.setClientBillingStreet(json.has("ClientBillingStreet") ? json.getString("ClientBillingStreet") : null);
                dto.setClientName(json.has("ClientName") ? json.getString("ClientName") : null);
                dto.setCloseDate(json.has("CreatedDate") ? json.getString("CloseDate") : null);
                dto.setCreatedDate(json.has("CreatedDate") ? json.getString("CreatedDate") : null);
                dto.setDescription(json.has("Description") ? json.getString("Description") : null);
                dto.setId(json.has("Id") ? json.getString("Id") : null);
                dto.setClosed(json.has("IsClosed") ? json.getBoolean("IsClosed") : null);
                clientDTOS.add(dto);
            }
            saveListDTO(clientDTOS);
        }

    }

    public void deleteClients(List<Client> clients) {
        for (Client client: clients) {
            this.entityManager.remove(client);
            this.entityManager.flush();
        }
    }

    public void saveListDTO(List<InfoDTO> dtos) {
        Client client;
        Project project;
        for (InfoDTO dto: dtos) {
            client = findByName(dto.getClientName());
            if (client == null) {
                client = this.entityManager.merge(dto.toClient());
            }
            project = projectManager.findByClientAndDescription(client, dto.getDescription());
            if (project == null) {
                project = dto.toProject();
                project.setClient(client);
                project = projectManager.save(project);
            }
        }
    }
}
