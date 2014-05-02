<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Cadastro de Usuário</h2><br/>
	
	<form action="createUser" method="post">
		${msg}
	
		<br />
		<p />
		
		Nome : <input type="text" name="name" /> <br/>
		Login : <input type="text"  name ="login"/> <br />
		Password: <input type="password"  name="password"/> <br />
		
		<input type="hidden"  name="cmd" value="create"/>
		<input type="submit" value="Cadastrar" /> 
		
	
	</form>

</body>
</html>