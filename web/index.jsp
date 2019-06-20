<%--
  Created by IntelliJ IDEA.
  User: Anywhere
  Date: 6/20/2019
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="floating-labels.css" rel="stylesheet">
</head>
<body>
<%
    if (session == null || session.getAttribute("accountNo") == null) {
        // user is not logged in, do something about it
//        response.sendRedirect("index.jsp");
    } else {
        // user IS logged in, do something: set model or do whatever you need
        response.sendRedirect("transaction.jsp");
    }
%>
<form class="form-signin" action="Login" method="post">
    <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">Sing In</h1>
    </div>
    <div class="form-label-group">
        <input type="text" id="accountNo" name="accountNo" class="form-control" placeholder="Account No" required autofocus>
        <label for="accountNo">Account No</label>
    </div>
    <div class="form-label-group">
        <input type="text" id="pinNo" name="pinNo" class="form-control" placeholder="Pin No" required>
        <label for="pinNo">Pin No</label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2019-2020</p>
</form>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    // $(function() {
    //     $.ajax({
    //         type : 'GET',
    //         url: 'Login',
    //         success : function(data) {
    //             console.log(data);
    //         }
    //     });
    // });
</script>
</body>
</html>
