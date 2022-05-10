<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccine Document</title>
<link href="../css/Add.css" rel="stylesheet">
</head>
<body>
	<center>
		<section class="container-fluid" style="background-color: lightblue;">

			<header class="container-fluid" style="background-color: pink;">
				<h1>VACCINE HOME PAGE</h1>
			</header>
		</section>
	</center>
	<br>
	<h2>${addMemberDetails}</h2>
	<form action="Vaccine.data" method="post"
		style="max-width: 350px; margin: 0 auto;">

		<center>
			<button class="btn btn-primary bbt" name="submit" type="submit">AddMember</button>
		</center>
	</form>

	<table style="width: 100%" style="solid" border="1">
		<thead>
			<tr>
				<th>NAME</th>
				<th>GENDER</th>
				<th>DOB</th>
				<th>PHOTO_ID_PROOF</th>
				<th>ID_NUMBER</th>
				<th>VACCINE_TYPE</th>
				<th>DOSE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="Details" items="${list}">
				<tr>
					<td>${Details.name}</td>
					<td>${Details.gender}</td>
					<td>${Details.dob}</td>
					<td>${Details.photoId}</td>
					<td>${Details.idNumber}</td>
					<td>${Details.vaccineType}</td>
					<td>${Details.dose}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>



</body>
</html>