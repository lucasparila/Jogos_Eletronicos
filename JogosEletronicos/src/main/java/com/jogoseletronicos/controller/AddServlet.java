package com.jogoseletronicos.controller;

import com.jogoseletronicos.model.DAO;
import com.jogoseletronicos.model.Jogo;

import java.io.File;
import java.io.IOException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/processarJogo")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10, // 10MB
	    maxRequestSize = 1024 * 1024 * 50 // 50MB
	)

public class AddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	  private static final String UPLOAD_DIR = "uploads";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Captura os dados do formulário
	        String titulo = request.getParameter("titulo");
	        String desenvolvedor = request.getParameter("desenvolvedor");
	        String anoLancamento = request.getParameter("anoLancamento");
	        String genero = request.getParameter("genero");
	        String sinopse = request.getParameter("sinopse");
	        String idioma = request.getParameter("idioma");
	        String plataforma = request.getParameter("plataforma");
	        String classificacaoIndicativa = request.getParameter("classificacaoIndicativa");
	     // Processar o upload da imagem
            Part filePart = request.getPart("imagemJogo"); // Obtém o arquivo enviado
            String fileName = titulo.replaceAll("\\s+", "_") + "_" + System.currentTimeMillis() + ".jpg"; // Nome único
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir(); // Cria a pasta se não existir
            }

            filePart.write(uploadPath + File.separator + fileName);
	        // Cria um objeto Jogo com os dados
	        Jogo jogo = new Jogo(titulo, desenvolvedor, anoLancamento, genero, sinopse, idioma, plataforma, classificacaoIndicativa, fileName);
	        DAO.adicionarJogo(jogo, getServletContext());
	        
	        request.getRequestDispatcher("listar-jogos").forward(request, response);
	    }

	
}
