<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="/login">
    <input type="text" name="email" placeholder="Email"/><br>
    <input type="password" name="password" placeholder="Password"><br>
    <button>Login</button>
    <a href="/registration">Registration</a>
</form>
</body>
</html>