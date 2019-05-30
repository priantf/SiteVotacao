package model;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.mysql.jdbc.log.Log;

public class ServicoEntityManager {

	protected static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("eleicao"); // Mudar o nome de
																							// acordo com o
																							// persistence
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
}
