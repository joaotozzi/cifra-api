package br.com.joaotozzi.cifraapi.form;

import java.util.List;

public class CifraForm {
	private long id;
	private String titulo;
	private String compositor;
	private String versao;
	private String linkYoutube;
	private int andamento;
	private String tomOriginal;
	private List<SecaoForm> secoes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
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
