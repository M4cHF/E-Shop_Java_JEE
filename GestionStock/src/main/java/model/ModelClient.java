package model;

import dao.DAOClient;
import entities.Client;

import java.util.List;


public class ModelClient {
    private Client client;
    private DAOClient service = new DAOClient();

    public ModelClient() {}

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient(Long id) {
        return service.getClient(id);
    }

    public void ajouterClient(Client client) {
        service.ajouterClient(client);
    }

    public void supprimerClient(Long id) {
        service.deleteClient(id);
    }

    public List<Client> getTousClients() {
        return service.getTousClients();
    }

    public boolean authentification(String email, String password) {
        return service.authentification(email, password);
    }

    public String getRole(String email) {
        return service.getRoleCilent(email);
    }

    public void changerRole(long code) {
        service.changerRole(code);
    }
}
