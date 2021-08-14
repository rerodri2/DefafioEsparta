<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,br.com.alura.gerenciador.modelo.Tarefa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>


		<c:import url="logout-parcial.jsp"/>



		Usuario Logado: ${usuarioLogado.login }
		
		<br>
		<br>
		<br>
	
		<c:if test="${not empty tarefa}">
			Tarefa ${tarefa} cadastrada com sucesso!
		</c:if>
		Lista de tarefas: <br/>
		
		<ul>
			<c:forEach items="${tarefas }" var="tarefa">
				<li>
				
				${tarefa.nome} -  <fmt:formatDate value="${tarefa.dataAbertura }" pattern="dd/MM/yyyy"/> 
				<a href="/gerenciador/entrada?acao=MostraTarefa&id=${empresa.id }">edite</a>
				<a href="/gerenciador/entrada?acao=RemovaTarefa&id=${empresa.id }">remove</a>
				</li>
			
			</c:forEach>
		
		</ul>

</body>
</html>