package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

public class VotoDAOImpl implements VotoDAO{
	
	protected EntityManager entityManager;
	Session session = null;

	@Override
	public Integer computaVoto(Integer voto) {
		entityManager = ServicoEntityManager.getEntityManager();
		Query query = entityManager.createNativeQuery("INSERT into voto VALUES (null, :voto)", Voto.class);
		query.setParameter("voto", voto);
		entityManager.getTransaction().begin();
		query.executeUpdate();

		entityManager.getTransaction().commit();
		
		return voto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer contaVoto(Integer candidato) {
		session = ServicoEntityManager.getSessionFactory().openSession();
		String hql = "SELECT count(numero) FROM voto WHERE numero = " + candidato;
		org.hibernate.Query query = session.createQuery(hql);
		List results = query.list();
		
		Long qtd = (Long) results.get(0);
		System.out.println(qtd);
		session.close();
		return Math.toIntExact(qtd);
	}

}
