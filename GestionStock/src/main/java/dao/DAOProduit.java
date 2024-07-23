package dao;

import entities.Produit;
import utility.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProduit implements DAO_Produit {
    Connection conx = SingletonConnection.seConnecter();

    @Override
    public void ajouterProduit(Produit produit) {
        String query = "INSERT INTO produit(codeProd, libelleProd, prixProd) VALUES (?, ?, ?)";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, produit.getCodeProduit());
            pst.setString(2, produit.getLibelle());
            pst.setDouble(3,produit.getPrixProduit());
            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Produit ajouté avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public  void modifierProduit(Produit produit) {
        String query = "UPDATE produit" +
                " SET codeProd = ?, libelleProd = ?, prixProd = ? " +
                "WHERE codeProd = ? ;";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, produit.getCodeProduit());
            pst.setString(2, produit.getLibelle());
            pst.setDouble(3,produit.getPrixProduit());
            pst.setLong(4, produit.getCodeProduit());
            int n = pst.executeUpdate();
            if(n != 0){
                System.out.println("Produit modifié avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void archiverProduit(Long id) {
        String query = "DELETE FROM produit WHERE codeProd = ?";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, id);

            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Produit archivé avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Produit getProduit(Long id) {
        Produit produit = new Produit();
        String query = "SELECT * FROM produit WHERE codeProd = ?";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, id);

            ResultSet result = pst.executeQuery();
            if(result.next()){
                produit.setCodeProduit(result.getLong("codeProd"));
                produit.setLibelle(result.getString("libelleProd"));
                produit.setPrixProduit(result.getDouble("prixProd"));
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return produit;
    }

    @Override
    public List<Produit> getTousProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produit";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Produit produit = new Produit(
                        result.getLong("codeProd"),
                        result.getString("libelleProd"),
                        result.getDouble("prixProd")
                );
                produits.add(produit);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return produits;
    }

//    @Override
//    public List<Produit> getProduitsParCommande(Long com) {
//        List<Produit> produits = new ArrayList<>();
//        String query = "SELECT * FROM produit where codeCom = ?";
//        try{
//            PreparedStatement pst = conx.prepareStatement(query);
//            pst.setLong(1, com);
//            ResultSet result = pst.executeQuery();
//            while (result.next()) {
//                Produit produit = new Produit(
//                        result.getLong("codeProd"),
//                        result.getString("libelleProd"),
//                        result.getDouble("prixProd")
//                );
//                produits.add(produit);
//            }
//        }catch(SQLException e){
//            System.err.println(e.getMessage());
//        }
//        return produits;
//    }


}
