package model;

import java.util.List;

public interface CandidatoDAO {
	public List<Candidato> listar();
	public Candidato buscar(Integer numero);
}
