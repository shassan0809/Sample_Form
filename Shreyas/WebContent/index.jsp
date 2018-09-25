<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Form</title>
</head>
<body>
	<form method="POST" action="SampleHandler">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="uname" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="uage" /></td>
			</tr>
			<tr>
				<td>Occupation:</td>
				<td><input type="text" name="uoccu" /></td>
			</tr>
		</table>
		<input type="submit" value="submit" />
	</form>
</body>
</html>