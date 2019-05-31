package model;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;

public class CandidatoDAOImpl implements CandidatoDAO {
	Session session = null;
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Candidato> listar() {
		session = ServicoEntityManager.getSessionFactory().openSession();
		String hql = "SELECT c FROM Candidato c";
		Query query = session.createQuery(hql);
		List<Candidato> results = query.list();
		
		for (Candidato candidato : results) {
			System.out.println(candidato.getNome());
		}
		session.close();
		return results;
	}

	@Override
	public Candidato buscar(Integer numero) {
    	entityManager = ServicoEntityManager.getEntityManager();
        Candidato candidato = null;
        try{
        	candidato =  entityManager.find(Candidato.class, numero);
        	System.out.println(candidato.getNome());
            return candidato;
        }           
        catch (Exception e)
        {
          System.out.print(e);
          return null;
        }
	
	}

}
