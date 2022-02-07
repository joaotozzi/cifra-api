package br.com.joaotozzi.cifraapi.form;

import java.util.List;

public class SecaoForm {
	private int posicao;
	private String nome;
	private int numeroDeExecucoes;
	private String notaDeEnsaio;
	private List<LinhaForm> linhas;

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

	public int getNumeroDeExecucoes() {
		return numeroDeExecucoes;
	}

	public void setNumeroDeExecucoes(int numeroDeExecucoes) {
		this.numeroDeExecucoes = numeroDeExecucoes;
	}

	public String getNotaDeEnsaio() {
		return notaDeEnsaio;
	}

	public void setNotaDeEnsaio(String notaDeEnsaio) {
		this.notaDeEnsaio = notaDeEnsaio;
	}

	public List<LinhaForm> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaForm> linhas) {
		this.linhas = linhas;
	}

}
