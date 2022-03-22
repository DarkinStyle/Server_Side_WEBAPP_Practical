<%--
  Created by IntelliJ IDEA.
  User: Wai Hin(Darkin)
  Date: 08/03/2022
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>PriorKnowledge</h1>
<%
        String location = request.getParameter("location");
        out.println("You chose " + location);
        out.println("<br><br>");
        out.println("<a href=\"" + "display.jsp?location=" + location + "&knowledge=diploma" + "\">Diploma</a>");
        out.println("<a href=\"" + "display.jsp?location=" + location + "&knowledge=bachelor" + "\">Bachelor</a>");
    out.println("<a href=\"" + "display.jsp?location=" + location + "&knowledge=master" + "\">Master</a>");

    out.println("<FORM METHOD=\"GET\"ACTION=\"display.jsp\">");
    out.println("<BR>Now enter your prior qualification: ");
    out.println("<INPUT TYPE =text NAME=\"knowledge\">");
// However, we also want to keep track of which user is on the system
    out.println("<INPUT TYPE=hidden NAME=\"location\" VALUE=\"" + location + "\">");
    out.println("<BR><BR><INPUT TYPE=submit value=\"Submit Form\">");
    out.println("</form>");
%>