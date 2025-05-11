<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Jogo</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/cadastrar-jogo.css">
</head>
<body>

	<jsp:include page="header.jsp" />
    <h2 class="titulo-cadastro">Cadastro de Jogo</h2>
    <form class="form-cadastro" action="<%= request.getContextPath() %>/processarJogo" method="post" enctype="multipart/form-data">
        <label>Título:</label>
        <input type="text" name="titulo" required><br><br>

        <label>Desenvolvedor:</label>
        <input type="text" name="desenvolvedor" required><br><br>

        <label>Ano de Lançamento:</label>
        <input type="text" name="anoLancamento" required><br><br>

        <label>Gênero:</label>
        <input type="text" name="genero" required><br><br>

        <label>Sinopse:</label>
        <textarea name="sinopse" required></textarea><br><br>

        <label>Idioma:</label>
        <input type="text" name="idioma" required><br><br>

        <label>Plataforma:</label>
        <input type="text" name="plataforma" required><br><br>

        <label>Classificação Indicativa:</label>
        <input type="text" name="classificacaoIndicativa" required><br><br>
        
          <label>Arte do Jogo:</label>
        <input type="file" name="imagemJogo" accept="image/*" required><br><br>

        <input type="submit" value="Cadastrar Jogo">
    </form>
    
    
</body>

</html>