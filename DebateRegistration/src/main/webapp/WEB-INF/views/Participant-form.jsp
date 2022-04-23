<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Participant</title>
</head>

<body>

	<div class="container">

		<h3>Participant Management</h3>
		<hr>

		<p class="h4 mb-4">Enter Participant</p>

		<form action="/Debate/registration/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Participant.id}" />

			<div class="form-inline">
				<input type="text" name="name" value="${Participant.name}"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>
			<div class="form-inline">
				<input type="text" name="department"
					value="${Participant.department}" class="form-control mb-4 col-4"
					placeholder="Category">
			</div>

			<div class="form-inline">
				<input type="text" name="country" value="${Participant.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Debate/registration/list">Back to Participants List</a>

	</div>
</body>
</html>
