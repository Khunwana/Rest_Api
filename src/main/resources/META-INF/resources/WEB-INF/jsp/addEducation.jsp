<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Add Education</title>
	</head>
	<body>
		<h1>Education</h1>
		<form:form action="" method="post" modelAttribute="education">
			Duration : <form:input type="text" path="due_year" required="required"/><br>
			<form:errors path="due_year" /><br>
			Type : <form:input type="text" path="course_stream" required="required"/><br>
			<form:errors path="course_stream" /><br>
			Institution : <form:input type="text" path="institution" required="required"/><br>
			<form:errors path="institution" /><br>
			Place : <form:input type="text" path="place_institution" required="required"/><br>
			<form:errors path="place_institution" /><br>
			Description : <form:input type="text" path="description" required="required"/><br>
			<form:errors path="description" /><br>
			<input type="submit" class="btn btn-success"/>
		</form:form>
	</body>
</html>
