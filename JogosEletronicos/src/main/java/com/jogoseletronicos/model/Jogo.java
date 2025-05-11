package com.jogoseletronicos.model;

public class Jogo {
	private String titulo;
	private String desenvolvedor;
	private String anoLancamento;
	private String genero;
	private String sinopse;
	private String idioma;
	private String plataforma;
	private String classificacaoIndicativa;
	private String imagemJogo;
	
	public Jogo(String titulo, String desenvolvedor, String anoLancamento, String genero, String sinopse, String idioma, String plataforma, String classificacaoIndicativa, String imagemJogo) {
		this.titulo = titulo;
		this.desenvolvedor = desenvolvedor;
		this.anoLancamento = anoLancamento;
		this.genero = genero;
		this.sinopse = sinopse;
		this.idioma = idioma;
		this.plataforma = plataforma;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.imagemJogo = imagemJogo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public String getImagemJogo() {
		return imagemJogo;
	}

	public void setImagemJogo(String imagemJogo) {
		this.imagemJogo = imagemJogo;
	}
	
	
	
	
	
	
	
	
}
