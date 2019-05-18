package model;

import model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    public Usuario insert(Usuario usuario);
    public Usuario findByTitulo(String nomeUsuario);
    public List<Usuario> findAll();
    public Usuario update(Usuario usuarioAnt, Usuario usuarioAt);
    public boolean delete(Usuario usuario);
    public boolean delete(Long id);   
}
