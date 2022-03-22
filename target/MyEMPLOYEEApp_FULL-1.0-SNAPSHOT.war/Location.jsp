<%--
  Created by IntelliJ IDEA.
  User: Wai Hin(Darkin)
  Date: 08/03/2022
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Location Page</title>
</head>
<body>
<h1>Location</h1>
<h2>Choose appropriate Location</h2>
<br><br>
<a href="PriorKnowledge.jsp?location=Klang Valley">Klang Valley Area</a>
<a href="PriorKnowledge.jsp?location=Non Klang Valley">Non Klang Valley Area</a>
<form action="PriorKnowledge.jsp">
    Location <input type="text" name="location" value="" />
    <input type="submit" value="Next" />
</form>
</body>
</html>
