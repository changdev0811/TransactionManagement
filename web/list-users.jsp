<%--
  Created by IntelliJ IDEA.
  User: Anywhere
  Date: 6/20/2019
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session == null || session.getAttribute("accountNo") == null) {
        // user is not logged in, do something about it
        response.sendRedirect("index.jsp");
    }
%>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
        </li>
    </ul>
</nav>
<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <span data-feather="users"></span>
                            Users
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="bar-chart-2"></span>
                            Transactions
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h2>Users</h2>
            <form action="Register" method="post">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="accountNo">Account No</label>
                        <input type="text" name="accountNo" class="form-control" id="accountNo" placeholder="Account No">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="pinNo">Pin No</label>
                        <input type="text" name="pinNo" class="form-control" id="pinNo" placeholder="Pin No">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="contactNo">Contact No</label>
                        <input type="text" name="contactNo" class="form-control" id="contactNo" placeholder="Contact No">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Account No</th>
                        <th>Pin No</th>
                        <th>Contact No</th>
                    </tr>
                    </thead>
                    <tbody>
                        <%--<c:forEach items="${users}" var="user">--%>
                            <%--<tr>--%>
                                <%--<td>1</td>--%>
                                <%--<td><c:out value="${user.getAccountNo}"/></td>--%>
                                <%--<td><c:out value="${user.getPinNo}"/></td>--%>
                                <%--<td><c:out value="${user.getContactNo}"/></td>--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
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

    // });
</script>
</body>
</html>
