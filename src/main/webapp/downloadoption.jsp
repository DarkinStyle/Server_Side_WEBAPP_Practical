<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body style="background-color:powderblue;">
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        Cookie cookie;
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equals("UserID")) {
                out.println("Hai User!" + "\n" + cookie.getValue());
            }
        }
    }
%>
<h1>Download School Calendar</h1>
<a href="download?type=pdf"><img style="border:0;" src="images/pdf.jpg" alt="HTML tutorial" width="42" height="42"></a>
<a href="download?type=excel"><img style="border:0;" src="images/excel.jpg" alt="HTML tutorial" width="42" height="42"></a>
<a href="download?type=word"><img style="border:0;" src="images/word.jpg" alt="HTML tutorial" width="42" height="42"></a>
</body>
</html>