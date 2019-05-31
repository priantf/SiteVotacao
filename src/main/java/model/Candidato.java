package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidato")
public class Candidato {
	
	@Id
	@Column(name = "numero", nullable = false)
	private Integer numero;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "partido", nullable = false)
	private String partido;

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Candidato getInfo(Integer numero) {
		CandidatoDAOImpl cdao = new CandidatoDAOImpl();
		Candidato c = cdao.buscar(numero);
		return c;
		
	}
}
