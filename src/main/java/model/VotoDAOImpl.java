package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class VotoDAOImpl implements VotoDAO{
	
	Session session = null;

	@Override
	public Voto computaVoto(Voto voto) {
		//session = ServicoEntityManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(voto);
			session.getTransaction().commit();
			session.close();
			return voto;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Voto> contaVoto() {
		//session = ServicoEntityManager.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Voto");
		List<Voto> votos = query.getResultList();
		return votos;
	}

}
