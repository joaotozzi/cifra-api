package br.com.joaotozzi.cifraapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.joaotozzi.cifraapi.model.Linha;

public class LinhaDTO {
	private int posicao;
	private String conteudo;

	public LinhaDTO(Linha linha) {
		this.posicao = linha.getPosicao();
		this.conteudo = linha.getConteudo();
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public static List<LinhaDTO> converter(List<Linha> linhas) {
		return linhas.stream().map(LinhaDTO::new).collect(Collectors.toList());
	}
}
