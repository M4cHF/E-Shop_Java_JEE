package controller;

import entities.Client;
import entities.Commande;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelCommande;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CommandeServlet", urlPatterns = {"/gererCommandes" })
public class CommandeServlet extends HttpServlet {
    ModelCommande modelCommande = new ModelCommande();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n -- Commande servlet -- ");
        String servletPath = req.getServletPath();
        System.out.println("Servlet path: " + servletPath);

        switch (servletPath) {
            case "/gererCommandes":
                listerTousCommandes(req, resp);
                break;

            default:
                System.out.println("Invalid Servlet Path");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void listerTousCommandes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Commande> listCommandes = new ArrayList<Commande>(modelCommande.getCommandes());
        req.setAttribute("listCommandes", listCommandes);
        req.getRequestDispatcher("/gererCommandes.jsp").forward(req, resp);
    }


}
