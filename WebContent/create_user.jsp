<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>

	<h2>Cadastro de Usuário</h2><br/>
	
	<form action="CreateUser" method="post">
		${msg}
	
		<br />
		<p />
		
		Nome : <input type="text" name="name" /> <br/>
		Login : <input type="text"  name ="login"/> <br />
		Password: <input type="password"  name="password"/> <br />
		
		<input type="submit" value="Cadastrar" />
		
		<a href="index.jsp"> Voltar </a> 		
	</form>
	

</body>
</html>