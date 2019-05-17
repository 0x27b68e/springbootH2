<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>
<h2> List All Student </h2>
<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Score</th>
  </tr>
 <c:forEach var="student" items="${listStudents}">
  <tr>
    <td>${student.id}</td>
    <td>${student.name}</td>
    <td>${student.score}</td>
  </tr>
  </c:forEach>
</table>

<a href="/" /> Home
</body>
</html>