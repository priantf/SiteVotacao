package model;

import java.sql.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "eleitor")
public class Eleitor {

	@Id
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "senha")
	private String senha;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nasc")
	private String nasc;

	@JoinColumn(name = "municipio", referencedColumnName = "id_municipio")
    @ManyToOne
    private Municipio municipio;

	@Column(name = "emissao_titulo")
	private String emissaoTitulo;

	@Column(name = "zona")
	private String zona;

	@Column(name = "secao")
	private String secao;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "liberacao")
	private int liberado;

	@Column(name = "ja_votou")
	private int jaVotou;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNasc() {
		return nasc;
	}

	public void setNasc(String nasc) {
		this.nasc = nasc;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getEmissaoTitulo() {
		return emissaoTitulo;
	}

	public void setEmissaoTitulo(String emissaoTitulo) {
		this.emissaoTitulo = emissaoTitulo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getLiberado() {
		return liberado;
	}

	public void setLiberado(int liberado) {
		this.liberado = liberado;
	}

	public int getJaVotou() {
		return jaVotou;
	}

	public void setJaVotou(int jaVotou) {
		this.jaVotou = jaVotou;
	}

	public String paraJSONString() {
		JsonObjectBuilder construtorJson = Json.createObjectBuilder();
		construtorJson.add("titulo", this.getTitulo());
		construtorJson.add("senha", this.getSenha());
		construtorJson.add("tipo", this.getCategoria());
		JsonObject objetoJson = construtorJson.build();

		/* Construção manual da String Json: */
		/*
		 * StringBuilder strBuilder = new StringBuilder();
		 * strBuilder.append("{ \"nomeUsuario\": ");
		 * strBuilder.append("\""+this.getNomeUsuario() + "\" ,");
		 * strBuilder.append(" \"senha\": "); strBuilder.append("\""+this.getSenha() +
		 * "\" }");
		 */

		return objetoJson.toString(); // strBuilder.toString();
	}

}
