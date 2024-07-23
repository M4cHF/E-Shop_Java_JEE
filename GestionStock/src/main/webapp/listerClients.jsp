<%@ page import="entities.Client" %>
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

<h1 class="title">Gestionnaire des clients</h1>
<hr>
<h3 class="sub-title">Gerer tous les clients</h3>
<hr>
<table class="table">
    <thead>
    <tr>
        <th></th>
        <th scope="col">Code</th>
        <th scope="col">username</th>
        <th scope="col">E-mail</th>
        <th scope="col">Role</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody class="table-group-divider">
    <%! List<Client> listClients; %>
    <%
        listClients = (ArrayList<Client>) request.getAttribute("listClients");

        if (listClients != null && !listClients.isEmpty()) {
            for (Client client : listClients) {
    %>
    <tr>
        <th>#</th>
        <th scope="row"><%= client.getCodeClient()%></th>
        <td><%= client.getUsername() %></td>
        <td><%= client.getEmail() %></td>
        <td><%= client.getRole() %></td>
        <td>
            <form action="./makeAdmin" method="post">
                <input  name="codeC" value=<%= client.getCodeClient() %> type="text" hidden="">
                <input type="submit" value="ADMIN" class="btn btn-secondary"  style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
            </form>
        </td>
        <td>
            <form action="./deleteUser" method="post">
                <input  name="codeCS" value=<%= client.getCodeClient() %> type="hidden">
                <input type="submit" value="Delete" class="btn btn-danger"  style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
            </form>
        </td>
    </tr>
    <%
        } // End of for loop
    } else {
    %><tr><td colspan="5">Aucun client trouve</td></tr><%
        }
    %>
    </tbody>
</table>


</body>
</html>