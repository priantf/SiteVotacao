package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class VotoDAOImpl implements VotoDAO{
	
	Session session = null;

	@Override
	public Voto computaVoto(Voto voto) {
		session = ServicoEntityManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(voto);
		session.getTransaction().commit();
		session.close();
		
		return voto;
	}

	@Override
	public List<Voto> contaVoto() {
		//session = ServicoEntityManager.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Voto");
		List<Voto> votos = query.getResultList();
		return votos;
	}

}
