package model;


public class ServicoUsuarioImpl implements ServicoUsuario{
	@Override
    public Usuario insert(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByTitulo(String tituloEleitor) {
    	UsuarioDAOMariaDB10 uDao = new UsuarioDAOMariaDB10();
        //UsuarioPapelDAO upDao = new UsuarioPapelDAOMariaDB10();
        //PapelDAO pdao = new PapelDAOMariaDB10();
        Usuario u = uDao.findByTitulo(tituloEleitor);

        return u;
    }    
}
