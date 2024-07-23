<%@ page import="entities.Produit" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Stock</title>
    <link rel="stylesheet" href="style/main.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
    String userRole = (String) session.getAttribute("role");
    if ("admin".equals(userRole)) {
%>
<%@ include file="navbar-admin.jsp" %>
<%
} else {
%>
<%@ include file="navbar-user.jsp" %>
<%
    }
%>

<h1 class="title">Gestionnaire des produits</h1>
<hr>
<h3 class="sub-title">Gerer tous les produits</h3>
<hr>
<a href="ajouterUnProduit.jsp" class="ajout">
    <h5 class="sub-title">Ajouter des produits</h5>
</a>

<hr>
<table class="table">
    <thead>
    <tr>
        <th></th>
        <th scope="col">Code de produit</th>
        <th scope="col">Libelle</th>
        <th scope="col">Prix</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody class="table-group-divider">
    <%! List<Produit> listProduits; %>
    <%
        listProduits = (ArrayList<Produit>) request.getAttribute("listProduits");

        if (listProduits != null && !listProduits.isEmpty()) {
            for (Produit produit : listProduits) {
    %>
    <tr>
        <th>#</th>
        <th scope="row"><%= produit.getCodeProduit() %></th>
        <td><%= produit.getLibelle() %></td>
        <td><%= produit.getPrixProduit() %>DT</td>
        <td>
            <form action="./modifierUnProduit" method="post">
                <input  name="codePM" value=<%= String.valueOf(produit.getCodeProduit()) %> type="text" hidden="">
                <input type="submit" value="Modifier" class="btn btn-secondary"  style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
            </form>
        </td>
        <td>
            <form action="./archiverProduit" method="post">
                <input  name="codePA" value=<%= produit.getCodeProduit() %> type="hidden">
                <input type="submit" value="Archiver" class="btn btn-danger"  style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
            </form>
        </td>

    </tr>
    <%
        } // End of for loop
    } else {
    %><tr><td colspan="5">Aucun produit trouve</td></tr><%
        }
    %>
    </tbody>
</table>


</body>
</html>