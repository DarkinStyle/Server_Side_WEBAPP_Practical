<%@ page import="com.utar.myemployeeapp_full.model.javabean.RegisterInfo" %><%--
  Created by IntelliJ IDEA.
  User: Wai Hin(Darkin)
  Date: 15/03/2022
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>


    <%
        RegisterInfo c = (RegisterInfo) request.getSession().getAttribute("reg1");
    out.println("<div style= \"margin-left: 400px;margin-top: 200px; background-color: #ffcccc; width:30%\">");
//Write some codes here to display the output….
    out.println("<h2>Welcome aboard " + c.getFname() + " " + c.getLname() + "</h2>");
    out.println("<h3>Your Registration Is Success</h3>");
    %>

<%--    RequestDispatcher rd = request.getRequestDispatcher("/navigation_link.html");--%>
<%--    rd.include(request, response);--%>

<jsp:include  page="navigation_link.html"/>
<%
out.println("<br>");
    out.println("<h4>Should you need technical support, contact us via email or phone</h4>");
    out.println("Email: " + " " + request.getServletContext().getInitParameter("Email"));
    out.println("&nbsp;&nbsp;Phone: " + " " + request.getServletContext().getInitParameter("Phone"));
    out.println("</div");


%>

</body>
</html>
