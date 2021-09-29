<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
    <h1> directory: ${path} </h1>
    <h2>
        <%
            if(request.getAttribute("content") == null){
                %>
            <br>
            <a> пиздец посыпалось</a>
            <%}
                else{
                ArrayList<String> list = (ArrayList<String>) request.getAttribute("content");
                for(String e: list)
                {
                    %>
                    <a> <%=e%> </a>
                    <br>
            <%
                }
            }
            %>
    </h2>
</body>
</html>