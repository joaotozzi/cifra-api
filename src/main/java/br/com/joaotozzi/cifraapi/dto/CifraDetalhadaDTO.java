package br.com.joaotozzi.cifraapi.dto;

import java.util.List;
import br.com.joaotozzi.cifraapi.model.Cifra;

public class CifraDetalhadaDTO {
	private long id;
	private String titulo;
	private String compositor;
	private String versao;
	private String linkYoutube;
	private int andamento;
	private String tomOriginal;
	private List<SecaoDTO> secoes;

	public CifraDetalhadaDTO(Cifra cifra) {
		this.id = cifra.getId();
		this.titulo = cifra.getTitulo();
		this.compositor = cifra.getCompositor();
		this.versao = cifra.getVersao();
		this.linkYoutube = cifra.getLinkYoutube();
		this.andamento = cifra.getAndamento();
		this.tomOriginal = cifra.getTomOriginal();

		if (cifra.getSecoes() != null) {
			this.secoes = SecaoDTO.converter(cifra.getSecoes());
		}
	}

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

	public List<SecaoDTO> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<SecaoDTO> secoes) {
		this.secoes = secoes;
	}

}
