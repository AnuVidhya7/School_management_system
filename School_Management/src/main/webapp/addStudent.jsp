<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student Record</title>
</head>
<body>
<h2>Add Student Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord">
<label>Student Name:</label>
<input type="text" name="studentName" required>
<br><br>
<label>Class:</label>
<input type="text" name="className" required>
<br><br>
<label>Section:</label>
<input type="text" name="section">
<br><br>
<label>Admission Date:</label>
<input type="date" name="admissionDate" required>
<br><br>
<label>Age:</label>
<input type="number" name="age" min="1" max="100">
<br><br>
<label>Remarks:</label>
<input type="text" name="remarks">
<br><br>
<input type="submit" value="Add Record">
<input type="reset" value="Clear">
</form>
<br><br>
<a href="menu.html">Back to Menu</a>
</body>
</html>
