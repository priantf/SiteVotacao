package model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author CASA
 *
 */
@Entity
@Table(name = "voto")
public class Voto {
	@Id
	//@Column(name="idvoto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "numero")
	private Integer candidato;
	
	public Integer getCandidato() {
		return candidato;
	}
	public void setCandidato(Integer candidato) {
		this.candidato = candidato;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String paraJSONString(){
		/*
        JsonObjectBuilder construtorJson = Json.createObjectBuilder();
        construtorJson.add("titulo", this.getTitulo());
        // construtorJson.add("voto", this.getVoto());
        JsonObject objetoJson = construtorJson.build();
        
        Construção manual da String Json: 
        
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("{ \"nomeUsuario\": ");
        strBuilder.append("\""+this.getNomeUsuario() + "\" ,");
        strBuilder.append(" \"senha\": ");
        strBuilder.append("\""+this.getSenha() + "\" }");
        
        
        return objetoJson.toString(); //strBuilder.toString();       
        */
		return null;
    } 
	
}
