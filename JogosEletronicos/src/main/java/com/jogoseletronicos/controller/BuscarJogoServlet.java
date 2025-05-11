package com.jogoseletronicos.controller;

import com.jogoseletronicos.model.DAO;
import com.jogoseletronicos.model.Jogo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscar-jogo")
public class BuscarJogoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");

        // Busca o jogo pelo nome no banco de dados ou na lista de jogos
        Jogo jogoEncontrado = DAO.buscarJogoNome(titulo, getServletContext());

        if (jogoEncontrado != null) {
            request.setAttribute("jogo", jogoEncontrado);
            request.getRequestDispatcher("view/resultado-busca.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagem", "Jogo não encontrado.");
            request.getRequestDispatcher("view/resultado-busca.jsp").forward(request, response);
        }
    }
}