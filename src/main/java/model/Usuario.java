package model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Usuario {
	
	private String titulo;
	private String senha;
	private String categoria;
	
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String paraJSONString(){
        JsonObjectBuilder construtorJson = Json.createObjectBuilder();
        construtorJson.add("titulo", this.getTitulo());
        construtorJson.add("senha", this.getSenha());
        construtorJson.add("tipo", this.getCategoria());
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
