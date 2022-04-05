<%--
  Created by IntelliJ IDEA.
  User: Wai Hin(Darkin)
  Date: 25/01/2022
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aptitude Results</title>
</head>
<body>

<div style="margin-left: 400px; margin-top: 200px; background-color: #ffcccc; width:30%">

    <%
        String[] s = (String[]) session.getAttribute("RESULTS");
        int totalcorrectansw = (Integer) session.getAttribute("FINALRES");
//Write some codes here..... Copy the codes from Aptitude servlet and paste it
        out.println("Your answer:");
        out.println("<br>Answer 1: " + s[0]);
        out.println("<br>Answer 2: " + s[1]);
        out.println("<br>Answer 3: " + s[2]);
        out.println("<br>Answer 4: " + s[3]);
        out.println("<br>Answer 5: " + s[4]);
        if (totalcorrectansw >= 3) {
            out.println("<br><br>Your score is " + " " + totalcorrectansw + " " + "over 5");
            out.println("<br>You have passed the test");
        } else {
            out.println("<br><br>Your score is " + " " + totalcorrectansw + " " + "over 5");
            out.println("<br>You have failed the test");
        }


        String z = request.getHeader("user-agent");
        if (!(z.contains("Firefox"))) {
            out.println("<SCRIPT type=\"text/javascript\">");
            out.println("alert(\"For better performance please use Firefox browser\")");
            out.println("</SCRIPT>");
        }

        String location = request.getParameter("location");
        String knowledge = request.getParameter("knowledge");
        out.println("<br>Your location is " + location);
        out.println("<br>Your prior knowledge is " + knowledge);
    %>

    <br><br>
    <a href="index.jsp">Main Page</a>
    <a href="downloadoption.jsp">Download Option Page</a>
</div>

</body>
</html>
