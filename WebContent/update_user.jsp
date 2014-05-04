<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editando Usuário</title>
</head>
<body>

	<form action="UpdateUser?cmd=update2" method="post" accept-charset="UTF-8">
	
		<fieldset>
			<legend>Editando Usuário</legend>
			
			Nome: <input type="text" name="name" value="${name} "/> <br /><br />
			Login: <input type="text"  name="login" value="${login} "/> <br /><br />
			Password: <input type="password" name="password" value="${password}" /> <br /><br />
				
			<input type="hidden"  name="id" value="${id }"/>
			<input type="submit" value="Editar" />
		</fieldset>
	
	</form>


</body>
</html>