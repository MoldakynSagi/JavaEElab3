<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Login</title>

</head>
<body>

<div class="form">

    <h1 style="text-align: center">Welcome Page</h1><br>
    <form method="post" action="" style="text-align: center">
        <label style="color: grey">Name: </label><br>
        <input type="text" required placeholder="login" name="login"><br>
        <label style="color: grey">Password: </label><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Login" style="border: 1px green; background: green; border-radius: 3px">

    </form>
</div>
</body>
</html>