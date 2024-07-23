package dao;

import entities.Produit;
import java.util.List;

public interface DAO_Produit {
    void ajouterProduit(Produit produit);
    void modifierProduit(Produit produit);
    void archiverProduit(Long id);
    Produit getProduit(Long id);
    List<Produit>  getTousProduits();
    //List<Produit>  getProduitsParCommande(Long idCom);
}