package br.com.joaotozzi.cifraapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.joaotozzi.cifraapi.model.Secao;

public class SecaoDTO {
	private int posicao;
	private String nome;
	private String notaDeEnsaio;
	private List<LinhaDTO> linhas;

	public SecaoDTO(Secao secao) {
		this.posicao = secao.getPosicao();
		this.nome = secao.getNome();
		this.notaDeEnsaio = secao.getNotaDeEnsaio();

		if (secao.getLinhas() != null) {
			this.linhas = LinhaDTO.converter(secao.getLinhas());
		}
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNotaDeEnsaio() {
		return notaDeEnsaio;
	}

	public void setNotaDeEnsaio(String notaDeEnsaio) {
		this.notaDeEnsaio = notaDeEnsaio;
	}

	public List<LinhaDTO> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaDTO> linhas) {
		this.linhas = linhas;
	}

	public static List<SecaoDTO> converter(List<Secao> secoes) {
		return secoes.stream().map(SecaoDTO::new).collect(Collectors.toList());
	}
}
