<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
<style>
a { color: blue;}
</style>
</head>
<body>
<p>Add Student</p>
<form action="addStudent">
<input type="text" name="id"> Id <br />
<input type="text" name="name"> Name <br />
<input type="text" name="score"> Score <br />
<input type="submit" value="Submit">
</form>

<a href="/read">Read Student By Id  <br />  
<a href="/readByName">Read Student By Name<br />  
<a href="/readByScore">Read Student By Score<br />
<a href="/readByIdGreaterThan">Read Student By Id Greater Than<br />
<a href="/readByScoreSorted">Read Student By Score Sorted<br />

<a href="/getStudents">Read All Student<br />
<a href="/update">Update Student<br />
<a href="/delete">Delete Student
</body>
</html>