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
    <title>Modifier un produit</title>
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
<%! String codeProMod; %>
<%  codeProMod = (String) request.getAttribute("codeProMod");

%>
<div class="formlaire-ajout">
    <h3 class="sub-title">Modifier un produit</h3>
    <form class="row g-3"   action="./modifierProduit" method="Post">
        <label for="code-prod" class="form-label">Code de produit</label>
        <input type="text" class="form-control" id="code-prod" name="code-prod" value=<%= codeProMod %> required>

        <label for="libelle-prod" class="form-label">Libelle de produit</label>
        <input type="text" class="form-control" id="libelle-prod" name="libelle-prod" required>

        <label for="prix-prod" class="form-label">Prix de produit</label>
        <input type="text" class="form-control" id="prix-prod" name="prix-prod" required>

        <input type="submit" class="btn btn-info" value="Modifier Produit">

    </form>
</div>
<hr>



</body>
</html>