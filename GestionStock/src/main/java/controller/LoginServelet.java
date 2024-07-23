package controller;

import entities.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ModelClient;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/logging", "/signing", "/logout" })
public class LoginServelet extends HttpServlet {
   ModelClient modelClient = new ModelClient();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n -- Login servlet -- ");
        String servletPath = req.getServletPath();
        System.out.println("Servlet path: " + servletPath);

        switch (servletPath) {
            case "/logging":
                tryingToLogIN(req, resp);
                break;
            case "/signing":
                signingUp(req, resp);
                break;
            case "/logout":
                logout(req, resp);
                break;
            default:
                System.out.println("Invalid Servlet Path");
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false); // Fetch session if exists, otherwise return null
        if (session != null) {
            session.invalidate(); // Invalidate the session if it exists
        }
        resp.sendRedirect("login.jsp");
    }


    private void tryingToLogIN(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("logging ... ");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        if(modelClient.authentification(email, password)){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", modelClient.getRole(email));

            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("login.jsp");
            System.out.println("username or email incorrect");
        }
    }

    private void signingUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Client client = new Client(username, email, password);
        modelClient.ajouterClient(client);
        // redirect to login page
        resp.sendRedirect("login.jsp");
    }
}
