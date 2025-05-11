<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jogoseletronicos.model.Jogo" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Jogos</title>
</head>
<body>
    <h2>Lista de Jogos Cadastrados</h2>

    <%
        ArrayList<Jogo> listaJogos = (ArrayList<Jogo>) request.getAttribute("listaJogos");
        if (listaJogos != null && !listaJogos.isEmpty()) {
            for (Jogo jogo : listaJogos) {
    %>
    			<img src="uploads/<%= jogo.getImagemJogo() %>" alt="Arte do Jogo" width="200">
                <p><strong>Título:</strong> <%= jogo.getTitulo() %></p>
                <p><strong>Desenvolvedor:</strong> <%= jogo.getDesenvolvedor() %></p>
                <p><strong>Ano de Lançamento:</strong> <%= jogo.getAnoLancamento() %></p>
                <p><strong>Gênero:</strong> <%= jogo.getGenero() %></p>
                <p><strong>Sinopse:</strong> <%= jogo.getSinopse() %></p>
                <p><strong>Idioma:</strong> <%= jogo.getIdioma() %></p>
                <p><strong>Plataforma:</strong> <%= jogo.getPlataforma() %></p>
                <p><strong>Classificação Indicativa:</strong> <%= jogo.getClassificacaoIndicativa() %></p>
                <a href="editar-jogo?titulo=<%=jogo.getTitulo() %>">Editar</a><br><br>
                <form action="remover-jogo" method="POST">
    				<input type="hidden" name="titulo" value="<%= jogo.getTitulo() %>">
    				<button type="submit">Remover</button>
				</form>
                <hr>
               
    <%
            }
        } else {
    %>
        <p>Nenhum jogo cadastrado.</p>
    <%
        }
    %>
    
    <a href='index.jsp'>Cadastrar novo Jogo</a><br><br>
</body>
</html>