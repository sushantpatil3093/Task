<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
    <h1 align="center">Loan List</h1>
    <hr>
    <div class="container">
    <table class="table table-striped">
        <tr>
            <th>Loan ID</th>
            <th>Loanee</th>
            <th>Description</th>
            <th>Mobile No</th>
            <th>Disbursal Date</th>
            <th>Next Due Date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="l" items="${list}">
            <tr>
                <td>${l.loanId}</td>
                <td>${l.loanee}</td>
                <td>${l.description}</td>
                <td>${l.mobileNo}</td>
                <td>${l.disbDate}</td>
                <td>${l.nextDueDate}</td>
                <td><a href="editLoan?loanId=${l.loanId}"><button class="btn btn-secondary">Edit</button></a></td>
                <td><a href="deleteLoan?loanId=${l.loanId}"><button class="btn btn-danger">Delete</button></a></td>
            </tr>
            </c:forEach>
            </table>
            <a href="add-data" ><button class="btn btn-success"><img th:src="" />Add<h9>
            </h9></button></a>
    </div>

</body >-->
