<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buscando Usuário</title>

<script type="text/javascript">

function excluir(id){
	/*Pergunta de confirmação da ação ao usuario*/
	if(confirm('Deseja excluir este usuário ?')){
		/*Redirecionar os dadols para o Servlet (Controle) */
		location.href = 'RemoveUser?idUser=' + id;
	}
}

</script>



</head>
<body>
	<h2>Buscando Usuários</h2>
	
	<a href="index.jsp"> Home </a> <br /><br />
	<a href="create_user.jsp"> Cadastrar Usuário</a> <br /><br />
	
	${msg }
	 
	<br />
	<br />
	
	<table border="1" title="Usuários">
		<tr>
			<th> Nome </th>
			<th> Login </th>
			<th> Editando </th>
			<th> Excluindo </th>
		</tr>
		<c:forEach var="user" items="${users }">
		<tr>
			<td> ${user.name}</td>
			<td> ${user.login}</td>
			<td> <a href="UpdateUser?cmd=update1&idUser=<c:out value="${user.id}" />"> Editar </a> </td>
			<td> <a href="#" onclick="excluir('<c:out value="${user.id}" />')">Excluir</a> </td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>