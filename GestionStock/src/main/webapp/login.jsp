
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style/login.css">
</head>
<body>

<div class="title">
    <h1 class="big-title">Gestionnaire des produits</h1>
</div>
<div class="notice">
    <p>In order to check your cart, first you have to <b>log in</b> </p>
</div>

<div class="container">
    <h1 class="title">Login</h1>
    <form action="./logging" method="Post">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" required>
        <br>
        <label for="email">E-mail</label>
        <input type="email" name="email" id="email"  required>
        <br>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"  required>
        <br>
        <input type="submit" name="Login" value="Login">
    </form>
    <div class="centered">
        if you don't have an account, <br>
        <a class="already" href="sign-up.jsp"><b>Create an account</b></a>
    </div>
</div>


</body>
</html>