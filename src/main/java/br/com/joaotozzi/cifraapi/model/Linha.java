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

	@Column(name = "LNH_ACORDES")
	private String acordes;

	@Column(name = "LNH_TEXTO")
	private String texto;

	@ManyToOne
	@JoinColumn(name = "SCS_ID")
	private Secao secao;
	
	public Linha(LinhaForm linhaForm, Secao secao) {
		this.posicao = linhaForm.getPosicao();
		this.acordes = linhaForm.getAcordes();
		this.texto = linhaForm.getTexto();
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

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

}
