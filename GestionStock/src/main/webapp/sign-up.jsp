<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign up</title>
    <link rel="stylesheet" href="style/login.css">
</head>
<body>
<div class="title">
    <h1 class="big-title">Gestionnaire des produits</h1>
</div>

<div class="container">
    <h1>Sign Up</h1>
    <form action="./signing" method="post">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" required>
        <br>
        <label for="email">E-mail</label>
        <input type="email" name="email" id="email"  required>
        <br>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"  required>
        <br>

        <input type="submit" name="sign-up" value="sign up">
    </form>
</div>

</body>
</html>