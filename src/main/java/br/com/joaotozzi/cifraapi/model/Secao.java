package br.com.joaotozzi.cifraapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.joaotozzi.cifraapi.form.SecaoForm;

@Entity(name = "TBL_SCS_SECOES")
public class Secao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCS_ID")
	private long id;

	@Column(name = "SCS_POSICAO")
	private int posicao;

	@Column(name = "SCS_NOME")
	private String nome;

	@Column(name = "SCS_NOTA_ENSAIO")
	private String notaDeEnsaio;

	@ManyToOne
	@JoinColumn(name = "CFR_ID")
	private Cifra cifra;

	@OneToMany(mappedBy = "secao", cascade = CascadeType.REMOVE)
	private List<Linha> linhas;
	
	public Secao(SecaoForm secaoForm, Cifra cifra) {
		this.posicao = secaoForm.getPosicao();
		this.nome = secaoForm.getNome();
		this.notaDeEnsaio = secaoForm.getNotaDeEnsaio();
		this.cifra = cifra;
	}
	
	public Secao() {
		
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

	public Cifra getCifra() {
		return cifra;
	}

	public void setCifra(Cifra cifra) {
		this.cifra = cifra;
	}

	public List<Linha> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

}
