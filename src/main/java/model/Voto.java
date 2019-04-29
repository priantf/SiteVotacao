package model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Voto {

	private String titulo;
	private String voto;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	public String paraJSONString(){
        JsonObjectBuilder construtorJson = Json.createObjectBuilder();
        construtorJson.add("titulo", this.getTitulo());
        // construtorJson.add("voto", this.getVoto());
        JsonObject objetoJson = construtorJson.build();
        
        /* Construção manual da String Json: */
        /*
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("{ \"nomeUsuario\": ");
        strBuilder.append("\""+this.getNomeUsuario() + "\" ,");
        strBuilder.append(" \"senha\": ");
        strBuilder.append("\""+this.getSenha() + "\" }");
        */
        
        return objetoJson.toString(); //strBuilder.toString();       
    } 
	
}
