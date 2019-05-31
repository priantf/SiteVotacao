package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CASA
 *
 */
@Entity(name="voto")
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idvoto")
	private int id;
	
	@Column(name = "numero")
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
