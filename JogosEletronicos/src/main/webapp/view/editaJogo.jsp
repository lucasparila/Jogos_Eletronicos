<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jogoseletronicos.model.Jogo" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Jogo</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
</head>
<body>
	<jsp:include page="header.jsp" />
    <h2>Edição do Jogo</h2>
    <% 
    	Jogo jogo = (Jogo) request.getAttribute("jogo");
    %>
    <form action="<%= request.getContextPath() %>/editar-jogo" method="post">
        <label>Título:</label>
        <input type="text" name="titulo" value ="<%= jogo.getTitulo()%>"><br><br>

        <label>Desenvolvedor:</label>
        <input type="text" name="desenvolvedor" value = "<%= jogo.getDesenvolvedor()%>"><br><br>

        <label>Ano de Lançamento:</label>
        <input type="text" name="anoLancamento" value = "<%= jogo.getAnoLancamento() %>"><br><br>

        <label>Gênero:</label>
        <input type="text" name="genero" value="<%= jogo.getGenero()%>"><br><br>

        <label>Sinopse:</label>
        <textarea name="sinopse" ></textarea><%= jogo.getSinopse()%><br><br>

        <label>Idioma:</label>
        <input type="text" name="idioma" value ="<%= jogo.getIdioma()%>" ><br><br>

        <label>Plataforma:</label>
        <input type="text" name="plataforma" value ="<%= jogo.getPlataforma()%>"><br><br>

        <label>Classificação Indicativa:</label>
        <input type="text" name="classificacaoIndicativa" value ="<%= jogo.getClassificacaoIndicativa()%>"><br><br>

        <input type="submit" value="Atualizar Jogo">
    </form>
</body>
</html>