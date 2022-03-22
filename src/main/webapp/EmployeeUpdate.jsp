<%@ page import="com.utar.myemployeeapp_full.model.entity.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <%
Employee emp = (Employee) request.getAttribute("EMP");
%>
    <form action="EmployeeController" method="post">
        <table>
            <tr>
                <td>Employee ID</td>
                <td>
                    <%
                        out.println("<input type=\"text\" name=\"id\" readonly value=" + emp.getId());
                    %>
                </td>
            </tr>
            <tr>
                <td>DOB</td>
                <td>
                    <%
                        out.println("<input type=\"datetime-local\" name=\"dob\" value=");
                    %>
                </td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>
                    <%
                        out.println("<input type=\"text\" name=\"fname\" value=" + emp.getFirstName());
                    %>
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>
                    <%
                        out.println("<input type=\"text\" name=\"lname\" value=" + emp.getLastName());
                    %>
                </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <%
                        out.println("<label for=\"prevgender\">(OLD) Gender:</label>" + emp.getGender() + "<br><br>");
                        out.println("<select name=\"gender\" id=\"gender\">\n" +
                                "    <option value=\"M\" selected >M</option>\n" +
                                "    <option value=\"F\">F</option>\n" +
                                "  </select>");
//                        out.println("<input list=\"gender\" name=\"gender\" value=" + emp.getGender() + ">\n" +
//                                "  <datalist id=\"gender\">\n" +
//                                "    <option value=\"M\">\n" +
//                                "    <option value=\"F\">\n" +
//                                "  </datalist>\n");
                        //out.println("<input type=\"text\" name=\"gender\" value=" + emp.getGender());
                    %>
                </td> </tr>
            <tr>
                <td>Hired Date</td>
                <td>
                    <%
                        out.println("<input type=\"text\" name=\"hdate\" value=" + emp.getHireDate());
                    %>
                </td>
            </tr>
        </table>
        <input type="submit" name="UPDATE" value="UPDATE" />
        <input type="submit" name="DELETE" value="DELETE" />
    </form>
</body>
</html>
