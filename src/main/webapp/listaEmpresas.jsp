<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/removeEmpresa" var="linkServletRemoveEmpresa"/>
<c:url value="/mostraEmpresa" var="linkServletMostraEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista de Empresas</title>
	</head>
	<body>
		<c:if test="${not empty empresa}">
			Empresa ${empresa} cadastrada com sucesso! <br />	
		</c:if>	
		
		Lista de empresas: <br />	
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">				
				<li>
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
					<a href="${linkServletMostraEmpresa}?id=${empresa.id}">
						<button>Editar</button>
					</a>
					<a href="${linkServletRemoveEmpresa}?id=${empresa.id}">
						<button>Remover</button>
					</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>