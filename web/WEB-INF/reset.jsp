<%-- 
    Document   : reset
    Created on : Nov 22, 2020, 6:18:52 PM
    Author     : 838771
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Notes</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Please enter your email address to reset your password.</p>
        <form method="POST" action="reset">
            Email Address: <input type="text" name="email" value="${email}"><br>
            <input type="submit">
        </form>
        
    </body>
</html>
