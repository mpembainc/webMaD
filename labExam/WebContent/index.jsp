<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="student">
		Name: <input type="text" name="name"><br>
		Registration Number: <input type="text" name="regno"><br>
		Grade: <input type="text" name="grade"><br>
		Phone Number: <input type="text" name="phone"><br>
		E-mail: <input type="text" name="email"><br>
		Gender: <input type="radio" name="gender" value="male"> Male
				<input type="radio" name="gender" value="female"> Female<br>
		Registration Status: 
				<input type="radio" name="status" value="registered"> Registered
				<input type="radio" name="status" value="not registered"> Not Registered
		<br><br>
		<input type="submit" value="Save">
	</form>	
</body>
</html>