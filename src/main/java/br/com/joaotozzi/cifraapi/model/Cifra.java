package br.com.joaotozzi.cifraapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.joaotozzi.cifraapi.form.CadastroCifraForm;

@Entity(name = "TBL_CFR_CIFRAS")
public class Cifra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CFR_ID")
	private long id;

	@Column(name = "CFR_TITULO")
	private String titulo;

	@Column(name = "CFR_COMPOSITOR")
	private String compositor;

	@Column(name = "CFR_VERSAO")
	private String versao;

	@Column(name = "CFR_LINK_YOUTUBE")
	private String linkYoutube;

	@Column(name = "CFR_ANDAMENTO")
	private int andamento;

	@Column(name = "CFR_TOM_ORIGINAL")
	private String tomOriginal;

	@OneToMany(mappedBy = "cifra", cascade = CascadeType.REMOVE)
	private List<Secao> secoes;
	
	
	public Cifra(CadastroCifraForm cifraForm) {
		this.titulo = cifraForm.getTitulo();
		this.compositor = cifraForm.getCompositor();
		this.versao = cifraForm.getVersao();
		this.linkYoutube = cifraForm.getLinkYoutube();
		this.andamento = cifraForm.getAndamento();
		this.tomOriginal = cifraForm.getTomOriginal();
	}
	
	public Cifra() {
		
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

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}

}
