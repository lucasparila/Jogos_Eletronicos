package com.jogoseletronicos.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogoseletronicos.model.DAO;
import com.jogoseletronicos.model.Jogo;

@WebServlet ("/listar-jogos")
public class ListServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        ArrayList<Jogo> listaJogos = DAO.getJogos(context);

        // Adiciona a lista de jogos como atributo na requisição
        request.setAttribute("listaJogos", listaJogos);

        // Encaminha para o JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/exibirJogo.jsp");
        dispatcher.forward(request, response);
    }


}
