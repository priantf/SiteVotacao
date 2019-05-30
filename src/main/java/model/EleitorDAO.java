package model;

import model.Eleitor;
import java.util.List;

public interface EleitorDAO {
    public Eleitor insert(Eleitor usuario);
    public Eleitor findByTitulo(String nomeUsuario);
    public List<Eleitor> findAll();
    public Eleitor update(Eleitor usuarioAnt, Eleitor usuarioAt);
    public Eleitor liberarVotacao(String titulo);
    public Eleitor jaVotou(String titulo);
    public boolean delete(Eleitor usuario);
    public boolean delete(Long id);   
}
