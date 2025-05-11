<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
</head>

<%
    String contextPath = ((HttpServletRequest) request).getContextPath();
%>

<header>
    <nav>
        <ul>
            <li><a href="<%= contextPath %>/index.jsp">Home</a></li>
            <li><a href="<%= contextPath %>/view/sobre-sistema.jsp">Sobre o Sistema</a></li>
            <li><a href="<%= contextPath %>/view/cadastrar-jogo.jsp">Login</a></li>
        </ul>
    </nav>

    <!-- Campo de busca -->
    <form action="<%= request.getContextPath() %>/buscar-jogo" method="post">
        <input type="text" name="titulo" placeholder="Buscar jogo..." required>
        <button type="submit">Buscar</button>
    </form>
</header>

</html>
