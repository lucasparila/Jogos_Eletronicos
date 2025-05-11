package com.jogoseletronicos.model;
import java.util.ArrayList;

import javax.servlet.ServletContext;

public class DAO {
	
	private static final String ATRIBUTO = "catalogoJogos";
	
	@SuppressWarnings("unchecked")
	private static ArrayList<Jogo> getLista(ServletContext context) {
        ArrayList<Jogo> jogos = (ArrayList<Jogo>) context.getAttribute(ATRIBUTO);
        if (jogos == null) {
            jogos = new ArrayList<>();
            context.setAttribute(ATRIBUTO, jogos);
        }
        return jogos;
    }
	
	
	public static ArrayList<Jogo> getJogos(ServletContext context){
		return getLista(context);
	}
	
	public static Jogo buscarJogoNome(String nome, ServletContext context) {
		ArrayList<Jogo> jogos = getLista(context);
		for(Jogo j : jogos) {
			if(j.getTitulo().equals(nome)) {
				return j;
			}
		}
		return null;
	}
	
	public static void adicionarJogo(Jogo jogo, ServletContext context) {
		ArrayList <Jogo> jogos = getLista(context);
		jogos.add(jogo);
	}
	
	public static void removerJogo (Jogo jogo, ServletContext context) {
		ArrayList<Jogo> jogos = getLista(context);
		jogos.remove(jogo);
	}
	
	public static void atualizarJogo(Jogo jogoAtualizado, ServletContext context) {
		Jogo jogo = buscarJogoNome(jogoAtualizado.getTitulo(), context); 
		if(jogo != null) {
			jogo.setTitulo(jogoAtualizado.getTitulo());
			jogo.setDesenvolvedor(jogoAtualizado.getDesenvolvedor());
			jogo.setAnoLancamento(jogoAtualizado.getAnoLancamento());
			jogo.setGenero(jogoAtualizado.getGenero());
			jogo.setSinopse(jogoAtualizado.getSinopse());
			jogo.setIdioma(jogoAtualizado.getIdioma());
			jogo.setPlataforma(jogoAtualizado.getPlataforma());
			jogo.setClassificacaoIndicativa(jogoAtualizado.getClassificacaoIndicativa());
		}
	}
}
