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
    <title>Transaction</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="dashboard.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="Logout">Sign out</a>
            </li>
        </ul>
    </nav>
    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <c:if test = "${userLevel == 2}">
                            <li class="nav-item">
                                <a class="nav-link" href="users.jsp">
                                    <span data-feather="users"></span>
                                    Users
                                </a>
                            </li>
                        </c:if>
                        <li class="nav-item">
                            <a class="nav-link active" href="transactions.jsp">
                                <span data-feather="bar-chart-2"></span>
                                Transactions
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                <h2>Transactions</h2>
                <c:if test = "${userLevel == 2}">
                    <form action="Transactions" method="post">
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="accountNo">Account No</label>
                                <input type="text" name="accountNo" class="form-control" id="accountNo" placeholder="Account No">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="description">Description</label>
                                <input type="text" name="description" class="form-control" id="description" placeholder="Description">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="criteria">Criteria</label>
                                <input type="text" name="criteria" class="form-control" id="criteria" placeholder="Criteria">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="result">Result</label>
                                <select class="form-control" name="result" id="result">
                                    <option value="Win">Win</option>
                                    <option value="Lose">Lose</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="stack">Stack</label>
                                <input type="text" name="stack" class="form-control" id="stack" placeholder="Stack">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="price">Price</label>
                                <input type="text" name="price" class="form-control" id="price" placeholder="Price">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="direction">Direction</label>
                                <select class="form-control" name="direction" id="direction">
                                    <option value="Credit">Credit</option>
                                    <option value="Debit">Debit</option>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </c:if>
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>AccountNo</th>
                            <th>Description</th>
                            <th>Criteria</th>
                            <th>Result</th>
                            <th>Stack</th>
                            <th>Price</th>
                            <th>Amount</th>
                            <th>Direction</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${transactions}" var="transaction" varStatus="no">
                                <tr>
                                    <td><c:out value="${no.count}"/></td>
                                    <td><c:out value="${transaction.accountNo}"/></td>
                                    <td><c:out value="${transaction.description}"/></td>
                                    <td><c:out value="${transaction.criteria}"/></td>
                                    <td><c:out value="${transaction.result}"/></td>
                                    <td><c:out value="${transaction.stack}"/></td>
                                    <td><c:out value="${transaction.price}"/></td>
                                    <td><c:out value="${transaction.amount}"/></td>
                                    <td><c:out value="${transaction.direction}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <p class="text-success d-inline">Income : ${income}</p>
                    <p class="text-danger d-inline">Outgoing: ${outgoing}</p>
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
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    // $(function() {

    // });
</script>
</body>
</html>
