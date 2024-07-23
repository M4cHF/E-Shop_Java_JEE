<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">G-Stock</a>
        <p class="admin">Admin</p>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="./listerClients">Lister Clients</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./gererProduits">Gerer Produits</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./gererCommandes">Gerer Commandes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="autres.jsp">Autres</a>
                </li>
            </ul>
        </div>
        <form action="./logout" method="post">
            <input type="submit" class="btn btn-outline-danger mg-l-5" value="Log Out" />
        </form>
    </div>
</nav>