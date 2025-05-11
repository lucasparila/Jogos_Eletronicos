package com.jogoseletronicos.controller;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogoseletronicos.model.*;

@WebServlet("/editar-jogo") 
public class UptadeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        try {
	            String nome = request.getParameter("titulo");
	            Jogo jogo = DAO.buscarJogoNome(nome, getServletContext());

	            if (jogo == null) {
	                response.getWriter().println("Jogo não encontrado!");
	                return;
	            }

	            // Adiciona o livro como atributo na requisição
	            request.setAttribute("jogo", jogo);

	            // Encaminha para o JSP
	            RequestDispatcher dispatcher = request.getRequestDispatcher("view/editaJogo.jsp");
	            dispatcher.forward(request, response);

	        } catch (NumberFormatException e) {
	            response.getWriter().println("titulo inválido!");
	        }
	    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String titulo = request.getParameter("titulo");
	        String desenvolvedor = request.getParameter("desenvolvedor");
	        String anoLancamento = request.getParameter("anoLancamento");
	        String genero = request.getParameter("genero");
	        String sinopse = request.getParameter("sinopse");
	        String idioma = request.getParameter("idioma");
	        String plataforma = request.getParameter("plataforma");
	        String classificacaoIndicativa = request.getParameter("classificacaoIndicativa");

	        // Busca o jogo existente
	        Jogo jogo = DAO.buscarJogoNome(titulo, getServletContext());

	        if (jogo == null) {
	            response.getWriter().println("Erro: Jogo não encontrado!");
	            return;
	        }

	        // Atualiza os dados do jogo
	        jogo.setTitulo(titulo);
	        jogo.setDesenvolvedor(desenvolvedor);
	        jogo.setAnoLancamento(anoLancamento);
	        jogo.setGenero(genero);
	        jogo.setSinopse(sinopse);
	        jogo.setIdioma(idioma);
	        jogo.setPlataforma(plataforma);
	        jogo.setClassificacaoIndicativa(classificacaoIndicativa);

	        // Atualiza no DAO
	        DAO.atualizarJogo(jogo, getServletContext());

	        // Redireciona para a página de exibição
	        request.getRequestDispatcher("listar-jogos").forward(request, response);

	    } catch (Exception e) {
	        response.getWriter().println("Erro ao atualizar jogo: " + e.getMessage());
	    }
	}
	
}
