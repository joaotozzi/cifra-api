package br.com.joaotozzi.cifraapi.dto;

import br.com.joaotozzi.cifraapi.model.Cifra;

public class CifraDTO {
	private long id;
	private String titulo;
	private String compositor;

	public CifraDTO(Cifra cifra) {
		this.id = cifra.getId();
		this.titulo = cifra.getTitulo();
		this.compositor = cifra.getCompositor();
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
}
