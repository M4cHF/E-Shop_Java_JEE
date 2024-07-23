package controller;

import entities.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelProduit;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProduitServlet",urlPatterns={"/ajouterProduit", "/modifierProduit", "/modifierUnProduit", "/archiverProduit", "/commanderProduit", "/listerTousProduits", "/gererProduits" ,"/cart"})
public class ProduitServlet extends HttpServlet {
    ModelProduit modeProd = new ModelProduit();
    private String codeProduitAModifie = "000";

    public void setCodeProduitAModifie(String codeProduitAModifie) {
        this.codeProduitAModifie = codeProduitAModifie;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n -- Produit servlet -- ");
        String servletPath = req.getServletPath();
        System.out.println("Servlet path: " + servletPath);

        switch (servletPath) {
            case "/ajouterProduit":
                handleAjoutProduit(req, resp);
                break;
            case "/modifierUnProduit":
                handleModifierUnProduit(req, resp);
                break;
            case "/modifierProduit":
                handleModifierProduit(req, resp);
                break;
            case "/archiverProduit":
                handleArchiverProduit(req, resp);
                break;
            case "/commanderProduit":
                handleCommanderProduit(req, resp);
                break;
            case "/listerTousProduits":
                listerProduits(req, resp);
                resp.sendRedirect("/listerProduits.jsp");
                break;
            case "/gererProduits":
                gererProduits(req, resp);
                resp.sendRedirect("/gererProduits.jsp");
                break;
            case "/cart":
                showCart(req, resp);
                break;
            default:
                System.out.println("Invalid Servlet Path");
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    // urlPatterns : implemented methods ;
    private void handleAjoutProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String code = req.getParameter("code-prod");
        String libelle = req.getParameter("libelle-prod");
        String prix = req.getParameter("prix-prod");

        try {
            long codeValue = Long.parseLong(code);
            double prixValue = Double.parseDouble(prix);
            Produit produit = new Produit(codeValue, libelle, prixValue);
            modeProd.setProd(produit);
            modeProd.ajouterProd();
        } catch (NumberFormatException e) {
            System.err.println("error occurs : " + e.getMessage());
        }
        // redirection to list page
        gererProduits(req, resp);
        resp.sendRedirect("/gererProduits.jsp");

    }

    private void handleModifierUnProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String code = req.getParameter("codePM");
        System.out.println("code de produit a modifié est : " + code);
        setCodeProduitAModifie(code);

        // Envoi de code de prduit vers le formulaire de modification :
        req.setAttribute("codeProMod", this.codeProduitAModifie);
        req.getRequestDispatcher("/modifierUnProduit.jsp").forward(req, resp);
        setCodeProduitAModifie("000");
        // redirection :
        resp.sendRedirect("./modifierUnProduit.jsp");
    }

    private void handleModifierProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println(this.codeProduitAModifie);
        String code = req.getParameter("code-prod");
        String libelle = req.getParameter("libelle-prod");
        String prix = req.getParameter("prix-prod");

        try {
            long codeValue = Long.parseLong(code);
            double prixValue = Double.parseDouble(prix);
            Produit p = new Produit(codeValue, libelle, prixValue);
            modeProd.setProd(p);
            modeProd.modifierProduit(p);
        } catch (NumberFormatException e) {
            System.err.println("error occurs : " + e.getMessage());
        }
        // redirection to list page
        gererProduits(req, resp);
        resp.sendRedirect("/gererProduits.jsp");
    }

    private void handleArchiverProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String code = req.getParameter("codePA");
        System.out.println("code: " + code);
        try {
            long codeValue = Long.parseLong(code);
            modeProd.archiverProduit(codeValue);
        } catch (NumberFormatException e) {
            System.err.println("error occurs : " + e.getMessage());
        }
        // redirection to list page
        gererProduits(req, resp);
        resp.sendRedirect("/gererProduits.jsp");
    }

    private void handleCommanderProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("commander produit ....");
        resp.sendRedirect("./cart.jsp");
    }

    private void listerProduits(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<Produit> listProduits = new ArrayList<Produit>(modeProd.getTousProduits());
        req.setAttribute("listProduits", listProduits);
        req.getRequestDispatcher("/listerProduits.jsp").forward(req, resp);
    }

    private void gererProduits(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<Produit> listProduits = new ArrayList<Produit>(modeProd.getTousProduits());
        req.setAttribute("listProduits", listProduits);
        req.getRequestDispatcher("/gererProduits.jsp").forward(req, resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("./cart.jsp");
    }
}
