<%--&lt;%&ndash;--%>
  Created by IntelliJ IDEA.
  User: Wai Hin(Darkin)
  Date: 05/04/2022
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<%--j_security check is a built-in servlet in jboss for authentication--%>
    <form method="post" action='<%=response.encodeURL("j_security_check")%>'>

        Username: <input type="text" name="j_username">

        Password: <input type="passwordt" name="j_password">

        <input type="submit" value="Log In"/>

    </form>

</body>
</html>
