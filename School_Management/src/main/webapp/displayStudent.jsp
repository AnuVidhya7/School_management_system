<%@ page import="com.wipro.school.bean.SchoolBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Record</title>
</head>
<body>

<h2>Student Record Details</h2>
<hr>

<%
SchoolBean bean = (SchoolBean) request.getAttribute("schoolBean");
String message = (String) request.getAttribute("message");

if(bean != null){
%>

Record ID: <%=bean.getRecordId()%> <br><br>
Student Name: <%=bean.getStudentName()%> <br><br>
Class: <%=bean.getClassName()%> <br><br>
Section: <%=bean.getSection()%> <br><br>
Admission Date: <%=bean.getAdmissionDate()%> <br><br>
Age: <%=bean.getAge()%> <br><br>
Remarks: <%=bean.getRemarks()%> <br><br>

<%
}
else{
%>

<%=message%>

<%
}
%>

<br><br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
