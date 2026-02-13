<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student Record</title>
</head>
<body>
<h2>View Student Record</h2>
<form action="MainServlet" method="post">
<!-- Hidden field to identify operation -->
    <input type="hidden" name="operation" value="viewRecord">
    <label>Student Name:</label>
    <input type="text" name="studentName" required>
    <br><br>
    <label>Admission Date:</label>
    <input type="date" name="admissionDate" required>
    <br><br>
    <input type="submit" value="View Record">
    <input type="reset" value="Clear">
</form>
<br><br>
<a href="menu.html">Back to Menu</a>
</body>
</html>
