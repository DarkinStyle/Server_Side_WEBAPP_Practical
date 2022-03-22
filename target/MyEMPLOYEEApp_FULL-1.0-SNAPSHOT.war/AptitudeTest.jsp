<%@ page import="com.utar.myemployeeapp_full.weblisteners.UserTrackingListener" %>
<%@page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aptitude Test</title>

    <style>

        body {
            font-family: Arial, Helvetica, sans-serif;}
        * {
            box-sizing: border-box;
        }
        /* Button used to open the contact form - fixed at the bottom of the page */
        .open-button {
            background-color: #555;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            opacity: 0.8;
            position: fixed;
            bottom: 23px;
            right: 28px;
            width: 280px;
        }
        /* The popup form - hidden by default */
        .form-popup {
            overflow-x: hidden;
            overflow-y: auto;
            height: 400px;
            display: none;
            position: fixed;
            top: 60%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        /* Add styles to the form container */
        .form-container {
            max-width: 500px;
            padding: 10px;
            background-color: white;
        }
        /* Full-width input fields */
        .form-container input[type=text], .form-container input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            border: none;
            background: #f1f1f1;
        }
        /* When the inputs get focus, do something */
        .form-container input[type=text]:focus, .form-container input[type=password]:focus
        {
            background-color: #ddd;
            outline: none;
        }

        /* Set a style for the submit button */
        .form-container .btn {
            background-color: #4CAF50;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            width: 100%;
            margin-bottom: 10px;
            opacity: 0.8;
        }
        /* Add a red background color to the cancel button */
        .form-container .cancel {
            background-color: red;
        }
        /* Add some hover effects to buttons */
        .form-container .btn:hover, .open-button:hover {
            opacity: 1;
        }
    </style>
</head>

<body>
<h2>Aptitude - Popup Form</h2>

<%--<%--%>
<%--    out.println("Number of users viewed the test:" + UserTrackingListener.getActiveSessions());--%>
<%--%>--%>
<div style= "margin-left: 400px;margin-top: 200px; background-color: #ffcccc ; width:35% " >
    <h2 style="text-align: center">Aptitude Test</h2>
        <%
Cookie[] cookies = request.getCookies();
if (cookies != null) {
Cookie cookie;
for (int i = 0; i < cookies.length; i++) {
cookie = cookies[i];
if (cookie.getName().equals("UserID")) {
out.println("Your User ID is" + "\n" + cookie.getValue());
}
}
}
%>
<p>Click on the button at the bottom of this page to open the
    Aptitude Test form.</p>
<button class="open-button" onclick="openForm()">Open Form</button>
<div class="form-popup" id="myForm">

    <form action="Apt" class="form-container" method="post">
        <h1>Numerical Test</h1>
        <table>
            <tbody>
            <tr style="font-size: large; font-weight: bold">
                <td>Question 1</td>
            </tr>
            <tr style="font-weight: bold">
                <td>Find the missing number: 10, 20,?,40</td>
                <td>&nbsp;</td>
                <td><input type="radio" name="Answer1" value="30" />30</td>
                <td><input type="radio" name="Answer1" value="25" />25</td>
                <td><input type="radio" name="Answer1" value="35" />35</td>
                <td><input type="radio" name="Answer1" value="20" />20</td>
                <input type="hidden" id="Answer1" name="Answer1" value="empty"/>
            </tr>
            <tr style="font-size: large; font-weight: bold">
                <td>Question 2</td>
            </tr>
            <tr style="font-weight: bold">
                <td>Find the missing number: 1,2,3,6,?,24,48</td>
                <td>&nbsp;</td>
                <td><input type="radio" name="Answer2" value="16" />16</td>
                <td><input type="radio" name="Answer2" value="10" />10</td>
                <td><input type="radio" name="Answer2" value="12" />12</td>
                <td><input type="radio" name="Answer2" value="14" />14</td>
                <input type="hidden" id="Answer2" name="Answer2" value="empty"/>
            </tr>
            <tr style="font-size: large; font-weight: bold">
                <td>Question 3</td>
            </tr>
            <tr style="font-weight: bold">
                <td>Find the missing number: 2,12,60,240,?</td>
                <td>&nbsp;</td>
                <td><input type="radio" name="Answer3" value="540" />540</td>
                <td><input type="radio" name="Answer3" value="480" />480</td>
                <td><input type="radio" name="Answer3" value="720" />720</td>
                <td><input type="radio" name="Answer3" value="380" />380</td>
                <input type="hidden" id="Answer3" name="Answer3" value="empty"/>
            </tr>
            <tr style="font-size: large; font-weight: bold">
                <td>Question 4</td>
            </tr>
            <tr style="font-weight: bold">
                <td>Find the missing number: 17,12,?,5,3</td>
                <td>&nbsp;</td>
                <td><input type="radio" name="Answer4" value="6" />6</td>
                <td><input type="radio" name="Answer4" value="8" />8</td>
                <td><input type="radio" name="Answer4" value="9" />9</td>
                <td><input type="radio" name="Answer4" value="7" />7</td>
                <input type="hidden" id="Answer4" name="Answer4" value="empty"/>
            </tr>

            <tr style="font-size: large; font-weight: bold">
                <td>Question 5</td>
            </tr>
            <tr style="font-weight: bold">
                <td>Find the missing number: 24,29,36,41,?,53</td>
                <td>&nbsp;</td>
                <td><input type="radio" name="Answer5" value="45" />45</td>
                <td><input type="radio" name="Answer5" value="46" />46</td>
                <td><input type="radio" name="Answer5" value="48" />48</td>
                <td><input type="radio" name="Answer5" value="47" />47</td>
                <input type="hidden" id="Answer5" name="Answer5" value="empty"/>
            </tr>

            </tbody>
        </table>
        <button type="submit" class="btn">Submit Test</button>
        <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        <button type="reset" class="btn">Reset</button>
    </form>
</div>
<script>
    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }
    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }
</script>
</body>
</html>