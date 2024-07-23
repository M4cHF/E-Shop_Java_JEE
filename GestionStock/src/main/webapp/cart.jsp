<%@ page import="entities.Produit" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%
    String username = (String) session.getAttribute("username");
    String role = (String) session.getAttribute("role");
    if (username == null || role .equalsIgnoreCase("admin")) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Cart</title>
    <link rel="stylesheet" href="style/cart.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%------------------ NAV BAR -----------------------%>
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
<%------------------ END NAV BAR -----------------------%>

<%--<%! List<Produit> listProduitsCom; %>--%>
<%--<%--%>
<%--    listProduitsCom = (ArrayList<Produit>) request.getAttribute("listProduitsCom");--%>

<%--    if (listProduitsCom != null && !listProduitsCom.isEmpty()) {--%>
<%--        for (Produit produit : listProduitsCom) {--%>
<%--%>--%>

<div class="container px-3 my-5 clearfix">
    <!-- Shopping cart table -->
    <div class="card">
        <div class="card-header">
            <h2>Shopping Cart</h2>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered m-0">
                    <thead>
                    <tr>
                        <!-- Set columns width -->
                        <th class="text-center py-3 px-4" style="min-width: 400px;">Product Name &amp; Details</th>
                        <th class="text-right py-3 px-4" style="width: 100px;">Price</th>
                        <th class="text-center py-3 px-4" style="width: 120px;">Quantity</th>
                        <th class="text-right py-3 px-4" style="width: 100px;">Total</th>
                        <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="p-4">
                            <div class="media align-items-center">

                                <div class="media-body">
                                    <a href="#" class="d-block text-dark" id="prod-name">Product name</a>
                                    <small>
                                        <span class="text-muted">code produit</span>
                                    </small>
                                </div>
                            </div>
                        </td>
                        <td class="text-right font-weight-semibold align-middle p-4">$57.55</td>
                        <td class="align-middle p-4"><input type="text" class="form-control text-center" value="2"></td>
                        <td class="text-right font-weight-semibold align-middle p-4">$115.1</td>
                        <td class="text-center align-middle px-0"><a href="#"><img src="images/delete.png" width="70px" height="70px"></a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!-- / Shopping cart table -->
            <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                <div class="mt-4">
                    <label class="text-muted font-weight-normal">Promocode</label>
                    <input type="text" placeholder="ABC" class="form-control">
                </div>
                <div class="d-flex">
                    <div class="text-right mt-4 mr-5">
                        <label class="text-muted font-weight-normal m-0">Discount</label>
                        <div class="text-large"><strong>$20</strong></div>
                    </div>

                    <div class="text-right mt-4 ml-2">
                        <label class="text-muted font-weight-normal m-0">Total price</label>
                        <div class="text-large"><strong>$1164.65</strong></div>
                    </div>
                </div>
            </div>

            <div class="float-right">
                <a href="./listerTousProduits">
                    <button type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3">Back to shopping</button>
                </a>
                <a href="checkout.jsp">
                    <button type="button" class="btn btn-lg btn-primary mt-2">Checkout</button>
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>

