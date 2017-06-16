<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Contas a pagar e receber</title>
</head>
<body>

	<table style="height: 10px; width: 775px;" border="1">
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Paga?</th>
			<th>Data de pagamento</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${contas}" var="conta">
			<tr>
				<td>${conta.id}</td>
				<td>${conta.descricao}</td>
				<td>${conta.valor}</td>
				<td>${conta.tipo}</td>

				<td id="conta_${conta.id}"><c:if test="${conta.paga eq false}">
						<a href="#" onclick="pagarAgora(${conta.id})">Pagar Agora!</a>
					</c:if> <c:if test="${conta.paga eq true}">
						Paga
					</c:if></td>

				<td><fmt:formatDate value="${conta.dataPagamento.time}"
						pattern="dd/MM/yyyy" /></td>

				<td><a href="removeConta?id=${conta.id}">Remover</a> | <a
					href="mostraConta?id=${conta.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<script src="resources/js/jquery.js"></script>
	<script>
// 		function deuCerto(dadosDaResposta) {
// 			alert("Conta paga com sucesso!");
// 		}	
	
		/*function pagarAgora(id) {
			alert("id = " + id);
		    $.get("pagaConta?id="+id, deuCerto);
			alert("id = " + id);

		}*/
		
		
		function pagarAgora(id) {
		    $.post("pagaConta", {'id' : id}, function() {
		      $('#conta_'+id).html('Paga');
		    });
		}
	</script>

</body>
</html>