<%--
  Created by IntelliJ IDEA.
  User: Wai Hin(Darkin)
  Date: 05/04/2022
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization Error</title>
</head>
<body>


Authorization Issue

<%
    session.invalidate();
%>
<p><a href="index.jsp">Go Back to Main Page</a></p>

</body>
</html>
