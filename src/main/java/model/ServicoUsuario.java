package model;

import model.Usuario;

public interface ServicoUsuario {
    public Usuario insert(Usuario usuario);
    public Usuario findByTitulo(String nomeUsuario);
}
