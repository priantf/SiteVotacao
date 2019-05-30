/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fabriciogmc
 */
public class EleitorDAOImpl implements EleitorDAO{

	protected EntityManager entityManager;
    
    @Override
    public Eleitor insert(Eleitor usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Eleitor findByTitulo(String titulo){
    	entityManager = ServicoEntityManager.getEntityManager();
        Eleitor eleitor = null;
        try{
        	eleitor =  entityManager.find(Eleitor.class, titulo);
        	System.out.println(eleitor.getNome());
            return eleitor;
        }           
        catch (Exception e)
        {
          System.out.print(e);
          return null;
        }
    }
    

    @Override
    public List<Eleitor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean liberarVotacao(String titulo) {
    	entityManager = ServicoEntityManager.getEntityManager();
    	try{
    		Query query = entityManager.createNativeQuery("UPDATE eleitor e SET e.liberacao = 1 "
                    + "WHERE e.titulo = :titulo", Eleitor.class);
    		query.setParameter("titulo", titulo);
    		entityManager.getTransaction().begin();
    		query.executeUpdate();

    		entityManager.getTransaction().commit();

            return true;
        }           
        catch (Exception e)
        {
        	System.out.print(e);
            return false;
        }
    	
    }

    @Override
    public Eleitor update(Eleitor usuarioAnt, Eleitor usuarioAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Eleitor usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


	@Override
	public boolean jaVotou(String titulo) {
		// TODO Auto-generated method stub
		return false;
	}
    
}
