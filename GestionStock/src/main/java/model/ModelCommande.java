package model;

import dao.DAOCommande;
import dao.DAO_Commande;
import entities.Commande;

import java.util.List;

public class ModelCommande  {
    DAO_Commande service = new DAOCommande();

    public List<Commande> getCommandes() {
        return service.getTousCommandes();
    }
}
