package com.jogoseletronicos.controller;
import com.jogoseletronicos.model.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remover-jogo")
public class RemoveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String titulo = request.getParameter("titulo");
	        
	        Jogo jogo = DAO.buscarJogoNome(titulo, getServletContext());

	        if (jogo == null) {
	            response.getWriter().println("Erro: Jogo não encontrado!");
	            return;
	        }
	        DAO.removerJogo(jogo, getServletContext());

	        // Redireciona para a página de exibição
	        request.getRequestDispatcher("listar-jogos").forward(request, response);

	    } catch (Exception e) {
	        response.getWriter().println("Erro ao remover o jogo: " + e.getMessage());
	    }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.getWriter().println("Página de remoção do jogo");
    }

}
