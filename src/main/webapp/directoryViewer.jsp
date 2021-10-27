<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tpp.model.FileModel" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.File" %>
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
    <h1><%=request.getAttribute("date").toString()%></h1>
    <br>
    <%%>
    <h1> directory: ${path} </h1>
    <h2>
        <%File tmp = new File(request.getAttribute("path").toString() + "/..");
        if (tmp.getCanonicalPath().equals("/")){
        %>
        <a> up </a>
        <br>
        <%}else {%>
        <a href="./?path=<%=request.getAttribute("path").toString()%>/..">up</a>
        <br>


        <%
            ArrayList<FileModel> list = (ArrayList<FileModel>)request.getAttribute("content");
            for(FileModel e: list)
            {
                if(e.isDirectory()){
        %>
                <a href="./?path=<%=request.getAttribute("path").toString()%>/<%=e.getName()%>">
                    <%=e.getName()%>
                </a>

        <a >
            <%=e.getSize()%>
        </a>
        <a >
            <%=new Date(e.getRedactDate())%>
        </a>
        <br>
        <%
                }
                else{
        %>
                    <a href="http://localhost:8080/TPP_block3_task3_2_war_exploded/download/?path=<%=request.getAttribute("path")
                    .toString()%>/<%=e.getName()%>"><%=e.getName()%></a>
                    <a>     <%=e.getSize()%> </a> <a>     <%=new Date(e.getRedactDate())%></a>
        <br>
                <%
                }
            }
        %>


        <%}%>
    </h2>

<a href="./logout" >log out</a>
</body>
</html>