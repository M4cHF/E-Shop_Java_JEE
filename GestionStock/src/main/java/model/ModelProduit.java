package model;

import dao.DAOProduit;
import entities.Produit;

import java.util.List;

public class ModelProduit {
    private Produit prod;
    private DAOProduit service = new DAOProduit();

    public void setProd(Produit produit) {
        this.prod = produit;
    }

    public void ajouterProd() {
        service.ajouterProduit(prod);
    }

    public void modifierProduit(Produit produit) {
        service.modifierProduit(produit);
    }

    public void archiverProduit(Long id) {
        service.archiverProduit(id);
    }

    public Produit getProduit(Long id) {
        Produit produit = service.getProduit(id);
        return produit;
    }

    public List<Produit> getTousProduits() {
        List list = service.getTousProduits();
        return list;
    }
}
