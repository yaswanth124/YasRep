<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
<!-- <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel='stylesheet' type='text/css' href='jquery-ui.css' /> -->


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>





<script language="JavaScript">
	function Validate() {
		var s = document.getElementById("image").value;
		if (image != '') {
			var checkimg = image.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
				alert("Please enter Image File Extensions .jpg,.png,.jpeg");
				document.getElementById("image").focus();
				return false;
			}
		}
		return true;
	}
</script>

<script type="text/javascript">
	function formsubmit() {
		var fname = document.getElementById('First_Name').value;
		var lname = document.getElementById('Last_Name').value;
		var mno = document.getElementById('Mobile_Number').value;
		var email = document.getElementById('email').value;
		if (document.form1.First_Name.value == '' || fname.length < 4
				|| document.form1.Last_Name.value == '' || lname.length < 4
				|| document.form1.Mobile_Number.value == '' || mno.length < 10
				|| document.form1.email.value == '') {
			message16.innerHTML = "Fill the required field";
			return false;
		} else {
			return true;
		}
	}
	function onlyAlphabets(e) {
		if (window.event) {
			var charCode = window.event.keyCode;
		} else if (e) {
			var charCode = e.which;
		} else {
			return true;
		}
		if ((charCode > 64 && charCode < 91)
				|| (charCode > 96 && charCode < 123)) {
			return true;
		} else {
			return false;
		}
	}
	function allaplh(inputtxt4) {
		var numbers = /^[A-Za-z]{4,10}$/g;
		var message = document.getElementById('message2');
		if (inputtxt4.value.match(numbers)) {
			message.innerHTML = "";
			return true;
		} else {
			message.innerHTML = "Enter Minimum 4 Characters ";
			return false;
		}

	}

	function allaplh1(inputtxt1) {
		var numbers = /^[A-Za-z]{4,10}$/g;
		var message = document.getElementById('message3');
		if (inputtxt1.value.match(numbers)) {
			message.innerHTML = "";
			return true;
		} else {
			message.innerHTML = "Enter Minimum 4 Characters ";
			return false;
		}
	}
	function allnumeric(inputtxt) {
		var numbers = /^[7-9][0-9]{9}$/g;
		var message = document.getElementById('message');
		if (inputtxt.value.match(numbers)) {
			message.innerHTML = "";

			return true;
		} else {
			message.innerHTML = "Enter 10 digit Number ";

			return false;
		}
	}
	function isNumber(evt) {
		evt = (evt) ? evt : window.event;
		var charCode = (evt.which) ? evt.which : evt.keyCode;
		if (charCode > 31 && (charCode < 48) || (charCode > 57)) {
			return false;
		}
		return true;
	}

	function emailvalid() {
	     var x = document.forms["form1"]["email"].value;
	    var message=document.getElementById('message4');
	    var atpos = x.indexOf("@");
	    var dotpos = x.lastIndexOf(".");
	    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	        message.innerHTML="Enter valid e-mail";
	        return false;
	    }
	    else
	    {  message.innerHTML="";
	    } 
	  
	}

</script>

<script>
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#image').attr('src', e.target.result).width(99).height(99);
			};

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>


<style type="text/css">
#image {
	float: right;
	left: 60%;
	top: 34.5%;
	/* width:100px;
	height:30px; */
	position: absolute;
}

image.resize {
	max-width: 50%;
	max-height: 50%;
}
</style>



</head>
<body>
	<center>
		<fieldset
			style="width: 550px; border: 1px solid; border-radius: 10px; box-shadow: 2.5px 3px 2px grey; margin-top: 150px">

			<legend style="color: teal; font-size: 30px">Registration
				Form</legend>
			<br> <br>
			<!-- 	<div style="color: teal; font-size: 30px">Registration Form</div> -->

			<c:url var="userRegistration" value="saveUser.html" />
			<form:form id="registerForm" modelAttribute="user" method="post"
				name="form1" action="${userRegistration}"
				onsubmit="return formsubmit()">
				<table width="400px" height="150px">

						<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id"  readonly="true"/></td>
				</tr>
				
				
						<tr>
					<td><form:label path="userId">User Id</form:label></td>
					<td><form:input path="userId"  readonly="true"/></td>
				</tr>
				
				
					<tr>
						<td><form:label path="firstName">First Name</form:label></td>
						<td><form:input path="firstName" id="First_Name" 
								maxlength="30" onkeypress="return onlyAlphabets(event);"
								onkeyup="allaplh(document.form1.FirstName);" required="required" />

						</td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last Name</form:label></td>
						<td><form:input path="lastName" id="Last_Name" maxlength="30"
								onkeypress="return onlyAlphabets(event);"
								onkeyup="allaplh(document.form1.LastName);" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="dob">Date of Birth</form:label></td>
						<td><form:input type="text" path="dob" id="dob"
								required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="age">Age</form:label></td>
						<!-- 	<td><p   id="age"/></td> -->
						<td><form:input type="text" path="age" id="age"></form:input></td>
						<%-- 	<td><form:input type="text" path="age" id="age" /></td> --%>
					</tr>
					<tr>
						<td><form:label path="gender">Gender</form:label></td>
						<td><form:radiobuttons path="gender" items="${model.gender}"
								required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="mobileNo">Mobile Number</form:label></td>
						<td><form:input path="mobileNo" id="Mobile_Number"
								onkeypress="return isNumber(event)" maxlength="10"
								onkeyup="allnumeric(document.form1.MobileNumber);" /></td>
					</tr>
					<tr>
						<td><form:label path="email">Email</form:label></td>
						<td><form:input path="email" maxlength="100"
								onkeyup="emailvalid(document.form1.email);" id="email"
								required="required" /> <span id="message4"></span></td>
					</tr>
					<tr>
						<td><form:label path="pwd">Password</form:label></td>
						<td><form:password path="pwd" /></td>
					</tr>
					<tr>
						<td><form:label path="tempAdd">Temporary Address</form:label></td>
						<td><form:textarea path="tempAdd" rows="5" cols="20"></form:textarea></td>
					</tr>
					<tr>
						<td><form:label path="permAdd">Permanent Address</form:label></td>
						<td><form:textarea path="permAdd" rows="5" cols="20"></form:textarea></td>
					</tr>
					<%-- <tr>
						<td><form:label path="photo">Image</form:label></td>
						<td><form:input path="photo" type='file'
								onchange="readURL(this);" /> <img
							src="img/images.png"
							id="image" class="resize" /></td>
						<td>
					</tr> --%>
				</table>
				<br>
				<br>
				<input type="submit" value="Register" />
			</form:form>
			<br> <a href="userList.html">Click Here to see User List</a>
	</center>
	<script type="text/javascript">
	$('#dob').datepicker({
	    onSelect: function(value, ui) {
	        var today = new Date(), 
	            dob = new Date(value), 
	            age = new Date(today - dob).getFullYear() - 1970;
	        
	        $('#age').text(age);
	        document.getElementById('age').value = age;
	    },
	    maxDate: '+0d',
	    yearRange: '1920:2016',
	    changeMonth: true,
	    changeYear: true
	   
	});
</script>
</body>
</html>
