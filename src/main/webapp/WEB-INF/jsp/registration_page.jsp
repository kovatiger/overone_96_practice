<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/registration">
    <input type="text" name="firstname" placeholder="Firstname"/><br>
    <input type="text" name="lastname" placeholder="Lastname"/><br>
    <input type="text" name="email" placeholder="Email"/><br>
    <input type="password" name="password" placeholder="Password"><br>
    <input type="password" name="repassword" placeholder="Repeat password"><br>
    <button>Registration</button>
    <a href="/login">Authorization</a>
</form>
</body>
</html>