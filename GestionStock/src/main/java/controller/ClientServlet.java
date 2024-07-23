package controller;

import entities.Client;
import entities.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelClient;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClientServlet", urlPatterns = {"/listerClients" , "/makeAdmin", "/deleteUser"})
public class ClientServlet extends HttpServlet {
    ModelClient modelClient = new ModelClient();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n -- Client servlet -- ");
        String servletPath = req.getServletPath();
        System.out.println("Servlet path: " + servletPath);

        switch (servletPath) {
            case "/listerClients":
                listerTousClients(req, resp);
                break;
            case "/makeAdmin":
                makeUserAsAdmin(req, resp);
                break;
            case "/deleteUser":
                supprimerClient(req, resp);
                break;
            default:
                System.out.println("Invalid Servlet Path");
        }


    }

    private void makeUserAsAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("codeC");
        System.out.println("code: " + code);
        try {
            long codeValue = Long.parseLong(code);
            modelClient.changerRole(codeValue);
        } catch (NumberFormatException e) {
            System.err.println("error occurs : " + e.getMessage());
        }
        // redirection to list page
        listerTousClients(req, resp);
        resp.sendRedirect("/listerClients.jsp");
    }

    private void listerTousClients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Client> listClients = new ArrayList<Client>(modelClient.getTousClients());
        req.setAttribute("listClients", listClients);
        req.getRequestDispatcher("/listerClients.jsp").forward(req, resp);
    }

    private void supprimerClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("codeCS");
        System.out.println("code: " + code);
        try {
            long codeValue = Long.parseLong(code);
            modelClient.supprimerClient(codeValue);
        } catch (NumberFormatException e) {
            System.err.println("error occurs : " + e.getMessage());
        }
        // redirection to list page
        listerTousClients(req, resp);
        resp.sendRedirect("/listerClients.jsp");
    }
}
