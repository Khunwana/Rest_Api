<html>
<head>
<title>Education</title>
</head>
<body>
<h1>Education</h1>
<br>
<h3>${educations }</h3>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>DURATIION</th>
			<th>STREAM</th>
			<th>INSTITUTION</th>
			<th>PLACE</th>
			<th>DESCRIPTION</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${educations }" var="educations">
			<tr>
				<td>${education.id}</td>
				<td>${education.due_year}</td>
				<td>${education.course_stream}</td>
				<td>${education.institution}</td>
				<td>${education.place_institution}</td>
				<td>${education.description}</td>
				<td><a href="delete-edu?id">DELETE ${education.id}</td>
			</tr>
		<c:forEach>
	</tbody>
</table>
<a href="/add-education" class="btn btn-success">New education</a>
</body>
</html>
String due_year,String course_stream,String institution,String place_institution,String description