package br.com.joaotozzi.cifraapi.form;

import java.util.List;

public class CadastroCifraForm {
	private String titulo;
	private String compositor;
	private String linkYoutube;
	private int andamento;
	private String tomOriginal;
	private List<SecaoForm> secoes;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCompositor() {
		return compositor;
	}

	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public int getAndamento() {
		return andamento;
	}

	public void setAndamento(int andamento) {
		this.andamento = andamento;
	}

	public String getTomOriginal() {
		return tomOriginal;
	}

	public void setTomOriginal(String tomOriginal) {
		this.tomOriginal = tomOriginal;
	}

	public List<SecaoForm> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<SecaoForm> secoes) {
		this.secoes = secoes;
	}

}
