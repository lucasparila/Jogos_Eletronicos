<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jogoseletronicos.model.Jogo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Busca</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
</head>

<jsp:include page="header.jsp" />

<h2>Resultado da Busca</h2>

<%
    Jogo jogo = (Jogo) request.getAttribute("jogo");
    String mensagem = (String) request.getAttribute("mensagem");

    if (jogo != null) {
%>
    <p><strong>Título:</strong> <%= jogo.getTitulo() %></p>
    <p><strong>Desenvolvedor:</strong> <%= jogo.getDesenvolvedor() %></p>
    <p><strong>Ano de Lançamento:</strong> <%= jogo.getAnoLancamento() %></p>
    <p><strong>Gênero:</strong> <%= jogo.getGenero() %></p>
    <p><strong>Sinopse:</strong> <%= jogo.getSinopse() %></p>
    <p><strong>Idioma:</strong> <%= jogo.getIdioma() %></p>
    <p><strong>Plataforma:</strong> <%= jogo.getPlataforma() %></p>
    <p><strong>Classificação Indicativa:</strong> <%= jogo.getClassificacaoIndicativa() %></p>
    <img src="uploads/<%= jogo.getImagemJogo() %>" alt="Arte do Jogo" width="200">
<%
    } else {
%>
    <p><%= mensagem %></p>
<%
    }
%>

</html>