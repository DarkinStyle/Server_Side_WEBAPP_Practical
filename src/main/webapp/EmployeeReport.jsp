<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Wai Hin(Darkin)
  Date: 31/03/2022
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Employee Report</h1>
<%
    List<String> map = (List<String>) request.getAttribute("RESULTS");
%>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Description</th>
        <th scope="col">Figures</th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 0;
        for (String c : map) {
        i++;
        String[] s = c.split(":");
    %>
    <tr>
        <th scope="row"><%=i%></th>
        <td><%=s[0]%>
        </td>
        <td><%=s[1]%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>
