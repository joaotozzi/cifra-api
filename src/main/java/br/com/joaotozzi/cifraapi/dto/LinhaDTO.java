package br.com.joaotozzi.cifraapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.joaotozzi.cifraapi.model.Linha;

public class LinhaDTO {
	private int posicao;
	private String acordes;
	private String texto;

	public LinhaDTO(Linha linha) {
		this.posicao = linha.getPosicao();
		this.acordes = linha.getAcordes();
		this.texto = linha.getTexto();
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String getAcordes() {
		return acordes;
	}

	public void setAcordes(String acordes) {
		this.acordes = acordes;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static List<LinhaDTO> converter(List<Linha> linhas) {
		return linhas.stream().map(LinhaDTO::new).collect(Collectors.toList());
	}
}
