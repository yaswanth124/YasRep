
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Personal Details</title>
<script type="text/javascript">
function confirmAction(){
    var confirmed = confirm("Are you sure? This will remove this entry forever.");
    return confirmed;
}


</script>
</head>
<body>
	<center>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div style="color: teal; font-size: 30px">Employee Personal Details</div>
		<br>
		<br>
		<c:if test="${!empty abc}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					<td>Id</td>
					<td>User Id</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>DOb</td>
					<td>Age</td>
					<td>Gender</td>
					<td>Mobile Number</td>
					<td>Email</td>
					<td>Password</td>
					<td>Temporary Address</td>
					<td>Permanent address</td>
					<!-- <td>Photo</td> -->
					<th>delete</th>
					<!-- <td>Photo</td> -->
				</tr>
				<c:forEach items="${abc}" var="abc">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						<td><c:out value="${abc.id}" /></td>
						<td><c:out value="${abc.userId}" /></td>
						<td><c:out value="${abc.firstName}" /></td>
						<td><c:out value="${abc.lastName}" /></td>
						<td><c:out value="${abc.dob}" /></td>
						<td><c:out value="${abc.age}" /></td>
						<td><c:out value="${abc.gender}" /></td>
						<td><c:out value="${abc.mobileNo}" /></td>
						<td><c:out value="${abc.email}" /></td>
						<td><c:out value="${abc.pwd}" /></td>
						<td><c:out value="${abc.tempAdd}" /></td>
						<td><c:out value="${abc.permAdd}" /></td><%-- 
						<td><c:out value="${abc.photo}" /></td> --%>
						<td><a href="edit.html?id=${abc.id}">Edit</a> |<a href="delete.html?id=${abc.id}" onclick="confirmAction()">Delete</a></td>
					<%-- 	<td><c:out value="${abc.photo}" /></td> --%>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br> <a href="register.html">add new User</a>
	</center>
</body>
</html>