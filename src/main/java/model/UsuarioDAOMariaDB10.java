/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.UsuarioDAO;
import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fabriciogmc
 */
public class UsuarioDAOMariaDB10 implements UsuarioDAO{

    Connection conexao;
    
    public UsuarioDAOMariaDB10(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            /* Abertura de conexão: */
            /* Notar que poderia ser substituida por
            uma chamada de get instance de uma conexão já aberta. 
            */
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/eleicao","root", "senha"); 
            
            System.out.println("Conectado.. Usuario DAO...");
        } catch (Exception e){
            System.out.print("Erro de conexao...UsuarioDAOMYSQL");
        }
    }
    
    @Override
    public Usuario insert(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Usuario findByTitulo(String nomeUsuario){
        Usuario u = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from eleicao.usuario where titulo = ?");  
            comandoSQLp.setString(1, nomeUsuario);
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado...");
            rs.next();
            u = new Usuario();
            u.setTitulo(rs.getString(1));
            u.setSenha(rs.getString(2));
            u.setCategoria(rs.getString(3));
            System.out.println(u.getCategoria());
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexao... find by nome usuaio");
          return null;
        }
    }
    

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario update(Usuario usuarioAnt, Usuario usuarioAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
