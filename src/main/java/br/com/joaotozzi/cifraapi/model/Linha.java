package br.com.joaotozzi.cifraapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.joaotozzi.cifraapi.form.LinhaForm;

@Entity(name = "TBL_LNH_LINHAS")
public class Linha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LNH_ID")
	private long id;

	@Column(name = "LNH_POSICAO")
	private int posicao;

	@Column(name = "LNH_CONTEUDO")
	private String conteudo;

	@ManyToOne
	@JoinColumn(name = "SCS_ID")
	private Secao secao;

	public Linha(LinhaForm linhaForm, Secao secao) {
		this.posicao = linhaForm.getPosicao();
		this.conteudo = linhaForm.getConteudo();
		this.secao = secao;
	}

	public Linha() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

}
