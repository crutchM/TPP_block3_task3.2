<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<a href="./login?act=reg">reg page</a>
<form method="post">
    <label>
        login:
        <input type="text" name="login">
    </label>
    <br>
    <label>
        Password:
        <input type="password" name="password">
    </label>
    <br>
    <input type="submit" value="log in">
    <br
    <% if(request.getAttribute("error") != null){%>
    <h1><%=request.getAttribute("error")%></h1
    <%}%>
</form>
</body>
</html>