<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Autres</title>
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

<h1 class="title">Gestion de stock</h1>
<hr>

<h3 class="sub-title">Une autre fonctionnalite est en cours de developpement.</h3>
</body>
</html>